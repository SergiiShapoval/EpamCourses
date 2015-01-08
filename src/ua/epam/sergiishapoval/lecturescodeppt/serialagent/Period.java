package ua.epam.sergiishapoval.lecturescodeppt.serialagent;

import java.io.*;
import java.util.Date;

/**
 * Created by Сергей on 20.11.2014.
 */
public final class Period implements Serializable{

    private static final long serialVersionUID = 753780943L;

    private static class SerializationProxy implements Serializable{
        private static final long serialVersionUID = 563789942L;
        private final Date start;
        private final Date end;

        private SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        private Object readResolve(){
            return new Period(start, end);
        }
    }

    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + "after" + end);
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end ;
    }

    private void readObject(ObjectInputStream is) throws InvalidObjectException {
            throw new InvalidObjectException("Proxy needed");
    }

    private Object writeReplace(){
        return new SerializationProxy(this);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        Period period = new Period(new Date(), new Date());
        System.out.println(period);
        out.writeObject(period);
        ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Period serialPeriod = (Period) is.readObject();
        System.out.println(serialPeriod);
    }
}
