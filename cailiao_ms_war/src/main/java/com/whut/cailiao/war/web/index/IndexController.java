package com.whut.cailiao.war.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by niuyang on 16/4/1.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/login.html", "/index.html"})
    public String index() {
        return "login/login";
    }

}