package com.ccniit.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import com.ccniit.net.common.Package;;

/**
 * <code>Connection</code>类是一个网络连接。它保存了网络
 * 连接的有关信息。并提供了了一些网络连接方法。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.5
 * @see ConnectionConfiguration
 */
public abstract class Connection {
	
	//连接配置
	private ConnectionConfiguration configuration;
	private String sessonId  = null;
	
	private Socket socket = null;
	
	
	/**
	 * 只有一个<code>ConnectionConfiguration</code>对象参数的构造方法。
	 * 
	 * @param config 连接配置对象。
	 * @see ConnectionConfiguration
	 */
	public Connection(ConnectionConfiguration config){
		this.configuration = config;
	}
	
	/**
	 * 通过给定的host和port初始化对象。
	 * 
	 * @param host 主机地址。
	 * @param port 端口。
	 */
	public Connection(String host,int port){
		configuration = new ConnectionConfiguration(host, port);
	}
	
	/**
	 * 关闭连接。
	 */
	public abstract void close();
	
	
	/**
	 * 连接服务器。
	 * 
	 * @throws UnknownHostException 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public abstract void connect() throws UnknownHostException, IOException, ClassNotFoundException ;
	/**
	 * 获得<code>ConnectionConfiguration</code>对象。
	 * 
	 * @return <code>ConnectionConfiguration</code>对象。
	 */
	public ConnectionConfiguration getConfiguration() {
		return configuration;
	}
	/**
	 * 获得会话id。
	 * 
	 * @return 会话id。
	 */
	public String getSessionId(){
		return sessonId;
	}
	/**
	 * 获得Socket
	 * @return socket 套接字
	 */
	public Socket getSocket() {
		return socket;
	}
	
	/**
	 * 会话是否存在。
	 * 
	 * @return 如果还存在则返回<tt>true</tt>。
	 */
	public abstract boolean live();
	
	
//	/**
//	 * 获得<code>PackageManager</code>对象。
//	 * 
//	 * @return <code>PackageManager</code>对象。
//	 */
//	public abstract PackageManager getPackageManager();

	/**
	 * 登录方法。
	 * 
	 * @param loginId 用户的登录id。
	 * @param password 用户密码。
	 * @return 成功则返回<tt>true</tt>。
	 * @throws IOException io流异常。
	 */
	public abstract boolean login(String loginId,String password) throws IOException;

	/**
	 * 接收包。
	 * 
	 * @return <code>Package</code>对象。
	 */
	public abstract Package receivePackage();

	
	/**
	 * 发送包。
	 * 
	 * @param p <code>Package</code>对象。
	 */
	public abstract void sendPackage(Package p);

	
	/**
	 * 设置<code>ConnectionConfiguration</code>对象。
	 * 
	 * @param configuration <code>ConnectionConfiguration</code>对象。
	 */
	public void setConfiguration(ConnectionConfiguration configuration) {
		this.configuration = configuration;
	}
	
	
	/**
	 * 设置会话参数
	 */
	public void setSessionId(String sessonId){
		this.sessonId = sessonId;
	}
	
	
	/**
	 * 设置<code>java.net.Socket</code>。
	 * 
	 * @param socket <code>java.net.Socket</code>。
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
