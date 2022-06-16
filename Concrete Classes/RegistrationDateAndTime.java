import java.time.LocalTime;
import java.time.LocalDate;


public class RegistrationDateAndTime {
    
    private String currentDateString;
    private String currentTimeString;
    private String month, day , year , hour , minute , second;

    public RegistrationDateAndTime() {
        // Taking local Data and Time from the System
        month = LocalDate.now().getMonth().toString();
        day = LocalDate.now().getDayOfMonth() + "";
        year = LocalDate.now().getYear() + "";
        hour = LocalTime.now().getHour() + "";
        minute = LocalTime.now().getMinute() + "";
        second = LocalTime.now().getSecond() + "";

        // Concatenating the local Data and Time
        currentDateString = month + " " + day + " " + year;
        if(LocalTime.now().getHour() > 12) {
            currentTimeString = (Integer.parseInt(hour) -12) +":"+ minute+ ":" + second + " PM";
        }
        else {
            currentTimeString = hour + minute + second + " AM";
        }
    }

    public String toString() {
        return "Registration Date : " + currentDateString + "\n" +
                "Registration Time : " + currentTimeString;
    }

    public static void main(String[] args) {
        RegistrationDateAndTime registrationDateAndTime = new RegistrationDateAndTime();
        System.out.println(registrationDateAndTime);
    }

}
