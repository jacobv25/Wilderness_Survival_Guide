package edu.miracosta.finalprojecttest.model.enviroment;

/**
 * This class handles the weather calculations.
 *
 * At the moment only the temperature variance has been implemented (calcTemp(time : GameTime).
 *
 */
public class Weather {

    private static int temp;
    private int wind;
    private int fog;

    /**
     * Default constructor, in case no parameters are given
     */
    public Weather() {
        wind = 0;
        fog = 0;
    }

    /**
     * Full constructor, initializing variables based on the parameters given
     * @param wind - An integer for the wind within the area
     * @param fog - An integer for the fog in the area
     */
    public Weather(int wind, int fog) {
        this.wind = wind;
        this.fog = fog;
    }

    /**
     * The temperature is higher in the afternoon and evening, and cold at night.
     * All depends on the gameTime of day.
     * @param gameTime
     * @return
     */
    public static int calculateTemp(GameTime gameTime) {

        //The day gameTime is between: 00:00-04:59
        //                         0min - 299min
        if (gameTime.getDayTime() >= 0 && gameTime.getDayTime() <= 299) {
            temp = -10; //-10 deg fahrenheit
        }
        //The day gameTime is between: 05:00-05:59
        //                         300min - 359min
        else if (gameTime.getDayTime() >= 300 && gameTime.getDayTime() <= 359) {
            temp = -5; //-5 deg fahrenheit
        }
        //The day gameTime is between: 06:00-06:59
        //                         360min - 419min
        else if (gameTime.getDayTime() >= 360 && gameTime.getDayTime() <= 419) {
            temp = -0; //0 deg fahrenheit
        }
        //The day gameTime is between: 07:00-07:59
        //                         420min - 479min
        else if (gameTime.getDayTime() >= 420 && gameTime.getDayTime() <= 479) {
            temp = 5; //5 deg fahrenheit
        }
        //The day gameTime is between: 08:00-08:59
        //                         480min - 539min
        else if (gameTime.getDayTime() >= 480 && gameTime.getDayTime() <= 539) {
            temp = 10; //10 deg fahrenheit
        }
        //The day gameTime is between: 09:00-09:59
        //                         540 - 559
        else if (gameTime.getDayTime() >= 540 && gameTime.getDayTime() <= 599) {
            temp = 15; //15 deg fahrenheit
        }
        //The day gameTime is between: 10:00-10:59
        //                         600min - 659min
        else if (gameTime.getDayTime() >= 600 && gameTime.getDayTime() <= 659) {
            temp = 20; //20 deg fahrenheit
        }
        //The day gameTime is between: 11:00-11:59
        //                         660 - 719min
        else if (gameTime.getDayTime() >= 660 && gameTime.getDayTime() <= 719) {
            temp = 25; //25 deg fahrenheit
        }
        //The day gameTime is between: 12:00-12:59
        //                         720 - 779min
        else if (gameTime.getDayTime() >= 660 && gameTime.getDayTime() <= 779) {
            temp = 30; //30 deg fahrenheit
        }
        //The day gameTime is between: 13:00pm-14:59
        //                         780 - 899min
        else if (gameTime.getDayTime() >= 780 && gameTime.getDayTime() <= 899) {
            temp = 35; //35 deg fahrenheit
        }
        //The day gameTime is between: 15:00pm-18:59
        //                         900min - 1139min
        else if (gameTime.getDayTime() >= 900 && gameTime.getDayTime() <= 1139) {
            temp = 40; //40 deg fahrenheit
        }
        //The day gameTime is between: 19:00pm-20:59
        //                         1140min - 1259min
        else if (gameTime.getDayTime() >= 1140 && gameTime.getDayTime() <= 1259) {
            temp = 30; //30 deg fahrenheit
        }
        //The day gameTime is between: 21:00pm-23:59
        //                         1260min - 1439min
        else if (gameTime.getDayTime() >= 1260 && gameTime.getDayTime() <= 1439) {
            temp = 10; //10 deg fahrenheit
        }
        else {
            System.out.println("MAJOR ERROR IN THE calculateTemp method in the Weather class");
            System.out.println("Exiting program");
            System.exit(0);
        }
        return temp;

    }

    /**
     * A list of the variables and values within the Weather object.
     * @return A string containing the variables and their values of this Weather object
     */
    @Override
    public String toString() {
        return "Weather{" +
                "temp=" + temp +
                ", wind=" + wind +
                ", fog=" + fog +
                '}';
    }

    //////////Getters & Setters///////////
    /**
     * An accessor to get the integer within the variable temp
     * @return the integer within temp
     */
    public int getTemp() {
        return temp;
    }

    /**
     * An mutator write a string into the temp variable
     * @param temp an integer for the temp variable
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * An accessor to get the integer within the variable wind
     * @return the integer within wind
     */
    public int getWind() {
        return wind;
    }

    /**
     * An mutator write a string into the wind variable
     * @param wind an integer for the wind variable
     */
    public void setWind(int wind) {
        this.wind = wind;
    }

    /**
     * An accessor to get the integer within the variable fog
     * @return the integer within fog
     */
    public int getFog() {
        return fog;
    }

    /**
     * An mutator write a integer into the fog variable
     * @param fog an integer for the fog variable
     */
    public void setFog(int fog) {
        this.fog = fog;
    }
}
