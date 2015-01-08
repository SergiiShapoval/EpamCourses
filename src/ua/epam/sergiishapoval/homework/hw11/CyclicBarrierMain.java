package ua.epam.sergiishapoval.homework.hw11;


/**
 * Created by Сергей on 13.11.2014.
 * Реализовать CyclicBarrier. Он приостанавливает все потоки,
 * которые вызывают его метод await до тех пор,
 * пока их не наберётся нужно количество,
 * указанное в конструкторе.
 * Также в конструкторе можно передать объект,
 * реализующий знакомый нам интерфейс Runnable,
 * который будет выполнен по достижению размера очереди потоков определённого количества.
 */
public class CyclicBarrierMain {
    public static void main(String[] args) {

        MyCyclicBarrier cyclicBarrier = new MyCyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("additional CyclicBarrier Task");
            }
        });

        for (int i = 0; i < 10; i++) {
            new BarrierThread(Integer.valueOf(i).toString(), cyclicBarrier);
        }

    }
}
