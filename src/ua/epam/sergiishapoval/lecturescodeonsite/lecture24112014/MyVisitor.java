package ua.epam.sergiishapoval.lecturescodeonsite.lecture24112014;

/**
 * Created by Сергей on 24.11.2014.
 */
interface Visitor{
    public void visit (Acceptor a);
}

class Acceptor {
    public void accept (Visitor v){
        v.visit(this);
    }
}


public class MyVisitor implements Visitor{
    @Override
    public void visit(Acceptor a) {

    }
}
