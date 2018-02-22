package com.ccniit.manager;

import com.ccniit.model.User;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.CreateUser;
import com.ccniit.util.RestResult;

public class AddStaffManager extends Requester<User> implements Manageable<User>{
	private static AddStaffManager addstaffmanager=new AddStaffManager();
	
	private AddStaffManager(){}
	
	public static AddStaffManager getAddStaffManager() {
		return addstaffmanager;
	}
	@Override
	public Data getAll(String size, String page, String sort) {
		return null;
	}

	@Override
	public RestResult<User> query(String id) {
		return null;
	}

	@Override
	public RestResult<User> delete(User t) {
		return null;
	}

	@Override
	public RestResult<User> save(User t) {
		return CreateUser.createuser(t);
	}

	@Override
	public RestResult<User> update(User t) {
		return null;
	}

}
