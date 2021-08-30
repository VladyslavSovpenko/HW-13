package TaskOne;

import java.io.IOException;

public class Main {

    public static String firstTask = "https://jsonplaceholder.typicode.com/users";
    public static String secondTask = "https://jsonplaceholder.typicode.com/users/3";
    public static String thirdTask = "https://jsonplaceholder.typicode.com/users/2";
    public static String fourthTask = "https://jsonplaceholder.typicode.com/users";
    public static String fivethTask = "https://jsonplaceholder.typicode.com/users/5";
    public static String sixthTask = "https://jsonplaceholder.typicode.com/users?username=Karianne";

    public static void main(String[] args) throws IOException, InterruptedException {

        Methods methods = new Methods();

        System.out.println(methods.create(firstTask));
        System.out.println(methods.put(secondTask));

 //       System.out.println(methods.delete(thirdTask));
//        System.out.println(methods.getAll(fourthTask));
//        System.out.println(methods.getByIDOrName(fivethTask));
//        System.out.println(methods.getByIDOrName(sixthTask));


    }
}
