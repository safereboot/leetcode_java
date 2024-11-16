package com.java.versions.java10;

import java.util.ArrayList;

public class Java10 {

    public static void main(String[] args) {
        var list = new ArrayList<String>(); // infers ArrayList<String>

        var stream = list.stream();         // infers Stream<String>


    }
}
