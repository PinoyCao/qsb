package com.ccniit.controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.ccniit.manager.AddCylinderManager;
import com.ccniit.manager.ExpiredCylinderManager;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Constant;
import com.ccniit.model.Cylinder;
import com.ccniit.model.CylinderDataModel;
import com.ccniit.util.RestResult;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * <code>ManageExpiredCylinderController</code>类是在线查询已经过期气瓶界面的控制器。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see CylinderDataModel
 * @see Cylinder
 * @see ViewHelper
 * @see TableViewHelper
 * @see ExpiredCylinderManager
 *
 */

public class ManageImportCylinderController extends ViewHelper implements Initializable,TableViewHelper{
	@FXML
	private TableView<CylinderDataModel> CylinderTable;
	@FXML
	private TableColumn<CylinderDataModel, String> id;
	@FXML
	private TableColumn<CylinderDataModel, String> companyId;
	@FXML
	private TableColumn<CylinderDataModel, String> uid;
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
	private TableColumn<CylinderDataModel, String> manufactureDate;	
	@FXML
	private Label messageLabel;
	private final static Logger log = Logger.getLogger(ManageImportCylinderController.class);
	private ObservableList<CylinderDataModel> CylinderDataSource;
	private List<Cylinder> types;
	private AddCylinderManager addCylinderManager = LocalManager.getAddCylinderManager();
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();
		
	
	@FXML
	public void uploadExcel(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		
		FileChooser fileChoose = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");  
		fileChoose.getExtensionFilters().add(extFilter); 
		File file = fileChoose.showOpenDialog(new Stage());
		if(file==null) {
			log.debug("取消上传");
			animateMessage(Constant.CANCAL_UPLOAD,messageLabel);
			return;
		}
		RestResult<Cylinder> result=addCylinderManager.upload(file);
		if(result.getResult()){//上传成功
			this.types=result.getList();
			loadTableData();			
		}
		animateMessage(result.getMessage(),messageLabel);
		
	}	
	@Override
	public void initTable() {
		CylinderDataSource=FXCollections.observableArrayList();
		CylinderTable.setEditable(true);
		
		id.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("id"));
		companyId.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("companyId"));
		uid.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("uid"));	
		type.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("type"));	
		contentName.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("contentName"));	
		testCycle.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("testCycle"));	
		serviceLife.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("serviceLife"));	
		location.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("location"));	
		manufactureDate.setCellValueFactory(new PropertyValueFactory<CylinderDataModel,String>("manufactureDate"));	
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
		
		modalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				stage.show();
				
			}
			
		});
	}
	
}
