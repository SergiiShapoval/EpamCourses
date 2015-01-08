package ua.epam.sergiishapoval.homework.hw8.concursum;

import java.math.BigInteger;

/**
 * Created by Сергей on 08.11.2014.
 */
public class BigSum extends Thread{

    BigInteger threadQty;
    BigInteger index;
    BigInteger result;
    volatile BigInteger limit;

    BigInteger bigOne = new BigInteger("1");

    public BigSum(Integer threadQty, Integer index, BigInteger limit) {
        this.threadQty = new BigInteger(threadQty.toString());
        this.index = new BigInteger(index.toString());
        this.limit = limit;
        result = new BigInteger("0");
    }

    public BigInteger getResult() {
        return result;
    }

    @Override
    public void run() {
        for (BigInteger i = new BigInteger("0"); i.add(index).compareTo(limit) < 0; i = i.add(threadQty)){
            result = result.add(i.add(index));
        }
    }
}
