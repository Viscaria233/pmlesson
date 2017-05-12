package com.pmlesson.group5.ques05_prime;

import java.util.Stack;

/**
 * Created by Haochen on 2017/4/18.
 * TODO:
 */
public class PrimeStack {
    private Stack<Integer> primes = new Stack<>();
    private int maxCount;
    private int maxSum;
    private int sum = 0;

    PrimeStack(int maxSum, int maxCount) {
        this.maxSum = maxSum;
        this.maxCount = maxCount;
    }

    void push(int i) {
        primes.push(i);
        sum += i;
    }

    int pop() {
        int i = primes.pop();
        sum -= i;
        return i;
    }

    int peek() {
        return primes.peek();
    }

    int size() {
        return primes.size();
    }

    boolean isEmpty() {
        return primes.isEmpty();
    }

    int getMaxCount() {
        return maxCount;
    }

    int getMaxSum() {
        return maxSum;
    }

    int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return primes.toString();
    }
}
