import java.util.Scanner;
/**
* <h1><strong>Class Einstein</strong></h1><br/>
* This program is based on a math riddle that Einstein used to enjoy confusing his friends with.<br/>
* The user is asked to choose a number, by the following rules:<br/>
* 1. The number needs to be a 3 digit integer.<br/>
* 2. The number needs to ne positive.<br/>
* 3. The hundred's digit and the unit's digit needs to be different.<br/>
* The program creates a new number, by replacing the hundred's digit with the unit's digit of the input number.<br/>
* Then. the programm calculates the difference between the larger and the smaller number.<br/>
* Then, the program creates a new number, by replacing the hundred's digit with the unit's digit of the difference.<br/>
* Finally, the program sums the difference with the new number created.<br/>
* In the last stage, is where the "magic" happans, no matter what the input is, the output will always be 1089.<br/>
* @author <em>Omer Munk</em>
* @since 06/2021
* @version 1
*/
public class Einstein
{
    public static void main(String [] args)
    {
        // Declaration and initialize of the final variable, Einstein magic number.
        final int EINSTEIN_MAGIC_NUMBER = 1089;
        
        // Declarations of variables.
        int hundredsDigit;
        int unitsDigit;
        
        // Welcome massage and explanation for the user.
        System.out.println("Welcome to the Einstein magic game.");
        System.out.println("Please enter a 3 digit positive number " +
            "whose first and last digits are different:");

        // Get an input from the user
        Scanner scan = new Scanner (System.in);
        int num = scan.nextInt();

        // Calculates the hundred's digit and the unit's digits of the input
        hundredsDigit = num/100;
        unitsDigit = num%10;

        // Checking if the input is a valid number according to the user instructions
        if ((num <= 0) || (hundredsDigit < 1) || (hundredsDigit > 9))
            System.out.println("The numer you entered is not a 3 digit positive number.");
            
        // Checking if the input number follows the rules of the program.
        else if (hundredsDigit == unitsDigit)
            System.out.println("The first and the last digits of the number should be different:");
            
        else // Input is valid.
        {
            System.out.println("User number is: "+ num);
            
            // Declarations of the variables for the calculations.
            // A reverse number is a 3 digits number with the hundred's and the unit's digit's relpaced.
            int reverseNum;
            
            // Settings the digits of the new number, and create it.
            int firstNumberUnits = unitsDigit;
            int reverseUnitsDigit = hundredsDigit;
            int firstNumberHundreds = hundredsDigit*100;
            int reverseHundredsDigit = unitsDigit*100;
            
            // A calculation to create the reversed number.
            reverseNum = num - firstNumberUnits + reverseUnitsDigit - firstNumberHundreds + reverseHundredsDigit;
            
            // Calculates and prints the absolute value (difference) of the input number minus the reverse number.
            int difference = Math.abs(num - reverseNum);
            System.out.println("Difference: " + difference);
            
            // Set the hundreds and units digits of the difference.
            hundredsDigit = difference/100;
            unitsDigit = difference%10;
            
            
            // replacing the hundred's and the unit's digits of the difference, in order to create a new number.
            firstNumberUnits = unitsDigit;
            reverseUnitsDigit = hundredsDigit;
            firstNumberHundreds = hundredsDigit*100;
            reverseHundredsDigit = unitsDigit*100;
            
            // Declaration and calculation of the new created reversed difference.
            int reverseDifference;
            reverseDifference = difference - firstNumberUnits + reverseUnitsDigit - firstNumberHundreds + reverseHundredsDigit;
            
            // Output print: reversed difference.
            System.out.println("Reversed difference: " + reverseDifference);
            
            // Checking if the "magic" worked, and printing the result.
            if (difference + reverseDifference == EINSTEIN_MAGIC_NUMBER)
                System.out.println("SUCCEEDED");
            else
                System.out.println("FAILED");
        }
    }// End of method main
}// End of class Einstein