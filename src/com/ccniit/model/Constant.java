package com.ccniit.model;

import com.ccniit.util.Language;


/**
 * <code>Constant</code>定义了一些常量。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.0
 *
 */
public class Constant {
	public static String PROTOCOL="http";
	public static String SERVER_HOST = "127.0.0.1";		//服务器地址
	public static int SERVER_PORT = 9998;				//服务器端口
	public static boolean havecode=false;  				//有无验证码
	public static boolean isfinish=false;
	public static boolean isonline=false;
	/*
	 * 所有界面的fxml文件路径
	 */
	public final static String MAIN_VIEW_PATH = "/com/ccniit/view/Main.fxml";
	public final static String LOGIN_VIEW_PATH = "/com/ccniit/view/Login.fxml";
	public final static String EXPIRED_CYLILNDER_PATH="/com/ccniit/view/ExpiredCylinder.fxml";
	public final static String WILL_EXPIRE_CYLILNDER_PATH="/com/ccniit/view/WillExpireCylinder.fxml";
	public final static String CYLILNDER_DETAIL_PATH="/com/ccniit/view/CylinderDetail.fxml";	
	public final static String ADD_CYLILNDER_PATH="/com/ccniit/view/AddCylinder.fxml";		
	public final static String STAFF_DETAIL_PATH="/com/ccniit/view/StaffDetail.fxml";		
	public final static String COMPANY_DETAIL_PATH="/com/ccniit/view/CompanyDetail.fxml";	
	public final static String ADD_STAFF_PATH="/com/ccniit/view/AddStaff.fxml";
	public final static String ADD_COMPANY_PATH="/com/ccniit/view/AddCompany.fxml";	
	public final static String YEAR_RECORD_PATH="/com/ccniit/view/YearRecord.fxml";	
	public final static String MONTH_RECORD_PATH="/com/ccniit/view/MonthRecord.fxml";	
	public final static String CUR_USER_INFO_PATH="/com/ccniit/view/CurUserInfo.fxml";	
	public final static String IMPORT_CYLINDER_PATH="/com/ccniit/view/ImportCylinder.fxml";
	public final static String ICON_PATH="/com/ccniit/view/20150506190068156815.jpg";	
	public final static String CUR_ICON_PATH="/com/ccniit/view/Historical-Viking-Female-icon.png";
	//连接服务器配置文件路径
	public final static String SERVER_CONFIG_FILE_PATH = "config.properties";
	
	
	/*
	 * 国际资源文件名称
	 */
	public final static String LANGUAGE_PACKAGE_NAME = "language";
	
	/*
	 * 国际字符串
	 */
	public final static String NOT_ALLOW = Language.getString("notAllow");
	public final static String PASSWORD_RIGHT="密码正确";
	public final static String PASSWORD_WRONG="密码错误";
	public final static String FAIL_TO_CONNECT_SERVER ="连接远程服务器失败";
	public final static String INPUT_CANT_BE_NULL = "输入不能为空";
	public final static String CODE_CANT_BE_NULL="验证码不能为空";
	public final static String CANT_BE_NULL="不能为空";
	public final static String CANCAL_DOWNLOAD="取消下载";
	public final static String CANCAL_UPLOAD="取消上传";
	public final static String SUCCESS_DOWNLOAD="下载成功";
	public final static String FAIL_DOWNLOAD="下载失败";
	public final static String FIRST_PAGE="已经是第一页了";
	public final static String ACTION_SUCCESS="操作成功";
	public final static String QUERY_SUCCESS="查询成功";	
	public final static String UPDATE_SUCCESS="修改成功";	
	public final static String DELETE_SUCCESS="删除成功";
	public final static String VOLUME_ERROR="容积只能输入小数或整数";
	public final static String DATE_ERROR="日期存在逻辑错误";
	public final static String ADD_CYLINDER_SUCCESS="增加气瓶成功";	
	public final static String ADD_STAFF_SUCCESS="增加员工成功";	
	public final static String ADD_COMPANY_SUCCESS="增加单位成功";	
	public final static String DAY_FORMAT_ERROR="请输入整数天数";		
	public final static String DAY_SIZE_ERROR="天数范围在1-15之间";	
	public final static String PASSWORD_SIZE_ERROR="密码位数范围在6-32之间";	
	public final static String PASSWORD_NOT_SAME="两次密码不一致";
	public final static String PASSWORD_SIZE_RIGHT="符合要求";
	public final static String LOGINNAME_LENGTH_SHORT="登录名长度必须超过2";
	public final static String NAME_LENGTH_SHORT="公司名长度必须超过2";
	public final static String PHONE_PATTERN_ERROR="电话格式错误";
	public final static String EMAIL_PATTERN_ERROR="邮箱格式错误";
	public final static String MOBILE_PATTERN_ERROR="手机号码格式错误";
	public final static String MAIN_VIEW_TITLE = "危化品容器监管追溯系统";

}
