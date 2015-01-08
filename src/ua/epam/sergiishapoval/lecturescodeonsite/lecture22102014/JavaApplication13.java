package ua.epam.sergiishapoval.lecturescodeonsite.lecture22102014;

import java.util.ArrayList;

interface Myinterface{
    public void g();
}
class A{
    int a=40;
    
    class D{
      class C{
          
      }
    }
    public void h(){
        class NoName implements Myinterface{
     
             public void g(){
                 int c=2/0;
            }
        
        }
    }
    public void f(){
        class NoName implements Myinterface{
            class F{}
             public void g(){
                 int c=2/0;
            }
        }
        Myinterface m1=new NoName();
     //   m1.g();
         
        Myinterface m=new Myinterface(){
            public void g(){
                int c=2/0;
          }
       };
        
       m.g();
    }
}
public class JavaApplication13 {
    public static void main(String[] args) {
    }
}
