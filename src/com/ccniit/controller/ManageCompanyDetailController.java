package com.ccniit.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import com.ccniit.manager.CompanyDetailManager;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Company;
import com.ccniit.model.CompanyDataModel;
import com.ccniit.model.Constant;
import com.ccniit.model.response_entity.Data;
import com.ccniit.util.RestResult;
import com.ccniit.view.DeleteCompanyButtonCell;
import com.ccniit.view.EditingStringCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class ManageCompanyDetailController extends ViewHelper implements Initializable,TableViewHelper{
	@FXML
	private TableView<CompanyDataModel> companyTable;
	@FXML
	private TableColumn<CompanyDataModel, Integer> id;
	@FXML
	private TableColumn<CompanyDataModel, String> companyType;
	@FXML
	private TableColumn<CompanyDataModel, String> name;
	@FXML
	private TableColumn<CompanyDataModel, String> phone;
	@FXML
	private TableColumn<CompanyDataModel, String> address;	
	@FXML
	private TableColumn<CompanyDataModel, String> province_code;
	@FXML
	private TableColumn<CompanyDataModel, String> remarks;
	@FXML
	private TableColumn<CompanyDataModel, Boolean> action;
	@FXML
	private Button query;
	@FXML
	private Button lastpage;
	@FXML
	private Button nextpage;
	@FXML
	private Button addCompany;
	@FXML
	private Label show;
	@FXML
	private Label page;
	@FXML
	private Label messageLabel;
	private final static Logger log = Logger.getLogger(ManageCompanyDetailController.class);
	private List<Company> types;
	private CompanyDetailManager companydetailmanager= LocalManager.getCompanyDetailManager();
	private ObservableList<CompanyDataModel> CompanyDataSource;
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();
	public static String msg;
	@FXML
	public void addCompany(ActionEvent event){
		LocalManager.getApplication().showAddCompany();
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
	@FXML
	public void query(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		if(query.getText().equals("查询本单位信息")){
			show.setText("查询本单位信息");
			RestResult<Company> result=companydetailmanager.query(null);
			if(!result.getResult()){
				animateMessage(result.getMessage(),messageLabel);
			}else{
				Company c=result.getData();
				CompanyDataSource.clear();
				CompanyDataSource.add(new CompanyDataModel(c));
				lastpage.setVisible(false);
				nextpage.setVisible(false);
				addCompany.setVisible(false);
				animateMessage(null,messageLabel);
			}
			query.setText("查看所有单位信息");
		}else{
			show.setText("查看所有单位信息");
			lastpage.setVisible(true);
			nextpage.setVisible(true);
			addCompany.setVisible(true);
			fetchData("0");
			query.setText("查询本单位信息");
		}	
	}
	@Override
	public void initTable() {
		CompanyDataSource=FXCollections.observableArrayList();
		companyTable.setEditable(true);
		id.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,Integer>("id"));
		companyType.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,String>("companyType"));
		address.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,String>("address"));
		province_code.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,String>("province_code"));
		name.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,String>("name"));
		phone.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,String>("phone"));
		remarks.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,String>("remarks"));
		action.setCellValueFactory(new PropertyValueFactory<CompanyDataModel,Boolean>("action"));
	    Callback<TableColumn<CompanyDataModel,String>, TableCell<CompanyDataModel,String>> cellEditStringFactory =
					new Callback<TableColumn<CompanyDataModel,String>, TableCell<CompanyDataModel,String>>() {
				@Override
				public TableCell<CompanyDataModel, String> call(TableColumn<CompanyDataModel, String> arg0) {
					return new EditingStringCell<CompanyDataModel>();
				}
			};
		Callback<TableColumn<CompanyDataModel,Boolean>, TableCell<CompanyDataModel,Boolean>> cellDeleteChoiceFactory =
					new Callback<TableColumn<CompanyDataModel,Boolean>, TableCell<CompanyDataModel,Boolean>>() {
				@Override
				public TableCell<CompanyDataModel, Boolean>  call(TableColumn<CompanyDataModel, Boolean> arg0) {
					return new DeleteCompanyButtonCell(LocalManager.getApplication().getModalStage(),companyTable,ManageCompanyDetailController.this);
				}
			};
		remarks.setCellFactory(cellEditStringFactory);
		name.setCellFactory(cellEditStringFactory);
		//companyType.setCellFactory(cellTypeChoiceFactory);
		province_code.setCellFactory(cellEditStringFactory);
		phone.setCellFactory(cellEditStringFactory);
		address.setCellFactory(cellEditStringFactory);
		action.setCellFactory(cellDeleteChoiceFactory);
		companyTable.setItems(CompanyDataSource);
		name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CompanyDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<CompanyDataModel, String> event) {	
				CompanyDataModel companyDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				companyDataModel.getCompany().setName(event.getNewValue());
				RestResult<Company>  result=companydetailmanager.update(companyDataModel.getCompany());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);   
				}
			}
		});
		address.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CompanyDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<CompanyDataModel, String> event) {	
				CompanyDataModel companyDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				companyDataModel.getCompany().setAddress(event.getNewValue());
				RestResult<Company>  result=companydetailmanager.update(companyDataModel.getCompany());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);   
				}
			}
		});
		phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CompanyDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<CompanyDataModel, String> event) {	
				CompanyDataModel companyDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				companyDataModel.getCompany().setPhone(event.getNewValue());
				RestResult<Company>  result=companydetailmanager.update(companyDataModel.getCompany());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
		remarks.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CompanyDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<CompanyDataModel, String> event) {	
				CompanyDataModel companyDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				companyDataModel.getCompany().setRemarks(event.getNewValue());
				RestResult<Company>  result=companydetailmanager.update(companyDataModel.getCompany());
				if(!result.getResult()){
					animateMessage(result.getMessage(),messageLabel);
				}else{
					animateMessage(Constant.UPDATE_SUCCESS,messageLabel);
				}
			}
		});
		province_code.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CompanyDataModel,String>>() {
			@Override
			public void handle(CellEditEvent<CompanyDataModel, String> event) {	
				CompanyDataModel companyDataModel = event.getTableView().getItems().get(event.getTablePosition().getRow());
				companyDataModel.getCompany().setProvinceCode(event.getNewValue());
				RestResult<Company>  result=companydetailmanager.update(companyDataModel.getCompany());
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
		CompanyDataSource.clear();
		for(Company c:types){
			CompanyDataSource.add(new CompanyDataModel(c));
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
		Data info=companydetailmanager.getAll("19",Page,"ASC");
		if(info.getResult()){
			@SuppressWarnings("unchecked")
			List<Company> types = (List<Company>) info.getContent();
			page.setText(CountPage(info.getNumber()));
			this.types = types;
			animateMessage("",messageLabel);
			loadTableData();
		}else{
			animateMessage(info.getMessage(),messageLabel);
		}

	}
	
	private String CountPage(String page){
		String pageSize=null;
		int number=Integer.parseInt(page)+1;
		pageSize=String.valueOf(number);
		return pageSize;
	}
	public  void deleteRow(Company c,int row){
		//告诉服务器删除气瓶
		//删除界面上的气瓶
		RestResult<Company>  result=LocalManager.getCompanyDetailManager().delete(c);
		if(!result.getResult()){
			animateMessage(result.getMessage(),messageLabel);
		}else{
			companyTable.getItems().remove(row);
			animateMessage(Constant.DELETE_SUCCESS,messageLabel);
		}
	}
	
}
