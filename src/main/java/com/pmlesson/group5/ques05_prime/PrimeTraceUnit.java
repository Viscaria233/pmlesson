package com.pmlesson.group5.ques05_prime;

import com.backtraceframework.api.TraceUnit;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

/**
 * Created by Haochen on 2017/4/18.
 * TODO:
 */
public class PrimeTraceUnit implements TraceUnit<PrimeStack> {
    private int current;
    private PrimitiveIterator.OfInt primes;

    PrimeTraceUnit(int min) {
        this.primes = IntStream.iterate(min, last -> {
            for (int i = last + 1; true; ++i) {
                if (isPrime(i)) {
                    return i;
                }
            }
        }).iterator();
        this.current = primes.next();
    }

    @Override
    public boolean hasNextCase(PrimeStack storage) {
        return current < storage.getMaxSum() - (storage.isEmpty() ? 0 : storage.peek());
    }

    @Override
    public void nextCase() {
        current = primes.next();
    }

    @Override
    public boolean tryCase(PrimeStack storage) {
        int newSum = storage.getSum() + current;
        if (storage.size() == storage.getMaxCount() - 1
                && newSum != storage.getMaxSum()) {
            return false;
        }
        if (newSum > storage.getMaxSum()) {
            return false;
        }
        storage.push(current);
        return true;
    }

    @Override
    public void rollback(PrimeStack storage) {
        storage.pop();
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
