/*
 * EditingIntegerCell.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-3.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.view;

import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * <code>EditingIntegerCell</code>类是一个带有一个<code>
 * javafx.scene.control.TextField</code>的可编辑文本框。
 * 这个文本框只能输入<code>java.lang.Integer</code>类型的数据。
 * 
 * @author fengyouchao
 *
 * @param <T> TableCell的数据模型
 */
public class EditingIntegerCell<T> extends TableCell<T, Integer> {
	private TextField textField;

	public EditingIntegerCell() {
	}

	@Override public void startEdit() {
		super.startEdit();

		if (textField == null) {
			createTextField();
		}
		setText(null);
		setGraphic(textField);
		textField.selectAll();
	}

	@Override public void cancelEdit() {
		super.cancelEdit();
		setText( getItem().toString());
		setGraphic(null);
	}

	@Override public void updateItem(Integer item, boolean empty) {
		super.updateItem(item, empty);
		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (textField != null) {
					textField.setText(getString());
				}
				setText(null);
				setGraphic(textField);
			} else {
				setText(getString());
				setGraphic(null);
			}
		}
	}

	private void createTextField() {
		textField = new TextField(getString());
		textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
		textField.setOnKeyReleased(new EventHandler<KeyEvent>() {                
			@Override public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER) {
					int value = 1;
					try{
						value = Integer.parseInt(textField.getText());
					}catch(Exception e){
						cancelEdit();
						return;
					}
					commitEdit(value);
				} else if (t.getCode() == KeyCode.ESCAPE) {
					cancelEdit();
				}
			}
		});
	}

	private String getString() {
		return getItem() == null ? "" : getItem().toString();
	}
}