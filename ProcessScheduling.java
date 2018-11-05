/*
Kevin McCormick
CSC331-01
Process Scheduling: Shortest Job First
*/

import java.io.*;
import java.util.*;

public class ProcessScheduling {

   public static void Rectagulizer(ArrayList<String[]> array) {
      //Garbage in ascii form
      String trc = Character.toString ((char) 201);
      String tlc = Character.toString ((char) 187);
      String brc = Character.toString ((char) 200);
      String blc = Character.toString ((char) 188);
      String vl = Character.toString ((char) 186);
      String hjt = Character.toString ((char) 203);
      String hjb = Character.toString ((char) 202);
      String hl = Character.toString ((char) 205);
      
      int size = 4;
      
      System.out.print(trc);
      for(int i = 0; i < size-1; i++) {
         System.out.print(hl + hl + hjt);
      }
      System.out.println(hl + hl + tlc);
      for(int i = 0; i < size; i++) {
         if(i < array.size() && array.get(i) != null) {
            System.out.print(vl + array.get(i)[0]);
         }
         else {
            System.out.print(vl + "  ");
         }
      }
      System.out.println(vl);
      System.out.print(brc);
      for(int i = 0; i < size-1; i++) {
         System.out.print(hl + hl + hjb);
      }
      System.out.println(hl + hl + blc);
         
  }

   public static void main(String[] args)throws IOException, InterruptedException {

      System.out.println("Shortest Job First Scheduling");

      ArrayList<String[]> processes = new ArrayList<String[]>();
      
      String[] P1 = {"P1", "3"};
      String[] P2 = {"P2", "1"};
      String[] P3 = {"P3", "2"};
      String[] P4 = {"P4", "4"};
      processes.add(P1);
      processes.add(P2);
      processes.add(P3);
      processes.add(P4);
      
      Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {
            while(true) {
               try {
                  Rectagulizer(processes);
                  int hold_time = 9999;
                  int hold_spot = 0;
                  String execute = "";

                  if(processes.size() > 0) {
                     for(int i=0; i < processes.size(); i++) {
                        if(Integer.parseInt(processes.get(i)[1]) < hold_time) {
                           hold_time = Integer.parseInt(processes.get(i)[1]);
                           hold_spot = i;
                           execute = processes.get(i)[0];
                        }
                     }
                     processes.remove(hold_spot);
                     System.out.println("Now executing " + execute + " for " + hold_time + " seconds.");
                     Thread.sleep(hold_time*1000);
                     System.out.println("Done");
                  }
               } 
               catch(InterruptedException ex) {
                  Thread.currentThread().interrupt();
               }
            }
         }
      });
      
      thread.start();
      
      thread.join();
      
   }  
}  