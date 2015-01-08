package ua.epam.sergiishapoval.homework.hw9.Puerto;

/**
 * Created by Сергей on 13.11.2014.
 */
public class Ship extends Thread {
    int containersToTake;
    int containersToLeave;
    Puerto puerto;

    int currentContainersQty;

    public Ship(String name, int containersToTake, int containersToLeave, Puerto puerto) {
        super(name);
        this.containersToTake = containersToTake;
        this.containersToLeave = containersToLeave;
        this.puerto = puerto;
        currentContainersQty = containersToLeave;
        start();
    }

    @Override
    public void run() {
        boolean isChanged = false;

        try {

            while (true) {
                if (!isChanged) {
                    puerto.askPermission();
                }

                isChanged = false;
                if (containersToLeave != 0 && containersToTake != 0) {
                    containersToTake--;
                    containersToLeave--;
                    isChanged = true;
                } else {
                    if (containersToLeave != 0  ){
                        synchronized (puerto) {
                            if (puerto.getContainersCapacity() > puerto.getCurrentContainersQty()) {
                                puerto.addContainer();
                                containersToLeave--;
                                isChanged = true;
                            }
                        }
                    } else {
                        if (containersToTake != 0 ){
                            synchronized (puerto) {
                                if (puerto.getCurrentContainersQty() > 0) {
                                    puerto.takeConatiner();
                                    containersToTake--;
                                    isChanged = true;
                                }
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " has finished his task");
                            puerto.returnPermission();
                            break;
                        }
                    }
                }

                if (isChanged){
                    Thread.sleep(10);
                } else {
                    puerto.returnPermission();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
