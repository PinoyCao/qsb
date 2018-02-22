package com.ccniit.sys.pub.login;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class FlashYZM {
	static ImageIcon  realicon = new ImageIcon(); 
	public static ImageIcon flashYZM(){
		 new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                while (true) {  
	                    SwingUtilities.invokeLater(new Runnable() {  
	                        @Override  
	                        public void run() {  
	                   		 	ImageIcon  icon = new ImageIcon("D:\\test.jpg");  
	                   		    realicon.setImage(icon.getImage());
	                        }  
	                    });  
	                      
	                    try {  
	                        Thread.sleep(100);  
	                    } catch (InterruptedException e) {  
	                        e.printStackTrace();  
	                    }  
	                }  
	            }  
	        }).start(); 
		 return realicon;
	}
}
