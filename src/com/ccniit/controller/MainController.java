package com.ccniit.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Constant;
import com.ccniit.model.Property_Content;
import com.ccniit.model.Property_ContentDataModel;
import com.ccniit.model.User;
import com.ccniit.sys.EditCurpassword;
import com.ccniit.util.RestResult;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


/**
 *  <code>MainController</code>类是主界面的控制器。
 *  
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see Main
 * @see ViewHelper
 * 
 */
public class MainController extends ViewHelper implements Initializable{
	@FXML
	private Label title;
	@FXML
	private Label name;
	@FXML
	private ImageView image;
	@FXML
	private Button   expiredCylinder ;
	@FXML
	private Button   addCylinder ;
	@FXML
	private Button   cylinderDetail ;
	@FXML
	private Button   willExpire ;
	@FXML
	private Button   userView ;
	@FXML
	private Button   monthRecord ;
	@FXML
	private Button   yearRecord ;
	@FXML
	private Button   companyView ;
	private Stage stage=LocalManager.getApplication().getMainStage();
	private double stagePostionX;
	private double stagePostionY;
	final static private int passwordWidth=150;
	final static private int labelWidth=150;
	private final static String pattern = "yyyy-MM-dd HH:mm:ss";
	private User user=LocalManager.getUser();
	final private Stage curInfo = new Stage();
	
