package ua.epam.sergiishapoval.homework.hw2.settask.listdone;

/**
 * Created by Сергей on 21.10.2014.
 */
public class MySetTestList {
    public static void main(String[] args) {
        Container container1 = new ContainerImplementation();
        Container container2 = new ContainerImplementation();

        for (int i = 0; i <8 ; i++) {
            container1.add(i);
        }

        for (int i = 6; i <25 ; i++) {
            container2.add(i);
        }

        System.out.println(container1);
        System.out.println(container2);
        MySet set = new MySet(container1);
        MySet set2 = new MySet(container2);
        set.union(set2);
        System.out.println(set);

    }
}
