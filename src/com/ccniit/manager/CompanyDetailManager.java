package com.ccniit.manager;

import com.ccniit.model.Company;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.CreateCompany;
import com.ccniit.sys.DeleteCompany;
import com.ccniit.sys.EditCompany;
import com.ccniit.sys.QueryAllcompany;
import com.ccniit.sys.QueryCurcompany;
import com.ccniit.util.RestResult;

public class CompanyDetailManager extends Requester<Company> implements Manageable<Company>{
	private static CompanyDetailManager companydetailmanager=new CompanyDetailManager();
	
	private CompanyDetailManager(){}
	
	public static CompanyDetailManager getCompanyDetailManager() {
		return companydetailmanager;
	}
	@Override
	public Data getAll(String size, String page, String sort) {
		return QueryAllcompany.queryallcompany(size, page, sort);
	}

	@Override
	public RestResult<Company> query(String id) {
		return QueryCurcompany.querycurcompamy();
	}

	@Override
	public RestResult<Company> delete(Company t) {
		return DeleteCompany.deletecompany(t.getId()+"");
	}

	@Override
	public RestResult<Company> save(Company t) {
		return CreateCompany.createcompany(t);
	}

	@Override
	public RestResult<Company> update(Company t) {
		return EditCompany.editcompany(t);
	}

}
