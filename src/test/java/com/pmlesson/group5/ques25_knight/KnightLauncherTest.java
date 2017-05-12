package com.pmlesson.group5.ques25_knight;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * KnightLauncher Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 12, 2017</pre>
 */
public class KnightLauncherTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: launch(int row, int col, int startRow, int startCol)
     */
    @Test
    public void testLaunch() throws Exception {
//TODO: Test goes here...
        int[] rows = {4, 5, 6, 7, 4, 5, 6};
        int[] cols = {4, 3, 3, 3, 5, 5, 4};
        int[] results = {0, 0, 0, 8, 32, 304, 220};

        for (int i = 0; i < rows.length; ++i) {
            Assert.assertEquals(results[i], KnightLauncher.launch(rows[i], cols[i], 0, 0));
        }
    }

} 
