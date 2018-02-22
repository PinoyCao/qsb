package com.ccniit.controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import com.ccniit.manager.LocalManager;
import com.ccniit.manager.WillExpireCylinderManager;
import com.ccniit.model.Constant;
import com.ccniit.model.Cylinder;
import com.ccniit.model.CylinderDataModel;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.WilldueCylinderexcel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
/**
 * <code>ManageWillExpireCylinderController</code>类是在线查询即将过期气瓶界面的控制器。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see CylinderDataModel
 * @see Cylinder
 * @see ViewHelper
 * @see TableViewHelper
 * @see WillExpireCylinderManager
 *
 */
public class ManageWillExpireCylinderController extends ViewHelper implements Initializable,TableViewHelper{
	@FXML
	private TableView<CylinderDataModel> CylinderTable;
	@FXML
	private TableColumn<CylinderDataModel, String> id;
	@FXML
	private TableColumn<CylinderDataModel, String> companyId;
	@FXML
	private TableColumn<CylinderDataModel, String> state;
	@FXML
	private TableColumn<CylinderDataModel, String> type;
	@FXML
	private TableColumn<CylinderDataModel, String> contentName;
	@FXML
	private TableColumn<CylinderDataModel, String> testCycle;
	@FXML
	private TableColumn<CylinderDataModel, String> serviceLife;
	@FXML
	private TableColumn<CylinderDataModel, String> location;
	@FXML
	private TextField searchBox;
	@FXML
	private Button searchButton;
	@FXML
	private Label page;
	@FXML
	private Label daycount;
	@FXML
	private Label messageLabel;
	private final static Logger log = Logger.getLogger(ManageWillExpireCylinderController.class);
	private ObservableList<CylinderDataModel> CylinderDataSource;
	private List<Cylinder> types;
	private WillExpireCylinderManager willexpireCylinderManager = LocalManager.getWillExpireCylinderManager();
	private int daysize;
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();
	@FXML
	public void searchAction(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		String text=searchBox.getText();
		try{
			daysize=Integer.parseInt(text);
		}catch(Exception e){
			animateMessage(Constant.DAY_FORMAT_ERROR,messageLabel);
			return;
		}if(daysize>15||daysize<1){
			animateMessage(Constant.DAY_SIZE_ERROR,messageLabel);
			return;
		}else{
			fetchData("0",daysize+"");
		}	
	}
	@FXML
	public void lastpage(ActionEvent event){
		int pageSize=Integer.parseInt(page.getText())-2;
		if(pageSize<0){
			animateMessage(Constant.FIRST_PAGE,messageLabel);
			pageSize=0;
		}
		fetchData(pageSize+"",daycount.getText());
	}
	
	@FXML
	public void nextpage(ActionEvent event){
		fetchData(page.getText(),daycount.getText());
	}
	@FXML
	public void exportExcel(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		FileChooser fileChoose = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");  
		fileChoose.getExtensionFilters().add(extFilter);  
		File file = fileChoose.showSaveDialog(LocalManager.getApplication().getModalStage());
		if(file==null) {
			log.debug("取消下载");
			animateMessage(Constant.CANCAL_DOWNLOAD,messageLabel);
			return;
		}
		String exportFilePath = file.getAbsolutePath().replaceAll(".xlsx", "")+".xlsx."; 
		if(WilldueCylinderexcel.duecylinderexcel(daycount.getText(),exportFilePath)){
			log.debug("下载成功");
			animateMessage(Constant.SUCCESS_DOWNLOAD,messageLabel);
		}else{
			log.debug("下载失败");
			animateMessage(Constant.FAIL_DOWNLOAD,messageLabel);
		}

	}	
	@Override
	public void initTable() {
		CylinderDataSource=FXCollections.observableArrayList();
		CylinderTable.setEditable(true);
		
		id.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("id"));
		companyId.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("companyId"));
		state.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("state"));	
		type.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("type"));	
		contentName.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("contentName"));	
		testCycle.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("testCycle"));	
		serviceLife.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("serviceLife"));	
		location.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("location"));	
		CylinderTable.setItems(CylinderDataSource);
		
	}

	@Override
	public void loadTableData() {
		CylinderDataSource.clear();
		if(types!=null)
		for(Cylinder type:types){
			CylinderDataSource.add(new CylinderDataModel(type));
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		initTable();
		page.setText("1");
		daycount.setText("15");
		fetchData("0","15");
		/*
		 * 为搜索框添加一个内容改变的监听器
		 */
		searchBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				searchButton.setVisible(searchBox.getText().length() != 0);
			}
		});	
		
		modalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				stage.show();
				
			}
			
		});
		
	}
	private void fetchData(String pagesize,String daysize){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}		
		Data info=willexpireCylinderManager.getAll("19",pagesize,daysize,"ASC");
		if(info.getResult()){
		@SuppressWarnings("unchecked")
		List<Cylinder> types = (List<Cylinder>) info.getContent();
		daycount.setText(daysize);
		page.setText(CountPage(info.getNumber()));
		this.types = types;
		}
		else{
			animateMessage(info.getMessage(),messageLabel);
		}
		loadTableData();
	}
	private String CountPage(String page){
		String pageSize=null;
		int number=Integer.parseInt(page)+1;
		pageSize=String.valueOf(number);
		return pageSize;
	}
}
