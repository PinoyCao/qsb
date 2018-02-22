package com.ccniit.net;


/**
 * <code>ConnectionConfiguration</code>类是一个连接配置类。
 * 它为<code>Connection</code>提供了配置。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.0
 *
 */
public class ConnectionConfiguration implements java.lang.Cloneable{
	
	private String host;			//主机地址
	private int port;				//端口
	private int timeout;			//超时
	
	
	/**
	 * 通过主机地址和端口号构造<code>ConnectionConfiguration</code>对象。
	 * 
	 * @param host 主机地址。
	 * @param port 主机端口。
	 */
	public ConnectionConfiguration(String host,int port){
		this.host = host;
		this.port = port;
	}
	
	/**
	 *  通过主机地址和端口号构造和超时构造<code>ConnectionConfiguration</code>对象。
	 *  
	 * @param host 主机地址。
	 * @param port 主机端口。
	 * @param timeout 超时。
	 */
	public ConnectionConfiguration(String host,int port,int timeout){
		this.host = host;
		this.port = port;
		this.timeout = timeout;
	}
	
	/**
	 * 获得主机地址。
	 * 
	 * @return 主机地址。
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * 获得端口。
	 * 
	 * @return 客户端需要连接的服务器端口。
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * 获得超时。
	 * 
	 * @return 超时。
	 */
	public int getTimeout() {
		return timeout;
	}
	
	/**
	 * 设置主机地址。
	 * 
	 * @param host 主机地址。
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	
	/**
	 * 设置端口。
	 * 
	 * @param port 客户端需要连接的服务器端口。
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * 设置超时。
	 * 
	 * @param timeout 超时。
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
