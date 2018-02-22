package com.ccniit.view;

import com.ccniit.model.StaffDataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * <code>StaffDeleteChoiceBoxCell</code>类是一个
 * 一个带有chocieBox的表格框，用于在员工管理中的表格
 * 中删除用户类型。
 * 
 * @author caoyan 
 * @version 1.0
 * @since JDK1.7
 * @see StaffDataModel
 *
 */
public class StaffDeleteChoiceBoxCell extends TableCell<StaffDataModel, Integer> {
	private ChoiceBox<Integer> choiceBox;
	ObservableList<Integer> value;

	public StaffDeleteChoiceBoxCell() {
		value = FXCollections.observableArrayList();
		value.add(0);
		value.add(1);
	}
	
	@Override public void startEdit() {
		super.startEdit();

		if (choiceBox == null) {
			createchoiceBox();
		}
		setText(null);
		setGraphic(choiceBox);
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
				if (choiceBox != null) {
///
				}
				setText(null);
				setGraphic(choiceBox);
			} else {
				setText(getString());
				setGraphic(null);
			}
		}
	}

	private void createchoiceBox() {

		choiceBox = new ChoiceBox<>();
		choiceBox.setItems(value);
		choiceBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
		//设置默认选择项
		choiceBox.getSelectionModel().select(Integer.parseInt(getText()));
		choiceBox.setOnKeyReleased(new EventHandler<KeyEvent>() {                
			@Override public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER) {
					commitEdit(choiceBox.getSelectionModel().getSelectedItem());
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