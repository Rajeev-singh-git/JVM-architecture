package jvm;

import java.lang.reflect.Method;

public class Student {

    public String getName(){
        return null;
    }
    public int getRollNo(){
        return 10;
    }

}

class Test{


    public static void main(String[]args) throws Exception {

            int count = 0;
            Class c = Class.forName("jvm.Student");
     //     Class c = Class.forName("java.lang.String");
     //       Class c = Class.forName("java.lang.Object");
            Method[] m = c.getDeclaredMethods();

            for (Method m1:m){
                count ++;
                System.out.println(m1.getName());         // getName getRollNo
            }
            System.out.println(count);                    // 2

          /*For Every loaded .class file Only One Class Object will be Created,
           even though we are  using Class Multiple Times in Our Application */

            Student s1 = new Student();
            Class c1 = s1.getClass();
            Student s2 = new Student();
            Class c2 = s2.getClass();
            System.out.println(c1.hashCode());        //81628611
            System.out.println(c2.hashCode());        //81628611
            System.out.println(c.hashCode());         //81628611
            System.out.println(c1==c2);               //true
            System.out.println(c2==c);                //true
            System.out.println(c1==c);                //true
            System.out.println(c1==c);                //true
    }

}

