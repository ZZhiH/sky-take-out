package com.sky.controller.user;

import java.util.HashMap;
import java.util.Map;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.user.UserService;
import com.sky.utils.JwtUtil;
import com.sky.vo.UserLoginVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The UserController.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/26 20:15
 */
@RestController
@RequestMapping("/user/user")
@Slf4j
@Tag(name = "User related interface")
public class UserController {

    /**
     * The user service.
     */
    private final UserService userService;

    /**
     * The jwt properties.
     */
    private final JwtProperties jwtProperties;

    /**
     * The construct with specific paramters.
     *
     * @param userService the {@code UserService}
     */
    public UserController(final UserService userService,
                          final JwtProperties jwtProperties) {
        this.userService = userService;
        this.jwtProperties = jwtProperties;
    }

    @PostMapping("/login")
    @Operation(summary = "userLogin", description = "User login")
    public Result<UserLoginVO> login(@RequestBody @Valid final UserLoginDTO userLoginDTO) {
        log.info("user login: {}", userLoginDTO);

        final User user = this.userService.wxLogin(userLoginDTO);

        final Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        final String token = JwtUtil.createJWT(
            jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(),
            claims
        );

        final UserLoginVO userLoginVO = UserLoginVO.builder()
            .id(user.getId())
            .openid(user.getOpenid())
            .token(token)
            .build();

        return Result.success(userLoginVO);
    }
}
