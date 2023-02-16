import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) {
        Class unknown = Unknown.class;
        Constructor[] constructor = unknown.getDeclaredConstructors();
        for(Constructor i:constructor){
            System.out.println(i);
        }

        System.out.println("--------------");

        Constructor myConstructor = null;
        try {
            myConstructor = unknown.getDeclaredConstructor(int.class, String.class, double.class);
            System.out.println(myConstructor);
            System.out.println("--------------");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        myConstructor.setAccessible(true);
//        try {
//            Unknown myUnknown = (Unknown) myConstructor.newInstance(1,"1", 1.1);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }

        Method[] methods = unknown.getDeclaredMethods();
        for(Method i:methods){
            System.out.println(i);
        }
        System.out.println("--------------");

        Method returned;
        try {
            returned = unknown.getDeclaredMethod("valueOf", int.class, int.class, String.class, double[].class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        double[] arrayOfDoubles = {1.1, 2.2};
        returned.setAccessible(true);
        Unknown myObject;
        try {
            myObject = (Unknown) returned.invoke(null, 1,1,"1",arrayOfDoubles);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(myObject);

        Class[] classes = unknown.getClasses();
        for(Class i:classes){
            System.out.println(i);
        }
        System.out.println("--------------");

        Field[] fieldsOfDirection  = Unknown.Direction.class.getDeclaredFields();
        for(Field i:fieldsOfDirection){
            System.out.println(i);
        }



    }
}
