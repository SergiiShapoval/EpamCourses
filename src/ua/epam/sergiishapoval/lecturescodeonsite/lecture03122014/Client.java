package ua.epam.sergiishapoval.lecturescodeonsite.lecture03122014;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.net.Socket;

/**
 * Created by Сергей on 03.12.2014.
 */
public class Client {

    public static void main(String[] args) {
        try {
            System.out.printf("Client Started");
            Socket s = new Socket("localhost", 7777);// в Java либо слушать, либо запрашивать
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            String message = "Hello";
            os.write(message.getBytes());
            os.flush();

            byte buf[] = new byte[64*1024]; // кратно 1024
            int r = is.read(buf);
            String data = new String(buf, 0, r);
            s.close();
            System.out.println(data);
//выводим ответ в консоль System.out.println(data); }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
