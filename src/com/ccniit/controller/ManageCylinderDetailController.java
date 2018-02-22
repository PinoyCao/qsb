package com.ccniit.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import com.ccniit.manager.LocalManager;
import com.ccniit.manager.RecordManager;
import com.ccniit.model.Constant;
import com.ccniit.model.Record;
import com.ccniit.model.RecordDataModel;
import com.ccniit.model.response_entity.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;



/**
 * 
 * @author caoyan
 *
 */
public class ManageCylinderDetailController extends ViewHelper implements Initializable,TableViewHelper{

	@FXML
	private Label messageLabel;
	@FXML
	private TextField searchId;
	@FXML
	private TableView<RecordDataModel> recordTable;
	@FXML
	private TableColumn<RecordDataModel, Long> recordIdCol;
	@FXML
	private TableColumn<RecordDataModel,String> cylinderId;
	@FXML
	private TableColumn<RecordDataModel,Integer> userId;
	@FXML
	private TableColumn<RecordDataModel,Integer> companyId;
	@FXML
	private TableColumn<RecordDataModel,String> operation;
	@FXML
	private TableColumn<RecordDataModel,String> description;
	@FXML
	private TableColumn<RecordDataModel,String> date;
	@FXML
	private DatePicker startTime;
	@FXML
	private DatePicker finishTime;
	
	
	private final static String pattern = "yyyy-MM-dd";
	private ObservableList<RecordDataModel> recordDataSource;
	private List<Record> types=null;
	private RecordManager recordManager = LocalManager.getRecordManager();
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@FXML
	public void search(ActionEvent event){
		String id=null;
		String start=null;
		String finish=null;
		if(startTime.getValue()!=null)
			start=startTime.getValue().toString();			
		if(finishTime.getValue()!=null)
			finish=finishTime.getValue().toString();
			
		if(searchId.getText().equals("")){
			animateMessage(Constant.INPUT_CANT_BE_NULL,messageLabel);
			return;
		}else{
			id=searchId.getText();
			animateMessage(null,messageLabel);
		}
		if(start!=null&&finish!=null){
			if(!compare_date(start,finish)){
				animateMessage(Constant.DATE_ERROR,messageLabel);
				return;
			}
		}

		fetchData(id,start,finish);				//获取数据
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		initTable();						//初始化表格
		modalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				stage.show();
				
			}
			
		});
	
	}


	@Override
	public void initTable(){
		/*
		 *recordTable,initialize some data int it; 
		 *为表格载入数据
		 */
		recordDataSource =  FXCollections.observableArrayList();

		recordIdCol.setCellValueFactory(new PropertyValueFactory<RecordDataModel,Long>("id"));
		cylinderId.setCellValueFactory(new PropertyValueFactory<RecordDataModel,String>("cylinderId"));
		userId.setCellValueFactory(new PropertyValueFactory<RecordDataModel,Integer>("userId"));
		companyId.setCellValueFactory(new PropertyValueFactory<RecordDataModel,Integer>("companyId"));
		operation.setCellValueFactory(new PropertyValueFactory<RecordDataModel,String>("operation"));
		description.setCellValueFactory(new PropertyValueFactory<RecordDataModel,String>("description"));
		date.setCellValueFactory(new PropertyValueFactory<RecordDataModel,String>("date"));
		recordTable.setItems(recordDataSource);
	}

	@Override
	public void loadTableData(){
		recordDataSource.clear();				//清空，以免后面添加后数据重复
		if(types!=null)
		for(Record record:types){
			recordDataSource.add(new RecordDataModel(record));
		}

	}


	public void fetchData(String id,String start,String finish){
		Data result=recordManager.getCheckOutByTime(id,start,finish);
		if(result.getResult()){
			@SuppressWarnings("unchecked")
			List<Record> types = (List<Record>)result.getContent();
			this.types=types;
			animateMessage("",messageLabel);
			loadTableData();
		}else{
			animateMessage(result.getMessage(),messageLabel);
		}
	}
	
	public static boolean compare_date(String date1, String date2) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {  
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true; 
        }
    }
}
