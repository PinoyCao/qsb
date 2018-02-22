package com.ccniit.util;

public class API {
	//登录接口
	private static String LOGIN_API="rest/sys/login";
	private static String LOGOUT_API="rest/sys/logout";//退出登录
	//User接口
	//private static String CURRENTUSER_API="rest/sys/user/currentUser";//查看当前用户信息
	private static String EDITCUR_API="/rest/sys/user/editCurrent";
	private static String ALTER_API="rest/sys/user/alter";//修改当前用户信息1
	private static String USERVIEW_API="rest/sys/user/view";//查看所属公司的所有用户
	private static String USEREDIT_API="rest/sys/user/edit";//管理员编辑某个所属公司的用户
	private static String USERCREATE_API="rest/sys/user/create";//创建一个当前用户所属公司的用户
	private static String USERDELETE_API="rest/sys/user/delete";//删除一个当前用户所属公司的用户
	//Company接口
	private static String CURRENTCOMPANY_API="rest/sys/company/currentCompany";//返回当前用户所属公司
	private static String EDITCURRENT_API="rest/sys/company/editCurrent";//管理员编辑自己所属公司
	private static String COMPANYVIEW_API="rest/sys/company/view";//查看所有的公司
	private static String COMPANYEDIT_API="rest/sys/company/edit";//局方管理员编辑某个公司的信息
	private static String COMPANYCREATE_API="rest/sys/company/create";//创建某个公司，并同时以此公司的公司名为loginName,电话为password创建该公司管理员
	private static String COMPANYDELETE_API="rest/sys/company/delete";//删除某个公司，不允许删除当前用户所在公司，且此公司下的所有用户将被禁止登录
	//政府接口
	private static String ADDCYLINDER_API="rest/gov/addCylinder";//增加气瓶
	private static String IMPORTCYLINDER_API="rest/gov/importCylinder";//增加气瓶
	private static String LASTIMPORT_API="rest/gov/lastImportCylinderList";//查询刚刚上传的气瓶
	private static String CYLINDERDETAIL_API="rest/gov/cylinderDetail";//查询某个id或者是某个uid的气瓶
	private static String EXPIREDCYLINDER_EXCEL_API="rest/gov/expiredCylinder/excel";//把已经过期的气瓶以excel导出
	private static String EXPIREDCYLINDER_ONLINE_API="rest/gov/expiredCylinder/online";//在线查看已经过期的气瓶
	private static String WILLEXPIRED_ONLINE_API="rest/gov/willExpire/online";//在线查看即将过期的气瓶
	private static String WILLEXPIRE_EXCEL_API="rest/gov/willExpire/excel";//把即将过期的气瓶以excel导出
	//Role接口
	private static String CURRENTROLE_API="rest/sys/role/currentRoleList";//查看当前用户的role
	private static String ROLEVIEW_API="rest/sys/role/view";//查看所在公司某个用户的role
	private static String ROLEADD_API="rest/sys/role/add";//给同公司某个用户增加角色，但是此角色必须是当前用户有的
	private static String ROLEREMOVE_API="rest/sys/role/remove";//给同公司某个用户删除角色
	//Menu接口
	private static String CURRENTMENU_API="rest/sys/menu/currentMenuSet";//查看当前用户的Menu
	//Inspection接口
	private static String INSPECTION_API="rest/inspection/inspection";//检验一个气瓶
	private static String REINSPECTION_API="rest/inspection/reinspectionByClinder";//审核一个气瓶的检验
	//Gas接口
	private static String FILL_API="rest/gas/fill";	//给气瓶充气
	private static String FILLCHECK_API="rest/gas/fillCheck";//气瓶充气审核
	private static String TRANSIT_API="rest/gas/transit";//气瓶设置为运输状态
	private static String ARRIVE_API="rest/gas/arrive";//气瓶到达目的单位
	private static String UPDATEGPS_API="rest/gas/updateGPS";//手动把当前用户所在车辆上的气瓶设置GPS定位
	private static String RECYCLE_API="rest/gas/recycle";//把气瓶设置为已回收气瓶状态
	private static String STORAGEIN_API="rest/gas/storage/in";//把气瓶设置为已经入库状态
	private static String STORAGEOUT_API="rest/gas/storage/out";//把气瓶设置为已经内库状态
	private static String NOTRECYCLE_API="rest/gas/notRecycle";//当前用户所属公司未回气瓶，以下状态为未回气瓶{已检验-合格，已检验-不合格，已出库，运输中，到达使用单位}
	private static String HAVERECYCLE_API="rest/gas/haveRecycle";//当前用户所属公司已回气瓶，以下状态为未回气瓶{已检验-合格，已检验-不合格，已出库，运输中，到达使用单位}
	private static String CUREXPIREDCYLINDER_EXCEL_API="rest/gas/expiredCylinder/excel";//把当前用户所在公司已经过期的气瓶以excel导出
	private static String CUEXPIREDCYLINDER_ONLINE_API="rest/gas/expiredCylinder/online";//在线查看当前用户所在公司已经过期的气瓶
	private static String CUWILLEXPIRED_ONLINE_API="rest/gas/willExpire/online";//在线查看当前用户所在公司即将过期的气瓶
	private static String CUWILLEXPIRE_EXCEL_API="rest/gov/willExpire/excel";//把当前用户所在公司即将过期的气瓶以excel导出
	private static String RECORDINSPECTION_API="rest/gov/recordInspection";	
	private static String RECORDALL_API="rest/gov/recordAll";
	public static String getLOGIN_API() {
		return LOGIN_API;
	}
	public static void setLOGIN_API(String lOGIN_API) {
		LOGIN_API = lOGIN_API;
	}
	/*	public static String getCURRENTUSER_API() {
			return CURRENTUSER_API;
		}
		public static void setCURRENTUSER_API(String cURRENTUSER_API) {
			CURRENTUSER_API = cURRENTUSER_API;
		}*/
	public static String getALTER_API() {
		return ALTER_API;
	}
	public static String getLOGOUT_API() {
		return LOGOUT_API;
	}
	public static void setLOGOUT_API(String lOGOUT_API) {
		LOGOUT_API = lOGOUT_API;
	}
	public static String getCURRENTROLE_API() {
		return CURRENTROLE_API;
	}
	public static void setCURRENTROLE_API(String cURRENTROLE_API) {
		CURRENTROLE_API = cURRENTROLE_API;
	}
	public static String getROLEVIEW_API() {
		return ROLEVIEW_API;
	}
	public static void setROLEVIEW_API(String rOLEVIEW_API) {
		ROLEVIEW_API = rOLEVIEW_API;
	}
	public static String getROLEADD_API() {
		return ROLEADD_API;
	}
	public static void setROLEADD_API(String rOLEADD_API) {
		ROLEADD_API = rOLEADD_API;
	}
	public static String getROLEREMOVE_API() {
		return ROLEREMOVE_API;
	}
	public static void setROLEREMOVE_API(String rOLEREMOVE_API) {
		ROLEREMOVE_API = rOLEREMOVE_API;
	}
	public static String getCURRENTMENU_API() {
		return CURRENTMENU_API;
	}
	public static void setCURRENTMENU_API(String cURRENTMENU_API) {
		CURRENTMENU_API = cURRENTMENU_API;
	}
	public static String getINSPECTION_API() {
		return INSPECTION_API;
	}
	public static void setINSPECTION_API(String iNSPECTION_API) {
		INSPECTION_API = iNSPECTION_API;
	}
	public static String getREINSPECTION_API() {
		return REINSPECTION_API;
	}
	public static void setREINSPECTION_API(String rEINSPECTION_API) {
		REINSPECTION_API = rEINSPECTION_API;
	}
	public static String getFILL_API() {
		return FILL_API;
	}
	public static void setFILL_API(String fILL_API) {
		FILL_API = fILL_API;
	}
	public static String getFILLCHECK_API() {
		return FILLCHECK_API;
	}
	public static void setFILLCHECK_API(String fILLCHECK_API) {
		FILLCHECK_API = fILLCHECK_API;
	}
	public static String getTRANSIT_API() {
		return TRANSIT_API;
	}
	public static void setTRANSIT_API(String tRANSIT_API) {
		TRANSIT_API = tRANSIT_API;
	}
	public static String getARRIVE_API() {
		return ARRIVE_API;
	}
	public static void setARRIVE_API(String aRRIVE_API) {
		ARRIVE_API = aRRIVE_API;
	}
	public static String getUPDATEGPS_API() {
		return UPDATEGPS_API;
	}
	public static void setUPDATEGPS_API(String uPDATEGPS_API) {
		UPDATEGPS_API = uPDATEGPS_API;
	}
	public static String getRECYCLE_API() {
		return RECYCLE_API;
	}
	public static void setRECYCLE_API(String rECYCLE_API) {
		RECYCLE_API = rECYCLE_API;
	}
	public static String getSTORAGEIN_API() {
		return STORAGEIN_API;
	}
	public static void setSTORAGEIN_API(String sTORAGEIN_API) {
		STORAGEIN_API = sTORAGEIN_API;
	}
	public static String getSTORAGEOUT_API() {
		return STORAGEOUT_API;
	}
	public static void setSTORAGEOUT_API(String sTORAGEOUT_API) {
		STORAGEOUT_API = sTORAGEOUT_API;
	}
	public static String getNOTRECYCLE_API() {
		return NOTRECYCLE_API;
	}
	public static void setNOTRECYCLE_API(String nOTRECYCLE_API) {
		NOTRECYCLE_API = nOTRECYCLE_API;
	}
	public static String getHAVERECYCLE_API() {
		return HAVERECYCLE_API;
	}
	public static void setHAVERECYCLE_API(String hAVERECYCLE_API) {
		HAVERECYCLE_API = hAVERECYCLE_API;
	}
	public static String getCUREXPIREDCYLINDER_EXCEL_API() {
		return CUREXPIREDCYLINDER_EXCEL_API;
	}
	public static void setCUREXPIREDCYLINDER_EXCEL_API(String cUREXPIREDCYLINDER_EXCEL_API) {
		CUREXPIREDCYLINDER_EXCEL_API = cUREXPIREDCYLINDER_EXCEL_API;
	}
	public static String getCUEXPIREDCYLINDER_ONLINE_API() {
		return CUEXPIREDCYLINDER_ONLINE_API;
	}
	public static void setCUEXPIREDCYLINDER_ONLINE_API(String cUEXPIREDCYLINDER_ONLINE_API) {
		CUEXPIREDCYLINDER_ONLINE_API = cUEXPIREDCYLINDER_ONLINE_API;
	}
	public static String getCUWILLEXPIRED_ONLINE_API() {
		return CUWILLEXPIRED_ONLINE_API;
	}
	public static void setCUWILLEXPIRED_ONLINE_API(String cUWILLEXPIRED_ONLINE_API) {
		CUWILLEXPIRED_ONLINE_API = cUWILLEXPIRED_ONLINE_API;
	}
	public static String getCUWILLEXPIRE_EXCEL_API() {
		return CUWILLEXPIRE_EXCEL_API;
	}
	public static void setCUWILLEXPIRE_EXCEL_API(String cUWILLEXPIRE_EXCEL_API) {
		CUWILLEXPIRE_EXCEL_API = cUWILLEXPIRE_EXCEL_API;
	}
	public static void setALTER_API(String aLTER_API) {
		ALTER_API = aLTER_API;
	}
	public static String getUSERVIEW_API() {
		return USERVIEW_API;
	}
	public static void setUSERVIEW_API(String uSERVIEW_API) {
		USERVIEW_API = uSERVIEW_API;
	}
	public static String getUSEREDIT_API() {
		return USEREDIT_API;
	}
	public static void setUSEREDIT_API(String uSEREDIT_API) {
		USEREDIT_API = uSEREDIT_API;
	}
	public static String getUSERCREATE_API() {
		return USERCREATE_API;
	}
	public static void setUSERCREATE_API(String uSERCREATE_API) {
		USERCREATE_API = uSERCREATE_API;
	}
	public static String getCURRENTCOMPANY_API() {
		return CURRENTCOMPANY_API;
	}
	public static void setCURRENTCOMPANY_API(String cURRENTCOMPANY_API) {
		CURRENTCOMPANY_API = cURRENTCOMPANY_API;
	}
	public static String getCOMPANYVIEW_API() {
		return COMPANYVIEW_API;
	}
	public static void setCOMPANYVIEW_API(String cOMPANYVIEW_API) {
		COMPANYVIEW_API = cOMPANYVIEW_API;
	}
	public static String getCOMPANYEDIT_API() {
		return COMPANYEDIT_API;
	}
	public static void setCOMPANYEDIT_API(String cOMPANYEDIT_API) {
		COMPANYEDIT_API = cOMPANYEDIT_API;
	}
	public static String getCOMPANYCREATE_API() {
		return COMPANYCREATE_API;
	}
	public static void setCOMPANYCREATE_API(String cOMPANYCREATE_API) {
		COMPANYCREATE_API = cOMPANYCREATE_API;
	}
	public static String getCOMPANYDELETE_API() {
		return COMPANYDELETE_API;
	}
	public static void setCOMPANYDELETE_API(String cOMPANYDELETE_API) {
		COMPANYDELETE_API = cOMPANYDELETE_API;
	}
	public static String getADDCYLINDER_API() {
		return ADDCYLINDER_API;
	}
	public static void setADDCYLINDER_API(String aDDCYLINDER_API) {
		ADDCYLINDER_API = aDDCYLINDER_API;
	}
	public static String getCYLINDERDETAIL_API() {
		return CYLINDERDETAIL_API;
	}
	public static void setCYLINDERDETAIL_API(String cYLINDERDETAIL_API) {
		CYLINDERDETAIL_API = cYLINDERDETAIL_API;
	}
	public static String getEXPIREDCYLINDER_EXCEL_API() {
		return EXPIREDCYLINDER_EXCEL_API;
	}
	public static void setEXPIREDCYLINDER_EXCEL_API(String eXPIREDCYLINDER_EXCEL_API) {
		EXPIREDCYLINDER_EXCEL_API = eXPIREDCYLINDER_EXCEL_API;
	}
	public static String getEXPIREDCYLINDER_ONLINE_API() {
		return EXPIREDCYLINDER_ONLINE_API;
	}
	public static void setEXPIREDCYLINDER_ONLINE_API(String eXPIREDCYLINDER_ONLINE_API) {
		EXPIREDCYLINDER_ONLINE_API = eXPIREDCYLINDER_ONLINE_API;
	}
	public static String getWILLEXPIRED_ONLINE_API() {
		return WILLEXPIRED_ONLINE_API;
	}
	public static void setWILLEXPIRED_ONLINE_API(String wILLEXPIRED_ONLINE_API) {
		WILLEXPIRED_ONLINE_API = wILLEXPIRED_ONLINE_API;
	}
	public static String getUSERDELETE_API() {
		return USERDELETE_API;
	}
	public static void setUSERDELETE_API(String uSERDELETE_API) {
		USERDELETE_API = uSERDELETE_API;
	}
	public static String getEDITCURRENT_API() {
		return EDITCURRENT_API;
	}
	public static void setEDITCURRENT_API(String eDITCURRENT_API) {
		EDITCURRENT_API = eDITCURRENT_API;
	}
	public static String getWILLEXPIRE_EXCEL_API() {
		return WILLEXPIRE_EXCEL_API;
	}
	public static void setWILLEXPIRE_EXCEL_API(String wILLEXPIRE_EXCEL_API) {
		WILLEXPIRE_EXCEL_API = wILLEXPIRE_EXCEL_API;
	}
	public static String getIMPORTCYLINDER_API() {
		return IMPORTCYLINDER_API;
	}
	public static void setIMPORTCYLINDER_API(String iMPORTCYLINDER_API) {
		IMPORTCYLINDER_API = iMPORTCYLINDER_API;
	}
	public static String getRECORDINSPECTION_API() {
		return RECORDINSPECTION_API;
	}
	public static void setRECORDINSPECTION_API(String rECORDINSPECTION_API) {
		RECORDINSPECTION_API = rECORDINSPECTION_API;
	}
	public static String getRECORDALL_API() {
		return RECORDALL_API;
	}
	public static void setRECORDALL_API(String rECORDALL_API) {
		RECORDALL_API = rECORDALL_API;
	}
	public static String getEDITCUR_API() {
		return EDITCUR_API;
	}
	public static void setEDITCUR_API(String eDITCUR_API) {
		EDITCUR_API = eDITCUR_API;
	}
	public static String getLASTIMPORT_API() {
		return LASTIMPORT_API;
	}
	public static void setLASTIMPORT_API(String lASTIMPORT_API) {
		LASTIMPORT_API = lASTIMPORT_API;
	}
	
}
