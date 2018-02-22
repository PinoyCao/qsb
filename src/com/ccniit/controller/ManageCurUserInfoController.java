package com.ccniit.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Property_Content;
import com.ccniit.model.Property_ContentDataModel;
import com.ccniit.model.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageCurUserInfoController extends ViewHelper implements Initializable,TableViewHelper{
	@FXML
	private TableView<Property_ContentDataModel> UserTable;
	@FXML
	private TableColumn<Property_ContentDataModel, String> property;	
	@FXML
	private TableColumn<Property_ContentDataModel, String> content;	
	@FXML
	private Label messageLabel;
	private ObservableList<Property_ContentDataModel> UserDataSource;
	private final static String pattern = "yyyy-MM-dd HH:mm:ss";
	@Override
	public void initTable() {
		UserDataSource=FXCollections.observableArrayList();
		UserTable.setEditable(true);
		property.setCellValueFactory(new PropertyValueFactory<Property_ContentDataModel,String>("property"));
		content.setCellValueFactory(new PropertyValueFactory<Property_ContentDataModel,String>("content"));
		UserTable.setItems(UserDataSource);
		loadTableData();

	}

	@Override
	public void loadTableData() {
		UserDataSource.clear();
		User u=LocalManager.getUser();
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("ID",u.getId()+"")));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("所属公司编号",u.getCompanyId()+"")));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("登录名",u.getLoginName())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("工号",u.getNo())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("用户名",u.getName())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("邮箱",u.getEmail())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("电话",u.getPhone())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("手机",u.getMobile())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("登录IP",u.getLoginIp())));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("上次登录时间",new SimpleDateFormat(pattern).format(u.getLoginDate()))));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("账户创建时间",new SimpleDateFormat(pattern).format(u.getCreateDate()))));
		UserDataSource.add(new Property_ContentDataModel(new Property_Content("备注",u.getRemarks())));	
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initTable();
		
	}

}
