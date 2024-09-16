package src.First;
import java.util.Scanner;

public class UserInput {
    
    boolean userEnterredValidValue = false;
    boolean userTerminatedSession  = false;
    double celciusValue = 0.0;

    public static void main(String[] args){

    }

    public UserInput(){
        //...
    }

    public void promptUserForFarenheit(){

        try {

            System.out.println("Please enter a temperature in Farenheit:");
            Scanner in = new Scanner(System.in);

            double userDoubleValue = in.nextDouble();
            double celcius = Temperature.convertFahrenheitToCelcius(userDoubleValue);

            celciusValue = celcius;
            in.close();

            userEnterredValidValue = true;
            userTerminatedSession = false;

        } catch (java.util.InputMismatchException e) {

            System.out.println("Please enter a number with decimal points or the negative symbol only.");
            userEnterredValidValue = false;

        } catch (java.util.NoSuchElementException e) {

            userTerminatedSession = true;
            
        }
    }

}
