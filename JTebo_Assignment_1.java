
/* 

* Class: CMSC203 CRN 202520 
* Instructor: Prof. Grigoriy Grinberg 
* Description: Read a file with color names, then randomly select one of those color names.  
* Each time user guesses the color name correctly they are given a point. They get three tries. 
* Due: 08/09/2024 
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment  
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student. 
*Print your Name here: Jacob Tebo 

*/ 
import java.util.Scanner;
import java.io.*;
import java.util.Random;

class JTebo_Assignment_1 {
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner (System.in); // variable to recieve input
        String colorOne, colorTwo, colorThree; //Names of user input for colors
        Random randomNumbers = new Random(); // Create random variable
        int randNumOne, randNumTwo, randNumThree; // Create an int variable to hold a random number
        int correctGuesses = 0;
   
         //Print Output for the user: 
        System.out.println("CMSC203 Assignment1: Test your ESP skills! ");
        System.out.println("Enter the filename: ");
        
        //Accept file name input from the user:
        String fileName = keyboard.nextLine(); 
        
        //Open the file
        Scanner inputFile = new Scanner(new File(fileName));
        
        //Read the colors from color.txt
        System.out.println("There are sixteen colors from a file: ");

        while (inputFile.hasNext())
        {
        //Read the first line from the file until it ends
        String line = inputFile.nextLine(); 
           
         //Display the lines from the file:
        System.out.println(line);
        }

  
    randNumOne = randomNumbers.nextInt(16)+1; //Generate rand num
        //Read color input from the user round 1
        System.out.println("Round 1\n");
        System.out.println("I am thinking of a color.\n" + "It is one of list " +
        "of colors above?");
        System.out.println("Enter you guess: ");
        colorOne = keyboard.nextLine();
       
        
        //Initialize constants for random colors
        final String COLOR_BLACK = "Black";
        final String COLOR_WHITE = "White";
        final String COLOR_GREY = "Grey";
        final String COLOR_SILVER = "Silver";
        final String COLOR_MAROON = "Maroon";
        final String COLOR_RED = "Red";
        final String COLOR_PURPLE = "Purple";
        final String COLOR_FUCHSIA = "Fuchsia";
        final String COLOR_GREEN = "Green";
        final String COLOR_LIME = "Lime";
        final String COLOR_OLIVE = "Olive";
        final String COLOR_YELLOW = "Yellow";
        final String COLOR_NAVY = "Navy";
        final String COLOR_BLUE = "Blue";
        final String COLOR_TEAL = "Teal";
        final String COLOR_AQUA = "Aqua";
        
           String actualColor = "test";
         if (randNumOne == 1)
        {
          actualColor = COLOR_BLACK ;
            
        }
        else if (randNumOne == 2)
        {
            actualColor = COLOR_WHITE;
        }
         else if (randNumOne == 3)
        {
           actualColor = COLOR_GREY;
              
        }
        else if (randNumOne == 4)
        {
            actualColor = COLOR_SILVER;
                
        }
        else if (randNumOne == 5)
        {
           actualColor = COLOR_MAROON;
            
                 
        }
        else if (randNumOne == 6)
        {
          actualColor = COLOR_RED;
            
              
            
        }
         else if (randNumOne == 7)
        {
             actualColor = COLOR_PURPLE;

            
        }
        else if (randNumOne == 8)
        {
             
            actualColor = COLOR_FUCHSIA;
               
            
            
        }
        else if (randNumOne == 9)
        {
            actualColor = COLOR_GREEN;
           
                 
            
        }
        else if (randNumOne == 10)
        {
           
            actualColor = COLOR_LIME;
          
            
        }
        else if (randNumOne == 11)
        {
          actualColor = COLOR_OLIVE;
            
              
            
        }
        else if (randNumOne == 12)
        {
           actualColor = COLOR_YELLOW;
            
        }
        else if (randNumOne == 13)
        {
             actualColor = COLOR_NAVY;
            
            
            
        }
        else if  (randNumOne == 14)
        {
              actualColor = COLOR_BLUE;
          
        }
        else if (randNumOne == 15)
        {
           
             actualColor = COLOR_TEAL;
         
            
        }
        else if (randNumOne == 16)
        {
            actualColor = COLOR_AQUA;
            
        }
        
       if (actualColor.equals(colorOne))
        {
            correctGuesses++;
            System.out.println("I was thinking " + actualColor);
        }
        else
        {
            System.out.println("I was thinking " + actualColor);
        }
        
        randNumTwo = randomNumbers.nextInt(16)+1; //Generate rand num
        //Read color input from the user round 2
        System.out.println("\nRound 2\n");
        System.out.println("I am thinking of a color.\n" + "It is one of list " +
        "of colors above?");
        System.out.println("Enter you guess: ");
        colorTwo = keyboard.nextLine();
        
