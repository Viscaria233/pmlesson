package com.pmlesson.group5.knight;

import com.backtraceframework.api.TraceUnit;

/**
 * Created by Haochen on 2017/4/10.
 * TODO:
 */
public class KnightTraceUnit implements TraceUnit<Integer[][]> {
    private int index;
    private int row;
    private int column;

    private static int[] dRow = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static int[] dColumn = {1, -1, -2, -2, -1, 1, 2, 2};
    private int cursor = -1;

    KnightTraceUnit(int index, int row, int column) {
        this.index = index;
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean hasNextCase(Integer[][] storage) {
        return cursor + 1 < 8;
    }

    @Override
    public void nextCase() {
        cursor++;
    }

    @Override
    public boolean tryCase(Integer[][] storage) {
        int targetRow = getTargetRow();
        int targetColumn = getTargetColumn();
        if (!inBound(storage, targetRow, targetColumn)) {
            return false;
        }
        if (storage[targetRow][targetColumn] > 0) {
            return false;
        }
        storage[targetRow][targetColumn] = index + 1;
        return true;
    }

    private boolean inBound(Integer[][] board, int targetRow, int targetColumn) {
        return targetRow >= 0 && targetRow < board.length
                && targetColumn >= 0 && targetColumn < board[0].length;
    }

    @Override
    public void rollback(Integer[][] storage) {
        storage[getTargetRow()][getTargetColumn()] = 0;
    }

    public int getIndex() {
        return index;
    }

    public int getTargetRow() {
        return row + dRow[cursor];
    }

    public int getTargetColumn() {
        return column + dColumn[cursor];
    }
}
