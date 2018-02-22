
package com.ccniit.manager;

import java.util.HashMap;
import java.util.Map;



import com.ccniit.model.Company;
import com.ccniit.model.Cylinder;
import com.ccniit.model.User;
import com.ccniit.net.Connection;

import qualitySupervisionBureau.Main;

/**
 * <code>LocalManager</code>类是客户端的一个全局管理器。
 * 它提供保存客户端全局信息的方法。它还提供了获取其他管理器对
 * 象的方法。
 * <p>
 * <code>LocalManager</code>类具只有一个私有的构造方法,也不提供其
 * 他方法来获取其对象。
 * </p>
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.5
 *
 */
public class LocalManager {
	
	//用于保存客户端全局信息的Map对象
	private final static Map<String,Object> parameneters = new HashMap<>();
	private final static String connectionKey = "connection";		//Conenction对象对应的键值
	private final static String userKey = "user";					//User对象对应的键值
	private final static String applicationKey = "application";		//Main对象的键值
	
	private LocalManager(){}
	/**
	 * 
	 * 获得一个<code>User</code>对象。
	 * @see User
	 * @return 一个<code>User</code>对象。
	 * 
	 */
	public static User getStaff(){
		return User.getUser();
	}		
	
	/**
	 * 
	 * 获得一个<code>Cylinder</code>对象。
	 * @see Cylinder
	 * @return 一个<code>Cylinder</code>对象。
	 * 
	 */
	public static Cylinder getCylinder(){
		return Cylinder.getCylinder();
	}
	
	/**
	 * 
	 * 获得一个<code>Company</code>对象。
	 * @see Company
	 * @return 一个<code>Company</code>对象。
	 * 
	 */
	public static Company getCompany(){
		return Company.getCompany();
	}
	
	public static void setCompany(Company c){
		Company.setCompany(c);
	}
	/**
	 * 
	 * 获得一个<code>ExpiredCylinderManager</code>对象。
	 * @see ExpiredCylinderManager
	 * @return 一个<code>ExpiredCylinderManager</code>对象。
	 * 
	 */
	public static ExpiredCylinderManager getExpiredCylinderManager(){
		return ExpiredCylinderManager.getExpiredCylinderManager();
	}

	/**
	 * 
	 * 获得一个<code>WillExpireCylinderManager</code>对象。
	 * @see WillExpireCylinderManager
	 * @return 一个<code>WillExpireCylinderManager</code>对象。
	 * 
	 */
	public static WillExpireCylinderManager getWillExpireCylinderManager(){
		return WillExpireCylinderManager.getWillExpireCylinderManager();
	}
	
	/**
	 * 
	 * 获得一个<code>CylinderDetailManager</code>对象。
	 * @see CylinderDetailManager
	 * @return 一个<code>CylinderDetailManager</code>对象。
	 * 
	 */
	public static CylinderDetailManager getCylinderDetailManager(){
		return CylinderDetailManager.getCylinderDetailManager();
	}

	/**
	 * 
	 * 获得一个<code>StaffDetailManager</code>对象。
	 * @see StaffDetailManager
	 * @return 一个<code>StaffDetailManager</code>对象。
	 * 
	 */
	public static StaffDetailManager getStaffDetailManager(){
		return StaffDetailManager.getStaffDetailManager();
	}

	/**
	 * 
	 * 获得一个<code>CompanyDetailManager</code>对象。
	 * @see CompanyDetailManager
	 * @return 一个<code>CompanyDetailManager</code>对象。
	 * 
	 */
	public static CompanyDetailManager getCompanyDetailManager(){
		return CompanyDetailManager.getCompanyDetailManager();
	}
	
	/**
	 * 
	 * 获得一个<code>AddCylinderManager</code>对象。
	 * @see AddCylinderManager
	 * @return 一个<code>AddCylinderManager</code>对象。
	 * 
	 */
	public static AddCylinderManager getAddCylinderManager(){
		return AddCylinderManager.getAddCylinderManager();
	}
	
	/**
	 * 
	 * 获得一个<code>RecordManager</code>对象。
	 * @see RecordManager
	 * @return 一个<code>RecordManager</code>对象。
	 * 
	 */
	public static RecordManager getRecordManager(){
		return RecordManager.getRecordManager();
	}

	/**
	 * 
	 * 获得一个<code>AddStaffManager</code>对象。
	 * @see AddStaffManager
	 * @return 一个<code>AddStaffManager</code>对象。
	 * 
	 */
	public static AddStaffManager getAddStaffManager(){
		return AddStaffManager.getAddStaffManager();
	}
	
	public static Object getParamenter(String key){
		return parameneters.get(key);
	}
	
	public static void setParamenter(String key,Object value){
		parameneters.put(key, value);
	}
	
	public static void clearParamenters(){
		parameneters.clear();
	}
	
	public static void setConnection(Connection connection){
		parameneters.put(connectionKey, connection);
	}
	
	public  static Connection getConnection(){
		return (Connection) parameneters.get(connectionKey);
	}
	
	public static User getUser(){
		return (User)parameneters.get(userKey);
	}
	
	public static void setUser(User user){
		parameneters.put(userKey, user);
	}
	
	public static void setApplication(Main application){
		parameneters.put(applicationKey, application);
	}
	
	public static Main getApplication(){
		return (Main)parameneters.get(applicationKey);
	}
	
}
