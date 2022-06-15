import java.time.LocalTime;
import java.time.LocalDate;


public class RegistrationDateAndTime {
    
    private String currentDateString;
    private String currentTimeString;

    public RegistrationDateAndTime() {
        // Taking local Data and Time from the System

        currentDateString = "" + LocalDate.now().getMonth() + "/" + LocalDate.now().getDayOfMonth() + "/"
                + LocalDate.now().getYear();

        if(LocalTime.now().getHour() > 12) {
            currentTimeString = "" + (LocalTime.now().getHour() - 12) + ":" + LocalTime.now().getMinute() + " PM";
        }
        else {
            currentTimeString = "" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + " AM";
        }
    }

    public String toString() {
        return  "Registration Date : " + currentDateString + "\n" +
                "Registration Time : " + currentTimeString;
    }


}
