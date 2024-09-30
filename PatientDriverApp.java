import java.util.Scanner;

 
public class PatientDriverApp
{
    
    public static void main(String[] args) 
    {
        displayPatient(); //Call display patient to show print/format user output
        displayProcedure(); //Call display procedure to show print/format user output
        System.out.println(" ");
        displayName("Jacob Tebo", "1234567", "8/30/2024"); //Call display name to print student info
    
    }
    
         public static void displayPatient() //Method to display patient info
        {
            
            
        //Create a variable for input  
        Scanner keyboard = new Scanner(System.in); 
        
        //Create a blank patient object
        Patient patient = new Patient();
        
               //Get user input for name and send info to patient class
        String firstName, middleName, lastName;
        
        //Get user input for address and send info to patient class
        String userAddress, userCity, userState, userZip;
        
        //Get user input for emergency contacts and send info to patient class
        String emergencyName, emergencyPhone;
        
        
        //User should enter name information
        System.out.println("Please Enter your first name: ");
        firstName = keyboard.nextLine();
        
        System.out.println("Please Enter your middle name: ");
        middleName = keyboard.nextLine();
        
        System.out.println("Please Enter your last name: ");
        lastName = keyboard.nextLine();
        
        
        //User should enter address information
         System.out.println("Please Enter your address: ");
        userAddress = keyboard.nextLine();
        
        System.out.println("Please Enter your city: ");
        userCity = keyboard.nextLine();
        
        System.out.println("Please Enter your state: ");
        userState = keyboard.nextLine();
        
        System.out.println("Please Enter your zip: ");
        userZip = keyboard.nextLine();
        
        
        //User should enter Emergency Contact information
        System.out.println("Please Enter your emergency name: ");
        emergencyName = keyboard.nextLine();
        
        System.out.println("Please Enter your emeergency phone number: ");
        emergencyPhone = keyboard.nextLine();
        
       //create classes for each input:
       //Send the name input
       patient.setFirst(firstName);
       patient.setMiddle(middleName);
       patient.setLast(lastName);
       
       //Send the address input
       patient.setAddress(userAddress);
       patient.setCity(userCity);
       patient.setState(userState);
       patient.setZip(userZip);
       
       //Send the Emergency contact input
       patient.setEmerName(emergencyName);
       patient.setEmerPhone(emergencyPhone);
       
       
           //Display Output:
       System.out.println("\n");
       System.out.println(patient.toString());
       System.out.println("\n");
       //Print using toString method
       
       
      }
         
         public static void displayProcedure()
         {
              
             
             //Create a blank patient object
             Procedure procedure = new Procedure();
             
             Procedure testOne = new Procedure("Physical Exam", "7/20/2019", "Dr. Irvine", 3250.00);
             
             Procedure testTwo = new Procedure("X-ray", "7/20/2019", "Dr. Jamison", 500.00);
             
             Procedure testThree = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 200.00);
             
             
            //Display Output:
            
            System.out.println(testOne.toString());
            System.out.println("\n");
            System.out.println(testTwo.toString());
            System.out.println("\n");
            System.out.println(testThree.toString());
            System.out.println("\n");
            //Print using toString method
            
            //Get the cost from each procedure class
            double chargeOne, chargeTwo, chargeThree;
            chargeOne = testOne.getCharges();
            chargeTwo = testTwo.getCharges();
            chargeThree = testThree.getCharges();
             
            double totalCost = calculateTotalCharges(chargeOne, chargeTwo,chargeThree);
            System.out.printf("Total Charges: " + totalCost);
         }
         
         public static void displayName(String dueDate, String studentName,String mcNumber)
         {
        	 
        	 System.out.println("Student Name: " + dueDate);
        	 System.out.println("MC#: "+ studentName);
        	 System.out.println("Due date: " + mcNumber);
         }
         
         //Calculate the total charges of the procedure
         public static double calculateTotalCharges(double chargeOne, double chargeTwo,  double chargeThree)
         {
             
             double totalCharge;
             totalCharge = chargeOne + chargeTwo + chargeThree;
             
             return totalCharge;
         }
         
}
        