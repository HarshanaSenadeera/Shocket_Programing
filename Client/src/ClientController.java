import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController {

    public TextArea ClientTextShow;
    public TextField ClientTypeText;

    public void ClientSendOnAction(ActionEvent actionEvent) throws IOException {

        dataOutputStream.writeUTF(ClientTypeText.getText().trim());
        dataOutputStream.flush();
    }


    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message = "";

    public void initialize() {
        new Thread(() -> {
            try {
                socket = new Socket("localhost", 3001);
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                while (!message.equals("Finish")) {
                    message = dataInputStream.readUTF();
//                    txtMassage.appendText("\nServer :"+message);
                    ClientTextShow.appendText("\nServer :" + message);

                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }
}
