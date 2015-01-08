package ua.epam.sergiishapoval.lecturescodeonsite.lecture03122014;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Сергей on 03.12.2014.
 */


class MyServer implements Runnable{
    int count = 0;
    Socket client;

    public MyServer(int count, Socket client) {
        this.count = count;
        this.client = client;
    }

    @Override
    public void run() {

        try {
            // из сокета клиента берём поток входящих данных
            InputStream is = client.getInputStream();
            // и оттуда же - поток данных от сервера к клиенту
            OutputStream os = client.getOutputStream();
            // буфер данных в 64 килобайта
            byte buf[] = new byte[64*1024];
            // читаем 64кб от клиента, результат - кол-во реально принятых данных
            int r = is.read(buf);
            // создаём строку, содержащую полученную от клиента информацию
            String data = new String(buf, 0, r);
            // добавляем данные об адресе сокета:
            data = ""+ count +": "+" "+data;
            // выводим данные:
            os.write(data.getBytes());
            os.flush();
            client.close();// завершаем соединение
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(
                    7777, //порт может прослушиваться только один
                    0, //сколько одновременно клиентов обслуживается,
                    // если 0 - уязвим от DDOS атак - остальные в очереди (ждут)
                    InetAddress.getByName("localhost"));
            int count = 0;
            while (true){
                System.out.printf("Server started");
                Socket client = server.accept(); // кидает IOException, выход по закрытию,
                // блокирует поток, пока кто-то не полшёлт запрос на присоединение
                Thread cl = new Thread(new MyServer(count++, client));
                cl.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server is started");

    }
}
