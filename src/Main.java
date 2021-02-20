import avatar.*;
import calendar.*;

import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        // create a tamagotchi
        Plant francis = new Plant();

        // calendar integrations needed
        // temporary stand-in calendar for demonstration purposes
        Agenda allTasks = new Agenda();


        ArrayList<Thing> = new ArrayList<Thing>();

        // populate stand-in calendar
        // TODO

        // create list of all assignments
        // TODO
        LocalDate date = LocalDate.now(); // Today's date
        LocalDate date1 = date.minusDays(1);
        System.out.println(date1);


    }

    // regular usage of application
    public static void normalOperation(Agenda allTasks, Plant francis){
        ArrayList<Thing> aList = allTasks.getTasks();
        while (true) {
            LocalDate date = LocalDate.now(); // Today's date
            date = date.minusDays(1);
            for (int i = 0; i < aList.size(); i++) { // search through all list items
                if (date.equals(aList.get(i).getDate())) { // check if date objects are equaivalent
                    francis.healthDown(missedAssignmentPenalty); // lower Tamagotchi's health
                }
            }
        }
    }
}
