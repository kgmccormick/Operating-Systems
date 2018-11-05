/*
Kevin McCormick
CSC331-01
Frugal Calendar

This program accepts a year between 1950 and 2050 and finds the next year which uses the same calendar.
It does this by cycling through an seven element array once or twice for every successive year depending
on whether or not it was a leap year and comparing it to a default array. It also checks to make sure
the leap year status of the input year and the output year is the same.
*/


import java.util.Scanner;
import java.util.*;

public class FrugalCalendar
{
   //Method to check if a year is a leap year
   public static boolean isLeap(int i) {
      boolean a = false;
      if(i%4 != 0) {
         a = false;
      } else {
         a = true;
      }
      return a;
   }
   
   //main method
   public static void main(String[] args)
   {
      final int[] currentYear = {0,1,2,3,4,5,6}; //default array which represents the days in a week
      int[] nextYear = {0,1,2,3,4,5,6}; //array which gets changed based on subsequent years
      int year = 0; //holds input year
   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter a year between 1950 and 2050: ");
      
      //gets input year from the user
      if(keyboard.hasNextInt()) {
         int n = keyboard.nextInt();
         year = n;
         
         //checks for valid input
         if(1950 <= n && n <= 2050) {
            
            //loops while year arrays are not equal
            do {
               n += 1; //sets n to the year after
               if(!isLeap(n)) {
                  //cycle array once for non-leap year
                  int hold = nextYear[0];
                  for(int i = 0; i < nextYear.length - 1; i++) {
                     nextYear[i] = nextYear[i + 1];
                  }
                  nextYear[6] = hold;
               }
               
               if(isLeap(n)) {
                  //cycle array twice for leap year
                  for(int i = 0; i < 2; i++) {
                     int hold = nextYear[0];
                     for(int e = 0; e < nextYear.length - 1; e++) {
                        nextYear[e] = nextYear[e + 1];
                     }
                     nextYear[6] = hold;
                  }
               }
            //Loop only ends if both years have the same arrangement of days and are both leap years/not leap years.
            } while(!Arrays.equals(currentYear, nextYear) || isLeap(year) != isLeap(n));
            
            System.out.println("The next year with the same calendar is " + n);
         } 
         else {
            System.out.println("Out of range.");
         }
      } 
      else {
         System.out.println("Not a number.");
      }      
      keyboard.close();
   }  
}