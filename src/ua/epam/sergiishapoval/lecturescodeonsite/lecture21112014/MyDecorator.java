package ua.epam.sergiishapoval.lecturescodeonsite.lecture21112014;

/**
 * Created by Сергей on 21.11.2014.
 */
public class MyDecorator {

    public static void main(String[] args) {
        Product product = new Pizza();
        Product productWithCheese = new Cheese(product);
        Product productWithTomatowithCheese = new Tomato(productWithCheese);

        productWithTomatowithCheese.show();
    }
}

abstract class Product{
    abstract public void show();
}

class Pizza extends Product{
    @Override
    public void show() {
        System.out.println("Pizza");
    }
}

abstract class Decorator extends Product{
   Product p;
}
class Tomato extends Decorator{


    Tomato(Product p) {
        this.p = p;
    }

    @Override
    public void show() {
        p.show();
        System.out.println("Tomato");
    }
}

class Cheese extends Decorator{


    Cheese(Product p) {
        this.p = p;
    }

    @Override
    public void show() {
        p.show();
        System.out.println("Cheese");
    }

}