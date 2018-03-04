/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerportal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mohit Arora
 */
public class searchSocketThread extends Thread{
    
    private static final Integer PORT = 9765;
    protected workstation wk;
    
    public searchSocketThread(workstation wk) {
        this.wk = wk;
    }
    
    public void run(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            new socketThread(socket,wk).start();
        }
    }
}
