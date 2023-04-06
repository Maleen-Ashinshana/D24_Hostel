package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routes;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane subpage;
    public JFXComboBox comType;
    public Label lblAllRooms;
    public Label lblCurrentRooms;
    public Label lblQty;
    public TableView tblRemain;
    public TableColumn colId;
    public TableColumn colname;
    public TableColumn colKyeMoney;
    public AnchorPane mainPane;

    public void btnDashBoard(ActionEvent actionEvent) throws IOException {
     subpage.getChildren().clear();
     Navigation.navigate(Routes.DASHBOARD,mainPane);
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        subpage.getChildren().clear();
        Navigation.navigate(Routes.STUDENT,subpage);

    }

    public void btnRoomOnAction(ActionEvent actionEvent) {

    }

    public void btnReservationOnACtion(ActionEvent actionEvent) {

    }
}