     if (randNumOne == 1)
        {
          actualColor = COLOR_BLACK ;
            
        }
        else if (randNumTwo == 2)
        {
            actualColor = COLOR_WHITE;
        }
         else if (randNumTwo == 3)
        {
           actualColor = COLOR_GREY;
              
        }
        else if (randNumTwo == 4)
        {
            actualColor = COLOR_SILVER;
                
        }
        else if (randNumTwo == 5)
        {
           actualColor = COLOR_MAROON;
            
                 
        }
        else if (randNumTwo == 6)
        {
          actualColor = COLOR_RED;
            
              
            
        }
         else if (randNumTwo == 7)
        {
             actualColor = COLOR_PURPLE;

            
        }
        else if (randNumTwo == 8)
        {
             
            actualColor = COLOR_FUCHSIA;
               
            
            
        }
        else if (randNumTwo == 9)
        {
            actualColor = COLOR_GREEN;
           
                 
            
        }
        else if (randNumTwo == 10)
        {
           
            actualColor = COLOR_LIME;
          
            
        }
        else if (randNumTwo == 11)
        {
          actualColor = COLOR_OLIVE;
            
              
            
        }
        else if (randNumTwo == 12)
        {
           actualColor = COLOR_YELLOW;
            
        }
        else if (randNumTwo == 13)
        {
             actualColor = COLOR_NAVY;
            
            
            
        }
        else if  (randNumTwo == 14)
        {
              actualColor = COLOR_BLUE;
          
        }
        else if (randNumTwo == 15)
        {
           
             actualColor = COLOR_TEAL;
         
            
        }
        else if (randNumTwo == 16)
        {
            actualColor = COLOR_AQUA;
            
        }
        
      if (actualColor.equals(colorTwo))
        {
            correctGuesses++;
            System.out.println("I was thinking " + actualColor);
        }
        else
        {
            System.out.println("I was thinking " + actualColor);
        }
        
        
        randNumThree = randomNumbers.nextInt(16)+1; //Generate rand num
        //Read color input from the user round 2
        System.out.println("\nRound 3\n");
        System.out.println("I am thinking of a color.\n" + "It is one of list " +
        "of colors above?");
        System.out.println("Enter you guess: ");
        colorThree = keyboard.nextLine();
        
           if (randNumThree == 1)
        {
          actualColor = COLOR_BLACK ;
            
        }
        else if (randNumThree == 2)
        {
            actualColor = COLOR_WHITE;
        }
         else if (randNumThree == 3)
        {
           actualColor = COLOR_GREY;
              
        }
        else if (randNumThree == 4)
        {
            actualColor = COLOR_SILVER;
                
        }
        else if (randNumThree == 5)
        {
           actualColor = COLOR_MAROON;
            
                 
        }
        else if (randNumThree == 6)
        {
          actualColor = COLOR_RED;
            
              
            
        }
         else if (randNumThree == 7)
        {
             actualColor = COLOR_PURPLE;

            
        }
        else if (randNumThree == 8)
        {
             
            actualColor = COLOR_FUCHSIA;
               
            
            
        }
        else if (randNumThree == 9)
        {
            actualColor = COLOR_GREEN;
           
                 
            
        }
        else if (randNumThree == 10)
        {
           
            actualColor = COLOR_LIME;
          
            
        }
        else if (randNumThree == 11)
        {
          actualColor = COLOR_OLIVE;
            
              
            
        }
        else if (randNumThree == 12)
        {
           actualColor = COLOR_YELLOW;
            
        }
        else if (randNumThree == 13)
        {
             actualColor = COLOR_NAVY;
            
            
            
        }
        else if  (randNumThree == 14)
        {
              actualColor = COLOR_BLUE;
          
        }
        else if (randNumThree == 15)
        {
           
             actualColor = COLOR_TEAL;
         
            
        }
        else if (randNumThree == 16)
        {
            actualColor = COLOR_AQUA;
            
        }
      if (actualColor.equals(colorThree))
        {
            correctGuesses++;
            System.out.println("I was thinking " + actualColor);
        }
        else
        {
            System.out.println("I was thinking " + actualColor);
        }
        
        //End the program
        System.out.println("\nGame Over\n");
        System.out.println("You guessed " + correctGuesses + " out of 3 Colors " +
        "correctly");
        
         System.out.println("Enter your name: ");
         String userName = keyboard.nextLine();
         
         System.out.println("Describe Yourself: ");
         String userDesc = keyboard.nextLine();
         
         System.out.println("Due Date: ");
         String userDate = keyboard.nextLine();
        
         System.out.println("\nUser name: " + userName);
         System.out.println("User description: " + userDesc);
         System.out.println("Date: " + userDate);
      
        inputFile.close();
    }
}
