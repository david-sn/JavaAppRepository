/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghorithms.Searching;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author David Shire
 */
public class SelfOrganisedSearch {

    private static int x[] = new int[100];

    public static void main(String[] args) {
        Random r = new Random(17);

        //Making the array//
        for (int i = 0; i < x.length; i++) {
            x[i] = x.length - i;
        }
        System.out.println(Arrays.toString(x));

        r.setSeed(17);
        // straight search
        for (int i = 0; i < x.length * 1; i++) {
            float p = r.nextFloat();
            int j = (int) (p * 79);
            if (p < 0.3) {
                find(j % 20 + 1);
            } else {
                find(j + 21);
            }
        }
        System.out.println(n + " " + count);
        //identical but self-organizing
        r.setSeed(17);
        count = 0;
        n = 0;
        for (int i = 0; i < x.length * 1; i++) {
            float p = r.nextFloat();
            int j = (int) (p * 79);
            if (p < 0.3) {
                find2_TrasposeMethod(j % 20 + 1);
            } else {
                find2_TrasposeMethod(j + 21);
            }
        }
        System.out.println(Arrays.toString(x));
        System.out.println(n + " " + count);
    }

//Find
    private static int find(int target) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == target) {
                count += i;
                n++;
                return i;
            }
        }
        return -1;
    }
    static int count = 0, n = 0;
    static final int NEAR = 100 / 10;

//Find2
    /**
    The self-organizing algo is attempting to organize 
    * itself in a fashion such that the more often 
    * searched-for items are closer to the front. 
    * This way when the array is searched the more often 
    * targets can be found quicker on subsequent searches. 
    * For example, 
    * if you search and find 1 at i = 99, 
    * then moving it to NEAR (10) would result in a 10x 
    * faster retrieval the second time around. 
    * However, just from what I've seen, the idea of 
    * creating a sorted array to show this is kind of silly. 
    * If you already had a sorted array, say 1 - 100 descending 
    * as in your example, you could just check the target 
    * and split the array or rather give it directly 
    * as x[100-target] and it would indeed give you the target. 
    * If it were me, I would have randomized the elements, oh well. 
    * ------------------------------------------------------------------------
    * 2. What's going on inside the for-loops in which find and find2 are called?
    *    These are just generating *pseudo* 
    * random numbers as the targets. They are pseudo so the results are
    * the same each time as the "random" numbers are not so random. 
    * They are also limited to the data set as nextFloat() will return a 
    * number between 0.0 and 1.0 - p*79 just gives a percentage of 79,
    * then based on p you then calculate the target which will be between 1 and 100.

    */
    private static int find2_TrasposeMethod(int target) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == target) {
                count += i;
                n++;
                if (i > NEAR) {     //swap to NEAR
                    x[i] = x[NEAR];
                    x[NEAR] = target;
                } else if (i != 0) {    //swap with predecessor
                    x[i] = x[i - 1];
                    x[i - 1] = target;
                }
                return i;
            }
        }
        return -1;
    }

}
