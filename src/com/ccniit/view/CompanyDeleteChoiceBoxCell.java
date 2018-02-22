package com.ccniit.view;

import com.ccniit.model.CompanyDataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CompanyDeleteChoiceBoxCell extends TableCell<CompanyDataModel, Integer>{
	private ChoiceBox<Integer> choiceBox;
	ObservableList<Integer> value;

	public CompanyDeleteChoiceBoxCell() {
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
