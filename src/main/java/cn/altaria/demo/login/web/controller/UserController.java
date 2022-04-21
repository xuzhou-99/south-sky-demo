package cn.altaria.demo.login.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.altaria.base.response.ApiResponse;
import cn.altaria.demo.login.exception.RegisterException;
import cn.altaria.demo.login.web.vo.UserVO;
import cn.altaria.demo.login.service.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * UserController
 *
 * @author xuzhou
 * @version 1.0.0
 * @date 2021/4/9 17:11
 */
@Slf4j
@Controller
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * user register
     *
     * @param userVO {@linkplain UserVO}
     * @return {{@linkplain String}}
     */
    @PostMapping(value = "register")
    @ResponseBody
    public ApiResponse register(final UserVO userVO) {
        // register
        try {
            userService.register(userVO);
        } catch (RegisterException e) {
            return ApiResponse.ofFail(e.getMessage());
        }
        return ApiResponse.ofSuccess();
    }
}
