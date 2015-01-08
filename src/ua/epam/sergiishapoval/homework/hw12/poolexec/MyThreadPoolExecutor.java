package ua.epam.sergiishapoval.homework.hw12.poolexec;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Сергей on 21.11.2014.
 * Создать свой собственные ThreadPoolExceutors.
 * Important points:
 * newTaskfor for Callable and Runnable
 * submit return newtaskfor and execute
 * element is taken from blockingQueue
 * elements is inserted if !isShutDown
 * taskThread contain isDone for boolean await method
 * await converse TimeUnit too milliseconds and check
 */
public class MyThreadPoolExecutor {

    class TaskThread extends Thread {

        private Runnable runnable;
        private volatile boolean isRunnableDone = true;

        public boolean isRunnableDone() {
            return isRunnableDone;
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                try {
                    runnable = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isRunnableDone = false;

                assert (runnable != null): "Null runnable running";
                    runnable.run();

                isRunnableDone = true;
            }
        }
    }



    private int queueDimension;
    private int threadLimit;

    public MyThreadPoolExecutor() {
        this(15,4);
    }

    public MyThreadPoolExecutor(int threadLimit) {
        this(15, threadLimit);
    }

    public MyThreadPoolExecutor(int queueDimension, int threadLimit) {
        if (queueDimension <= 0)
            throw new IllegalArgumentException("Too small queue " + queueDimension);
        if (threadLimit <= 0)
            throw new IllegalArgumentException("Thread qty( " + threadLimit + ") can't be less than 1");

        this.queueDimension = queueDimension;
        this.threadLimit = threadLimit;

        queue = new ArrayBlockingQueue<>(queueDimension);
        threadList = new ArrayList<>(threadLimit);


    }

    private BlockingQueue<Runnable>  queue;
    private List<TaskThread> threadList;
    private boolean isShutDown = false;
    private boolean isThreadsFinished;

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new FutureTask<T>(runnable, value);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureTask<T>(callable);
    }

    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
        return ftask;
    }

    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task, result);
        execute(ftask);
        return ftask;
    }

    public Future<?> submit(Runnable task){
        if (task == null) throw new NullPointerException();
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
        return ftask;
    }

    public void execute(Runnable command) {
        if (queue.size() < queueDimension){
            if (!isShutdown()) {
                System.out.println("Queue size: " + queue.size());

                queue.offer(command);

                boolean isTaskPassedToThread = false;

                if (threadList.isEmpty()) {
                    addNewThread();
                } else {
                    if (!queue.isEmpty() && threadList.size() < threadLimit) {
                        addNewThread();
                    }
                }
            }
            System.out.println("Thread list size: "+ threadList.size());


        }else {
            System.out.println(queue);
            throw new IllegalStateException("Number of maximum tasks qty exceeded");
        }
    }

    private void addNewThread() {
        TaskThread taskThread = new TaskThread();
        threadList.add(taskThread);
        taskThread.setDaemon(true);
        taskThread.start();
    }

    public void shutdown() {
        isShutDown = true;
    }

    public boolean isShutdown() {
        return isShutDown;
    }

    /**
     * Blocks until all tasks have completed execution after a shutdown
     * request, or the timeout occurs, or the current thread is
     * interrupted, whichever happens first.
     *
     * @param timeout the maximum time to wait
     * @param unit    the time unit of the timeout argument
     * @return {@code true} if this executor terminated and
     * {@code false} if the timeout elapsed before termination
     * @throws InterruptedException if interrupted while waiting
     */
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {

        for (long i = 0; i < (unit.toMillis(timeout) + 1) * 3 / 4 ; i++) {
//            long startTime = System.currentTimeMillis();

            if (queue.isEmpty()) {
                isThreadsFinished = true;
                for (TaskThread taskThread : threadList) {
                    if (!taskThread.isRunnableDone()) {
                        isThreadsFinished = false;
                        break;
                    }
                }
                if (isThreadsFinished) return true;
            }
            else Thread.sleep(1);
//            long endTime = System.currentTimeMillis();
//            System.out.printf("Time for iteration: %d%n", endTime - startTime);
        }

        return false;


    }


}
