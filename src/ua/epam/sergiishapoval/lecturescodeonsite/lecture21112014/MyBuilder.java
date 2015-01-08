package ua.epam.sergiishapoval.lecturescodeonsite.lecture21112014;

/**
 * Created by Сергей on 21.11.2014.
 */
public class MyBuilder {

    public static void main(String[] args) {
        Builder builder = new CottadgeBuilder();
        Director director= new Director(builder);
        director.create();
        Building house = builder.getBuilding();
        house.show();
    }
}

class Director{
    Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }


    public void create() {

        builder.buildBasic();
        builder.buildWalls();
        builder.buildRoof();
    }


}

interface Building{
    void show();
}

abstract class   Builder{
    Building building;
    abstract public void buildBasic();
    abstract public void buildWalls();
    abstract public void buildRoof();

    public Building getBuilding(){
        return building;
    }
}


class CottadgeBuilder extends Builder{

    CottadgeBuilder() {
        building = new Cottage();
    }

    @Override
    public void buildBasic() {
        System.out.println("Basic builded");
    }

    @Override
    public void buildWalls() {
        System.out.println("Walls builded");

    }

    @Override
    public void buildRoof() {
        System.out.println("Roof builded");

    }
}


class Cottage implements Building{
    @Override
    public void show() {
        System.out.println(this);
    }
}