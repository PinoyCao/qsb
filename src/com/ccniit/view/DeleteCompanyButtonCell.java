package com.ccniit.view;

import com.ccniit.controller.ManageCompanyDetailController;
import com.ccniit.model.Company;
import com.ccniit.model.CompanyDataModel;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeleteCompanyButtonCell extends TableCell<CompanyDataModel, Boolean>{
	final static String message="确定删除？";
    final Button deleteButton= new Button("删除");
    // pads and centers the add button in the cell.
    final StackPane paddedButton = new StackPane();
    // records the y pos of the last button press so that the add person dialog can be shown next to the cell.
    final DoubleProperty buttonY = new SimpleDoubleProperty();
	private ManageCompanyDetailController controller;
 
    /** 
     * DeleteButtonCell constructor
     * @param stage the stage in which the table is placed.
     * @param table the table to which a new person can be added.
     */
    public DeleteCompanyButtonCell(final Stage stage, final TableView<CompanyDataModel> table,ManageCompanyDetailController controller) {
      this.controller=controller;
      paddedButton.setPadding(new Insets(3));
      paddedButton.getChildren().add(deleteButton);
      deleteButton.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent mouseEvent) {
          buttonY.set(mouseEvent.getScreenY());
        }
      });
      
      deleteButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent actionEvent) {
          showDeleteDialog(stage, table, buttonY.get());
          table.getSelectionModel().select(getTableRow().getIndex());

        }
      });
    }
 
    /** places an add button in the row only if the row is not empty. */
    @Override protected void updateItem(Boolean item, boolean empty) {
      super.updateItem(item, empty);
      if (!empty) {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setGraphic(paddedButton);
      } else {
        setGraphic(null);
      }
    }
  
 
  /**
   * shows a dialog which displays a UI for confirming the deletion.
   * @param parent a parent stage to which this dialog will be modal and placed next to.
   * @param table the table to which a person is to be added.
   * @param y the y position of the top left corner of the dialog.
   */
  private void showDeleteDialog(Stage parent, final TableView<CompanyDataModel> table, double y) {
    // initialize the dialog.
    final Stage dialog = new Stage();
    dialog.setTitle("提示");
    dialog.initOwner(parent);  //对话框永远在前面
    dialog.initModality(Modality.WINDOW_MODAL);  //必须关闭对话框后才能操作其他的
    dialog.initStyle(StageStyle.UTILITY); //对话框-只保留关闭按钮
    dialog.setX(parent.getX() + parent.getWidth()/3);
    dialog.setY(y);
 
    // create a grid for the data entry.
    HBox msg = new HBox();  
    msg.setSpacing(5);  
    msg.getChildren().addAll(new Message(message));  
 
    // create action buttons for the dialog.
    Button ok = new Button("确定");
    ok.setDefaultButton(true);
    Button cancel = new Button("取消");
    cancel.setCancelButton(true);
 
 
    // add action handlers for the dialog buttons.
    ok.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent actionEvent) {
    	int row = table.getSelectionModel().getSelectedIndex();
    	Company c=table.getSelectionModel().getSelectedItem().getCompany();
    	controller.deleteRow(c,row);
        dialog.close();
      }
    });
    cancel.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent actionEvent) {
        dialog.close();
      }
    });
 
    // layout the dialog.
    HBox buttons = HBoxBuilder.create().spacing(10).children(ok, cancel).alignment(Pos.CENTER_RIGHT).build();
    VBox layout = new VBox(10);
    layout.getChildren().addAll(msg, buttons);
    layout.setPadding(new Insets(15));
    dialog.setScene(new Scene(layout));
    dialog.show();
  }
  static class Message extends Text {  
      public Message(String msg) {  
          super(msg);  
          setWrappingWidth(250);//自动换行的宽度  
      }  
}
}
