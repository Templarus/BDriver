/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author RusTe
 */
public class PackListener {

    private ServerSocket serverSocket;
    private Socket cs;
    InputStream in;
    OutputStream out;
    int length = 0;
    byte[] incoming;

    private boolean status = true;  // статус соединения\открытого ClientSocker
    private long time1;
    private long time2;
    private int timeLimit = 10000;
    boolean switcher = true;

    private void makeConnection() {
        try {
            serverSocket = new ServerSocket(5656);
            Socket clientSocket = new Socket();
            clientSocket = serverSocket.accept();

            while (true) {
                if (!clientSocket.isClosed()) { // подлежит доработке для адекватной отработки кода

                    in = clientSocket.getInputStream();
                    out = clientSocket.getOutputStream();
                    incoming = new byte[256];

                    System.out.println("Client query(" + length + " bytes):" + new String(incoming).trim());

//                    String reply = makeAnswer(incoming); // выполняется метод, который возвращает устройству требуемый ответ в зависимости от пришедшего пакета
//
//                    if (reply.equals("empty")) { //если вернулось empty - устройство разорвало соединение со своей стороны.
//                        in.close();
//                        out.close();
//                        //cs.close();
//                        serverSocket.close();
//                        Start.mf.setWatcherStatus(device, false); // соединение разорвано и требуется запустить новый поток с новым Listener для этого порта и устройства
//                        Start.mf.deviceConnection(device.getId(), false);
//                        Start.mf.deviceStatus(device.getId(), false);
//                    } else {
//
//                        out.write(reply.getBytes());}
                    System.out.println("DeviceListener: getPacket executed");

                }
            }
        } catch (IOException ex) {
            try {
                in.close();
                out.close();
                cs.close();
                serverSocket.close();

            } catch (IOException ex1) {

            }
        }
    }

}
