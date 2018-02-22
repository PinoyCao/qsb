package com.ccniit.manager;

import com.ccniit.model.response_entity.Data;
import com.ccniit.util.RestResult;


/**
 * <code>Manageable</code>类定义了一些数据操作方法。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.5
 * 
 *
 * @param <T> 操作对象的数据类型
 */
public interface Manageable<T> {
	
	/**
	 * 获得服务器返回的所有有用信息
	 * @param size 页面大小
	 * @param page 页数，从0开始
	 * @param sort 排序字段以及排序规律，值为 ASC （正序）或 DESC （逆序）
	 * @return 该<code>com.ccniit.model.response_entity.Data</code>实体
	 */
	public Data getAll(String size,String page,String sort);
	/**
	 * 根据ID查询某个实体，获取服务器返回的有用信息
	 * @return 该<code>com.ccniit.util.RestResult</code>实体
	 */
	public RestResult<T> query(String id);
	/**
	 * 删除一个实体
	 * @param t 要删除的实体
	 */
	public RestResult<T> delete(T t);
	/**
	 * 保存一个实体
	 * @param t 要保存的实体
	 * @return 
	 */
	public RestResult<T> save(T t);
	/**
	 * 更新一个实体
	 * @param t 要更新实体
	 */
	public RestResult<T> update(T t);

}
