package com.ccniit.controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ccniit.manager.LocalManager;
import com.ccniit.manager.RecordManager;
import com.ccniit.model.Record;
import com.ccniit.model.RecordDataModel;
import com.ccniit.model.response_entity.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ChoiceBox;
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
public class MonthRecordController extends ViewHelper implements Initializable,TableViewHelper,ChartHelper{

	@FXML
	private ChoiceBox<String> state;
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
	private LineChart<Integer,Integer> lineChart;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private NumberAxis xAxis;

	private ObservableList<Series<Integer,Integer>> chartDataSource;
	private ObservableList<RecordDataModel> recordDataSource;
	private Map<Integer,Integer> recordMonthMap;//key 当月天数  value 操作次数
	//private Map<Integer,Integer> recordYearMap;//key 1-12  value 操作次数
	private List<Record> typesMonth;
	//private List<Record> typesYear;
	private RecordManager recordManager = LocalManager.getRecordManager();
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();
	private Calendar calendar;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@FXML
	public void search(ActionEvent event){
		String id=null;
		if(!searchId.getText().equals(""))
		id=searchId.getText();
		String operation=state.getSelectionModel().getSelectedItem();
		fetchData(id,operation,calendar);				//获取数据
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		initChart();						//初始化图表
		initTable();						//初始化表格
		calendar = new GregorianCalendar();
		

		state.setItems(FXCollections.observableArrayList( "充装", "审核充装","出库","入库","检验","审核检验","回收气瓶","到达使用单位","运输"));
		state.getSelectionModel().select(0);
		modalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				stage.show();
				
			}
			
		});
	
	}

	@Override
	public void initChart(){
		chartDataSource = FXCollections.observableArrayList();
		lineChart.setData(chartDataSource);
	}

	@Override
	public void loadChartData(){
		chartDataSource.clear();
		XYChart.Series<Integer,Integer> series = new XYChart.Series<>();
		series.setName("当前时间"+sdf.format(calendar.getTime()));
		for(Integer i:recordMonthMap.keySet()){
			series.getData().add(new XYChart.Data<Integer,Integer>(i,recordMonthMap.get(i)));
		}
		chartDataSource.add(series);
	}

	@Override
	public void initTable(){

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
		for(Record record:typesMonth){
			recordDataSource.add(new RecordDataModel(record));
		}

	}


	public void fetchData(String id,String operation,Calendar calendar){
		Data info=recordManager.getCheckOutByMonth(id,operation,calendar);
		@SuppressWarnings("unchecked")
		List<Record> resultmonth = (List<Record>)info.getContent();	
		if(info.getResult()){
			Map<Integer,Integer> recordMonthMap = new HashMap<>();
			//将List<Record>处理出图表需要显示的信息
			for(int i=1;i<=calendar.get(Calendar.DAY_OF_MONTH);i++){
				int numb=0;
				for(Record record:resultmonth){
					Date date;
					try {
						date = sdf.parse(record.getDate());
						Calendar c = Calendar.getInstance();
						c.setTime(date);
						int day = c.get(Calendar.DAY_OF_MONTH);
						if(day==i){
							numb++;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

				}
				recordMonthMap.put(i, numb);
			}
			this.typesMonth=resultmonth;
			this.recordMonthMap = recordMonthMap;
			this.calendar = calendar;
			loadChartData();
			loadTableData();
		}else{
			animateMessage(info.getMessage(),messageLabel);
		}


	}
	
/*	*//** 
	 * 取得当月天数 
	 * *//*  
	public static int getCurrentMonthLastDay()  
	{  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
	    return maxDate;  
	}  */
}
