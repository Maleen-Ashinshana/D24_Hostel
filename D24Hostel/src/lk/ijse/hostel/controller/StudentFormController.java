package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.awt.event.ActionEvent;

public class StudentFormController {
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtxTel;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private TableView tblStudent;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> coltel;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colGender;


    public void txtIdOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void btnAddOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(javafx.event.ActionEvent actionEvent) {
    }
}
