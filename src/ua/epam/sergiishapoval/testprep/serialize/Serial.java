package ua.epam.sergiishapoval.testprep.serialize;

import java.io.*;

/**
 * Created by Сергей on 01.12.2014.
 */

class SerialFather{
    private int i;

/*
    public SerialFather(int i) {
        this.i = i;
    }
*/
}


public class Serial extends SerialFather implements Serializable {
    private int i;
    private int b;

    public Serial(int i) {
        this.i = i;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        Serial serial = new Serial(8);

        objectOutputStream.writeObject(serial);
        System.out.println(serial);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Serial serialCopy = (Serial) objectInputStream.readObject();

        System.out.println(serialCopy);

        System.out.println(serialCopy.i);
    }
}
