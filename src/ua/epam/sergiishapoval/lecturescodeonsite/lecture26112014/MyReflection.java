package ua.epam.sergiishapoval.lecturescodeonsite.lecture26112014;

import java.lang.reflect.*;

/**
 * Created by Сергей on 26.11.2014.
 */
public class MyReflection {

    class A{
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        A(int a) {
            this.a = a;
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class c = A.class;
        Class[] paramTypes = {int.class};
        Constructor con = c.getDeclaredConstructor(paramTypes);
        Object[] o = {new Integer(200)};
        A pa = (A) con.newInstance(o);

        System.out.println(pa.a);

        Field fil =  c.getDeclaredField("a");
        fil.setAccessible(true);
        fil.set(pa, new Integer(300));

//        AccessibleObject
//      для всех меняет, если на каком-то не удалось остальным после него уровень доступа не измениться


        Class[] typeOfMthods = {int.class};
        Method m = c.getDeclaredMethod("setA", typeOfMthods);
        Object[] param = {new Integer(500)};
        int s = (int) m.invoke(pa, param);

        System.out.println(s);
        int mod = fil.getModifiers();
//        битовая маска
        System.out.println(Modifier.isPrivate(mod));





    }
}
