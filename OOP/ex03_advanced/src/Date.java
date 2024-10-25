import java.util.Scanner;

public class Date {
    Scanner input = new Scanner(System.in);
    private String day, month, year, time;

    //setters
    public void setDay(String day) {
        this.day = day;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setYear(String year) {
        this.year = year;
    }
    //getters
    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public String getTime() {
        return time;
    }
    public String getYear() {
        return year;
    }
    //methods
    public void enterInfo(){
        System.out.print("Enter the day of the order: "); day = input.nextLine();
        System.out.print("Enter the month of the order: "); month = input.nextLine();
        System.out.print("Enter the year of the order: "); year = input.nextLine();
        System.out.print("Enter the time of the order: "); time = input.nextLine();
    }
}
