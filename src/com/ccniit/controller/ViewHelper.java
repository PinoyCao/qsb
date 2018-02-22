package com.ccniit.controller;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;


/**
 * <code>ViewHelper</code>类实现了一些界面上的方法。
 * @author caoyan
 * 
 */
public abstract class ViewHelper {

	/**
	 * 一个由浅变深的动画，用来显示信息。
	 * 
	 * @param message 要显示的信息。
	 * @param messageLabel 显示此条信息的<code>javafx.scene.control.Label</code>对象
	 */
	public void animateMessage(String message,Label messageLabel) {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), messageLabel);
		ft.setFromValue(0.0);
		ft.setToValue(1);
		ft.play();
		messageLabel.setText(message);
	}
}
