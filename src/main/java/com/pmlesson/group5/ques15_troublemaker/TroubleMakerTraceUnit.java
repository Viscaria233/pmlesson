package com.pmlesson.group5.ques15_troublemaker;

import com.backtraceframework.api.TraceUnit;

/**
 * Created by Haochen on 2017/5/12.
 * TODO:
 */
public class TroubleMakerTraceUnit implements TraceUnit<Room> {
    public static final int NO_MOVED = 0;
    public static final int MOVED = 1;

    private int childIndex;
    private int moved = -1;

    public TroubleMakerTraceUnit(int childIndex) {
        this.childIndex = childIndex;
    }

    @Override
    public boolean hasNextCase(Room room) {
        return moved + 1 < 2;
    }

    @Override
    public void nextCase() {
        moved++;
    }

    @Override
    public boolean tryCase(Room room) {
        room.children[childIndex][1] = moved;
        return childIndex < room.children.length - 1
                || room.totalTroubleMakerCount() <= room.troubleMakers.length / 2;
    }

    @Override
    public void rollback(Room room) {
        room.children[childIndex][1] = Room.NO_MOVED;
    }
}
