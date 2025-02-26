package com.sky.service.user.impl;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sky.constant.MessageConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.exception.LoginFailedException;
import com.sky.mapper.UserMapper;
import com.sky.properties.WeChatProperties;
import com.sky.service.user.UserService;
import com.sky.utils.WebClientUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * The UserServiceImpl.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/26 20:20
 */
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * WECHAT LOGIN
     */
    private static final String WECHAT_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    /**
     * The user mapper.
     */
    private final UserMapper userMapper;

    /**
     * The wechat properties.
     */
    private final WeChatProperties weChatProperties;

    /**
     * The constructor with specific paramters.
     *
     * @param userMapper the {@code UserMapper}
     */
    public UserServiceImpl(final UserMapper userMapper,
                           final WeChatProperties weChatProperties) {
        this.userMapper = userMapper;
        this.weChatProperties = weChatProperties;
    }

    @Override
    public User wxLogin(final UserLoginDTO userLoginDTO) {
        log.info("wx login: {}", userLoginDTO);
        final String openid = getOpenid(userLoginDTO.getCode());

        // validate openid
        if (openid == null) {
            throw new LoginFailedException(MessageConstant.LOGIN_FAILED);
        }

        // validate is new user
        User user = this.userMapper.findByOpenid(openid);

        if (user == null) {
            user = User.builder()
                .openid(openid)
                .createTime(LocalDateTime.now())
                .build();

            this.userMapper.insert(user);
        }

        return user;
    }

    /**
     * Get Openid from WECHAT interface.
     *
     * @param code the js_code
     * @return the openid
     */
    private String getOpenid(final String code) {
        final HashMap<String, String> params = new HashMap<>();
        params.put("appid", this.weChatProperties.getAppid());
        params.put("secret", this.weChatProperties.getSecret());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");

        final String json = WebClientUtil.doGet(WECHAT_LOGIN, params, String.class);
        final JSONObject jsonObject = JSON.parseObject(json);
        final String openid = jsonObject.getString("openid");
        return openid;
    }
}
