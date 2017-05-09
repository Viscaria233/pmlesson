package com.pmlesson.group5.prime;

import com.backtraceframework.api.TraceUnit;
import com.backtraceframework.api.TraceUnitIterator;

import java.util.Collection;

/**
 * Created by Haochen on 2017/4/18.
 * TODO:
 */
public class PrimeIterator implements TraceUnitIterator<PrimeStack> {
    @Override
    public boolean hasNext(PrimeStack storage, Collection<TraceUnit<PrimeStack>> units) {
        return units.size() < storage.getMaxCount();
    }

    @Override
    public TraceUnit<PrimeStack> next(PrimeStack storage, Collection<TraceUnit<PrimeStack>> units) {
        return new PrimeTraceUnit(storage.size() == 0 ? 0 : storage.peek());
    }
}
