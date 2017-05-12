package com.pmlesson.group5.ques15_troublemaker;

import com.backtraceframework.api.TraceUnit;
import com.backtraceframework.api.TraceUnitIterator;

import java.util.Collection;

/**
 * Created by Haochen on 2017/5/12.
 * TODO:
 */
public class TroubleMakerIterator implements TraceUnitIterator<Room> {
    @Override
    public boolean hasNext(Room room, Collection<TraceUnit<Room>> traceUnits) {
        return traceUnits.size() < room.children.length;
    }

    @Override
    public TraceUnit<Room> next(Room room, Collection<TraceUnit<Room>> traceUnits) {
        return new TroubleMakerTraceUnit(traceUnits.size());
    }
}
