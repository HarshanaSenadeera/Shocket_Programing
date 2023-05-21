import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class ClientAppInizializor extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Client.fxml")))));
        //   primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/lk/hostelManagement/pos/view/LoginForm.fxml")))));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
