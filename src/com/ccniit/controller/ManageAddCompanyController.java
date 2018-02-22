package com.ccniit.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.ccniit.manager.CompanyDetailManager;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Company;
import com.ccniit.model.Constant;
import com.ccniit.util.RestResult;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManageAddCompanyController extends ViewHelper implements Initializable{
	@FXML
	private Button saveInfo;
	@FXML
	private ChoiceBox<String> companyType;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private TextField address;
	@FXML
	private TextField province_code;
	@FXML
	private TextField loginName;
	@FXML
	private TextField password;
	@FXML
	private TextArea remarks;	
	@FXML
	private Label messageLabel;
	private final static Logger log = Logger.getLogger(ManageAddCompanyController.class);
	private CompanyDetailManager companydetailmanager= LocalManager.getCompanyDetailManager();
	public void saveInfo(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		//
		Company c=LocalManager.getCompany();
		c.setName(name.getText());
		c.setCompanyType(companyType.getSelectionModel().getSelectedItem());
		c.setPhone(phone.getText());
		if(!province_code.getText().equals(""))
		c.setProvinceCode(province_code.getText());
		if(!remarks.getText().equals(""))
		c.setRemarks(remarks.getText());
		if(!address.getText().equals(""))
		c.setAddress(address.getText());
		RestResult<Company> result=companydetailmanager.save(c);
		if(!result.getResult()){
			animateMessage(result.getMessage(),messageLabel);	
		}else{
			animateMessage(Constant.ADD_COMPANY_SUCCESS,messageLabel);
			//清空所有输入框
			loginName.setText("");
			password.setText("");
			name.setText("");
			province_code.setText("");
			phone.setText("");
			remarks.setText("");
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		companyType.setItems(FXCollections.observableArrayList("1","2"));
		companyType.getSelectionModel().selectFirst();
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		name.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!name.isFocused()){
					if(name.getText()==null){
						animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
					}else if(name.getText().length()<=2){
						animateMessage(Constant.NAME_LENGTH_SHORT,messageLabel);					
					}else{
						loginName.setText(name.getText());
						animateMessage(null,messageLabel);	
					}	
				}	
			}
		});
		
		phone.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!phone.isFocused()){
					if(phone.getText()==null){
						animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
					}else if(phone.getText().length()<7||phone.getText().length()>11){
						animateMessage(Constant.PHONE_PATTERN_ERROR,messageLabel);					
					}else{
						password.setText(phone.getText());
						animateMessage(null,messageLabel);	
					}	
				}	
			}
		});
		
		password.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				saveInfo.setVisible(loginName.getText().length() != 0&password.getText().length()!= 0);
			}
		});	
	}


}
