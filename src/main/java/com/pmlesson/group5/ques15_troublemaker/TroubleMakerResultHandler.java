package com.pmlesson.group5.ques15_troublemaker;

import com.backtraceframework.api.ResultHandler;
import com.backtraceframework.api.TraceUnit;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Haochen on 2017/5/12.
 * TODO:
 */
public class TroubleMakerResultHandler implements ResultHandler<Room> {
    @Override
    public void onResultFound(int index, Room room, Collection<TraceUnit<Room>> traceUnits) {
        Integer[] result = Arrays.stream(room.children)
                .filter(i -> i[1] == Room.MOVED)
                .map(i -> i[0])
                .toArray(Integer[]::new);
        room.results.add(new Pair<>(room.totalTroubleMakerCount(), result));
    }
}
