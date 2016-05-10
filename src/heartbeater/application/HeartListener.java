package heartbeater.application;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeartListener {

            DataInputStream is;
        PrintStream os;
        Socket clientSocket = null;
    public HeartListener(){
        this.connectToClient();
    }
    
    public boolean check(){
        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            String line;
            line = is.readLine();
            System.out.println("Recieved Beat");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HeartListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void connectToClient() {
        ServerSocket echoServer = null;
        try {
            echoServer = new ServerSocket(25);
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Listening");
            clientSocket = echoServer.accept();
            System.out.println("Connected");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
