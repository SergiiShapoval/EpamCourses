package ua.epam.sergiishapoval.homework.hw3.task3;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Сергей on 23.10.2014.
 * Создать класс Catalog с внутренним классом,
 * с помощью объектов которого можно хранить
 * информацию об истории выдач книги читателям.
 */
public class Library {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        ArrayList<String> readers = new ArrayList<String>(){{
            for (int i = 0; i <40 ; i++) {
                add("Reader" + i);
            }
        }};
        ArrayList<String> booksTaken = new ArrayList<>();


        for (String reader : readers){

            if ((int) (Math.random()*60) %2 == 0) {
                String currentBook = "Book" + (int) (Math.random()*14);
                String currentBookId = catalog.takeBook(reader, currentBook);
                if (!currentBookId.equals("taken")){
                    booksTaken.add(currentBookId);
                    System.out.printf("All copies of %s are taken, sorry %s.", currentBook, reader);
                    System.out.println();
                }

            } else {
                if (!booksTaken.isEmpty())
                catalog.returnBook("Reader" + (int) (Math.random()*40), booksTaken.get(0));
            }

        }

        System.out.println(catalog);





    }
}