    @FXML
    public void editcur(ActionEvent event){
    	showEditPasswordDialog();
    }
	@FXML
	public void expiredCylinder(ActionEvent event){
		LocalManager.getApplication().showExpiredCylinder();
	}
	@FXML
	public void addCylinder(ActionEvent event){
		LocalManager.getApplication().showAddCylinder();
	}
	@FXML
	public void cylinderDetail(ActionEvent event){
		LocalManager.getApplication().showCylinderDetail();
	}
	@FXML
	public void willExpire(ActionEvent event){
		LocalManager.getApplication().showWillExpireCylinder();
	}
	@FXML
	public void userView(ActionEvent event){
		LocalManager.getApplication().showStaffDetail();
	}
	@FXML
	public void companyView(ActionEvent event){
		LocalManager.getApplication().showCompanyDetail();
	}
	@FXML
	public void monthRecord(ActionEvent event){
		LocalManager.getApplication().showMonthRecord();
	}
	@FXML
	public void yearRecord(ActionEvent event){
		LocalManager.getApplication().showYearRecord();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setText(LocalManager.getUser().getName());
		title.setText(LocalManager.getUser().getLoginName());	
		image.hoverProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				if(image.isHover()){
					showCurInfo();
				}else{
					curInfo.hide();
				}
			}
		});
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        @Override
	        public void handle(final WindowEvent event) {
	        	showConfirmQuit();
	        }
	    });

	}

	private void showEditPasswordDialog() {
	    // initialize the dialog.
	    final Stage dialog = new Stage();
	    dialog.setTitle("修改密码");
	    dialog.initOwner(stage);  //对话框永远在前面
	    dialog.initModality(Modality.WINDOW_MODAL);  //必须关闭对话框后才能操作其他的
	    dialog.initStyle(StageStyle.UTILITY); //对话框-只保留关闭按钮
        dialog.setX(stage.getX() + stage.getWidth());
	    dialog.setY(stage.getY()+stage.getHeight()/3);
	 
	    // create a grid for the data entry.
	    GridPane grid = new GridPane();
	    final PasswordField newPassWord = new PasswordField();
	    final PasswordField rePassWord = new PasswordField();
	    final PasswordField lastPassWord = new PasswordField();
	    final Label message=new Label(); 
	    final Label lastMessage=new Label();
	    final Label newMessage=new Label();
	    final Label reMessage=new Label();

	    newPassWord.setPrefWidth(passwordWidth);
	    rePassWord.setPrefWidth(passwordWidth);
	    lastPassWord.setPrefWidth(passwordWidth);
	    lastMessage.setPrefWidth(labelWidth);
	    newMessage.setPrefWidth(labelWidth);
	    reMessage.setPrefWidth(labelWidth);
	    lastPassWord.setPromptText("输入原密码");
	    newPassWord.setPromptText("输入新的密码");
	    rePassWord.setPromptText("确认新的密码");
	    //监听旧密码是否输入正确
	    lastPassWord.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				String lastPwd=lastPassWord.getText().trim();
				if(!lastPwd.equals("")){
					if(user.getPassword().equals(lastPwd)){
						lastMessage.setText(Constant.PASSWORD_RIGHT);
					    lastMessage.setTextFill(Color.rgb(21, 117, 84));
					}else{
						lastMessage.setText(Constant.PASSWORD_WRONG);
					    lastMessage.setTextFill(Color.rgb(210, 39, 30));
					}
				}
			}
		});	
	   
	    newPassWord.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				String newPwd=newPassWord.getText().trim();
				if(!newPwd.equals("")){
					if(newPwd.length()>5&&newPwd.length()<32){
						newMessage.setText(Constant.PASSWORD_SIZE_RIGHT);
						newMessage.setTextFill(Color.rgb(21, 117, 84));
					}else{
						newMessage.setText(Constant.PASSWORD_SIZE_ERROR);
						newMessage.setTextFill(Color.rgb(210, 39, 30));
					}
				}
			}
		});	

	    rePassWord.hoverProperty().addListener(new InvalidationListener() {
	    	@Override
	    	public void invalidated(Observable observable) {
				String rePwd=rePassWord.getText().trim();
				String newPwd=newPassWord.getText().trim();
				if(!rePwd.equals("")&!rePassWord.isHover()){
					if(rePwd.equals(newPwd)){
						reMessage.setText(Constant.PASSWORD_SIZE_RIGHT);
						reMessage.setTextFill(Color.rgb(21, 117, 84));
					   
					}else{
						reMessage.setText(Constant.PASSWORD_NOT_SAME);
						reMessage.setTextFill(Color.rgb(210, 39, 30));
					}
					
				}
	    	}    	
	    	});
	    lastMessage.setAlignment(Pos.CENTER);
	    lastMessage.setContentDisplay(ContentDisplay.CENTER);
	    newMessage.setAlignment(Pos.CENTER);
	    newMessage.setContentDisplay(ContentDisplay.CENTER);
	    reMessage.setAlignment(Pos.CENTER);
	    reMessage.setContentDisplay(ContentDisplay.CENTER);
	    grid.addRow(0,message);
	    grid.addRow(1,lastPassWord,lastMessage);
	    grid.addRow(2,newPassWord,newMessage);
	    grid.addRow(3,rePassWord,reMessage);	    
	    grid.setHgap(0);
	    grid.setVgap(10);
	    GridPane.setHgrow(lastPassWord, Priority.ALWAYS);
	    GridPane.setHgrow(newPassWord, Priority.ALWAYS);
	    GridPane.setHgrow(rePassWord, Priority.ALWAYS); 
	    // create action buttons for the dialog.
	    Button ok = new Button("确认");
	    ok.setDefaultButton(true);
	    Button cancel = new Button("取消");
	    cancel.setCancelButton(true);

	    // only enable the ok button when there has been some text entered.
	    ok.disableProperty().bind(lastPassWord.textProperty().isEqualTo("").or(newPassWord.textProperty().isEqualTo("").or(rePassWord.textProperty().isEqualTo("")).or(lastMessage.textProperty().isEqualTo(Constant.PASSWORD_WRONG)).or(newMessage.textProperty().isEqualTo(Constant.PASSWORD_SIZE_ERROR)).or(reMessage.textProperty().isEqualTo(Constant.PASSWORD_NOT_SAME))));
	 
	    // add action handlers for the dialog buttons.
	    ok.setOnAction(new EventHandler<ActionEvent>() {
	      @Override public void handle(ActionEvent actionEvent) {
	    	//保存新密码 
	    	RestResult<User> result=EditCurpassword.editcurcompany(user.getId()+"",newPassWord.getText().trim());
	    	if(result.getResult()){
	    		message.setText(Constant.ACTION_SUCCESS);
	    		message.setTextFill(Color.rgb(21, 117, 84));
	    	}else{
	    		message.setText(result.getMessage());
	    		message.setTextFill(Color.rgb(210, 39, 30));
	    	}
	        //dialog.close();
	      }
	    });
	    cancel.setOnAction(new EventHandler<ActionEvent>() {
	      @Override public void handle(ActionEvent actionEvent) {
	        dialog.close();
	      }
	    });
	    // layout the dialog.
	    HBox buttons = HBoxBuilder.create().spacing(10).children(ok, cancel).alignment(Pos.CENTER_RIGHT).build();
	    VBox layout = new VBox(10);
	    layout.getChildren().addAll(grid, buttons);
	    layout.setPadding(new Insets(10));
	    dialog.setScene(new Scene(layout));
	    dialog.show();
	}
	
	 @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	private void showCurInfo() {
		 	//curInfo.initModality(Modality.NONE);
			//curInfo.initStyle(StageStyle.UNDECORATED);
		 	//curInfo.initStyle(StageStyle.UTILITY); 
			curInfo.setX(stage.getX()-stage.getWidth()/10*9);
			curInfo.setY(stage.getY());
			curInfo.setTitle("个人信息");
			//curInfo.getIcons().add(new Image("http://icons.iconarchive.com/icons/icons-land/vista-people/72/Historical-Viking-Female-icon.png"));  // icon license: Linkware (Backlink to http://www.icons-land.com required)
		    // create a table.
		    final TableView<Property_ContentDataModel> table = new TableView<>(
		      FXCollections.observableArrayList(
		        new Property_ContentDataModel(new Property_Content("ID",user.getId()+"")),
		        new Property_ContentDataModel(new Property_Content("所属公司编号",user.getCompanyId()+"")),
		        new Property_ContentDataModel(new Property_Content("登录名",user.getLoginName())),
		        new Property_ContentDataModel(new Property_Content("工号",user.getNo())),
		        new Property_ContentDataModel(new Property_Content("用户名",user.getName())),
		        new Property_ContentDataModel(new Property_Content("邮箱",user.getEmail())),
		        new Property_ContentDataModel(new Property_Content("手机",user.getMobile())),
		        new Property_ContentDataModel(new Property_Content("电话",user.getPhone())),
		        new Property_ContentDataModel(new Property_Content("登录IP",user.getLoginIp())),
		        new Property_ContentDataModel(new Property_Content("上次登录时间",new SimpleDateFormat(pattern).format(user.getLoginDate()))),
		        new Property_ContentDataModel(new Property_Content("账户创建时间",new SimpleDateFormat(pattern).format(user.getCreateDate()))),
		        new Property_ContentDataModel(new Property_Content("备注",user.getRemarks()))
		      )
		    );
		 
		    // define the table columns.
		    TableColumn<Property_ContentDataModel, String> property = new TableColumn<>("属性");
		    property.setCellValueFactory(new PropertyValueFactory("property"));
		    TableColumn<Property_ContentDataModel, String> content = new TableColumn<>("内容");
		    content.setCellValueFactory(new PropertyValueFactory("content"));
		    content.setPrefWidth(labelWidth+100);
		    table.getColumns().setAll(property, content);
		    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
		    curInfo.setScene(new Scene(table));
		    stage.setFocused(true);
		    curInfo.getIcons().add(new Image("http://icons.iconarchive.com/icons/icons-land/vista-people/72/Historical-Viking-Female-icon.png"));
		    curInfo.getIcons().add(new Image(Constant.ICON_PATH));
		    curInfo.show();
	 	}
	private void showConfirmQuit() {
        //Stage init
    	stagePostionX=stage.getX();
    	stagePostionY=stage.getY();
        final Stage dialog = new Stage();
        dialog.setTitle("提示");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setX(stage.getX() + stage.getWidth()/3);
        dialog.setY(stage.getY()+stage.getHeight()/3);
        HBox msg = new HBox();
        msg.setSpacing(10);  
        // Frage - Label
        Label label = new Label("确认退出？");
        msg.getChildren().addAll(label);
        // Antwort-Button JA
        Button okBtn = new Button("确定");
        okBtn.setPrefSize(60, 40);
        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        // Antwort-Button NEIN
        Button cancelBtn = new Button("取消");
        cancelBtn.setPrefSize(60, 40);
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	stage.setX(stagePostionX);
            	stage.setY(stagePostionY);
                stage.show();
                dialog.close();
            }
        });
        HBox buttons = HBoxBuilder.create().spacing(10).children(okBtn, cancelBtn).alignment(Pos.CENTER_RIGHT).build();
        VBox layout = new VBox(10);
        layout.getChildren().addAll(msg, buttons);
        layout.setPadding(new Insets(15));
        dialog.setScene(new Scene(layout));
        dialog.getIcons().add(new Image("http://icons.iconarchive.com/icons/icons-land/vista-people/72/Historical-Viking-Female-icon.png"));
        dialog.show();
	  }


}
