package com.sky.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;

import org.apache.ibatis.annotations.Delete;
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


    /**
     * Category page query.
     *
     * @param categoryPageQueryDTO the {@code CategoryPageQueryDTO}
     * @return page of {@code Category}
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * Update category.
     *
     * @param category the {@code Category}
     */
    void update(Category category);

    /**
     * Delete category by id.
     *
     * @param id the category id
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * Get category list by type.
     *
     * @param type the category type
     * @return list of {@code Category}
     */
    List<Category> findCategoryListByType(Integer type);
}
