package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResrvationFormController {
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXComboBox<?> cmbStudentId;

    @FXML
    private JFXComboBox<?> cmbRoomId;

    @FXML
    private JFXTextField txtStudent;

    @FXML
    private TableView<?> tblReservation;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colStudenrId;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colStatus;

    public void txtIdOnActionm(ActionEvent actionEvent) {
    }

    public void btnRegistaion(ActionEvent actionEvent) {
        
    }

    public void btnUpdateOnACtion(ActionEvent actionEvent) {
    }
}
