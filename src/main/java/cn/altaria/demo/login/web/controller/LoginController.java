package cn.altaria.demo.login.web.controller;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.altaria.demo.login.service.ILoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * LoginController
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/28 15:50
 */
@Slf4j
@Controller
@RequestMapping()
public class LoginController {

//    @Resource
//    private ILoginService loginService;
//
//    @Value("${sso.enable}")
//    private Boolean ssoOpen;
//
//    @Value("${sso.url}")
//    private String ssoUrl;
//
//
//    /**
//     * html模板入口
//     *
//     * @return ' resources/templates '下的html模板
//     */
//    @GetMapping("/login")
//    public String login(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//
//        if (ssoOpen) {
//            StringBuffer requestUrl = request.getRequestURL();
//            log.info("requestUrl:{}", requestUrl);
//            return "redirect:" + ssoUrl + "?service=" + requestUrl;
//        }
//
//        return "login";
//    }
//
//
//    @PostMapping(value = "/login")
//    @ResponseBody
//    public ResponseEntity<?> loginPost(@RequestParam String email, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
//
//        try {
//            loginService.login(email, password);
//        } catch (LoginException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(e.getMessage());
//        }
//        return ResponseEntity.ok("home");
//    }
//
//    /**
//     * 用户登出
//     *
//     * @return String
//     */
//    @GetMapping(value = "/logout")
//    public String logout() {
//        loginService.logout();
//        return "redirect:" + "/login";
//    }
}
