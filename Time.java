
import java.util.*;
class Time {
	public static int hours;
	public static int minutes;
	public static int seconds;
	
	public static int currentTime = 60 * 60 * 16;
    public static void main(String[] args) {
		hours = 14;
		minutes = 45;
		seconds = 15;
		int secondsSinceMidnight = hours * 3600 + minutes * 60 + seconds;
		double percentagePassed = ((double)secondsSinceMidnight)/(24 * 3600);
        System.out.println("Amount of seconds since midnight: " + secondsSinceMidnight);
        System.out.println("Percentage of day: " + percentagePassed * 100 + "%");
        int timeDifference = (currentTime - secondsSinceMidnight);
        System.out.println("Time since creation: " + (timeDifference/3600) + " hours " + ((timeDifference%3600)/60) + " minutes " + ((timeDifference%3600)%60) + " seconds ");
    }
}
