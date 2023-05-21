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

public class ServerController {
    public TextArea ServerTextShow;
    public TextField ServerTypeText;

    public void ServerSendOnAction(ActionEvent actionEvent) throws IOException {

        dataOutputStream.writeUTF(ServerTypeText.getText().trim());
        dataOutputStream.flush();
    }

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message="";

    public void initialize(){
        new Thread(()->{
            try {
                serverSocket= new ServerSocket(3001);
                ServerTextShow.appendText("Server Started!..");
                socket = serverSocket.accept();

                ServerTextShow.appendText("\nClient Connected!..");
                dataInputStream=new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());


                while (!message.equals("Finish")){
                    message=dataInputStream.readUTF();
                    ServerTextShow.appendText("\nClient :"+message);
                }



            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }}