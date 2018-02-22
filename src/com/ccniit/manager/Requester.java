package com.ccniit.manager;

import java.util.List;

import com.ccniit.net.Connection;
import com.ccniit.net.common.Package;
import com.ccniit.net.common.RequestPackage;


/**
 * <code>Requester</code>实现了<code>RequestDataHelper</code>
 * 接口。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.5
 * @see RequestDataHelper
 * 
 *
 * @param <E> 请求的数据的数据类型。
 */
public class Requester<E> implements RequestDataHelper<E>{

	@Override
	public List<E> requestData(String request) {
		Connection connection = LocalManager.getConnection();
		connection.sendPackage(new RequestPackage(request));
		Package p = connection.receivePackage();
		@SuppressWarnings("unchecked")
		List<E> list = (List<E>) p.getResult();
		return list;
	}

	@Override
	public String updateData(String request, String key, E value) {
		Connection connection = LocalManager.getConnection();
		Package p1 = new RequestPackage(request);
		p1.setPrameter(key, value);
		connection.sendPackage(p1);
		Package p = connection.receivePackage();
		String result = (String) p.getResult();
		return result;
	}

}
