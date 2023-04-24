package me.dio.junit;

import java.util.*;

public class Program {
    public static void main(String[] args){
        int num = 29;
        var step = 0;

// TODO: Implemente uma condição onde seja possível reduzir o número até 0:

        while (num > 0) {
            if ((num & 1) == 1) {
                step++;
            }
            num /= 2;
            step++;
        }

//        if(step >        ){
//            System.out.println(step);
//        }else{
//            System.out.println();
//        }
    }
}
