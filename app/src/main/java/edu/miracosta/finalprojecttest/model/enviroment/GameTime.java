package edu.miracosta.finalprojecttest.model.enviroment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class handles all total running time in the game and the
 * in game day/night time.
 */
public class GameTime implements Parcelable {

    public static final int PASS_LRG = 30; //30 minutes passing in game
    public static final int PASS_MED= 15; //15 minutes passing in game
    public static final int PASS_SML = 5; //5 minutes passing in game
    public static final int MAX_DAY_MINUTES = 1440; // (24 hours) * (60 minutes) = 1440 minutes in a day
    public static final int DEFAULT_START_TIME = 360; // game by default starts at 06:00

    public static int GLOBAL_DAY_TIME;
    public static int GLOBAL_TOTAL_TIME;

    private int totalTime;
    private int dayTime;

    //We may need String versions of the time
    private String dayTimeFormatted;
    private String totalTimeFormatted;

    /**
     * Sets total time to 00:00
     * and sets day time to 00:00 (midnight).
     */
    public GameTime() {
        this.totalTime = 0;
        this.dayTime = 0;

        GLOBAL_DAY_TIME = this.dayTime;
        GLOBAL_TOTAL_TIME = this.totalTime;
    }

    /**
     * A full constructor used to create an object with specific parameters passed in
     * @param totalTime - Total running time of the game
     * @param dayTime - The time within the game
     */
    public GameTime(int totalTime, int dayTime) {
        this.totalTime = totalTime;
        this.dayTime = dayTime;

        GLOBAL_TOTAL_TIME = totalTime;
        GLOBAL_DAY_TIME = dayTime;
    }

    /**
     * An method to get the time displayed
     * @return dayTimeFormatted, a string setting the time in a specific format
     */
    public String getDayTimeFormatted() {
        int t = dayTime;
        int hours = t / 60; //since both are ints, you get an int
        int minutes = t % 60;
        dayTimeFormatted = String.format("%d:%02d", hours, minutes);

        return dayTimeFormatted;
    }

    /**
     * An accessor to get the total time displayed
     * @return totalTimeFormatted, a string setting the total time in a specific format
     */
    public String getTotalTimeFormatted() {

        int days = totalTime/(24*60);
        int hours = (totalTime%(24*60)) / 60;
        int minutes = (totalTime%(24*60)) % 60;



        totalTimeFormatted = days + " Days : " + hours + " Hours : " + minutes + " Minutes";

        return totalTimeFormatted;
    }

    /**
     * Increments the total time and day time by the default value (30 minutes).
     */
    public void passTime(int time) {

        totalTime += time;
        dayTime += time;

        GLOBAL_DAY_TIME = dayTime;
        GLOBAL_TOTAL_TIME = totalTime;

        resetDayTime();
    }

    /**
     * If the day time exceeds the max time,
     * then set the daytime to itself minus the default MAX_DAY_MINUTES value (1440).
     * This SHOULD reset the day time to 00:00.
     */
    public void resetDayTime() {

        if (dayTime >= MAX_DAY_MINUTES) {

            dayTime = dayTime - MAX_DAY_MINUTES;

            GLOBAL_DAY_TIME = dayTime - MAX_DAY_MINUTES;
        }
    }

    /**
     * A list of the variables and values within the GameTime object.
     * @return A string containing the variables and their values of this GameTime object
     */
    @Override
    public String toString() {
        return "GameTime{" +
                "totalTime=" + totalTime +
                ", dayTime=" + dayTime +
                '}';
    }

    //////////GETTERS & SETTERS//////////

    /**
     * An accessor to get the integer within the variable totalTime
     * @return the integer within totalTime
     */
    public int getTotalTime() {
        return totalTime;
    }

    /**
     * An mutator write a integer into the totalTime variable
     * @param totalTime an integer for the totalTime variable
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * An accessor to get the integer within the variable dayTime
     * @return the integer within dayTime
     */
    public int getDayTime() {
        return dayTime;
    }

    /**
     * An mutator write a integer into the dayTime variable
     * @param dayTime an integer for the dayTime variable
     */
    public void setDayTime(int dayTime) {
        this.dayTime = dayTime;
    }

    /**
     * Describes the contents of the Gametime object
     * @return an integer
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * A way to access the campFire object as a parcelable object
     * @param dest where the parcelable information is being sent to
     * @param flags determines how the object should be written
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalTime);
        dest.writeInt(dayTime);
    }

    /**
     * Retrieves a parcelable object and turns it into a GameTime object using a constructor
     * @param parcel The object used for the GameTime object
     */
    private GameTime(Parcel parcel) {
        totalTime = parcel.readInt();
        dayTime = parcel.readInt();
    }

    /**
     * Used to create a CREATOR object using GameTime, able to utilize the Parcel object
     */
    public static final Parcelable.Creator<GameTime> CREATOR = new Creator<GameTime>() {
        /**
         * Creates a new GameTime object based on the Parcelable object passed in
         * @param source the object used to create the parcelable object
         * @return the GameTime object made from the source
         */
        @Override
        public GameTime createFromParcel(Parcel source) {
            return new GameTime(source);
        }

        /**
         * Creates a new GameTime object array
         * @param size the size of the array
         * @return the GameTime array made from the method
         */
        @Override
        public GameTime[] newArray(int size) {
            return new GameTime[size];
        }
    };
}
