package com.ccniit.manager;

import java.io.File;

import com.ccniit.model.Cylinder;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.AddCylinder;
import com.ccniit.sys.ImportCylinder;
import com.ccniit.util.RestResult;

public class AddCylinderManager extends Requester<Cylinder> implements Manageable<Cylinder>{
	private static AddCylinderManager addCylinderManager=new AddCylinderManager();
	
	private AddCylinderManager(){}
	
	public static AddCylinderManager getAddCylinderManager() {
		return addCylinderManager;
	}
	public RestResult<Cylinder> upload(File file){
		ImportCylinder.importcylinder(file);
		return ImportCylinder.lastImport();
	}
	@Override
	public Data getAll(String size, String page, String sort) {
		return null;
	}

	@Override
	public RestResult<Cylinder> query(String id) {
		return null;
	}

	@Override
	public RestResult<Cylinder> delete(Cylinder t) {
		return null;
	}

	@Override
	public RestResult<Cylinder> save(Cylinder t) {
		return AddCylinder.addcylinder(t);
	}

	@Override
	public RestResult<Cylinder> update(Cylinder t) {
		return null;
	}

}
