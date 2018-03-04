/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerportal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Mohit Arora
 */
public class socketThread extends Thread {
    protected Socket socket;
    protected workstation wk;
    protected ArrayList<String> receivedArray = new ArrayList<>();

    public socketThread(Socket clientSocket, workstation wk) {
        this.socket = clientSocket;
        this.wk = wk;
    }

    public void run() {
        
        InputStream inp = null;
        BufferedReader brinp = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.equalsIgnoreCase("DONE")) {
                    socket.close();
                    wk.putData_and_sendKitchen(receivedArray);
                    return;
                } else {
                    receivedArray.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
