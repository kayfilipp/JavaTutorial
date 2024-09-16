package src.First;
public class Temperature {
    public static void main(String[] args){
        UserInput input = new UserInput();

        while (!input.userEnterredValidValue && !input.userTerminatedSession){
            input.promptUserForFarenheit();
        }

        if (input.userEnterredValidValue){
            System.out.println(input.celciusValue);
        }
        
    }

    public static double convertFahrenheitToCelcius(double f){
        return (f - 32) * (5.0/9.0);
    }

}
