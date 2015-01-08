package ua.epam.sergiishapoval.lecturescodeonsite.lecture21112014;


/**
 * Created by Сергей on 21.11.2014.
 */
public class MyChainOfResponsibility {

    public static void main(String[] args) {
        Handler h = new Handler();

        CommandA commandA = new CommandA(h);
        CommandB commandB = new CommandB(commandA);

        commandB.execute("aaa");
    }
}

/**
 * заглушка для всех остальных
 */
class Handler{
    Handler handler;
    public void execute(String command){
        System.out.println("Default");
    }


}

class CommandA extends Handler{
    CommandA(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(String command) {
        if (command == "aa"){
            System.out.println("aaa");
        }else {
            handler.execute(command);
        }
    }
}

class CommandB extends Handler{
    CommandB(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(String command) {
        if (command == "BB"){
            System.out.println("bbb");
        }else {
            handler.execute(command);
        }
    }
}

