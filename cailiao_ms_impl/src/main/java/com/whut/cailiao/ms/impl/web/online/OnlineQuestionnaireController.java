package com.whut.cailiao.ms.impl.web.online;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.commons.ApiResponseCode;
import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireContent;
import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.ms.api.service.questionnaire.QuestionnaireService;
import com.whut.cailiao.ms.api.service.questionnaire.QuestionnaireTemplateService;
import com.whut.cailiao.ms.impl.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gammaniu on 16/4/22.
 */
@Controller
@RequestMapping("/online/wj")
public class OnlineQuestionnaireController extends BaseController {

    @Autowired
    private QuestionnaireTemplateService questionnaireTemplateService;

    @Autowired
	private QuestionnaireService questionnaireService;

    @RequestMapping(value = "/{wjtId}.html", method = RequestMethod.GET)
    public String navigateToWJPage(@PathVariable int wjtId, Model model) {
        ApiResponse response = this.questionnaireTemplateService.getQuestionnaireTemplate(wjtId);
        if (response.getRetCode() == ApiResponseCode.SUCCESS) {
            QuestionnaireTemplate questionnaireTemplate = (QuestionnaireTemplate) response.getData("questionnaireTemplate");
            if (questionnaireTemplate != null) {
                model.addAttribute("wjtId", wjtId);
                return questionnaireTemplate.getTemplateUrl();
            }
        }
        return "online/index/index";
    }

    @RequestMapping(value = "/saveTemp.html", method = RequestMethod.POST)
    @ResponseBody
    public String saveWjTemplate(@RequestBody QuestionnaireContent questionnaireContent) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireContent == null) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
        } else {
            if (StringUtils.isBlank(questionnaireContent.getAccountId())) {
                questionnaireContent.setAccountId(getAccountId());
            }
            response = this.questionnaireService.saveQuestionnaireContentTemp(questionnaireContent);
        }
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/commit.html", method = RequestMethod.PUT)
    @ResponseBody
    public String commitWJ(@RequestBody QuestionnaireContent questionnaireContent) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireContent == null) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
        } else {
            if (StringUtils.isBlank(questionnaireContent.getAccountId())) {
                questionnaireContent.setAccountId(getAccountId());
            }
            response = this.questionnaireService.commitQuestionnaireContent(questionnaireContent);
        }
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/history/{wjtId}.html", method = RequestMethod.GET)
    public String navigateToHistoryListPage(@PathVariable int wjtId, Model model) {
        if (wjtId <= 0) {
            return "error/404";
        }
        model.addAttribute("wjtId", wjtId);
        return "online/wj/history";
    }

    @RequestMapping(value = "/getHistoryList/{wjtId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getHistoryList(@PathVariable int wjtId) {
        ApiResponse response = this.questionnaireService.getQuestionnaireContentListByAccountId(wjtId, getAccountId());
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/edit/{wjId}.html", method = RequestMethod.GET)
    public String navigateToEditPage(@PathVariable int wjId, Model model) {
        if (wjId <= 0) {
            return "error/404";
        }
        model.addAttribute("wjId", wjId);
        return "online/wj/wj_edit";
    }
    
    @RequestMapping(value = "/scan/{wjId}.html", method = RequestMethod.GET)
    public String navigateToScanPage(@PathVariable int wjId, Model model) {
        if (wjId <= 0) {
            return "error/404";
        }
        model.addAttribute("wjId", wjId);
        return "online/wj/wj_scan";
    }

    @RequestMapping(value = "/detail/{wjId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getWJDetail(@PathVariable int wjId) {
        ApiResponse response = this.questionnaireService.getQuestionnaireContent(wjId);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/check/{wjId}.html", method = RequestMethod.GET)
    public String navigateToCheckPage(@PathVariable int wjId, Model model) {
        if (wjId <= 0) {
            return "error/404";
        }
        model.addAttribute("wjId", wjId);
        return "online/wj/wj_check";
    }

    @RequestMapping(value = "/examine/{wjId}.html", method = RequestMethod.PUT)
    @ResponseBody
    public String examine(@PathVariable int wjId, @RequestParam boolean isPass,@RequestBody QuestionnaireContent questionnaireContent) {
        /*Mail mail = new Mail();
        mail.setContent("test content");
        mail.setTitle("hello");
        mail.setToWho("");
        EmailUtil.sendEmail(mail);*/    	
    	System.out.println(questionnaireContent.getRejectReason());
        ApiResponse response = this.questionnaireService.examineCommittedQuestionnaireContent(wjId, isPass, questionnaireContent.getRejectReason());
        return convertApiResponseToJSONString(response);
    }
}
