/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeater.server;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeartBeater {

    static Socket smtpSocket = null;
    static DataOutputStream os = null;
    static DataInputStream is = null;

    private static void beat() {
        if (smtpSocket != null && os != null && is != null) {
            try {
                System.out.println("Sending Beat");
                os.writeBytes("Tick\n");

            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            smtpSocket = new Socket(InetAddress.getByName("localhost"), 25);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
            while(true){
                beat();
                
                Thread.sleep(1000);
            }
            

        } 
        catch (InterruptedException ex) {
                    Logger.getLogger(HeartBeater.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
                    
        try {
            os.close();
            smtpSocket.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(HeartBeater.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
