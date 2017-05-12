package com.pmlesson.group5.ques05_prime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.List;

/**
 * PrimeLauncher Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 12, 2017</pre>
 */
public class PrimeLauncherTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: launch(int sum, int maxPrimeCount)
     */
    @Test
    public void testLaunch() throws Exception {
//TODO: Test goes here...
        int[][] inputs = {
                {24, 3},
                {24, 2},
                {2, 1},
                {1, 1},
                {4, 2},
                {18, 3},
                {17, 1},
                {17, 3},
                {17, 4},
                {100, 5},
//                {1000, 10},
//                {1120, 14},
        };
        int[] results = {
                2, 3, 1, 0, 0, 2, 1, 0, 1, 55
//                , 200102899, 2079324314,
        };

        for (int i = 0; i < inputs.length; ++i) {
            List<String> result = PrimeLauncher.launch(inputs[i][0], inputs[i][1]);
            System.out.println("Case #" + (i + 1) + ":" + result.size());
            result.forEach(s -> System.out.println("    " + s));
            System.out.println();
            Assert.assertEquals(results[i], result.size());
        }
    }

} 
