/*
Kevin McCormick
CSC331-01
Parent Process Starts Two Child Process

This program launches Notepad and Calculator, then continues running until they are closed
*/

import java.io.*;

public class ChildProcess
{
   public static void main(String[] args)throws IOException, InterruptedException
   {
      //ProcessBuilder is used to create operating system processes
      //Creates two instances of the class, one for notepad and one for calculator
      ProcessBuilder notepad = new ProcessBuilder("notepad");
      ProcessBuilder calculator = new ProcessBuilder("calc");
      
      try {
         //Creates new process instances for notepad and calculator
         Process process1 = notepad.start();
         Process process2 = calculator.start();
         
         //The program waits for the processes to exit and returns an exit value when they do
         int exitValue1 = process1.waitFor();
         int exitValue2 = process2.waitFor();
         
         //If each program exited successfully, a message will display informing the user
         if(exitValue1 == 0) {
            System.out.println("Notepad has been closed");
         }
         if(exitValue2 == 0) {
            System.out.println("Calculator has been closed");
         }
      }
      //Displays if a program fails to start
      catch(IOException e) {
         System.out.println("A process did not start correctly");
      }      
      //Displays if a program is interrupted
      catch(InterruptedException ex) {
         System.out.println("A process has been interrupted");
      }  
   }  
}  