package cn.altaria.demo.login.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.altaria.demo.login.mapper.UserMapper;
import cn.altaria.demo.login.pojo.UserPojo;
import cn.altaria.demo.login.service.IUserService;
import lombok.extern.slf4j.Slf4j;

/**
 * UserServiceImpl
 *
 * @author xuzhou
 * @version 1.0.0
 * @date 2021/4/9 17:07
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserPojo load(String id, String email, String username, String mobile) {
        UserPojo userPojo = null;
        if (!StringUtils.isEmpty(id)) {
            userPojo = userMapper.selectUserById(id);
        }
        if (Objects.isNull(userPojo) && !StringUtils.isEmpty(email)) {
            userPojo = userMapper.selectUserByEmail(email);
        }
        if (Objects.isNull(userPojo) && !StringUtils.isEmpty(username)) {
            userPojo = userMapper.selectUserByUsername(username);
        }
        if (Objects.isNull(userPojo) && !StringUtils.isEmpty(mobile)) {
            userPojo = userMapper.selectUserByMobile(mobile);
        }
        return userPojo;
    }
}
