package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.UserService;
import lk.ijse.hostel.service.exception.DuplicateException;
/*import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.UserService;
import lk.ijse.hostel.service.exception.DuplicateException;*/

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class LoginFormController {
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public Label lblCreateAccount;
    public AnchorPane layer1;
    public Label lblSign;
    public JFXButton singUp;
    public JFXTextField txtId;
    public AnchorPane layer2;
    public JFXButton btnForget;
    public JFXButton singIn;
    public JFXButton underSingUp;
    public JFXButton underSingIn;
    public JFXButton underSingIn1;
    private Pattern txtUserNamePatten;
    private Pattern txtPasswordPatten;
    private Pattern idPatten;
    private Pattern namePatten;
    private Pattern passwordPatten;
    //public UserService userService;
public UserService userService;
    public void initialize() throws SQLException, ClassNotFoundException {
        /*singUp.setVisible(true);*/
        singIn.setVisible(false);
        underSingUp.setVisible(false);
        lblCreateAccount.setVisible(false);
        txtId.setVisible(false);
        idPatten= Pattern.compile("^[S][0][0-9]{1,}$");
        namePatten=Pattern.compile("^[A-Za-z0-9]{4,}$");
        passwordPatten=Pattern.compile("^[a-zA-Z0-9_]{8,}$");
        this.userService= (UserService) ServiceFactory.getInstance().getService(ServiceTypes.USER);
    }
/*    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        UserEntity userEntity=new UserEntity();
        String hql="SELECT U.name FROM UserEntity U";
        Query query= session.createQuery(hql);
        List<UserEntity> re=query.list();
        System.out.println(re);


*//*        boolean uniq=true;
        String pass="password";

        if (uniq){
            if (pass.equals(txtPassword.getText())){
                Stage widow= (Stage) pane.getScene().getWindow();
                widow.close();
                URL resource = getClass().getResource("/lk/ijse/hostel/view/dashboardForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
//                Stage widow= (Stage) pane.getScene().getWindow();
//                widow.close();
                stage.show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"password is incorect").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Please Enter The User Name And Password").show();
        }
        boolean isUserNameMatched=txtUserNamePatten.matcher(txtUserName.getText()).matches();
        boolean isPasswordMatched=txtPasswordPatten.matcher(txtPassword.getText()).matches();
        if (isUserNameMatched){
            if (isPasswordMatched) {
                System.out.println("Loging Success");
            }else{
                txtPassword.setFocusColor(Paint.valueOf("Red"));
                txtPassword.requestFocus();
            }
        }else{
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            txtUserName.requestFocus();
        }*//*
        Stage widow= (Stage) pane.getScene().getWindow();
        widow.close();
        URL resource = getClass().getResource("/lk/ijse/hostel/view/dashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
//                Stage widow= (Stage) pane.getScene().getWindow();
//                widow.close();
        stage.show();



    }*/

    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {
      /*pane.getChildren().clear();
        Navigation.navigation(Routs.USER,pane);*/
    }

    public void btnOnCliked(MouseEvent mouseEvent) {
        TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(558);
        slide.play();

        layer1.setTranslateX(-400);

        singIn.setVisible(true);
        singUp.setVisible(false);
        underSingIn1.setVisible(false);
        underSingUp.setVisible(true);
        lblSign.setVisible(false);
        txtId.setVisible(true);
        btnForget.setVisible(false);
        lblCreateAccount.setVisible(true);

        slide.setOnFinished((e->{

             
        }));
    }

    public void btnFrogetPasswordOnAction(ActionEvent actionEvent) {

    }

    public void btnOnCliked2(MouseEvent mouseEvent) {
        TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(0);
        underSingUp.setVisible(false);
        underSingIn1.setVisible(true);
        singIn.setVisible(false);
        singUp.setVisible(true);
        lblSign.setVisible(true);
        txtId.setVisible(false);
        btnForget.setVisible(true);
        lblCreateAccount.setVisible(false);

        slide.setOnFinished((e->{


        }));
    }

    public void btnSingInOnAction(ActionEvent actionEvent) throws IOException {
        Stage widow= (Stage) pane.getScene().getWindow();
        widow.close();
        URL resource = getClass().getResource("/lk/ijse/hostel/view/dashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    public void btnSingUpOAction(ActionEvent actionEvent) {
        boolean isIdMatched=idPatten.matcher(txtId.getText()).matches();
        boolean isNameMatched=namePatten.matcher(txtUserName.getText()).matches();
        boolean isPasswordMatched=passwordPatten.matcher(txtPassword.getText()).matches();

        if (isIdMatched){
            if(isNameMatched){
                    if(isPasswordMatched){

                        UserDTO userDTO=new UserDTO(txtId.getText(),txtUserName.getText(),txtPassword.getText());
                        try {
                            boolean isAdded = userService.saveUser(userDTO);
                            new Alert(Alert.AlertType.CONFIRMATION, "Done").show();
                            txtId.clear();
                            txtUserName.clear();
                            txtPassword.clear();
                        }catch (DuplicateException e){
                            new Alert(Alert.AlertType.ERROR,"User Already Registered").show();
                        }
                    }else {
                        txtPassword.setFocusColor(Paint.valueOf("Red"));
                        txtPassword.requestFocus();
                    }

            }else {
                txtUserName.setFocusColor(Paint.valueOf("Red"));
                txtUserName.requestFocus();
            }
        }else {
            txtId.setFocusColor(Paint.valueOf("Red"));
            txtId.requestFocus();
        }
    }
}
