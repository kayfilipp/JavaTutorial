package src.TemperatureConversion;
import java.util.*; 

public class App {
    public static void main(String[] args){
        UserInput input = new UserInput();
        input.promptUserForFahrenheitTemperatures();

        if (input.fahrenheitValues != null){
            input.convertFarenheitTemperaturesToCelcius();
            System.out.println(Arrays.toString(input.fahrenheitValues));
            System.out.println(Arrays.toString((input.celciusValues)));
        }
    }
}
