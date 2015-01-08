package ua.epam.sergiishapoval.homework.hw15;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Сергей on 04.12.2014.
 */
public class UserTask extends Thread {

    BufferedReader in;

    public UserTask(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                String nextString = in.readLine();
                if (!nextString.equals(User.decodeString(User.RES_CHAT.getString("EXIT"))))
                System.out.println(nextString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
