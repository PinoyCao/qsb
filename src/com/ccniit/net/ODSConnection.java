package com.ccniit.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.ccniit.net.common.LoginPackage;
import com.ccniit.net.common.PackageType;
import com.ccniit.net.common.Package;;

/**
 * <code>ODSConnection</code>类实现了<code>Connection</code>抽象类。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK1.5
 * @see Connection
 */
public class ODSConnection extends Connection{

	private final static Logger log = Logger.getLogger(ODSConnection.class);

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;


	/**
	 * 通过<code>ConnectionConfiguration</code>对象构造<code>
	 * ODSConnection</code>。
	 * 
	 * @param config <code>ConnectionConfiguration</code>对象。
	 */
	public ODSConnection(ConnectionConfiguration config) {
		super(config);
	}

	/**
	 * 通过给定的host和port初始化对象。
	 * 
	 * @param host 主机地址。
	 * @param port 端口。
	 */
	public ODSConnection(String host,int port){
		super(host, port);
	}

	@Override
	public void connect() throws UnknownHostException, IOException, ClassNotFoundException {
		setSocket(new Socket(getConfiguration().getHost(), getConfiguration().getPort()));
		//		Package p = getPackageManager().receivePackage();
		//		//获得由服务器分配的sessionId
		//		setSessionId(p.getSessionId());
	}

	@Override
	public void close() {

		try {
			if(live()){
				getSocket().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean live() {
		if(!getSocket().isClosed()){
			return true;
		}
		return false;
	}


	@Override
	public boolean login(String loginId, String password) throws IOException {
		log.debug("send a loginPacakge");
		sendPackage(new LoginPackage(loginId, password));
		Package p = receivePackage();
		if(p.getType()==PackageType.RESULT){
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public void sendPackage(Package p) {
		if(p == null){
			throw new NullPointerException();
		}
		log.debug("send a Pacakge,type:"+p.getType());
		try {
			objectOutputStream = new ObjectOutputStream(getSocket().getOutputStream());
			objectOutputStream.writeObject(p);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Package receivePackage() {
		Object obj = null;
		try {
			objectInputStream = new ObjectInputStream(getSocket().getInputStream());
			obj = objectInputStream.readObject();
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		}
		Package p = (Package)obj;
		
		if(p!=null){
			log.debug("receive a Package,type:"+p.getType());
		}

		return p;
	}
}




