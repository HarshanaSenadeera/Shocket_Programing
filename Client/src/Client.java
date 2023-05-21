import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",3000);
            //Catch client message
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //Buffer Reader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            //Output Stream
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //Variables for catch message and reply
            String message="";
            String reply="";

            while (!message.equals("stop")){
                message=bufferedReader.readLine();

                dataOutputStream.writeUTF(message);

                dataOutputStream.flush();

                reply=dataInputStream.readUTF();

                System.out.println("Server says---->" + reply);
            }

            dataOutputStream.close();
            socket.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}