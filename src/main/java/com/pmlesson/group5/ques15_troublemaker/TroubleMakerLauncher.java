package com.pmlesson.group5.ques15_troublemaker;

import com.backtraceframework.api.BackTracer;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Haochen on 2017/5/12.
 * TODO:
 */
public class TroubleMakerLauncher {
    public static List<Integer[]> launch(String[] input) {
        BackTracer<Room> tracer = new BackTracer<Room>()
                .setExitDecider(i -> false)
                .setResultHandler(new TroubleMakerResultHandler())
                .setTraceUnitIterator(new TroubleMakerIterator());

        Room[] rooms = Room.parse(Arrays.asList(input).iterator());

        List<Integer[]> result = new ArrayList<>();
        for (Room room : rooms) {
            tracer.setStorage(room).launch();

            Integer[] movedChildren = room.results.stream()
                    .min(Comparator.comparingInt(Pair::getKey))
                    .orElse(new Pair<>(0, new Integer[0])).getValue();

            result.add(movedChildren);
        }
        return result;
    }
}
