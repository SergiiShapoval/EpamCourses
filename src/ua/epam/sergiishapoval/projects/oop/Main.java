package ua.epam.sergiishapoval.projects.oop;

import ua.epam.sergiishapoval.projects.oop.carhierarchy.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Сергей on 27.10.2014.
 */
public class Main {
    public static void main(String[] args) throws IOException{

        TaxiStation station = new TaxiStation("C:\\Dropbox\\epam\\EpamCoursesCode\\src\\ua\\epam\\sergiishapoval\\projects\\oop\\Cars.csv");

        List<Car> carPool = station.getCarPool();


        //        Посчитать стоимость автопарка.
        double poolPrice = 0.0;
        for (Car car : carPool){
            poolPrice += car.getPrice();
        }
        System.out.println("Cost of taxistation's cars: " + Math.round(poolPrice*100)/100.0 );

//        Провести сортировку автомобилей парка по расходу топлива.
        Collections.sort(carPool, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return ((int) Math.round(100.0 * (car1.getFuelConsumption() - car2.getFuelConsumption())));
            }
        });

        for (Car car: carPool) {
            System.out.printf("FuelConsumption of %s: %s", car, car.getFuelConsumption());

            System.out.println();
        }

/*
        Найти автомобиль в компании, соответствующий
         заданному диапазону параметров скорости.
*/



        System.out.println("\n Найдите автомобили отвечающие Вашим критериям скорости");

        System.out.println("Какой должна быть минимальная скорость автомобиля? (разделитель - .)" );
        double minVelocity = getVelocity();


        System.out.println("Какое значение не должна превышать максимальная скорость автомобиля? (разделитель - .)" );
        double maxVelocity = getVelocity();

        while (maxVelocity < minVelocity) {
            System.out.println("Указанное Вами значение меньше минимальной, \n" +
                    "укажите другое");
            maxVelocity = getVelocity();
        }

        for (Car car : carPool) {
            if (car.getVelocity() >= minVelocity && car.getVelocity() <= maxVelocity) {
                System.out.printf("Speed of %s: %s", car, car.getVelocity());
                System.out.println();
            }


        }


    }

    private static double getVelocity() throws IOException {
        double currentVelocity;

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                currentVelocity = Double.parseDouble(reader.readLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Введите число (разделитель - .)");
            }
        }
        return currentVelocity;
    }
}
