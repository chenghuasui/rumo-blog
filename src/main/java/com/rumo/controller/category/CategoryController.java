package com.rumo.controller.category;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.vo.CategoryVo;
import com.rumo.service.category.ICategoryService;
import com.rumo.vo.ServerResponse;

/**
 * 
 * todo:分类表Controller控制器类
 * CategoryController<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年11月11日 20:19:21 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/category")
	public String categoryindex() {
		return "category/index";
	}

	/**
	 * 方法名：categorydetail<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/category/{id}")
	public String categorydetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "category/detail";
	}
	
	
	/**
	 * 模板方法，提供给分页使用
	 * 方法名：template<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:15074816437<br/>
	 * @param params
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@PostMapping("/category/template")
	public String template(CategoryVo categoryVo,ModelMap map) {
		ServerResponse serverResponse = categoryService.queryCategoryAll(categoryVo);
		map.addAttribute("pages", serverResponse.getData());
		return "category/template";
	}
	
	
	/**
	 * 根据id查询信息
	 * 方法名：getCategory<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/category/get/{id}")
	public ServerResponse getCategory(@PathVariable("id") Integer id) {
		return categoryService.getCategoryById(id);
	}
	
	
	/**
	 * 保存
	 * 方法名：saveCategory<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 20:19:21<br/>
	 * 手机:15074816437<br/>
	 * @param categoryVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/category/save")
	public ServerResponse saveCategory(@Valid CategoryVo categoryVo) {
		return categoryService.saveCategory(categoryVo);
	}
	
	/**
	 * 修改
	 * 方法名：updateCategory<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:15074816437<br/>
	 * @param categoryVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/category/update")
	public ServerResponse updateCategory(@Valid CategoryVo categoryVo) {
		return categoryService.updateCategory(categoryVo);
	}
	
	
	/**
	 * 删除
	 * 方法名：deleteCategory<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/category/delete/{id}")
	public ServerResponse deleteCategory(@PathVariable("id") Integer id) {
		return categoryService.deleteCategoryById(id);
	}
	
}
