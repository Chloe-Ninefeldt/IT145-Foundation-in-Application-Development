
 /* Southern NH University
 * IT - 145 Foundations in Application Development
 * Instructor: Joe Parker
 * Student: Chloe Ninefeldt
 * Date: 08/18/2019
 *
 * Description: Final Project
 *
 * Create a program for a zookeeper that can keep track of animal/habitat information
 * Ask the user what they would like to monitor
 * Get answer and give the correct information
 * If any details are out of range, have a warning pop up 
 *
 *
 * NOTE: I put the txt files on the same level as my java files, the files
 * should pull without a file path
 */
package zoomonitor;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ZooMonitor {
    private static Scanner usrch = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        AnimalsHabitat methodCall = new AnimalsHabitat();
    // use to pull information from AnimalsHabitat class
               
        while(true){
            //use a while loop to go through the options repeatedly until user exits
        
                int userChoice = mainMenu();
            //use switch case to go through the files easier and make code more
            //readable 
            switch(userChoice) {
                case 1:
                    //pull the animal.txt file
                    methodCall.askForWhichDetails("animals");
                    break;
                case 2:
                    //pull the habitats.txt file
                    methodCall.askForWhichDetails("habitats");                 
                    break;
                case 3:
                    //exit the program if user chooses
                    System.out.println("Exiting program.");
                    //system exit 
                    System.exit(0);
                    break;
                default:
                    int loopError = 0;
                    while(loopError < 3){
                        loopError++;
                        if(loopError == 3){
                            //if the user enters any other number, goes back to main menu
                            System.out.println("Error: Not a valid option, please try again.");
                                    
                            
                        }
                              
                                
                    }
                }
        }   
}
            
        
        
    // used this instead of adding every line item into the loop several times
    public static int mainMenu(){  
        System.out.println("");
        System.out.println("Welcome to the Zoo Habitat and Animal Monitoring System.");
        //make a greeting message
        System.out.println("Please select what you would like to do.");
        //diplay the options for the user
        System.out.println("");
        System.out.println("1.) - Animal Monitoring");   
        // 1 if the user would like to monitor an animal
        System.out.println("2.) - Habitat Monitoring");   
        // 2 if the user would like to monitor a habitat
        System.out.println("3.) - Exit the program");
        //3 to simply exit out of the program
        System.out.println("Please enter choice: ");
        //prompt user for their choice
        int userChoice = Integer.parseInt(usrch.nextLine());
        return userChoice;
        }
}
    
    
               
                     
                       
                
                
            
        
    
    

