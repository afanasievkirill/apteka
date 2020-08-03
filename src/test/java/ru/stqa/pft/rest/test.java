package ru.stqa.pft.rest;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

/*
Вывести числа в обратном порядке
*/

public class test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<10; i++){
            int n = 0;
             n = scanner.nextInt();
            list.add(n);

        }
        for(int i = list.size(); i>=0; i--)
        {
            System.out.println(list.get(i));
        }


        //напишите тут ваш код
    }
}