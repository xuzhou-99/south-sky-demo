package cn.altaria.demo.login.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/7/22 14:13
 */
@Controller
public class HomeController {
    /**
     * html模板入口
     *
     * @return ' resources/templates '下的html模板
     */
    @GetMapping({"/", "/home"})
    public String home(HttpServletRequest request) {
        return "home";
    }
}
