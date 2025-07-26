package com.codewithmosh;

import java.util.Scanner;

/*
    Since there is only a single console, class members could be defined as static.
*/

public class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt){
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt,double min,double max){

        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
    }
}

