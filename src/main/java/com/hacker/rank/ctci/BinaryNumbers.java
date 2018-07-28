package com.hacker.rank.ctci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BinaryNumbers
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        String binaryStr = Integer.toBinaryString(n);
        System.out.println("binary="+binaryStr);

        Arrays.stream(binaryStr.split("0+")).forEach(System.out::println);

        String maxOnes = Arrays.stream(binaryStr.split("0+")).max(Comparator.comparingInt(String::length)).get();
        System.out.println(maxOnes.length());
    }
}
