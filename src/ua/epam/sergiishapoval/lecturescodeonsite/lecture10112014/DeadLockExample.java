package ua.epam.sergiishapoval.lecturescodeonsite.lecture10112014;

/**
 * Created by Сергей on 10.11.2014.
 */
class Thread1 extends Thread{
    Thread1 th;
    public void  setTh (Thread1 th) {
        this.th=th;
    }

    public synchronized void f(){
        try{
            Thread.sleep(1000);
            th.f();
        }catch (InterruptedException e){

        }
    }

    @Override
    public void run() {
        f();
    }
}



public class DeadLockExample {
    public static void main(String[] args) {
        Thread1 thr1 = new Thread1();
        Thread1 thr2 = new Thread1();
        thr1.setTh(thr2);
        thr2.setTh(thr1);

        thr1.start();
        thr2.start();
    }

}
