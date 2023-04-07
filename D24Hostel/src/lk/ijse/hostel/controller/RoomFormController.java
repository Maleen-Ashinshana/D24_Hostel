package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.tm.RoomTm;

import java.sql.SQLException;

public class RoomFormController {
    public AnchorPane pane;
    public JFXTextField txtId;
    public JFXTextField txtType;
    public JFXTextField txtxKeyMoney;
    public JFXTextField txtQty;
    public TableView tblRooms;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public RoomService roomService;
    public void initialize() throws SQLException, ClassNotFoundException {
        RoomtView();
        this.roomService= (RoomService) ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
    }
    private void RoomtView(){
        colId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

    }

    public void txtIDOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO=roomService.searchRoom(txtId.getText());
        if (roomDTO!=null){
            fillData(roomDTO);
        }
    }
    private void fillData(RoomDTO roomDTO){
        txtId.setText(roomDTO.getRoom_type_id());
        txtType.setText(roomDTO.getType());
        txtxKeyMoney.setText(roomDTO.getKey_money());
        txtQty.setText(String.valueOf(roomDTO.getQty()));
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO=new RoomDTO(txtId.getText(),txtType.getText(),txtxKeyMoney.getText(),Integer.parseInt(txtQty.getText()));
        try {
            boolean isAdded=roomService.saveRoom(roomDTO);
            if (isAdded){
                tblRooms.getItems().add(new RoomTm(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(), roomDTO.getQty()));
                txtId.clear();
                txtType.clear();
                txtxKeyMoney.clear();
                txtQty.clear();
            }else {
                new Alert(Alert.AlertType.ERROR,"No").show();
            }

        }catch (DuplicateException e){
            new Alert(Alert.AlertType.ERROR,"Room Already Added").show();
            txtId.selectAll();
            txtId.requestFocus();
        }
    }

    public void btnDeleteonAction(ActionEvent actionEvent) {
    }

    public void btnUpdateonAction(ActionEvent actionEvent) {
        RoomDTO roomDTO=new RoomDTO(txtId.getText(),txtType.getText(),txtxKeyMoney.getText(),Integer.parseInt(txtQty.getText()));
        try {
            roomService.updateRoom(roomDTO);
            new Alert(Alert.AlertType.INFORMATION,"Update").show();
        }catch (NotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }
}
