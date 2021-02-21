import avatar.*;
import calendar.*;
import calendar.utils.*;

import java.util.*;
import java.time.*;

public class Main {
    // class variables
    private static int healthPenalty = 12;
    private static int healthRegen = 4;
    
    //main
    public static void main(String[] args) {
        // Scanner for user input
        Scanner userInput = new Scanner(System.in);

        // create a tamagotchi
        Plant francis = new Plant();

        // calendar integrations needed
        // temporary stand-in calendar for demonstration purposes
        Agenda allTasks = new Agenda();

        // populate stand-in calendar
        ThingType r = ThingType.reminder;
        allTasks.addItem(r, 2, 22, 2021, "Sample Reminder");

        normalOperation(allTasks, francis, userInput);
    }

    // regular usage of application
    public static void normalOperation(Agenda allTasks, Plant francis, Scanner userInput){
        ArrayList<Thing> aList = allTasks.getThings();
        LocalDate lastDay = LocalDate.now();
        int dateMod = 0;
        boolean isBeenFed = false;
        boolean isPetted = false;
        while (true) {
            boolean valid = false;
            while (!valid) {
                String in = userInput.next();
                if (in.indexOf("advance") != -1) {
                    valid = true;
                    dateMod++;
                } else if (in.indexOf("water") != -1) { // TODO change "water" per Tamagotchi type
                    valid = true;
                    if (!isBeenFed) {
                        francis.happinessUp(10);
                        isBeenFed = true;
                    } else { 
                        System.out.println(francis.getName() + " has already been fed today!");
                    }
                } else if (in.indexOf("pet") != -1 ) {// TODO change "pet" per Tamagotchi type
                    valid = true;
                    if (!isPetted) {
                        francis.happinessUp(10);
                        isPetted = true;
                    } else { 
                        System.out.println(francis.getName() + " has already been pet today!");
                    }
                } else if (in.indexOf("today") != -1 ) {
                    valid = true;
                }
            }

            LocalDate today = LocalDate.now(); // Today's date
            LocalDate yesterday = today.minusDays(1);
            today = today.plusDays(dateMod);

            // add/subtract tamagotchi health once per day
            for (int i = 0; i < aList.size(); i++) { // search through all list items
                // check for overdue/incomplete assignments
                if (yesterday.equals(aList.get(i).getDate())) { // check if date objects are equaivalent
                    if (aList.get(i) instanceof Reminder){
                        Reminder rem = (Reminder)(aList.get(i));
                        rem.printReminder();
                        aList.remove(i);
                    } else {
                        francis.healthDown(healthPenalty); // lower Tamagotchi's health
                        aList.remove(i);
                    }
                }
                // check for assignments completed early
                if (aList.get(i).getIsDone()) {
                    francis.healthUp(healthRegen);
                    aList.remove(i);
                }
            }

            // add/subtract tamagotchi happiness at end of day
            if (lastDay.equals(today)) {
                francis.happinessDown(20);
                lastDay = today;
            }

            // display tamagotchi stats
            System.out.println(francis);
            System.out.println(allTasks);
        }
    }
}
