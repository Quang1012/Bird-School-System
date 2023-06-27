/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;

/**
 *
 * @author PC
 */
public class Utils {
    public static int NextInt(int from, int to){
        Random random = new Random();
        return from + random.nextInt(to - from + 1);
    }
}
