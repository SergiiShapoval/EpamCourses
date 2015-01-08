package ua.epam.sergiishapoval.homework.hw12.poolexec;

import java.util.concurrent.TimeUnit;

/**
 * Created by Сергей on 22.11.2014.
 */
public class MyThreadPoolTest {
    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(4,4);


        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("First thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("First thread finished");
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Second thread finished");
            }
        });

       executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Third thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Third thread finished");
            }
        });
       executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Forth thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Forth thread finished");
            }
        });


       executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Fifth thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Fifth thread finished");
            }
        });
       executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sixth thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sixth thread finished");
            }
        });
       executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Seventh thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Seventh thread finished");
            }
        });
       executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Eighth thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Eighth thread finished");
            }
        });

        executor.shutdown();

        long startAwait = System.currentTimeMillis();

        try {
            System.out.println(executor.awaitTermination(11, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endAwait = System.currentTimeMillis();

        System.out.printf("Time for awaiting: %d%n", (endAwait - startAwait));

/*
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/


/*
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Nineth thread started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Nineth thread finished");
            }
        });
*/


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
