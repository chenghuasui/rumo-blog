package com.rumo.service.category;

import com.rumo.vo.ServerResponse;
import com.rumo.vo.CategoryVo;

public interface ICategoryService {
	
	/**
	 * 
	 *  保存分类表
	 * 方法名：saveCategory<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param category
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse saveCategory(CategoryVo categoryVo);
	
	/**
	 * 
	 * (修改分类表)<br/>
	 * 方法名：updateCategory<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:1564545646464<br/>
	 * @param category
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse updateCategory(CategoryVo categoryVo);
	
	/**
	 * 
	 * (根据id删除分类表)<br/>
	 * 方法名：deleteCategoryById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse deleteCategoryById(Integer id);
	
	/**
	 * 
	 * (根据id获取分类表)<br/>
	 * 方法名：getCategoryById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse getCategoryById(Integer id);
	
	/**
	 * 
	 * (查询所有的分类表)<br/>
	 * 方法名：queryCategoryAll<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 20:19:21 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryCategoryAll(CategoryVo categoryVo);
}
