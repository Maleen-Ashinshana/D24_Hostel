package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.StudentService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import tm.StudentTM;


import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    private TableView<StudentTM> tblStudent;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn coltel;

    @FXML
    private TableColumn colDOB;

    @FXML
    private TableColumn colGender;
    private Pattern idPattern;
    private Pattern NamePattern;
    private Pattern addressPattern;
    private Pattern contPattern;
    private Pattern dobPattern;
    private Pattern genderPattern;
    public StudentService studentService;
    public StudentTM studentTM;
    public void initialize() throws SQLException, ClassNotFoundException {
        pattern();
        studentView();
        //loadAllStudent();
        this.studentService= (StudentService) ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);
    }
    public void pattern(){
        idPattern=Pattern.compile("[S][0][0-9]{1,}");
        NamePattern=Pattern.compile("^[A-Za-z0-9]{4,}$");
        addressPattern=Pattern.compile("^[A-Za-z0-9]{1,}$");
        contPattern=Pattern.compile("^(076|074|073|075|078|072|091)([0-9]{7})$");
        dobPattern=Pattern.compile("[0-9]{1,}");
        genderPattern=Pattern.compile("^[A-Za-z]{1,}$");
    }


    public void txtIdOnAction(javafx.event.ActionEvent actionEvent) {
        StudentDTO studentDTO=studentService.searchStudent(txtId.getText());
        if (studentDTO!=null){
            fillData(studentDTO);
        }
    }
    private void fillData(StudentDTO studentDTO){
        txtId.setText(studentDTO.getStudentId());
        txtName.setText(studentDTO.getStudentName());
        txtAddress.setText(studentDTO.getAddress());
        txtxTel.setText(String.valueOf(studentDTO.getContact_number()));
        txtDOB.setText(studentDTO.getDate_of_birth());
        txtGender.setText(studentDTO.getGender());
    }
    public void btnSAddOnAction(javafx.event.ActionEvent actionEvent) {
        boolean isIdMatched = idPattern.matcher(txtId.getText()).matches();
        boolean isNameMatched = NamePattern.matcher(txtName.getText()).matches();
        boolean isAddressMatched = addressPattern.matcher(txtAddress.getText()).matches();
        boolean isContMatched = contPattern.matcher(txtxTel.getText()).matches();
        //boolean isDOBdMatched=dobPattern.matcher(txtDOB.getText()).matches();
        boolean isGenderMatched = genderPattern.matcher(txtGender.getText()).matches();

/*        if (isIdMatched){
            if (isNameMatched){
                if (isAddressMatched){
                    if (isContMatched){
                        *//*if (isDOBdMatched){*//*
                            if (isGenderMatched){

                            }
                        }
                    }
                }
            }
        }*/
        StudentDTO studentDTO=new StudentDTO(txtId.getText(),txtName.getText(),txtAddress.getText()
                ,Integer.parseInt(txtxTel.getText()),txtDOB.getText(),txtGender.getText());
        System.out.println(studentDTO);
        try {
            boolean isAdded=studentService.saveStudent(studentDTO);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Added  Successful").show();
                tblStudent.getItems().add(new StudentTM(studentDTO.getStudentId(),studentDTO.getStudentName(),
                        studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender()));
                txtId.clear();
                txtName.clear();
                txtAddress.clear();
                txtxTel.clear();
                txtDOB.clear();
                txtGender.clear();
            }else {
                new Alert(Alert.AlertType.ERROR,"No").show();
            }

        }catch (DuplicateException e){
            new Alert(Alert.AlertType.ERROR,"Student Already Added").show();
            txtId.selectAll();
            txtId.requestFocus();
        }


    }

    public void btnSDeleteOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void btnSUpdateOnAction(javafx.event.ActionEvent actionEvent) {
        StudentDTO studentDTO=new StudentDTO(txtId.getText(),txtName.getText(),txtAddress.getText(),Integer.parseInt(txtxTel.getText()),txtDOB.getText(),txtGender.getText());
        try {
            studentService.updateStudent(studentDTO);
            new Alert(Alert.AlertType.INFORMATION,"Update").show();
        }catch (NotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
    }

    public void BtnStSearchOnAction(javafx.event.ActionEvent actionEvent) {
    txtIdOnAction(actionEvent );
    }
    private void studentView(){
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        coltel.setCellValueFactory(new PropertyValueFactory<>("contact_number"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }
    private void loadAllStudent() throws SQLException {
       // System.out.println(studentTM.getStudentId());
        System.out.println("**************");
        List<StudentTM> collect=studentService.getAllStudent().stream().map(studentDTO -> new StudentTM
                (studentDTO.getStudentId(), studentDTO.getStudentName(), studentDTO.getAddress(), studentDTO.getContact_number(),
                        studentDTO.getDate_of_birth(), studentDTO.getGender())).collect(Collectors.toList());
        System.out.println("++++++++++++++++");
        tblStudent.setItems(FXCollections.observableArrayList(collect));
        System.out.println("-----------------");
    }
}
