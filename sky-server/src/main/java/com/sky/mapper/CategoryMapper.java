package com.sky.mapper;

import com.sky.entity.Category;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * The CategoryMapper interface.
 * <p>
 * Creator：ZHIHAO
 * Create date：2025/1/31 22:11
 */
@Mapper
public interface CategoryMapper {

    @Insert("insert into category (type, name, sort, status, create_time, create_user) " +
        "values (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{createUser})")
    void insert(Category category);
}
