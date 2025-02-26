package com.sky.service.user;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * The UserService interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/26 20:19
 */
public interface UserService {

    /**
     * User login.
     *
     * @param userLoginDTO the {@code UserLoginDTO}
     * @return the login User.
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
