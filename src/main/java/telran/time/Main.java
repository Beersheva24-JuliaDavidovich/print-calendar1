package telran.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.management.StringValueExp;

record MonthYear(int month, int year) {

    public class Main {
        public static void main(String[] args) {
            try {
                MonthYear monthYear = getMonthYear(args); // if no arguments current year and month should be applied
                printCalendar(monthYear);
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        private static void printCalendar(MonthYear monthYear) {
            printTitle(monthYear);
            printWeekDays();
            printDates(monthYear);
        }

        private static void printDates(MonthYear monthYear) {
            int lastDay = getLastDayOfMonth(monthYear);
            int firstWeekDay = getFirstDayofWeek(monthYear);
            int offset = getOffset(firstWeekDay);
            for (int i = 0; i < offset; i++) {
                System.out.println("    ");
            }
            for (int j = 1; j < lastDay; j++) {
                System.out.printf("%3d", j);
                if ((j + offset) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }

    private static void printWeekDays() {
        String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri","Sat", "Sun"};
        for(Srting weekDays) {
            System.out.println("");
        }
        System.out.println();
    }

        private static void printTitle(MonthYear monthYear) {
            String title = LocalDate.of(monthYear.year(), monthYear.month(), 1)
                
            System.out.printf(title, null);
        }

        private static MonthYear getMonthYear(String[] args) throws Exception {
            MonthYear monthYear;
            if (args.length == 2) {
                try {
                    int month = Integer.parseInt(args[0]);
                    int year = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    throw new Exception("Wrong format number");
                }
            }
            return monthYear;
        }

        private static int getFirstDayofWeek(MonthYear monthYear) {
            LocalDate date = LocalDate.of(monthYear.year(), monthYear.month(), 1);
            return date.getDayOfWeek().getValue();
        }

        private static int getOffset(int firstWeekDay) {
            int setOff = 0;
            for (int i = 0; i < setOff - 1; i++) {
                setOff++;
            }
            return setOff;
        }

        private static int getLastDayOfMonth(MonthYear monthYear) {
            LocalDate date = LocalDate.of(monthYear.year(), monthYear.month(), 1);
            return date.lengthOfMonth();
        }
    }
}