package com.pmlesson.group5.knight;

import com.backtraceframework.api.TraceUnit;
import com.backtraceframework.api.TraceUnitIterator;

import java.util.Collection;
import java.util.Stack;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class KnightIterator implements TraceUnitIterator<Integer[][]> {
    private int startRow;
    private int startColumn;

    KnightIterator(int startRow, int startColumn) {
        this.startRow = startRow;
        this.startColumn = startColumn;
    }

    @Override
    public boolean hasNext(Integer[][] storage, Collection<TraceUnit<Integer[][]>> units) {
        return units.size() + 1 < storage.length * storage[0].length;
    }

    @Override
    public TraceUnit<Integer[][]> next(Integer[][] storage, Collection<TraceUnit<Integer[][]>> units) {
        if (units.size() == 0) {
            int startIndex = 1;
            storage[startRow][startColumn] = startIndex;
            return new KnightTraceUnit(startIndex, startRow, startColumn);
        }
        KnightTraceUnit unit = (KnightTraceUnit) ((Stack<TraceUnit<Integer[][]>>) units).peek();
        return new KnightTraceUnit(unit.getIndex() + 1, unit.getTargetRow(), unit.getTargetColumn());
    }
}
