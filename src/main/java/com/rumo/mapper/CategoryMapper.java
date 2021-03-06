package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rumo.vo.CategoryVo;
import com.rumo.pojo.Category;

/**
 * 
 * todo:分类表
 * Category<br/>
 * 创建人:中华墨风<br/>
 * 时间：2018年11月11日 20:19:21 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface CategoryMapper {
	//添加
	public int saveCategory(Category category);
	//修改
	public int updateCategory(Category category);
	//删除
	public int deleteCategoryById(@Param("id")Integer id);
	//查询单个
	public Category getCategoryById(@Param("id")Integer id);
	//查询所有
	public List<Category> queryCategoryAll(CategoryVo categoryVo);
}