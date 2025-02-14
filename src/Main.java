import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "C:\\Users\\USER02\\IdeaProjects\\Alarm-Clock\\src\\Audio\\why-so-serious-made-with-Voicemod.wav";

        while (alarmTime == null){
            try{
                System.out.print("Enter an alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime,formater);
                System.out.println("Alarm set for " + alarmTime);

            }catch (DateTimeException e){
                System.out.println("Invalid format. Please used (HH:mm:ss)");
            }
        }


        AlarmClock alarmClock = new AlarmClock(alarmTime,filePath,scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();


    }
}
