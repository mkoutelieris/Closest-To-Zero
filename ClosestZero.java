/*
  This program loops through a temperatures array (Celsius degrees) and returns the temperature that is closest to 0.
  If there is a negative and positive temperature with the same value, e.g. [+2, -2], it returns the positive temperature.
*/

import java.util.*;
import java.lang.Math.*;

public class ClosestZero {

  public static int closeToZero(int[] temps) {

    int closest = 0;
    
    if(temps.length > 1) {
        
        ArrayList<Integer> tempsM = new ArrayList<Integer>();
        ArrayList<Integer> tempsP = new ArrayList<Integer>();
    
        for(int i = 0; i < temps.length; i++) {
          if(temps[i] == 0) {
            closest = 0;
            return closest;
          } else if(temps[i] < 0) {
            tempsM.add(temps[i]);
          } else if(temps[i] > 0) {
            tempsP.add(temps[i]);
          }
        }
    
        Collections.sort(tempsM);
        Collections.sort(tempsP);
        
        if(!tempsM.isEmpty() && !tempsP.isEmpty()) {
            if(Math.abs(tempsM.get(tempsM.size()-1)) == tempsP.get(0)) {
              closest = tempsP.get(0);
            } else if(Math.abs(tempsM.get(tempsM.size()-1)) > tempsP.get(0)) {
              closest = tempsP.get(0);
            } else if(Math.abs(tempsM.get(tempsM.size()-1)) < tempsP.get(0)) {
              closest = tempsM.get(tempsM.size()-1);
            }
        } else if(!tempsM.isEmpty()) {
            closest = tempsM.get(tempsM.size()-1);
        } else if(!tempsP.isEmpty()) {
            closest = tempsP.get(0);
        }
        
    } else if(temps.length == 1) {
        closest = temps[0];
    }
    
    return closest;

  }

  public static void main(String[] args) {
    
    int[] test1 = new int[]{1, -3, 0, 45, -56};
    int[] test2 = new int[]{4};
    int[] test3 = new int[]{-2, -45, -90};
    int[] test4 = new int[]{-2, 2, 90, -80, -45};
    int[] test5 = new int[]{};
    
    System.out.println(Arrays.toString(test1) + "\n");
    System.out.println("Closest temperature to 0 for the array above is: " + closeToZero(test1) + "\n");
    System.out.println(Arrays.toString(test2) + "\n");
    System.out.println("Closest temperature to 0 for the array above is: " + closeToZero(test2) + "\n");
    System.out.println(Arrays.toString(test3) + "\n");
    System.out.println("Closest temperature to 0 for the array above is: " + closeToZero(test3) + "\n");
    System.out.println(Arrays.toString(test4) + "\n");
    System.out.println("Closest temperature to 0 for the array above is: " + closeToZero(test4) + "\n");
    System.out.println(Arrays.toString(test5) + "\n");
    System.out.println("Closest temperature to 0 for the array above is: " + closeToZero(test1) + "\n");

  }
}
