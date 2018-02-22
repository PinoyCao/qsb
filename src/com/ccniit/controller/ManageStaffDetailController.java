package com.ccniit.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.ccniit.manager.LocalManager;
import com.ccniit.manager.StaffDetailManager;
import com.ccniit.model.Constant;
import com.ccniit.model.StaffDataModel;
import com.ccniit.model.User;
import com.ccniit.model.response_entity.Data;
import com.ccniit.util.RestResult;
import com.ccniit.view.DeleteStaffButtonCell;
import com.ccniit.view.EditingStringCell;

import javafx.scene.control.TableCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class ManageStaffDetailController extends ViewHelper implements Initializable,TableViewHelper{
	@FXML
	private TableView<StaffDataModel> staffTable;
	@FXML
	private TableColumn<StaffDataModel, Integer> id;
	@FXML
	private TableColumn<StaffDataModel, Integer> companyId;
	@FXML
	private TableColumn<StaffDataModel, String> no;
	@FXML
	private TableColumn<StaffDataModel, String> loginName;
	@FXML
	private TableColumn<StaffDataModel, String> name;
	@FXML
	private TableColumn<StaffDataModel, String> email;
	@FXML
	private TableColumn<StaffDataModel, String> phone;
	@FXML
	private TableColumn<StaffDataModel, String> mobile;
	@FXML
	private TableColumn<StaffDataModel, Boolean> action;
	@FXML
	private Label page;
	@FXML
	private Label messageLabel;
	private final static Logger log = Logger.getLogger(ManageStaffDetailController.class);
	private List<User> types;
	private StaffDetailManager staffdetailmanager= LocalManager.getStaffDetailManager();
	private ObservableList<StaffDataModel> StaffDataSource;
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();
	@FXML
	public void addStaff(ActionEvent event){
		LocalManager.getApplication().showAddStaff();
	}
	@FXML
	public void refresh(ActionEvent event){
		animateMessage(null,messageLabel);
		int pageSize=Integer.parseInt(page.getText())-1;
		fetchData(pageSize+"");
	}
	@FXML
	public void lastpage(ActionEvent event){
		int pageSize=Integer.parseInt(page.getText())-2;
		if(pageSize<0){
			animateMessage(Constant.FIRST_PAGE,messageLabel);
			pageSize=0;
		}
		fetchData(pageSize+"");		
	}
	@FXML
	public void nextpage(ActionEvent event){
		animateMessage(null,messageLabel);
		fetchData(page.getText());
	}

	@Override
	public void initTable() {
		StaffDataSource=FXCollections.observableArrayList();
		staffTable.setEditable(true);
		id.setCellValueFactory(new PropertyValueFactory<StaffDataModel,Integer>("id"));
		companyId.setCellValueFactory(new PropertyValueFactory<StaffDataModel,Integer>("companyId"));
		no.setCellValueFactory(new PropertyValueFactory<StaffDataModel,String>("no"));
		loginName.setCellValueFactory(new PropertyValueFactory<StaffDataModel,String>("loginName"));
		name.setCellValueFactory(new PropertyValueFactory<StaffDataModel,String>("name"));
		email.setCellValueFactory(new PropertyValueFactory<StaffDataModel,String>("email"));
		phone.setCellValueFactory(new PropertyValueFactory<StaffDataModel,String>("phone"));
		mobile.setCellValueFactory(new PropertyValueFactory<StaffDataModel,String>("mobile"));
		action.setCellValueFactory(new PropertyValueFactory<StaffDataModel,Boolean>("action"));
		//Set cell factory for cells that allow editing
	    Callback<TableColumn<StaffDataModel,String>, TableCell<StaffDataModel,String>> cellEditStringFactory =
					new Callback<TableColumn<StaffDataModel,String>, TableCell<StaffDataModel,String>>() {
				@Override
				public TableCell<StaffDataModel, String> call(TableColumn<StaffDataModel, String> arg0) {
					return new EditingStringCell<StaffDataModel>();
				}
			};
		Callback<TableColumn<StaffDataModel,Boolean>, TableCell<StaffDataModel,Boolean>> cellDeleteChoiceFactory =
					new Callback<TableColumn<StaffDataModel,Boolean>, TableCell<StaffDataModel,Boolean>>() {
				@Override
				public TableCell<StaffDataModel, Boolean>  call(TableColumn<StaffDataModel, Boolean> arg0) {
					return new DeleteStaffButtonCell(LocalManager.getApplication().getModalStage(),staffTable,ManageStaffDetailController.this);
				}
			};
		no.setCellFactory(cellEditStringFactory);
		name.setCellFactory(cellEditStringFactory);
		email.setCellFactory(cellEditStringFactory);
		phone.setCellFactory(cellEditStringFactory);
		mobile.setCellFactory(cellEditStringFactory);
		action.setCellFactory(cellDeleteChoiceFactory);
		staffTable.setItems(StaffDataSource);
		no.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StaffDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<StaffDataModel, String> event) {	
				StaffDataModel staffDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				staffDataModel.getStaff().setNo(event.getNewValue());
				RestResult<User>  result=staffdetailmanager.update(staffDataModel.getStaff());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
		name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StaffDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<StaffDataModel, String> event) {	
				StaffDataModel staffDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				staffDataModel.getStaff().setName(event.getNewValue());
				RestResult<User>  result=staffdetailmanager.update(staffDataModel.getStaff());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
		email.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StaffDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<StaffDataModel, String> event) {	
				StaffDataModel staffDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				staffDataModel.getStaff().setEmail(event.getNewValue());
				RestResult<User>  result=staffdetailmanager.update(staffDataModel.getStaff());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
		phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StaffDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<StaffDataModel, String> event) {	
				StaffDataModel staffDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				staffDataModel.getStaff().setPhone(event.getNewValue());
				RestResult<User>  result=staffdetailmanager.update(staffDataModel.getStaff());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
		mobile.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StaffDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<StaffDataModel, String> event) {	
				StaffDataModel staffDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				staffDataModel.getStaff().setMobile(event.getNewValue());
				RestResult<User>  result=staffdetailmanager.update(staffDataModel.getStaff());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
	}

	@Override
	public void loadTableData() {
		StaffDataSource.clear();
		for(User user:types){
			StaffDataSource.add(new StaffDataModel(user));
		}
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		initTable();
		fetchData("0");
		
		modalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				stage.show();
				
			}
			
		});
	}
	
	public void fetchData(String Page){
		Data info=staffdetailmanager.getAll("19",Page,"ASC");
		if(info.getResult()){
			@SuppressWarnings("unchecked")
			List<User> types = (List<User>) info.getContent();
			page.setText(CountPage(info.getNumber()));
			this.types = types;
			animateMessage("",messageLabel);
			loadTableData();
		}
		else{
			animateMessage(info.getMessage(),messageLabel);			
		}

	}
	
	private String CountPage(String page){
		String pageSize=null;
		int number=Integer.parseInt(page)+1;
		pageSize=String.valueOf(number);
		return pageSize;
	}
	
	public  void deleteRow(User c,int row){
		//告诉服务器删除气瓶
		//删除界面上的气瓶
		RestResult<User>  result=LocalManager.getStaffDetailManager().delete(c);
		if(!result.getResult()){
			animateMessage(result.getMessage(),messageLabel);
		}else{
			staffTable.getItems().remove(row);
			animateMessage(Constant.DELETE_SUCCESS,messageLabel);
		}
	}

}
