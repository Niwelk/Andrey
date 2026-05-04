package TestPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static String getString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return Integer.parseInt(s);
    }

    //public static void main(String[] args) throws IOException{

//        try (BufferedReader buffer = new BufferedReader(new FileReader("C:\\Users\\Admin\\OneDrive\\Рабочий стол\\book_assistant\\17_27629.txt"))) {
//
//
//
//        } catch (FileNotFoundException e) {
//            System.err.println(e.getMessage());
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }


//        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\java\\monolit\\book_assistant\\17_27629.txt"))) {
//
//            String line = reader.readLine();
//            while (line!=null) {
//
//            }
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }

//

//        List<Integer> array = new ArrayList<>(List.of(1, 3, 2, 2, 11));
//
//        int index = array.set(4, 52);
//        System.out.println(array);
//        System.out.println(index);
//
//        String s = "124";
//        Integer a = Integer.valueOf(5);
//        System.out.println(a.getClass().getName());
//    }
}

class B {
    public int data;

    B() {
        this.data = 1;
    }

    B (int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

class A {
    public B methodFromB() {
        return new B();
    }

    public static void main(String[] args) {

        A a = new A();
        B b2 = a.methodFromB();

        System.out.println(b2.getData());
    }
}
