import java.time.LocalTime;
import java.util.Scanner;

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday implements Alarm {
    protected String time;

    @Override
    public void setAlarm(String time) {
        this.time = time;
    }
}

public class Monday extends Weekday {
    @Override
    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(time);
        LocalTime now = LocalTime.now();

        if (alarm.isAfter(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else {
            System.out.println("I'll wake you up later!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monday monday = new Monday();

        System.out.println("Enter time for alarm in this format (HH:MM): ");
        String inputTime = scanner.nextLine();

        monday.setAlarm(inputTime);
        monday.showAlarm();

        scanner.close();
    }
}
