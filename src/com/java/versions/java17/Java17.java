package com.java.versions.java17;

import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class Java17 {
    public static void main(String[] args) {


//        Pattern Matching for switch
        Object obj = "Hello";


//        Pattern Matching for instanceof
        if (obj instanceof String s) {
            // can use s directly here
            System.out.println(s.toUpperCase());
        }


    }

//    Record Classes
    public record Point(int x, int y) { }

}


 sealed class Shape permits Circle, Square {
    //...
}

 final class Circle extends Shape {
    //...
}

 non-sealed class Square extends Shape {
    //...
}