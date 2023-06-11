/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.research;

/**
 *
 * @author Hammad Gulraiz
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author Hammad Gulraiz
 */
public class ConfirmConjecture {

    private static int intiator = 5;
    private static int followerAddition = 5;

    private static int divider = 5;
    private static HashMap<Long, Integer> hmap = new HashMap<Long, Integer>();
//    private static Long x = 686712L; //For 6x+2 && divider is 2
    private static Long x = 1L;

    public static void main(String[] args) {
        System.out.println("*************Conjucture Starts*************");
        ConfirmConjecture con = new ConfirmConjecture();
        new Thread(() -> {
            con.performEquation(x);
        }).start();
    }

    private Long performEquation(Long carrier) {
        try {
            while (true) {
                if (hmap.get(carrier) != null) {
                    if (hmap.get(carrier) == 5) {
                        System.out.println("*************Loop Identified for " + intiator + "x" + " + " + followerAddition + " AND Dividing Rule is = " + divider + "*************");
                        System.out.println("#############Switching Value to : " + (x + 1) + "#############");
                        hmap.clear();
                        new Thread(() -> {
                            performEquation(x++);
                        }).start();
                        break;
                    }
                    hmap.put(carrier, hmap.get(carrier) + 1);
                } else {
                    hmap.put(carrier, 0);
                }
                if (carrier <= 0) {
                    System.out.println("***************************************Conjucture Failed****************************************************");
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
