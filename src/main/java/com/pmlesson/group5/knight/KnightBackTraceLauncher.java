package com.pmlesson.group5.knight;

import com.backtraceframework.api.BackTracer;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class KnightBackTraceLauncher {
    public static void launch(int row, int col, int startRow, int startCol) {
        int count = new BackTracer<Integer[][]>()
                .setStorage(array(row, col))
                .setTraceUnitIterator(new KnightIterator(startRow, startCol))
                .setResultHandler(new KnightResultHandler())
                .setExitDecider(i -> false)
                .launch();
        System.out.println(count + " result(s) found.");
    }

    private static Integer[][] array(int row, int col) {
        Integer[][] array = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }
}
