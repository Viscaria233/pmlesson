package com.pmlesson.group5.ques15_troublemaker;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Haochen on 2017/5/12.
 * TODO:
 */
public class Room {
    static final int MOVED = 1;
    static final int NO_MOVED = 0;

    int[][] children;
    int[][] troubleMakers;

    List<Pair<Integer, Integer[]>> results = new ArrayList<>();

    private Room(int childCount, int troubleMakerCount) {
        children = new int[childCount][2];
        for (int i = 0; i < childCount; ++i) {
            children[i][0] = i + 1;
            children[i][1] = NO_MOVED;
        }
        troubleMakers = new int[troubleMakerCount][2];
    }

    public static Room[] parse(Iterator<String> input) {
        int count = Integer.parseInt(input.next());
        Room[] makers = new Room[count];
        for (int i = 0; i < count; ++i) {
            int[] childAndMakerCount = Arrays.stream(input.next().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            makers[i] = new Room(childAndMakerCount[0], childAndMakerCount[1]);

            int makerCount = childAndMakerCount[1];
            for (int j = 0; j < makerCount; ++j) {
                int[] maker = Arrays.stream(input.next().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                makers[i].troubleMakers[j][0] = maker[0];
                makers[i].troubleMakers[j][1] = maker[1];
            }
        }
        return makers;
    }

    public boolean isTroubleMaker(int childA, int childB) {
        return Arrays.stream(troubleMakers)
                .anyMatch(i ->
                        (i[0] == childA && i[1] == childB)
                        || (i[0] == childB && i[1] == childA));
    }

    public int troubleMakerCount(int moved) {
        int[] childrenInSameRoom = Arrays.stream(children)
                .filter(i -> i[1] == moved)
                .mapToInt(i -> i[0])
                .toArray();
        int count = 0;
        for (int i = 0; i < childrenInSameRoom.length - 1; ++i) {
            for (int j = i + 1; j < childrenInSameRoom.length; ++j) {
                if (isTroubleMaker(childrenInSameRoom[i], childrenInSameRoom[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public int totalTroubleMakerCount() {
        return troubleMakerCount(NO_MOVED) + troubleMakerCount(MOVED);
    }
}
