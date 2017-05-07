package com.pmlesson.group5.prime;

import com.backtraceframework.api.BackTracer;

/**
 * Created by Haochen on 2017/4/18.
 * TODO:
 */
public class PrimeBackTraceLauncher {
    public static void launch(int sum, int maxPrimeCount) {
        int count = new BackTracer<PrimeStack>()
                .setExitDecider(i -> false)
                .setStorage(new PrimeStack(sum, maxPrimeCount))
                .setResultHandler((index, storage, units) ->
                        System.out.println(index + ": " + storage))
                .setTraceUnitIterator(new PrimeIterator())
                .launch();
        System.out.println(count + " result(s) found.");
    }
}
