package com.ccniit.controller;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.ccniit.manager.AddCylinderManager;
import com.ccniit.manager.LocalManager;
import com.ccniit.model.Constant;
import com.ccniit.model.Cylinder;
import com.ccniit.util.RestResult;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;
import javafx.scene.control.DatePicker;


public class ManageAddCylinderController extends ViewHelper implements Initializable{
	@FXML
	private Button saveInfo;
	@FXML
	private Button uploadFile;
	@FXML
	private TextField id;
	@FXML
	private ChoiceBox<String> companyId;
	@FXML
	private TextField workingPressure;
	@FXML
	private TextField type;
	@FXML
	private TextField volume;
	@FXML
	private DatePicker manufactureDate;
	@FXML
	private TextField testCycle;
	@FXML
	private TextField productionUnitCode;
	@FXML
	private ChoiceBox<String> lastInspectionFlag;

	
	@FXML
	private TextField uid;
	@FXML
	private ChoiceBox<String> state;
	@FXML
	private TextField model;
	@FXML
	private TextField waterOverpressure;
	@FXML
	private TextField material;
	@FXML
	private TextField contentName;	
	@FXML
	private TextField manufacturingNumber;
	@FXML
	private DatePicker serviceLife;
	@FXML
	private TextField location;


	@FXML
	private Label messageLabel;
	private final static String pattern = "yyyy-MM-dd";
	private final static Logger log = Logger.getLogger(ManageAddCylinderController.class);
	private AddCylinderManager addCylinderManager = LocalManager.getAddCylinderManager();
	private Stage modalStage=LocalManager.getApplication().getModalStage();
	private Stage stage=LocalManager.getApplication().getMainStage();
	@FXML
	public void saveInfo(ActionEvent event){
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		if(isTextfieldnull(id,"气瓶编号")) return;
		if(isTextfieldnull(workingPressure,"工作压力")) return;
		if(isTextfieldnull(type,"类型")) return;
		if(isTextfieldnull(volume,"容积")) return;
		if(isDatepickernull(manufactureDate,"制造日期")) return;
		if(isTextfieldnull(testCycle,"检验周期")) return;
		if(isTextfieldnull(productionUnitCode,"生产单位代码")) return;
		if(isDatepickernull(manufactureDate,"制造日期")) return;
		if(isTextfieldnull(uid,"电子标签编号")) return;
		if(isTextfieldnull(model,"型号")) return;
		if(isTextfieldnull(waterOverpressure,"水试验压力")) return;
		if(isTextfieldnull(material,"材料")) return;
		if(isTextfieldnull(contentName,"内容物中文名")) return;
		if(isDatepickernull(serviceLife,"使用期限")) return;
		if(isTextfieldnull(location,"所在位置")) return;
		String manufacturedate=manufactureDate.getValue().toString();
		String servicelife=serviceLife.getValue().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		if(compare_date(dateFormat.format(new Date()),manufacturedate)){
			animateMessage(Constant.DATE_ERROR,messageLabel);
			return;
		}		
		if(compare_date(servicelife,dateFormat.format(new Date()))){
			animateMessage(Constant.DATE_ERROR,messageLabel);
			return;
		}
		Cylinder c=LocalManager.getCylinder();
		try{
			c.setVolume(Double.parseDouble(volume.getText()));//bug volume只能输入double类型内容
		}catch(NumberFormatException e){
			log.debug("容积只能输入小数或整数");
			animateMessage( Constant.VOLUME_ERROR , messageLabel );
			return;
		}
		c.setId(id.getText());
		c.setCompanyId(companyId.getSelectionModel().getSelectedItem());
		c.setWorkingPressure(workingPressure.getText());
		c.setType(type.getText());
		c.setManufactureDate(manufactureDate.getValue().toString());
		
		c.setTestCycle(testCycle.getText());
		c.setProductionUnitCode(productionUnitCode.getText());
		c.setLastInspectionFlag(transform(lastInspectionFlag.getSelectionModel().getSelectedItem()));
		c.setUid(uid.getText());
		c.setState(state.getSelectionModel().getSelectedItem());
		c.setModel(model.getText());
		c.setWaterOverpressure(waterOverpressure.getText());
		c.setMaterial(material.getText());
		
		c.setContentName(contentName.getText());
		c.setManufacturingNumber(manufacturingNumber.getText());
		c.setServiceLife(serviceLife.getValue().toString());
		c.setLocation(location.getText());
		//
		RestResult<Cylinder> result=addCylinderManager.save(c);
		if(result.getResult()){
			animateMessage(Constant.ADD_CYLINDER_SUCCESS, messageLabel );
		}else{
			animateMessage(result.getMessage(), messageLabel );
		}
	}
	@FXML
	public void uploadFile(ActionEvent event){
		modalStage.hide();
		LocalManager.getApplication().showImportCylinder();
	}

	public void initTable() {
		companyId.setItems(FXCollections.observableArrayList( "1", "2", "3", "4"));
		lastInspectionFlag.setItems(FXCollections.observableArrayList( "合格-0", "不合格-1"));
		state.setItems(FXCollections.observableArrayList( "已检验-合格", "已检验-不合格","已充气-未审核", "已充气-通过审核","已充气-审核未通过","仓库内","已出库","运输中","到达使用单位"));
		companyId.getSelectionModel().select(0);
		lastInspectionFlag.getSelectionModel().select(0);
		state.getSelectionModel().select(0);
	    StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
	            DateTimeFormatter dateFormatter = 
	                DateTimeFormatter.ofPattern(pattern);
	            @Override
	            public String toString(LocalDate date) {
	                if (date != null) {
	                    return dateFormatter.format(date);
	                } else {
	                    return "";
	                     
	                }
	            }
	            @Override
	            public LocalDate fromString(String string) {
	                if (string != null && !string.isEmpty()) {
	                    return LocalDate.parse(string, dateFormatter);
	                } else {
	                    return null;
	                }
	            }
	    };  
	    manufactureDate.setConverter(converter);
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initTable();
		if(!Constant.isonline){
			log.debug("连接远程服务器失败");
			animateMessage(Constant.FAIL_TO_CONNECT_SERVER,messageLabel);
		}
		modalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				stage.show();
				
			}
			
		});
	}
	public boolean isTextfieldnull(TextField demo,String name){
		if(demo.getText()==null||demo.getText().trim().equals("")||demo.getText().equals("必填")){
			log.debug(name+"输入为空");
			animateMessage( name+Constant.CANT_BE_NULL , messageLabel );
			return true;
		}
		return false;
	}
	public boolean isDatepickernull(DatePicker demo,String name){
		if(demo.getValue()==null){
			log.debug(name+"输入为空");
			animateMessage( name+Constant.CANT_BE_NULL , messageLabel );
			return true;
		}
		return false;
	}
	public String transform(String origin){
		if(origin.equals("合格-0")||origin.equals("未报废-0")){
			return "0";
		}else if(origin.equals("不合格-1")||origin.equals("已报废-1")){
			return "1";
		}
		return null;
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
