package com.ccniit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.ccniit.manager.AddStaffManager;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Constant;
import com.ccniit.model.User;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManageAddStaffController extends ViewHelper implements Initializable{

	@FXML
	private Button saveInfo;
	@FXML
	private TextField loginName;
	@FXML
	private ChoiceBox<String> companyId;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField repwd;
	@FXML
	private TextField no;
	@FXML
	private TextField name;
	@FXML
	private TextField email;
	@FXML
	private TextField phone;
	@FXML
	private TextField mobile;
	@FXML
	private TextArea remarks;	
	@FXML
	private Label messageLabel;
	private final static Logger log = Logger.getLogger(ManageAddStaffController.class);
	private AddStaffManager addstaffmanager=LocalManager.getAddStaffManager();
	@FXML
	public void saveInfo(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		User u=LocalManager.getStaff();
		u.setLoginName(loginName.getText());
		u.setPassword(password.getText());
		u.setNo(no.getText());
		u.setName(name.getText());
		if(!email.getText().equals(""))
		u.setEmail(email.getText());
		if(!phone.getText().equals(""))
		u.setPhone(phone.getText());
		if(!mobile.getText().equals(""))
		u.setMobile(mobile.getText());
		if(!remarks.getText().equals(""))
		u.setRemarks(remarks.getText());
		RestResult<User> userResult =addstaffmanager.save(u);
		if(!userResult.getResult()){
			animateMessage(userResult.getMessage(),messageLabel);	
		}else{
			animateMessage(Constant.ADD_STAFF_SUCCESS,messageLabel);
			//清空所有输入框
			loginName.setText("");
			password.setText("");
			repwd.setText("");
			no.setText("");
			name.setText("");
			email.setText("");
			phone.setText("");
			mobile.setText("");
			remarks.setText("");
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		companyId.setItems(FXCollections.observableArrayList("1"));
		companyId.getSelectionModel().selectFirst();
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		/*
		 * 为特殊框添加一个内容改变的监听器
		 */
		loginName.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!loginName.isFocused()){
					if(loginName.getText()==null){
						animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
					}else if(loginName.getText().length()<=2){
						animateMessage(Constant.LOGINNAME_LENGTH_SHORT,messageLabel);					
					}else{
						animateMessage(null,messageLabel);	
					}	
				}
			
				
			}
		});	
		password.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!password.isHover()){
					if(password.getText().equals("")){
						animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
					}else if(password.getText().length()<6||password.getText().length()>32){
						animateMessage(Constant.PASSWORD_SIZE_ERROR,messageLabel);						
					}else{
						animateMessage(null,messageLabel);					
					}					
				}
			}
		});	
		repwd.focusedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
					if(!repwd.isHover()){
						if(repwd.getText().equals("")){
							animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
						}else if(!repwd.getText().equals(password.getText())){
							animateMessage(Constant.PASSWORD_NOT_SAME,messageLabel);
						}else{
							animateMessage(null,messageLabel);						
						}	
					}
					
				}
			});	
		no.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!no.isHover()){
					if(no.getText().equals("")){
						animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
					}else{
						animateMessage(null,messageLabel);					
					}					
				}
			}
		});	
		name.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!name.isHover()){
					if(name.getText().equals("")){
						animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
					}else{
						animateMessage(null,messageLabel);					
					}					
				}
			}
		});	
		name.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				saveInfo.setVisible(name.getText().length() != 0&password.getText().length() != 0&loginName.getText().length() != 0&no.getText().length() != 0);
			}
		});	
		email.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!email.isFocused()){
					if(checkEmail(email.getText())){
						animateMessage(null,messageLabel);	
					}else{
						animateMessage(Constant.EMAIL_PATTERN_ERROR,messageLabel);						
					}
				}	
			}	
		});	
		phone.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!phone.isFocused()){
					if(phone.getText().length()>5&&phone.getText().length()<17){
						animateMessage(null,messageLabel);	
					}else{
						animateMessage(Constant.PHONE_PATTERN_ERROR,messageLabel);						
					}
				}	
			}	
		});	
		mobile.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if(!mobile.isFocused()){
					if(checkMobileNumber(mobile.getText())){
						animateMessage(null,messageLabel);	
					}else{
						animateMessage(Constant.MOBILE_PATTERN_ERROR,messageLabel);						
					}
				}	
			}	
		});	
	}
	
	
    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
     
    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber){
        boolean flag = false;
        try{
                Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
                Matcher matcher = regex.matcher(mobileNumber);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
}
