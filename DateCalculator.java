
import java.util.Scanner;

public class DateCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first date (day month year):");
        int day1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int year1 = scanner.nextInt();

        System.out.println("Enter the second date (day month year):");
        int day2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int year2 = scanner.nextInt();

        scanner.close();

        if (isValidDate(day1, month1, year1) && isValidDate(day2, month2, year2)) {
            long daysBetween = calculateDaysBetween(day1, month1, year1, day2, month2, year2);
            System.out.println("The number of days between the two dates is: " + daysBetween);
        } else {
            System.out.println("Invalid date input. Please enter valid dates.");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int daysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return daysInMonth[month];
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    public static long calculateDaysBetween(int day1, int month1, int year1, int day2, int month2, int year2) {
        long daysBetween = 0;

        if (year1 == year2) {
            if (month1 == month2) {
                daysBetween = day2 - day1;
            } else {
                for (int month = month1; month < month2; month++) {
                    daysBetween += daysInMonth(month, year1);
                }
                daysBetween += day2 - day1;
            }
        } else {
            for (int year = year1; year < year2; year++) {
                if (year == year1) {
                    for (int month = month1; month <= 12; month++) {
                        daysBetween += daysInMonth(month, year1);
                    }
                } else if (year == year2) {
                    for (int month = 1; month < month2; month++) {
                        daysBetween += daysInMonth(month, year2);
                    }
                } else {
                    daysBetween += isLeapYear(year) ? 366 : 365;
                }
            }
            daysBetween += day2 - day1;
        }

        return daysBetween;
    }
}
