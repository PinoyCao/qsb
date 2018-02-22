package com.ccniit.manager;

import com.ccniit.model.User;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.DeleteUser;
import com.ccniit.sys.EditUser;
import com.ccniit.sys.QueryAlluser;
import com.ccniit.util.RestResult;

public class StaffDetailManager extends Requester<User> implements Manageable<User>{
	private static StaffDetailManager staffdetailmanager=new StaffDetailManager();
	
	private StaffDetailManager(){}
	
	public static StaffDetailManager getStaffDetailManager() {
		return staffdetailmanager;
	}
	@Override
	public Data getAll(String size, String page, String sort) {
		return QueryAlluser.queryalluser(size,page,sort);
	}

	@Override
	public RestResult<User> query(String id) {
		return null;
	}

	@Override
	public RestResult<User> delete(User t) {
		return DeleteUser.deleteuser(t.getId()+"");
	}

	@Override
	public RestResult<User> save(User t) {

		return null;
	}

	@Override
	public RestResult<User> update(User t) {
		return EditUser.edituser(t);
		
	}

	
}
