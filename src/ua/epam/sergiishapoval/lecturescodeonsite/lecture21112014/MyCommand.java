package ua.epam.sergiishapoval.lecturescodeonsite.lecture21112014;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Сергей on 21.11.2014.
 */
public class MyCommand {
    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.createCommand("aaa").execute();

        Comand cmd = commandFactory.createCommand("bbb");;
        cmd.execute();
    }
}

interface Comand{
    void execute();
}


class ComandA implements Comand{
    @Override
    public void execute() {
        System.out.println("A");
    }
}

class ComandB implements Comand{
    @Override
    public void execute() {
        System.out.println("B");
    }
}


class CommandFactory{
    Map<String, Comand> m = new HashMap<String, Comand>(){
        {
            put("aaa", new ComandA());
            put("bbb", new ComandB());
        }
    };
    public Comand createCommand(String s){
        return m.get(s);
    }

}
