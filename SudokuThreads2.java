/*
Kevin McCormick
CSC331-01
Sudoku Solution Validator

This program works by creating 27 different threads, each responsible for checking whether or not a row, column, or box in the sudoku is valid.
Running the program will validate the Sudoku array stored as a global variable in the GV class.
If the sudoku is valid, the program will print: "This Sudoku is Valid"
If any row, column, or box is invalid, the program will print: "This Sudoku is NOT Valid" along with the row, column and box containing the mistake.

The boxes are arranged like this:
            1 4 7
            2 5 8
            3 6 9       
*/

import java.io.*;
import java.util.*;
import static java.lang.Math.toIntExact;

class GV {
   //arrays to store the results of the validation threads for rows, columns, and boxes individually
   public static boolean[] RowValidator = new boolean[9];
   public static boolean[] ColValidator = new boolean[9];
   public static boolean[] BoxValidator = new boolean[9];
   
   //Sudoku array, change this to test the results
   public static int[][] Sudoku = {{6, 2, 4, 5, 3, 9, 1, 8, 7},
                     			    {5, 1, 9, 7, 2, 8, 6, 3, 4},
                     		   	 {8, 3, 7, 6, 1, 4, 2, 9, 5},
                     		   	 {1, 4, 3, 8, 6, 5, 7, 2, 9},
                     		   	 {9, 5, 8, 2, 4, 7, 3, 6, 1},
                     			    {7, 6, 2, 3, 9, 1, 4, 5, 8},
                     			    {3, 7, 1, 9, 5, 6, 8, 4, 2},
                     			    {4, 9, 6, 1, 8, 2, 5, 7, 3},
                     			    {2, 8, 5, 4, 7, 3, 9, 1, 6}};
}


//Class that creates threads to check rows ------------------------------------------------------------------
class RowThread implements Runnable {
   public int[][] array;
   public int rowNum;


   public RowThread(int[][] a) {
      array = a;     
   }
   
   //Method that checks for a number in an array
   public boolean contains(int[] array, int n) {
      for (int i = 0; i < 9; i++) {
         if (n == array[i]) {
            return true;
         }
      }
      return false;
   }
   //Method that checks if numbers 1-9 are in an array
   public boolean containsAll(int[] array) {
      if(contains(array, 1) &&
         contains(array, 2) &&
         contains(array, 3) &&
         contains(array, 4) &&
         contains(array, 5) &&
         contains(array, 6) &&
         contains(array, 7) &&
         contains(array, 8) &&
         contains(array, 9)) {
         return true;
      }
      return false;
   }
   
   //method that creates the threads
   @Override
   public void run() {
      int[] row = new int[9];
         for(int i = 0; i < 9; i++) {
            row[i] = array[toIntExact(Thread.currentThread().getId()-11)][i];
         }
      //System.out.println(toIntExact(Thread.currentThread().getId()-11));
      GV.RowValidator[toIntExact(Thread.currentThread().getId()-11)] = containsAll(row);
      
      if(!GV.RowValidator[toIntExact(Thread.currentThread().getId()-11)]) {
            System.out.println("Mistake in Row " + (toIntExact(Thread.currentThread().getId()-10)));
      }
   }
}


//Class that checks columns ----------------------------------------------------
class ColThread implements Runnable {
   public int[][] array;
   public int colNum;


   public ColThread(int[][] a) {
      array = a;     
   }
   
   //Method that checks for a number in an array
   public boolean contains(int[] array, int n) {
      for (int i = 0; i < 9; i++) {
         if (n == array[i]) {
            return true;
         }
      }
      return false;
   }
   //Method that checks if numbers 1-9 are in an array
   public boolean containsAll(int[] array) {
      if(contains(array, 1) &&
         contains(array, 2) &&
         contains(array, 3) &&
         contains(array, 4) &&
         contains(array, 5) &&
         contains(array, 6) &&
         contains(array, 7) &&
         contains(array, 8) &&
         contains(array, 9)) {
         return true;
      }
      return false;
   }
   
   //method that creates the threads
   @Override
   public void run() {
      int[] col = new int[9];
         for(int i = 0; i < 9; i++) {
            col[i] = array[i][toIntExact(Thread.currentThread().getId()-20)];
         }
      //System.out.println(toIntExact(Thread.currentThread().getId()-20));
      GV.ColValidator[toIntExact(Thread.currentThread().getId()-20)] = containsAll(col);
      
      if(!GV.ColValidator[toIntExact(Thread.currentThread().getId()-20)]) {
            System.out.println("Mistake in Column " + (toIntExact(Thread.currentThread().getId()-19)));
         }
   }
}

