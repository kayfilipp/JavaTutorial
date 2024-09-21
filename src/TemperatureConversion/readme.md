# Temperature Conversion App

```
Really not much going on.
Entry point through App.py prompts the user to enter csv fahrenheit values.
This repeats until:
    the user enters a legitimate set of values:
    1. each value must be a double (includes only numbers, decimal points, and positive/negative signs) -> 10, -2.3, 0, 37.5
    2. no value may contain any alphabetical characters

    OR 

    the user hits CTRL+Z and gives up on the session.

```

legitimate fahrenheit values are stored in the `UserInput` class after `promptUserForFahrenheitTemperatures()` is run, and can be converted by the user 
to celcius by calling `convertFarenheitTemperaturesToCelcius()`.