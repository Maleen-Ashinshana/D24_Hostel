package lk.ijse.hostel.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case DASHBOARD:
                window.setTitle("Customer Manage Form");
                initUI("dashboardForm.fxml");
                break;
            case STUDENT:
                initUI("studentForm.fxml");
                break;
            case ROOM:
                initUI("roomForm.fxml");
                break;
            case RESERVATION:
                initUI("resrvationForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/hostel/view/" + location)));
    }
}
