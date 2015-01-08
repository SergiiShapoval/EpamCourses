package ua.epam.sergiishapoval.homework.hw15;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Сергей on 04.12.2014.
 */
public class ServerTask extends Thread {
    Socket currentUser;
    List<ServerTask> usersOnline;

    public ResourceBundle resChat;

    String userName;

    public ServerTask(Socket currentUser, List<ServerTask> usersOnline) {
        this.currentUser = currentUser;
        this.usersOnline = usersOnline;
    }

    BufferedReader reader;
    PrintWriter out;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(currentUser.getInputStream()));
            out = new PrintWriter(currentUser.getOutputStream(), true);

            resChat = ResourceBundle.getBundle(Server.RESOURCE_PATH+".chat", new Locale(reader.readLine()));

            while (true){
                out.println(decodeString(resChat.getString("USERNAME_REQUEST")));
                String possibleName = reader.readLine();
                boolean isNameRepeated = false;
                if (decodeString(resChat.getString("ALL")).equals(possibleName)){
                    isNameRepeated = true;
                }
                for (ServerTask task : usersOnline){
                    if (task.getUserName().equals(possibleName)){
                        isNameRepeated = true;
                        break;
                    }
                }
                if (isNameRepeated){
                    out.printf(decodeString(resChat.getString("CHOOSE_ANOTHER_NAME")), possibleName);
                    continue;
                }else setUserName(possibleName);
                break;
            }

            usersOnline.add(this);
            writeToAll(decodeString(resChat.getString("ONLINE")));
            String currentLine;

            while (!decodeString(resChat.getString("EXIT")).equals(currentLine = reader.readLine())){

                if (decodeString(resChat.getString("ONLINE")).equals(currentLine)){
                    StringBuilder builder = new StringBuilder();
                    builder.append(decodeString(resChat.getString("LIST_OF_ONLINE_USERS")));
                    boolean isFirst = true;
                    for (ServerTask task : usersOnline) {
                        if (isFirst){
                            isFirst = false;
                        }else {
                            builder.append(", ");
                            builder.append("\n");
                        }
                        builder.append(task.getUserName());
                    }
                    builder.append(decodeString(resChat.getString("END_OF_LIST")));
                    out.println(builder.toString());
                }else {
                    int firstColumnPos = currentLine.indexOf(':');
                    String receiverName = null;
                    if (firstColumnPos>0)
                        receiverName = currentLine.substring(0, firstColumnPos);
                    else writeToAll(currentLine);
                    if (decodeString(resChat.getString("ALL")).equals(receiverName)){
                        writeToAll(currentLine.substring(firstColumnPos + 1, currentLine.length()));
                    }else {
                        boolean isFound =false;
                        synchronized (usersOnline) {
                            for (ServerTask task : usersOnline) {
                                if (task.getUserName().equals(receiverName)&&task!=this) {
                                    isFound = true;
                                    PrintWriter writer = task.out;
                                    writer.println(
                                            userName +
                                                    decodeString(resChat.getString("PERSONALLY")) +
                                                    "[" + Server.FORMATTER.format(Server.CALENDAR.getTime())+ "]" +
                                                    currentLine.substring(firstColumnPos + 1, currentLine.length())
                                    );
                                }
                            }
                        }
                        if (!isFound) out.println(
                                String.format(
                                        decodeString(resChat.getString("USER_NOT_FOUND")),
                                        receiverName));
                    }
                }

            }

            writeToAll(decodeString(resChat.getString("OFFLINE")));
            usersOnline.remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToAll(String message) {
        synchronized (usersOnline) {
            for (ServerTask task : usersOnline) {
                PrintWriter writer = task.out;
                writer.println(String.format("%s[%s]: %s",
                        userName,
                        Server.FORMATTER.format(new Date()),
                        message));
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