//Class that checks boxes ----------------------------------------------------
class BoxThread implements Runnable {
   public int[][] array;
   public int colNum;


   public BoxThread(int[][] a) {
      array = a;     
   }
   
   //Method that checks for a number in an array
   public boolean contains(int[] array, int n) {
      for (int i = 0; i < 9; i++) {
         if (n == array[i]) {
            return true;
         }
      }
      return false;
   }
   //Method that checks if numbers 1-9 are in an array
   public boolean containsAll(int[] array) {
      if(contains(array, 1) &&
         contains(array, 2) &&
         contains(array, 3) &&
         contains(array, 4) &&
         contains(array, 5) &&
         contains(array, 6) &&
         contains(array, 7) &&
         contains(array, 8) &&
         contains(array, 9)) {
         return true;
      }
      return false;
   }
   
   //method that create the threads
   @Override
   public void run() {
      //Each if statement applies to a different thread number
      if((toIntExact(Thread.currentThread().getId()-29) == 0)) {
         int[] box1 = new int[9];
         box1[0] = array[0][0];
         box1[1] = array[0][1];
         box1[2] = array[0][2];
         box1[3] = array[1][0];
         box1[4] = array[1][1];
         box1[5] = array[1][2];
         box1[6] = array[2][0];
         box1[7] = array[2][1];
         box1[8] = array[2][2];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box1);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 1");
         }
      }
         
      if((toIntExact(Thread.currentThread().getId()-29) == 1)) {
         int[] box2 = new int[9];
         box2[0] = array[3][0];
         box2[1] = array[3][1];
         box2[2] = array[3][2];
         box2[3] = array[4][0];
         box2[4] = array[4][1];
         box2[5] = array[4][2];
         box2[6] = array[5][0];
         box2[7] = array[5][1];
         box2[8] = array[5][2];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box2);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 2");
         }
         
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 2)) {
         int[] box3 = new int[9];
         box3[0] = array[6][0];
         box3[1] = array[6][1];
         box3[2] = array[6][2];
         box3[3] = array[7][0];
         box3[4] = array[7][1];
         box3[5] = array[7][2];
         box3[6] = array[8][0];
         box3[7] = array[8][1];
         box3[8] = array[8][2];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box3);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 3");
         }
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 3)) {
         int[] box4 = new int[9];
         box4[0] = array[0][3];
         box4[1] = array[0][4];
         box4[2] = array[0][5];
         box4[3] = array[1][3];
         box4[4] = array[1][4];
         box4[5] = array[1][5];
         box4[6] = array[2][3];
         box4[7] = array[2][4];
         box4[8] = array[2][5];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box4);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 4");
         }
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 4)) {
         int[] box5 = new int[9];
         box5[0] = array[3][3];
         box5[1] = array[3][4];
         box5[2] = array[3][5];
         box5[3] = array[4][3];
         box5[4] = array[4][4];
         box5[5] = array[4][5];
         box5[6] = array[5][3];
         box5[7] = array[5][4];
         box5[8] = array[5][5];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box5);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 5");
         }
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 5)) {
         int[] box6 = new int[9];
         box6[0] = array[6][3];
         box6[1] = array[6][4];
         box6[2] = array[6][5];
         box6[3] = array[7][3];
         box6[4] = array[7][4];
         box6[5] = array[7][5];
         box6[6] = array[8][3];
         box6[7] = array[8][4];
         box6[8] = array[8][5];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box6);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 6");
         }
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 6)) {
         int[] box7 = new int[9];
         box7[0] = array[0][6];
         box7[1] = array[0][7];
         box7[2] = array[0][8];
         box7[3] = array[1][6];
         box7[4] = array[1][7];
         box7[5] = array[1][8];
         box7[6] = array[2][6];
         box7[7] = array[2][7];
         box7[8] = array[2][8];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box7);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 7");
         }
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 7)) {
         int[] box8 = new int[9];
         box8[0] = array[3][6];
         box8[1] = array[3][7];
         box8[2] = array[3][8];
         box8[3] = array[4][6];
         box8[4] = array[4][7];
         box8[5] = array[4][8];
         box8[6] = array[5][6];
         box8[7] = array[5][7];
         box8[8] = array[5][8];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box8);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 8");
         }
      }
      if((toIntExact(Thread.currentThread().getId()-29) == 8)) {
         int[] box9 = new int[9];
         box9[0] = array[6][6];
         box9[1] = array[6][7];
         box9[2] = array[6][8];
         box9[3] = array[7][6];
         box9[4] = array[7][7];
         box9[5] = array[7][8];
         box9[6] = array[8][6];
         box9[7] = array[8][7];
         box9[8] = array[8][8];

         GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)] = containsAll(box9);
         if(!GV.BoxValidator[toIntExact(Thread.currentThread().getId()-29)]) {
            System.out.println("Mistake in Box 9");
         }
      }
   }
}


