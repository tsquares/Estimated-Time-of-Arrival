import avatar.*;
import calendar.*;

import java.util.*;
import java.time.*;

public class Main {
    // class variables
    private static int healthIncrement = 10;
    
    //main
    public static void main(String[] args) {
        // create a tamagotchi
        Plant francis = new Plant();

        // calendar integrations needed
        // temporary stand-in calendar for demonstration purposes
        Agenda allTasks = new Agenda();

        // populate stand-in calendar
        // TODO
    }

    // regular usage of application
    public static void normalOperation(Agenda allTasks, Plant francis){
        ArrayList<Thing> aList = allTasks.getThings();
        LocalDate lastDay = LocalDate.now();
        while (true) {
            LocalDate today = LocalDate.now(); // Today's date
            LocalDate yesterday = today.minusDays(1);
            // add/subtract tamagotchi health
            for (int i = 0; i < aList.size(); i++) { // search through all list items
                // check for overdue/incomplete assignments
                if (yesterday.equals(aList.get(i).getDate())) { // check if date objects are equaivalent
                    francis.healthDown(healthIncrement); // lower Tamagotchi's health
                    aList.remove(i);
                }
                // check for assignments completed early
                if (aList.get(i).getIsDone()) {
                    francis.healthUp(healthIncrement);
                    aList.remove(i);
                }
            }
            // add/subtract tamagotchi happiness
            if (lastDay.equals(today)) {
                francis.happinessDown(20);
                lastDay = today;
            }
        }
    }
}
