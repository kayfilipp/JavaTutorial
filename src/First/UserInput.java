package src.First;
import java.util.Scanner;
import java.util.*; 

public class UserInput {
    
    boolean userEnterredValidValue = false;
    boolean userTerminatedSession  = false;
    double[] fahrenheitValues;
    double[] celciusValues;

    public static void main(String[] args){}
    public UserInput(){}


    public void promptUserForFahrenheitTemperatures(){
        /* 
         * Scan user input on loop until we either get a legitimate list of comma separated doubles or until
         * the user gives up. Store valid output to fahrenheitValues.
         * Handles empty responses.
         * Run this before running convertFarenheitTemperaturesToCelcius() or you'll get an error.
        */
        
        Scanner in = new Scanner(System.in); 

        while(!userEnterredValidValue && !userTerminatedSession){
            System.out.println("Please enter temperatures in Fahrenheit, separated by commas:");
            String userInput;

            try{
                
                in = new Scanner(System.in);
                userInput = in.nextLine();

            }catch(java.util.NoSuchElementException e){

                System.out.println("bye :3");
                userTerminatedSession = true;
                continue;

            }
            
            double[] userFahrenheitTemperatures = getListOfUserFahrenheitTemperatues(userInput);
            
            int n = userFahrenheitTemperatures.length;
            double status = userFahrenheitTemperatures[n-1];

            if (status == 0){

                userEnterredValidValue = true;
                fahrenheitValues = Arrays.copyOf(userFahrenheitTemperatures, n-1);
                continue;
            }

            if (status == 1){
                System.out.println("It looks like you haven't entered anything! You can press CTRL+Z to exit on windows, or try again.");
            }

            if (status == -1){
                System.out.println("Unable to convert all values. Please only enter numbers like 23, 12.3, and -0.2.");
            }
        }

        in.close();
    }

    public void convertFarenheitTemperaturesToCelcius(){
        int n = fahrenheitValues.length;
        double[] fahrenheitToCelciusValues = new double[n];

        for (int i = 0; i < fahrenheitValues.length; i++){
            fahrenheitToCelciusValues[i] = Temperature.convertFahrenheitToCelcius(
                fahrenheitValues[i]
            );
        }

        celciusValues = fahrenheitToCelciusValues;
    }


    private static double[] getListOfUserFahrenheitTemperatues(String userInput){
        /*
         * returns a list of parsed temperatures in farenheit 
         * status codes accessible at the end of the array.
         * 0 = success
         *-1 = unable to properly parse at least one value 
         * 1 = array is empty.
         */

        String[] commaSeparatedUserInputs = userInput.split(",", -1);
        int n = commaSeparatedUserInputs.length;
        double[] fahrenheitValues = new double[n+1]; //extra space to account for status code

        // early exit if the user provides nothing
        if (userInput.length() == 0){
            fahrenheitValues[n] = 1;
            return fahrenheitValues;
        }

        for (int i = 0; i < commaSeparatedUserInputs.length; i++){

            try {
                double tempValue = Double.parseDouble(commaSeparatedUserInputs[i]);
                fahrenheitValues[i] = tempValue;
            } catch (java.lang.NumberFormatException e){
                fahrenheitValues[n] = -1;
                return fahrenheitValues;
            }

        }

        fahrenheitValues[n] = 0;
        return fahrenheitValues;

    }

}
