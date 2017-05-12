package com.pmlesson.group5.ques15_troublemaker;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TroubleMakerLauncher Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 12, 2017</pre>
 */
public class TroubleMakerLauncherTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: launch(String[] input)
     */
    @Test
    public void testLaunch() throws Exception {
//TODO: Test goes here...
        String[] input = {
                "2",
                "4 3",
                "1 2",
                "2 3",
                "3 4",
                "4 6",
                "1 2",
                "1 3",
                "1 4",
                "2 3",
                "2 4",
                "3 4",
        };
        List<Integer[]> result = TroubleMakerLauncher.launch(input);
        Assert.assertEquals(2, result.size());
        Assert.assertArrayEquals(new Integer[]{2, 4}, result.get(0));
        Assert.assertArrayEquals(new Integer[]{3, 4}, result.get(1));

        for (int i = 0; i < result.size(); ++i) {
            int count = result.get(i).length;

            System.out.print("Case #" + (i + 1) + ':');
            if (count == 0) {
                System.out.println("Impossible.\n");
            } else {
                System.out.println(count);
            }

            Arrays.stream(result.get(i))
                    .forEach(child -> System.out.print(child + " "));
            System.out.println();
        }
    }


} 
