package com.ccniit.connectServer;

import com.ccniit.model.Constant;

public class LinkThread extends Thread{
	Object flag;
    public LinkThread(String testurl,Object flag){
    	 super(testurl);
    	 this.flag = flag;
    	 setDaemon(true);//守护线程，在没有用户线程可服务时会自动离开
    }
	public void run() {
        while(true)
			try {
				Constant.isonline=new FluentAsync().isconnect(Thread.currentThread().getName());
				synchronized (flag) {
					flag.notify();
				}
				//System.out.println(Constant.isonline);
				Constant.isfinish=true;
				sleep(1000);//休眠时间1s
			} catch (Exception e) {
				e.printStackTrace();
			}
    }


}
