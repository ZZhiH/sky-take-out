package com.sky.interceptor;

import com.sky.constant.JwtClaimsConstant;
import com.sky.properties.JwtProperties;
import com.sky.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Jwt token validate interceptor.
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    /**
     * The JwtProperties.
     */
    private final JwtProperties jwtProperties;

    /**
     * The construct with specific parameters.
     *
     * @param jwtProperties the JwtProperties
     */
    public JwtTokenAdminInterceptor(final JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    /**
     * Validate jwt.
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // To determine whether the intercepted request is targeting a Controller method or other resources
        if (!(handler instanceof HandlerMethod)) {
            // not a dynamic method, allow it.
            return true;
        }

        //1、get jwt token from header.
        String token = request.getHeader(jwtProperties.getAdminTokenName());

        //2、validate token
        try {
            log.info("jwt validate:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("current employee id：{}", empId);
            //3、valid, allow
            return true;
        } catch (Exception ex) {
            //4、not allowed, response with 401 status
            response.setStatus(401);
            return false;
        }
    }
}
