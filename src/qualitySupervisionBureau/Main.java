package qualitySupervisionBureau;

import com.ccniit.connectServer.Http_util;
import com.ccniit.controller.LoginController;
import com.ccniit.controller.MainController;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.ConfigurationReader;
import com.ccniit.model.Constant;
import com.ccniit.util.Language;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <code>Main</code>类是整个系统的启动类，它控制着系统各个界面
 * 的跳转。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see MainController
 * @see LoginController
 */
public class Main extends Application {

	private final static Logger log = Logger.getLogger(Main.class);

	private Stage mainStage;							//登录界面和主界面的Stage。
	private Stage modalStage;							//模式窗口的Stage
	private MainController mainController;				//主界面的控制器。
	@Override
	public void start(Stage stage) throws Exception {
		init(stage);
		stage.show();
	}


	/**
	 * 初始化。
	 * 
	 * @param stage 来自start方法中的Stage
	 */
	private void init(Stage stage){
		//初始化国际化配置
		Language language = new Language(Constant.LANGUAGE_PACKAGE_NAME);
		language.setDefaultLanguage();
		//加载连接服务器配置文件
		ConfigurationReader.initializ(Constant.SERVER_CONFIG_FILE_PATH);
		/*
		 *检测服务器连接
		 */
		Object flag = new Object();
		Http_util.threadstart(flag);
		synchronized (flag) {
			try {
				flag.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("网络连接："+Constant.isonline);
		this.mainStage=stage;
		LocalManager.setApplication(this);
		goToLoginView(); //the first view
		stage.setTitle(Constant.MAIN_VIEW_TITLE);
		stage.getIcons().add(new Image(Constant.ICON_PATH));
	}


	@Override
	public void stop() throws Exception {
		super.stop();
	}

	/**
	 * 显示主界面
	 */
	public void goToMainView(){
		log.info("lanuch MainView");
		try {
			mainController = (MainController) replaceSceneContent(Constant.MAIN_VIEW_PATH);
		} catch (Exception e) {
			log.error(e, e.fillInStackTrace());
		}
	}

	/**
	 * 显示登录界面
	 */
	public void goToLoginView(){
		log.info("lanuch loginView");
		try {
			replaceSceneContent(Constant.LOGIN_VIEW_PATH);  
		} catch (Exception e) {
			log.error(e, e.fillInStackTrace());
		}
	}
	/**
	 * 显示查询已经过期气瓶界面。
	 */
	public void showExpiredCylinder(){
		log.info("show expired cylinder");
		showView(Constant.EXPIRED_CYLILNDER_PATH);
	}
	/**
	 * 显示追溯气瓶信息界面。
	 */
	public void showCylinderDetail(){
		log.info("show cylinder detail");
		showView(Constant.CYLILNDER_DETAIL_PATH);
	}
	/**
	 * 显示在线增加气瓶信息界面。
	 */
	public void showAddCylinder(){
		log.info("show add Cylinder");
		showView(Constant.ADD_CYLILNDER_PATH);
	}
	/**
	 * 显示批量增加气瓶信息界面。
	 */
	public void showImportCylinder(){
		log.info("show import Cylinder");
		showView(Constant.IMPORT_CYLINDER_PATH);
	}	
	/**
	 * 显示查询即将过期气瓶界面。
	 */
	public void showWillExpireCylinder(){
		log.info("show will expire cylinder");
		showView(Constant.WILL_EXPIRE_CYLILNDER_PATH);
	}
	
	/**
	 * 显示质监局员工信息界面。
	 */
	public void showStaffDetail(){
		log.info("show staff detail");
		showView(Constant.STAFF_DETAIL_PATH);
	}
	
	/**
	 * 显示单位信息界面。
	 */
	public void showCompanyDetail(){
		log.info("show company detail");
		showView(Constant.COMPANY_DETAIL_PATH);
	}	

	/**
	 * 显示增加员工信息界面。
	 */
	public void showAddStaff(){
		log.info("show add staff");
		showView(Constant.ADD_STAFF_PATH);
	}
	
	/**
	 * 显示增加单位信息界面。
	 */
	public void showAddCompany(){
		log.info("show add company");
		showView(Constant.ADD_COMPANY_PATH);
	}
	
	/**
	 * 显示月记录界面。
	 */
	public void showMonthRecord(){
		log.info("show month record");
		showView(Constant.MONTH_RECORD_PATH);
	}
	
	/**
	 * 显示年记录界面。
	 */
	public void showYearRecord(){
		log.info("show year record");
		showView(Constant.YEAR_RECORD_PATH);
	}
	
	/**
	 * 显示当前用户信息界面。
	 */
	public void showCurUserInfo(){
		log.info("show cur user info");
		showView2(Constant.CUR_USER_INFO_PATH);
	}
	/**
	 * 显示一个模式窗口,并隐藏主窗口。
	 * 
	 * @param fxmlPath 需要显示的界面的fxml文件路径。
	 */
	private void showView(String fxmlPath){

		final Stage stage = new Stage();
		this.modalStage = stage;
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(fxmlPath),ResourceBundle.getBundle(Constant.LANGUAGE_PACKAGE_NAME));
		} catch (IOException e) {
			log.error(e, e.fillInStackTrace());
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(this.mainStage);
		this.mainStage.hide();
		stage.getIcons().add(new Image(Constant.ICON_PATH));
		stage.show();
	}

	/**
	 * 显示一个模式窗口,与主窗口并存。
	 * 
	 * @param fxmlPath 需要显示的界面的fxml文件路径。
	 */
	private void showView2(String fxmlPath){

		final Stage stage = new Stage();
		this.modalStage = stage;
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(fxmlPath),ResourceBundle.getBundle(Constant.LANGUAGE_PACKAGE_NAME));
		} catch (IOException e) {
			log.error(e, e.fillInStackTrace());
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(this.mainStage);
		stage.setX(this.mainStage.getX()+this.mainStage.getWidth());
		stage.setY(this.mainStage.getY());
		stage.getIcons().add(new Image(Constant.CUR_ICON_PATH));
		stage.show();
	}
	
	/**
	 * 替换布景的内容。
	 * 
	 * @param fxml 需要显示界面的fxml文件路径。
	 * @return	Initializable
	 * @throws Exception
	 */
	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = Main.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(Main.class.getResource(fxml));
		loader.setResources(ResourceBundle.getBundle(Constant.LANGUAGE_PACKAGE_NAME));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		}finally {
			in.close();
		} 
		mainStage.centerOnScreen();
		Scene scene = new Scene(page);
		mainStage.setScene(scene);
		mainStage.sizeToScene();
		return (Initializable) loader.getController();
	}

	/**
	 * 获得主窗体的Stage。
	 * 
	 * @return 当前窗体的Stage。
	 */
	public Stage getMainStage() {
		return mainStage;
	}


	/**
	 * 获得主界面的控制器。
	 * 
	 * @return 主界面控制器。
	 */
	public MainController getMainController() {
		return mainController;
	}



	/**
	 * 获得模式窗口的Stage。
	 * 
	 * @return 模式窗口的Stage。
	 */
	public Stage getModalStage() {
		return modalStage;
	}




	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}




}