package edu.miracosta.finalprojecttest.model.enviroment;

import android.os.Parcel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTimeTest {

    private GameTime gameTimeTest;
    @Before
    public void setUp() throws Exception {
        gameTimeTest = new GameTime(100, 1440);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDayTimeFormatted() {
        assertEquals("Testing getDayTimeFormatted", "24:00", gameTimeTest.getDayTimeFormatted());
    }

    @Test
    public void getTotalTimeFormatted() {

        assertEquals("Testing getTotalTimeFormatted", "0 Days : 1 Hours : 40 Minutes", gameTimeTest.getTotalTimeFormatted());
    }

    @Test
    public void passTime() {
        gameTimeTest.passTime(10);
        assertEquals("Testing dayTime in passTime", 10, gameTimeTest.getDayTime());
        assertEquals("Testing totalTime in passTime", 110, gameTimeTest.getTotalTime());
    }

    @Test
    public void resetDayTime() {
        gameTimeTest.resetDayTime();
        assertEquals("Testing resetDayTime", 0, gameTimeTest.getDayTime());
    }

    @Test
    public void testToString() {
        String expected = "GameTime{" +
                "totalTime=" + 100 +
                ", dayTime=" + 1440 +
                '}';
        assertEquals("Testing toString", expected, gameTimeTest.toString());
    }

    @Test
    public void getTotalTime() {
        assertEquals("Testing getTotalTime method", 100, gameTimeTest.getTotalTime());
    }

    @Test
    public void setTotalTime() {
        gameTimeTest.setTotalTime(200);
        assertEquals("Testing setTotalTime method", 200, gameTimeTest.getTotalTime());
    }

    @Test
    public void getDayTime() {
        assertEquals("Testing getDayTime", 1440, gameTimeTest.getDayTime());
    }

    @Test
    public void setDayTime() {
        gameTimeTest.setDayTime(20);
        assertEquals("Testing getDayTime", 20, gameTimeTest.getDayTime());
    }

    @Test
    public void describeContents() {
        assertEquals("Testing describeContents", 0 , gameTimeTest.describeContents());
    }

    //Not sure how the JUnit test works for this one

    @Test
    public void writeToParcel() {
        GameTime test = new GameTime();
        Parcel parcel = Parcel.obtain();
        test.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        GameTime createdFromParcel = GameTime.CREATOR.createFromParcel(parcel);
        assertEquals(test, createdFromParcel);
    }

}