import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //server socket
            ServerSocket serverSocket = new ServerSocket(3000);

            //local socket
            Socket socket = serverSocket.accept();

            System.out.println("Client Accepted");

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

                message=dataInputStream.readUTF();
                System.out.println("Client says------>" + message);

                reply=bufferedReader.readLine();

                dataOutputStream.writeUTF(reply);

                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataInputStream.close();
            socket.close();
            serverSocket.close();





        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}