package com.pmlesson.group5;

import com.pmlesson.group5.knight.KnightBackTraceLauncher;
import com.pmlesson.group5.prime.PrimeBackTraceLauncher;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

/**
 * Created by Haochen on 2017/4/11.
 * TODO:
 */
public class Main {
    public static void main(String[] args) {
        int row = 6;
        int col = 4;
        int startRow = 0;
        int startCol = 0;
        KnightBackTraceLauncher.launch(row, col, startRow, startCol);

        System.out.println("======================================");

        int primeSum = 24;
        int primeCount = 3;
        PrimeBackTraceLauncher.launch(primeSum, primeCount);
    }
}
