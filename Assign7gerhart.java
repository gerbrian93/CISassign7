/*
Name: Brian Gerhart
CSU ID: 2741107
CIS 265: Assignment 7
Description: This assignment is an extension from assignment 5 that implements comparator interfaces to sort our list based upon name, id number, or gpa. 
*/


import java.io.File;
import java.util.Collections;
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Assign7gerhart {
      public static void main (String[] args) throws IOException {
      ArrayList<Student3> studentList = new ArrayList<>();//initialize ArrayList 
      String name;
      int idNum;
      float gpa;
      boolean isTransfer;
      String college;
  
         if (args.length != 2) {//prints invalid if the arg length is not 2
         System.out.println("ERROR, invalid arguments");
         }
         File inputFile = new File(args[0]); //inputs the files to pass as arguments
         File outputFile = new File(args[1]);
         Scanner input = new Scanner(inputFile);//Scanner reads input from the input file or first argument
         String line = "";//creates empty string for input to read

       while (input.hasNextLine()) {//this passes the input through every line of the file 
        try {
               line = input.nextLine();//starts at first line
               String[] split = line.split(",");//splits string line into substrings 
               name = split[0];
               idNum = Integer.parseInt(split[1]);//converts string to integer
               gpa = Float.parseFloat(split[2]);//converts string to float
                  if (split[3].equals("undergraduate")) {
                        isTransfer = Boolean.parseBoolean(split[4]);//converts string to boolean                    
                        studentList.add(new UndergradStudent2(name, idNum, gpa, isTransfer)); //creates undergrad and adds to list  
                  } else if (split[3].equals("graduate")) {
                        college = split[4];
                        studentList.add(new gradStudent2(name, idNum, gpa, college));//creates grad and adds to list
                  }else {
                        System.out.println("invalid input: "+line);//extra credit #4
                  }
         } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("Invalid input: "+line);  //extra credit #1        
         } catch (NumberFormatException f) {
               System.out.println("invalid input: "+line); //extra credit #2 & #3
           }
        }
        input.close();//close input
        Scanner in = new Scanner(System.in);  //create scanner for user input
        StudentIDComparator idSorter = new StudentIDComparator(); //creates comparator objects from comparator classes to sort the list by one of the 3 parameters
        StudentNameComparator nameSorter = new StudentNameComparator(); 
        StudentGPAComparator gpaSorter = new StudentGPAComparator(); 
            
             while(true){ //loop is to get valid input from user
               System.out.println("Which field should be used to sort Students(1-3)?");
               System.out.print("1.) Name\n2.) ID\n3.) GPA");
               System.out.println("");
                  int num = in.nextInt();
                     if (num == 1) { //user input num will break out only if it equals 1, 2, or 3, respectively. 
                       Collections.sort(studentList, nameSorter);// 1 calls the collection.sort method from our name comparator class 
                       break;
                    } else if (num == 2) { 
                       Collections.sort(studentList, idSorter);// 2 calls the collection.sort method from our id comparator class
                       break;
                    } else if (num == 3) {
                       Collections.sort(studentList, gpaSorter); // 3 calls the collection.sort method from our gpa comparator class
                       break;
                    }
              }
         PrintWriter output = new PrintWriter(outputFile);//create printwriter object 
           for (int i = studentList.size() - 1; i >= 0; i--) {//starts at last element of array and i-- decremnts
              studentList.get(i).printStudent(output);//uses .get(i) and calls the printStudent methods
              
           }
            output.close();//close output
      }
} 



