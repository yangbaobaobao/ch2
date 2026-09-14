import java.util.*;
class Date {
	public static String day;
	public static int date;
	public static String month;
	public static int year;
    public static void main(String[] args) {
		day = "Monday";
		month = "Steptember";
		year = 2026;
		date = 14;
        System.out.println("American format: " + day + ", " + month + " " + date + ", " + year);
        System.out.println("European format: " + day +  " " + date + " " + month + " " + year);
    }
}
