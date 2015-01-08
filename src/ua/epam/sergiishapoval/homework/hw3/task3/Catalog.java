package ua.epam.sergiishapoval.homework.hw3.task3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 23.10.2014.
 * Создать класс Catalog с внутренним классом,
 * с помощью объектов которого можно хранить
 * информацию об истории выдач книги читателям.
 */
public class Catalog {

    List<Book> books = new ArrayList<Book>(){{
        for (int i = 0; i <7 ; i++) {
            add(new Book("Book" + i, "AA" + i));
        }
        for (int i = 3; i <10 ; i++) {
            add(new Book("Book" + i, "BB" + i));
        }
        for (int i = 8; i <14 ; i++) {
            add(new Book("Book" + i, "CC" + i));
        }
    }};



    public static class Book{
        String name;
        String catalogID;
        boolean isTaken;
        StringBuilder history;

        public Book(String name, String catalogID) {
            this.name = name;
            this.catalogID = catalogID;
            isTaken = false;
            history = new StringBuilder();
        }
    }

    public String takeBook (String readerId, String bookName){
/*
        ищем есть ли свободная книга с указанным названием в каталоге
        если есть: делаем записи в каталоге по данной книге о выдаче
*/
        for (Book currentBook : books){
            if (currentBook.name.equals(bookName)){
                if (currentBook.isTaken) continue;
                else {
                    currentBook.isTaken = true;
                    currentBook.history.append(readerId);
                    currentBook.history.append(" take ");
                    currentBook.history.append(new Date());
                    currentBook.history.append("\r\n");
                    return currentBook.catalogID;
                }
            }
        }
        return "taken";


    }
    public void returnBook (String readerId, String bookId){
/*
        ищем книгу в каталоге,
        делаем пометки про возврат книги,
        изменяем доступность
*/
        for (Book currentBook: books){

            if (currentBook.catalogID.equals(bookId)){
                if (currentBook.isTaken) {
                    currentBook.isTaken = false;
                    currentBook.history.append(readerId);
                    currentBook.history.append(" return ");
                    currentBook.history.append(new Date());
                    currentBook.history.append("\r\n");
                    return;
                }
                break;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder catalogLog = new StringBuilder();
        for (Book book : books){
            catalogLog.append(book.name);
            catalogLog.append("\r\n");
            catalogLog.append(book.history);
        }

        return catalogLog.toString();
    }
}
