package ua.epam.sergiishapoval.lecturescodeonsite.lecture07112014;

/**
 * Created by Сергей on 07.11.2014.
 */


class Sum extends Thread{
    int begin, end, result;

    Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = begin; i <end ; i++) {
            result += i;
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Sum s = new Sum(0, 500);
        Sum s2 = new Sum(500, 1001);

        s.start();
        s2.start();


        try {
            s.join();
            s2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println((s.result + s2.result));

    }
}
