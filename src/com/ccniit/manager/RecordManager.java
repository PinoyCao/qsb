package com.ccniit.manager;

import java.util.Calendar;
import java.util.GregorianCalendar;
import com.ccniit.model.Record;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.CylinderRecord;
import com.ccniit.sys.SearchRecord;

/**
 * <code>RecordManager</code>
 * 这个类重写一些方法，并定义了一些针对<code>Record</code>对象的特殊方法。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.5
 * @see Record
 *
 */
public class RecordManager extends Requester<Record> {
	
	public static RecordManager recordManager = new RecordManager();
	
	
	/**
	 * 获得一个<code>RecordManager</code>对象。
	 * @return 一个<code>RecordManager</code>对象。
	 */
	public static RecordManager getRecordManager(){
		return recordManager;
	}
	
	private RecordManager(){}
			
	
	/**
	 * 通过一个<code>java.util.Calendar</code>对象获得
	 * 当天所有已完成的<code>Record</code>对象。
	 * 
	 * @param id 气瓶ID
	 * @param operation 操作内容
	 * @param calendar <code>java.util.Calendar</code>对象
	 * @return <code>Data</code>对象。
	 * @see Data
	 */
	public Data getCheckOutDealByDay(String id,String operation,Calendar calendar){
		Calendar startCalendar = new GregorianCalendar();
		//获取当前起始Calendar
		startCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		Calendar endCalendar = new GregorianCalendar();
		//获取当天末Calendar
		endCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),23,59,59);
		return getCheckOutDealByTime(id,operation,startCalendar, endCalendar);
	}
	
	/**
	 * 通过一个<code>java.util.Calendar</code>对象获得
	 * 当月所有已完成的<code>Record</code>对象。
	 * 
	 * @param id 气瓶ID
	 * @param operation 操作内容
	 * @param calendar <code>java.util.Calendar</code>对象
	 * @return <code>Data</code>对象。
	 * @see Data
	 */
	public Data getCheckOutByMonth(String id,String operation,Calendar calendar){
		Calendar startCalendar = new GregorianCalendar();
		//获取当前起始Calendar
		startCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);
		Calendar endCalendar = new GregorianCalendar();
		//获取当天末Calendar
		endCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH),23,59,59);
		return getCheckOutDealByTime(id,operation,startCalendar, endCalendar);
	}
	
	/**
	 * 通过一个<code>java.util.Calendar</code>对象获得
	 * 当年所有已完成的<code>Record</code>对象。
	 * 
	 * @param id 气瓶ID
	 * @param operation 操作内容
	 * @param calendar <code>java.util.Calendar</code>对象
	 * @return <code>Data</code>对象。
	 * @see Data
	 */
	public Data getCheckOutDealByYear(String id,String operation,Calendar calendar){
		Calendar startCalendar = new GregorianCalendar();
		//获取当前起始Calendar
		startCalendar.set(calendar.get(Calendar.YEAR), calendar.getActualMinimum(Calendar.MONTH), calendar.getActualMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);
		Calendar endCalendar = new GregorianCalendar();
		//获取当天末Calendar
		endCalendar.set(calendar.get(Calendar.YEAR), calendar.getActualMaximum(Calendar.MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH),23,59,59);
		return getCheckOutDealByTime(id,operation,startCalendar, endCalendar);
	}
	
	/**
	 * 通过一个<code>java.util.Calendar</code>对象获得
	 * 一段时间所有已完成的<code>Record</code>对象。
	 * 
	 * @param id 气瓶ID
	 * @param operation 操作内容
	 * @param startCalendar 起始事件
	 * @param endCalendar 结束事件
	 * @return <code>Data</code>对象。
	 * @see Data
	 */	
	public Data getCheckOutDealByTime(String id,String operation,Calendar startCalendar,Calendar endCalendar){
		String start=startCalendar.get(Calendar.YEAR)+"-"+(startCalendar.get(Calendar.MONTH)+1)+"-"+startCalendar.get(Calendar.DATE);
		String end=endCalendar.get(Calendar.YEAR)+"-"+(endCalendar.get(Calendar.MONTH)+1)+"-"+endCalendar.get(Calendar.DATE);
		Data datainfo=SearchRecord.recordall(id,operation,start,end);
		return datainfo;
	}

	public Data getCheckOutByTime(String id,String start,String end){
		Data datainfo=CylinderRecord.recordall(id,start,end);
		return datainfo;
	}


	
	
}
