package com.pmlesson.group5.knight;

import com.backtraceframework.api.ResultHandler;
import com.backtraceframework.api.TraceUnit;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class KnightResultHandler implements ResultHandler<Integer[][]> {
    @Override
    public void onResultFound(int index, Integer[][] storage, Collection<TraceUnit<Integer[][]>> units) {
        String format = "%"
                + (((storage.length * storage[0].length) + "").toCharArray().length + 1)
                + 'd';
        System.out.println("--------------------------" + index);
        Arrays.stream(storage).forEach(row -> {
            Arrays.stream(row).forEach(i -> System.out.printf(format, i));
            System.out.println();
        });
        System.out.println();
    }
}
