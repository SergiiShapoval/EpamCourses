package ua.epam.sergiishapoval.homework.hw9.Puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 13.11.2014.
 * 1.	Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров.
 * Число контейнеров, находящихся в текущий момент в порту и на корабле,
 * должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта.
 * В порту работает несколько причалов. У одного причала может стоять один корабль.
 * Корабль может загружаться у причала, разгружаться или выполнять оба действия.
 */
public class PuertoMain {
    public static void main(String[] args) {
        Puerto puerto = new Puerto(4, 5000, 1000);

        List<Ship> ships = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ships.add(new Ship("Ship " + i, 260, 0, puerto));
        }

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 4; i < 8; i++) {
            ships.add(new Ship("Ship " + i, 0, 300, puerto));
        }

        for (Ship ship : ships){
            try {
                ship.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All ships have finished their task");


    }
}
