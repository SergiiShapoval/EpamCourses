package ua.epam.sergiishapoval.homework.hw15;

import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Сергей on 04.12.2014.
 */
public class User {
    public static final String RESOURCE_PATH = Paths.get(Server.class.getPackage().getName()).toString() + ".resources";;
    public static ResourceBundle RES_CHAT = ResourceBundle.getBundle(RESOURCE_PATH+".chat", Locale.getDefault());
    private static ResourceBundle RES_SERVER = ResourceBundle.getBundle(RESOURCE_PATH + ".server", Locale.getDefault());

    static Socket socket;
    static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) {
            System.out.printf(decodeString(RES_CHAT.getString("INSTRUCTIONS")));
        try {
            socket = new Socket(RES_SERVER.getString("ADDRESS"), Integer.parseInt(RES_SERVER.getString("PORT")));
            in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            UserTask task = new UserTask(in);
            task.start();

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String currentLine;

            out.println(Locale.getDefault().getCountry());

            while (!(currentLine = consoleReader.readLine()).equals(decodeString(RES_CHAT.getString("EXIT")))){
                out.println(currentLine);
            }

            out.println(currentLine);
            task.interrupt();
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static String decodeString(String resource)  {
        try {
            return new String( resource.getBytes("CP1252"),"CP1251");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
