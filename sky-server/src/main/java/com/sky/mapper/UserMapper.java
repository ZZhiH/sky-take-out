package com.sky.mapper;

import com.sky.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * The UserMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/2/26 20:28
 */
@Mapper
public interface UserMapper {

    /**
     * Find user by openid.
     *
     * @param openid the openid
     * @return the {@code User}
     */
    @Select("select * from user where openid = #{openid}")
    User findByOpenid(String openid);

    /**
     * Insert user.
     *
     * @param user the {@code User}
     */
    void insert(User user);
}
