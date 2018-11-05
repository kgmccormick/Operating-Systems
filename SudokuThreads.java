/*
Kevin McCormick
CSC331-01
Sudoku Solution Validator
*/

import java.io.*;
import java.util.*;

/*
class RowThread implements Runnable {

   public RowThread(int[][] a, int rn, int vn) {
      int[][] array = a;
      int rowNum = rn;
      int valNum = vn;
   }
   
   @Override
   public void run(){
      int[] row = new int[9];
         for(int i = 0; i < 9; i++) {
            row[i] = array[i][rowNum];
         }
      if(containsAll(row)) {
         validator[valNum] = true;
      }

   }
*/
/*
public static void rowCheck(int[][] array, int rowNum, int valNum) {
      Thread tRow1 = new Thread(new Runnable() {
            @Override
            public void run(){
               int[] row = new int[9];
               for(int i = 0; i < 9; i++) {
                  row[i] = array[i][rowNum];
               }
               if(containsAll(row)) {
                  validator[valNum] = true;
               }
            }
      }); 
   } 
}
*/

public class SudokuThreads {
   //Validator is public so methods can access it
   public static boolean[] validator = new boolean[27];
   
   //Method that checks for a number in an array
   public static boolean contains(int[] array, int n) {
      for (int i = 0; i < 9; i++) {
         if (n == array[i]) {
            return true;
         }
      }
      return false;
   }
   //Method that checks if numbers 1-9 are in an array
   public static boolean containsAll(int[] array) {
      if(contains(array, 1) &&
         contains(array, 2) &&
         contains(array, 3) &&
         contains(array, 4) &&
         contains(array, 5) &&
         contains(array, 6) &&
         contains(array, 7) &&
         contains(array, 8) &&
         contains(array, 8) &&
         contains(array, 9)) {
         return true;
      }
      return false;
   }
   
   public static void rowCheck(int[][] array, int rowNum, int valNum) {
      Thread tRow = new Thread(new Runnable() {
            @Override
            public void run(){
               int[] row = new int[9];
               for(int i = 0; i < 9; i++) {
                  row[i] = array[i][rowNum];
               }
               if(containsAll(row)) {
                  validator[valNum] = true;
               }
            }
      });
      tRow.start();
   } 
   
   public static void main(String[] args){
   
      //Initializes global validator
      for(int i = 0; i < 27; i++) {
         validator[i] = false;
      }
   
      //List of numbers from the Sudoku example in order
      int[][] exampleSudoku = {{6, 2, 4, 5, 3, 9, 1, 8, 7},
                     			 {5, 1, 9, 7, 2, 8, 6, 3, 4},
                     		 	 {8, 3, 7, 6, 1, 4, 2, 9, 5},
                     		 	 {1, 4, 3, 8, 6, 5, 7, 2, 9},
                     			 {9, 5, 8, 2, 4, 7, 3, 6, 1},
                     			 {7, 6, 2, 3, 9, 1, 4, 5, 8},
                     			 {3, 7, 1, 9, 5, 6, 8, 4, 2},
                     			 {4, 9, 6, 1, 8, 2, 5, 7, 3},
                     			 {2, 8, 5, 4, 7, 3, 9, 1, 6}};
                                                    
         
      
      if(validator[0]) {
         System.out.println("yee");
         }
         int[] j = {8,2,3,4,6,5,7,1,9};
         
         if(containsAll(j)) {
            System.out.println("yee");
         }
         else {
            System.out.println("nah");
         }
         
      }
   }  
//}  