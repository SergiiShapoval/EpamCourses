package ua.epam.sergiishapoval.projects.oop;

import ua.epam.sergiishapoval.projects.oop.carhierarchy.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Сергей on 24.10.2014.
 * 10.	Таксопарк. Определить иерархию легковых автомобилей.
 * Создать таксопарк. Посчитать стоимость автопарка.+
 * Провести сортировку автомобилей парка по расходу топлива.+
 * Найти автомобиль в компании, соответствующий
 * заданному диапазону параметров скорости.
 */
public class TaxiStation {
    List<Car> carPool;

    String fileAddress;

    public TaxiStation(String fileAddress) throws IOException {
        this.fileAddress = fileAddress;

        this.carPool = new CarBuilder().createCars(fileAddress);;
    }



    public List<Car> getCarPool() {
        return carPool;
    }
}
