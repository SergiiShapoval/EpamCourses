package ua.epam.sergiishapoval.homework.hw15;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Сергей on 04.12.2014.
 */
public class Server {

    public static final String RESOURCE_PATH = Paths.get(Server.class.getPackage().getName()).toString() + ".resources";
    private static ResourceBundle RES_SERVER = ResourceBundle.getBundle(Server.RESOURCE_PATH + ".server", Locale.ENGLISH);


    public static Calendar CALENDAR = Calendar.getInstance();
    public static DateFormat FORMATTER = new SimpleDateFormat("d-MM-YY HH:mm:ss");

    public static void main(String[] args) {
        try {
            List<ServerTask> usersOnline = new CopyOnWriteArrayList<>();

            int port = Integer.parseInt(RES_SERVER.getString("PORT"));
            int maxUsers = Integer.parseInt(RES_SERVER.getString("MAX_USERS"));
            InetAddress webAddress = InetAddress.getByName(RES_SERVER.getString("ADDRESS"));

            ServerSocket server = new ServerSocket(port
                    , maxUsers, webAddress
            );
            System.out.printf(RES_SERVER.getString("LAUNCH_MESSAGE"), webAddress.toString(), port, maxUsers);

            while (true){
                Socket newUser = server.accept();
                new ServerTask(newUser, usersOnline).start();
                System.out.printf(RES_SERVER.getString("NEW_USER_CONNECTED"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
