package com.whut.cailiao.ms.impl.web.news;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.news.News;
import com.whut.cailiao.ms.api.service.news.NewsService;
import com.whut.cailiao.ms.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gammaniu on 16/4/16.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String navigateToListPage() {
        return "news/list";
    }

    @RequestMapping(value = "/getNewsList.html", method = RequestMethod.GET)
    @ResponseBody
    public String getNewsList() {
        ApiResponse response = this.newsService.getNewsList();
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String navigateToCreateNewsPage() {
        return "news/create";
    }

    @RequestMapping(value = "/publish.html", method = RequestMethod.POST)
    @ResponseBody
    public String publishNews(@RequestBody News news) {
        ApiResponse response = this.newsService.sendNews(news);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/delete/{id}.html", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteNews(@PathVariable int id) {
        ApiResponse response = this.newsService.deleteNews(id);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/detail/{id}.html", method = RequestMethod.GET)
    @ResponseBody
    public String newsDetail(@PathVariable int id) {
        ApiResponse response = this.newsService.getNewsDetail(id);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/pause/{id}/{status}.html", method = RequestMethod.PUT)
    @ResponseBody
    public String pauseNews(@PathVariable int id, @PathVariable int status) {
        ApiResponse response = this.newsService.updateNewsStatus(id, status);
        return convertApiResponseToJSONString(response);
    }

}
