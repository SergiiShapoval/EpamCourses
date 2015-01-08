package ua.epam.sergiishapoval.homework.hw8.concursum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 08.11.2014.
 * 	1) Посчитать сумму Н чисел 1-2 млн;
 * 	использовать BigInteger. Разделить на k потоков, замерить производительность;
 * 	При каком к-ве потоков производительность максимальна;
 * 	Вначале "разогреть систему", чтобы система не подгружала сервисные процессы в процессе замеров
 */
public class ConcurrentSumTest {
    public static void main(String[] args) {
        List<BigSum> threads;

        BigInteger limit = new BigInteger("1000000");

        long optimalTime = Long.MAX_VALUE;
        int optimalThreadsQty = 0;

        for (int i = 1; i <25 ; i++) {
            threads = new ArrayList<>(i+15);
            BigInteger finalResult = new BigInteger("0");

            for (int j = 0; j < i ; j++) {
                BigSum buffer = new BigSum(i, j, limit);
                threads.add(buffer);
            }

            long startTime = System.currentTimeMillis();

            for (BigSum thread : threads){
                thread.start();
            }

            for (BigSum thread : threads){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (BigSum thread : threads){
                finalResult = finalResult.add(thread.getResult());
            }

            System.out.println(finalResult);

            long endTime = System.currentTimeMillis();

            long currentThreadTime = endTime - startTime;
            if (currentThreadTime < optimalTime){
                optimalTime = currentThreadTime;
                optimalThreadsQty = i;
            }

            System.out.println(String.format("Needed time for %d threads to calculate %s: %d", i, limit, currentThreadTime ));
        }


        System.out.printf("Optimal time - %d, when working %d threads", optimalTime, optimalThreadsQty);
    }
}
