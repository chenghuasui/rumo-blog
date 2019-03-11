package com.rumo.service.category;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.CategoryMapper;
import com.rumo.vo.CategoryVo;
import com.rumo.pojo.Category;
import com.rumo.vo.ServerResponse;


/**
 * 
 * todo:分类表Service实现类
 * CategoryServiceImpl<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年11月11日 20:19:21 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService  {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public ServerResponse queryCategoryAll(CategoryVo categoryVo){
		PageHelper.startPage(categoryVo.getPageNo(), categoryVo.getPageSize());
		List<Category> categorys = categoryMapper.queryCategoryAll(categoryVo);
		PageInfo<Category> pageInfo = new PageInfo<>(categorys);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveCategory(CategoryVo categoryVo) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryVo, category);
		int count = categoryMapper.saveCategory(category);
		return count>0?ServerResponse.createBySuccess(category):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateCategory(CategoryVo categoryVo) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryVo, category);
		int count = categoryMapper.updateCategory(category);
		return count>0?ServerResponse.createBySuccess(category):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteCategoryById(Integer id) {
		int count = categoryMapper.deleteCategoryById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getCategoryById(Integer id) {
		Category category = categoryMapper.getCategoryById(id);
		return category!=null?ServerResponse.createBySuccess(category):ServerResponse.createByError();
	}
	
	
}
