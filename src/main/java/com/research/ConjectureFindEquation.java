/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.research;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author Hammad Gulraiz
 */
public class ConjectureFindEquation {

    private static int intiator = 5;
    private static int followerAddition = 1;

    private static int divider = 5;
    private static HashMap<Long, Integer> hmap = new HashMap<Long, Integer>();
    private static Long x = 1L;

    private static boolean conjuctureFailed = true;
    private static int loopInitialValue = 1;
    private static int loopThreshold = 1000;

    public static void main(String[] args) {
        System.out.println("*************Conjucture Starts*************");
        ConjectureFindEquation con = new ConjectureFindEquation();
        con.performEquation(x);
        while (conjuctureFailed && divider <= 9) {
            while (conjuctureFailed && followerAddition <= 9) {
                hmap.clear();
                con.performEquation(x);
                followerAddition++;
            }
            followerAddition = 1;
            hmap.clear();
            divider++;
        }
    }

    private Long performEquation(Long carrier) {
        try {
            while (true) {
                conjuctureFailed = false;
                if (hmap.get(carrier) != null) {
                    if (hmap.get(carrier) == 5) {
                        System.out.println("*************Loop Identified for " + intiator + "x" + " + " + followerAddition + " AND Dividing Rule is = " + divider + "*************");
                        System.out.println("#############Switching Value to : " + (x + 1) + "#############");
                        hmap.clear();
                        loopInitialValue++;
                        if (loopInitialValue <= loopThreshold) {
                            performEquation(x++);
                        }
                        break;
                    }
                    hmap.put(carrier, hmap.get(carrier) + 1);
                } else {
                    hmap.put(carrier, 0);
                }
                if (carrier <= 0) {
                    System.out.println("*************Conjucture Failed - Switching Equation" + intiator + "x" + " + " + (followerAddition + 1) + " AND Dividing Rule is = " + divider + "*************");
                    conjuctureFailed = true;
                    break;
                }
                if ((carrier % divider) == 0) {
                    carrier = evenDivider(carrier);
                } else {
                    carrier = oddMultiplier(carrier);
                }
            }
            System.out.println("Ending Result :: " + carrier);
            return carrier;
        } catch (Exception exe) {
            System.out.println("^^^^^^^^^^^^^^^^^^Found Error^^^^^^^^^^^^^^^^^^" + exe);
            return null;
        }
    }

    private Long oddMultiplier(Long result) {

        result = (intiator * result) + followerAddition;
//        result = (intiator * result) - followerAddition;
        System.out.println("Odd Result :: " + result);
        return result;
    }

    private Long evenDivider(Long result) {

        result = result / divider;
        System.out.println("Even Result :: " + result);
        return result;
    }

}
