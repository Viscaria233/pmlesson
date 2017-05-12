package com.pmlesson.group5.ques05_prime;

import com.backtraceframework.api.BackTracer;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Haochen on 2017/4/18.
 * TODO:
 */
public class PrimeLauncher {
    public static List<String> launch(int sum, int maxPrimeCount) {
        List<String> result = new ArrayList<>();

        new BackTracer<PrimeStack>()
                .setExitDecider(i -> false)
                .setStorage(new PrimeStack(sum, maxPrimeCount))
                .setResultHandler((index, storage, units) ->
                        result.add(index + ": " + storage))
                .setTraceUnitIterator(new PrimeIterator())
                .launch();

        return result;
    }
}
