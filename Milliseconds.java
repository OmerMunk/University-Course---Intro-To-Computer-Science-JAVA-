import java.util.Scanner;
/**
 * <h1><strong>Class Milliseconds</strong></h1><br/>
 * This program gets an integer that represent an amount<br/>
 * of milliseconds, converts it to the number<br/>
 * of days, hours, minutes, and second that equals<br/>
 * to the amount of milliseconds, and then prints it. <br/><br/>
 * @since 06/2021
 * @verstion 1
 * @author <em>Omer Munk</em>
 */ 
public class Milliseconds
{
    public static void main(String [] args)
    {
        // Declaration of variables
        // Setting the final variables for the calculations
        final long MILLISECONDS_IN_DAY = 86400000;
        final long MILLISECONDS_IN_HOUR = 3600000;
        final long MILLISECONDS_IN_MINUTE = 60000;
        final long MILLISECONDS_IN_SECOND = 1000;

        // Declaring variables for the output
        long days;
        long hours;
        long minutes;
        long seconds;

        // Explanation and instructions for the user.
        System.out.println("This program reads an integer which " +
            "represents Milliseconds and convert it to days," +
            "hours, minutes, seconds. ");

        // Get an input from the user: amount of milliseconds.       
        System.out.println("Please enter the number of Milliseconds");
        Scanner scan = new Scanner (System.in);
        long ms = scan.nextLong(); 

        // Calculates the amount of days in the milliseconds input.
        days = ms / MILLISECONDS_IN_DAY; 

        // Reduces the amount of days in milliseconds terms, in order to calculate the amount of hours.
        ms -= MILLISECONDS_IN_DAY*days; 

        // Calculates the amount of hours in the milliseconds input.
        hours = ms / MILLISECONDS_IN_HOUR; 

        // Reduces the amount of hours in milliseconds terms, in order to calculate the amount of minutes.
        ms -= MILLISECONDS_IN_HOUR*hours; 

        // Calculates the amount of minutes in the milliseconds input.
        minutes = ms / MILLISECONDS_IN_MINUTE; 

        // Reduces the amount of minutes in milliseconds terms, in order to calculate the amount of seconds.
        ms -= MILLISECONDS_IN_MINUTE*minutes; 

        // Calculates the amount of seconds in the milliseconds input.
        seconds = ms / MILLISECONDS_IN_SECOND; 

        // Printing the result that was calculated according to the input.
        System.out.println (days + " days " + hours+":"+minutes+":"+seconds+" hours");

    } //end of method main
} // end of class Milliseconds