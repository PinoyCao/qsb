package com.ccniit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


import com.ccniit.manager.LocalManager;
import com.ccniit.model.Constant;
import com.ccniit.model.User;
import com.ccniit.sys.pub.login.GetYZM;
import com.ccniit.sys.pub.login.UserLogincontroller;
import com.ccniit.util.RestResult;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * <code>LoginController</code>类是登录界面的控制器。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see UserManager
 * @see LocalManager
 * @see Main
 * @see ViewHelper
 *
 */
public class LoginController extends ViewHelper implements Initializable{

	private final static Logger log = Logger.getLogger(LoginController.class);
	private final static String validateCode="验证码";
	@FXML
	private Label messageLabel;
	@FXML
	private Button loginButton;
	@FXML
	private TextField userNameFeild;
	@FXML
	private PasswordField passwordField;
	@FXML
	private TextField yzmFeild;
	@FXML
	private ImageView imageview;
	@FXML
	private Button flashcode;
	@FXML
	private Label codeLabel;	

	@FXML
	public void flashCode(ActionEvent event){
		imageview.setImage(GetYZM.getValidateImage());
	}
	
	@FXML
	public void loginAction(ActionEvent event){
		final String loginId = userNameFeild.getText().trim();
		final String password = passwordField.getText().trim();
		String code=yzmFeild.getText().trim();
		if(!Constant.isonline){
			animateMessage( Constant.FAIL_TO_CONNECT_SERVER , messageLabel);
			return;
		}
		if(loginId.equals("")||password.equals("")){
			log.debug("用户名或密码输入为空");
			animateMessage( Constant.INPUT_CANT_BE_NULL , messageLabel );
			return;
		}
		if(Constant.havecode&&code.equals("")){
			log.debug("验证码输入为空");
			animateMessage( Constant.CODE_CANT_BE_NULL , messageLabel );
			return;
		}else{
			if(code==null){
				code="";
			}
			//如果连接有效，保存连接
			//LocalManager.setConnection(connection);
			//RestResult<User> userResult= UserLogincontroller.controluserlogin(loginId, password,code);
			FutureTask<RestResult> futureTask = UserLogincontroller.asyncLogin(loginId, password, code);
			animateMessage("正在登陆...", messageLabel);
			loginButton.setDisable(true);
			new Thread(){
				public void run(){
						while(true){
							try{
								Thread.sleep(100);
								//拿到了，就不会抛出异常
								final RestResult<User> userResult = futureTask.get(200, TimeUnit.MICROSECONDS);
								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										update(userResult,password);
									}
								});
								break;
							}catch(Exception e){
								
							}
						}
				}
				
			}.start();
		}	
	}
	private void update(RestResult<User> userResult,String password){
		loginButton.setDisable(false);
		if(userResult.getResult()){
			User user=userResult.getData();
			user.setPassword(password);
			log.debug(user.getName()+" login success");
			//保存user信息
			LocalManager.setUser(user);
			LocalManager.getApplication().goToMainView();
		}
		else{ 
			if(userResult.getMessage().indexOf(validateCode)==-1){

			}else{//用户名或密码错误3次以上，有验证码
				Constant.havecode=true;
				codeLabel.setVisible(true);
				yzmFeild.setVisible(true);
				imageview.setVisible(true);
				flashcode.setVisible(true);
				imageview.setImage(GetYZM.getValidateImage());
			}
			animateMessage(userResult.getMessage(), messageLabel);
			//userNameFeild.setText(null);
			passwordField.setText(null);	
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userNameFeild.setEditable(false);
	}
	
}
