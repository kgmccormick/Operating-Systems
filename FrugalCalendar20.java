import java.util.Scanner;
import java.util.*;

public class FrugalCalendar{
   public static boolean isLeap(int i) {
      boolean a = false;
      if(i%4 != 0) {a = false;} else {a = true;}return a;}
   public static void main(String[] args){
      final int[] currentYear = {0,1,2,3,4,5,6}; //default array which represents the days in a week
      int[] nextYear = {0,1,2,3,4,5,6}; //array which gets changed based on subsequent years
      int year = 0; //holds input year
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter a year between 1950 and 2050: ");
      if(keyboard.hasNextInt()) {
         int n = keyboard.nextInt();year = n;
         if(1950 <= n && n <= 2050) {
            do {n += 1; //sets n to the year after
               if(!isLeap(n)) {int hold = nextYear[0];for(int i = 0; i < nextYear.length - 1; i++) {nextYear[i] = nextYear[i + 1];}nextYear[6] = hold;}
               if(isLeap(n)) {for(int i = 0; i < 2; i++) {int hold = nextYear[0];for(int e = 0; e < nextYear.length - 1; e++) {nextYear[e] = nextYear[e + 1];}nextYear[6] = hold;}}
            } while(!Arrays.equals(currentYear, nextYear) || isLeap(year) != isLeap(n));
            System.out.println("The next year with the same calendar is " + n);} else {System.out.println("Out of range.");}
      } else {System.out.println("Not a number.");}      
      keyboard.close();}}
      
      //its only like 25 lines of code lol