//main class ----------------------------------------------------------------------------------
public class SudokuThreads2 {
   
   //Used to check if all the contents of a validator are true
   public static boolean allTrue(boolean[] array)
   {
       for(boolean b : array) if(!b) return false;
       return true;
   }
   
   public static void main(String[] args){
      
      //Manually create all threads because I couldn't get it to work with a loop
      RowThread row1 = new RowThread(GV.Sudoku); Thread t1 = new Thread(row1); t1.start();
      RowThread row2 = new RowThread(GV.Sudoku); Thread t2 = new Thread(row2); t2.start();
      RowThread row3 = new RowThread(GV.Sudoku); Thread t3 = new Thread(row3); t3.start();
      RowThread row4 = new RowThread(GV.Sudoku); Thread t4 = new Thread(row4); t4.start();
      RowThread row5 = new RowThread(GV.Sudoku); Thread t5 = new Thread(row5); t5.start();
      RowThread row6 = new RowThread(GV.Sudoku); Thread t6 = new Thread(row6); t6.start();
      RowThread row7 = new RowThread(GV.Sudoku); Thread t7 = new Thread(row7); t7.start();
      RowThread row8 = new RowThread(GV.Sudoku); Thread t8 = new Thread(row8); t8.start();
      RowThread row9 = new RowThread(GV.Sudoku); Thread t9 = new Thread(row9); t9.start();
      
      ColThread col1 = new ColThread(GV.Sudoku); Thread t10 = new Thread(col1); t10.start();
      ColThread col2 = new ColThread(GV.Sudoku); Thread t11 = new Thread(col2); t11.start();
      ColThread col3 = new ColThread(GV.Sudoku); Thread t12 = new Thread(col3); t12.start();
      ColThread col4 = new ColThread(GV.Sudoku); Thread t13 = new Thread(col4); t13.start();
      ColThread col5 = new ColThread(GV.Sudoku); Thread t14 = new Thread(col5); t14.start();
      ColThread col6 = new ColThread(GV.Sudoku); Thread t15 = new Thread(col6); t15.start();
      ColThread col7 = new ColThread(GV.Sudoku); Thread t16 = new Thread(col7); t16.start();
      ColThread col8 = new ColThread(GV.Sudoku); Thread t17 = new Thread(col8); t17.start();
      ColThread col9 = new ColThread(GV.Sudoku); Thread t18 = new Thread(col9); t18.start();
      
      BoxThread box1 = new BoxThread(GV.Sudoku); Thread t19 = new Thread(box1); t19.start();
      BoxThread box2 = new BoxThread(GV.Sudoku); Thread t20 = new Thread(box2); t20.start();
      BoxThread box3 = new BoxThread(GV.Sudoku); Thread t21 = new Thread(box3); t21.start();
      BoxThread box4 = new BoxThread(GV.Sudoku); Thread t22 = new Thread(box4); t22.start();
      BoxThread box5 = new BoxThread(GV.Sudoku); Thread t23 = new Thread(box5); t23.start();
      BoxThread box6 = new BoxThread(GV.Sudoku); Thread t24 = new Thread(box6); t24.start();
      BoxThread box7 = new BoxThread(GV.Sudoku); Thread t25 = new Thread(box7); t25.start();
      BoxThread box8 = new BoxThread(GV.Sudoku); Thread t26 = new Thread(box8); t26.start();
      BoxThread box9 = new BoxThread(GV.Sudoku); Thread t27 = new Thread(box9); t27.start();


      //manually join all threads
      try {
         //rows
         t1.join();
         t2.join();
         t3.join();
         t4.join();
         t5.join();
         t6.join();
         t7.join();
         t8.join();
         t9.join();
         
         //colums
         t10.join();
         t11.join();
         t12.join();
         t13.join();
         t14.join();
         t15.join();
         t16.join();
         t17.join();
         t18.join();
         
         //boxes
         t19.join();
         t20.join();
         t21.join();
         t22.join();
         t23.join();
         t24.join();
         t25.join();
         t26.join();
         t27.join();
         
         
      } catch(InterruptedException e) {
         e.printStackTrace();
      
      }
   
      //validate the sudoku using the global boolean arrays
      if(allTrue(GV.RowValidator)) {
         if(allTrue(GV.ColValidator)) {
            if(allTrue(GV.BoxValidator)) {
               System.out.println("This Sudoku is Valid");
            }
         }
      } else {
         System.out.println("This Sudoku is NOT Valid");
      }

   
   }    
}