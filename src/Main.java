import avatar.*;
import calendar.*;
import calendar.utils.*;
import java.util.*;
import java.time.*;
import java.lang.Throwable;

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
        Agenda overdues = new Agenda();

        // populate stand-in calendar
        ThingType r = ThingType.reminder;
        ThingType a = ThingType.appointment;
        ThingType t = ThingType.task;
        allTasks.addItem(r, 2, 22, 2021, "Sample Reminder");
        allTasks.addItem(a, 2, 23, 2021, "Sample Appointment");
        allTasks.addItem(t, 2, 24, 2021, "Sample Task");

        normalOperation(allTasks, overdues, francis, userInput);
        //debug();
    }

    // regular usage of application
    public static void normalOperation(Agenda allTasks, Agenda overdues, Plant francis, Scanner userInput){
        ArrayList<Thing> aList = allTasks.getThings();
        ArrayList<Thing> bList = overdues.getThings();
        LocalDate lastDay = LocalDate.now().minusDays(1);
        int dateMod = 0;
        boolean isBeenFed = false;
        boolean isPetted = false;
        System.out.println("For help, type \"help\"");
        while (true) {
            // Tasks to do without advancing the day --------------------------------------------------------------------------
            
            boolean isDoneWithDay = false;
            LocalDate today = LocalDate.now(); // Today's date
            today = today.plusDays(dateMod);
            LocalDate yesterday = today.minusDays(1);
            boolean isStreak = false;

            while (!isDoneWithDay) {
                System.out.print("---------------------- Command: ");
                String in = userInput.nextLine();
                if (in.indexOf("advance") != -1) {
                    isDoneWithDay = true;
                    dateMod++;
                } else if (in.indexOf("water") != -1) { // TODO change "water" per Tamagotchi type
                    if (!isBeenFed) {
                        francis.happinessUp(12);
                        isBeenFed = true;
                    } else { 
                        System.out.println(francis.getName() + " has already been watered today!");
                    }
                    System.out.println(francis);
                } else if (in.indexOf("pet") != -1 ) {// TODO change "pet" per Tamagotchi type
                    if (!isPetted) {
                        francis.happinessUp(12);
                        isPetted = true;
                    } else { 
                        System.out.println(francis.getName() + " has already been pet today!");
                    }
                    System.out.println(francis);
                } else if (in.indexOf("today") != -1 ) {
                    displayStats(allTasks, overdues, francis, userInput);
                } else if (in.indexOf("complete") == 0) {
                    francis.healthUp(markAsDone(in, allTasks, overdues));
                    francis.xpUp(10); // Basic XP implementation
                } else if (in.indexOf("add") == 0) {
                    addItem(in, allTasks, overdues);
                } else if (in.indexOf("help") == 0) {
                    helpList();
                }
            }

            // Advance Day and Proceed with Daily Task
            today = LocalDate.now().plusDays(dateMod);
            yesterday = today.minusDays(1);
            System.out.println("Today's Date: " + today);

            // Tasks to do after advancing the day --------------------------------------------------------------------------

            // add/subtract tamagotchi health once per day
            for (int i = 0; i < aList.size(); i++) { // search through all list items
                // check for overdue/incomplete assignments
                if (yesterday.isEqual(aList.get(i).getDate())) { // check if date objects are equaivalent
                    System.out.println("Overdue item(s)!");
                    if (aList.get(i) instanceof Reminder){
                        Reminder rem = (Reminder)(aList.get(i));
                        rem.printReminder();
                        aList.remove(i);
                    } else {
                        francis.healthDown(healthPenalty); // lower Tamagotchi's health
                        bList.add(aList.get(i));
                        aList.remove(i);
                    }
                }
                // check for assignments completed early
                if (!aList.isEmpty()) {
                    if (aList.get(i).getIsDone()) {
                        francis.healthUp(healthRegen);
                        aList.remove(i);
                    }
                }
            }

            // add/subtract tamagotchi happiness at end of day
            if (!lastDay.isEqual(today)) {
                francis.happinessDown(20);
                lastDay = today;
                isBeenFed = false;
                isPetted = false;
            }

            // Display end day state
            displayStats(allTasks, overdues, francis, userInput);
        }
    }

    private static void addItem(String userInput, Agenda allThings, Agenda overdues) {
        // add type YYYY MM DD name
        Scanner lineScan = new Scanner(userInput);
        lineScan.next();
        String thingT = "";
        int[] date = new int[3];
        int ind = 0;
        String name = "";
        while (lineScan.hasNext()) {
            String temp = lineScan.next();
            if (temp.equalsIgnoreCase("appointment") || temp.equalsIgnoreCase("task") || temp.equalsIgnoreCase("reminder")) {
                thingT = temp.toLowerCase();
            } else {
                throw new Error("Error: Incorrect command (add): incorrect ThingType parameter");
            }
            
            while (lineScan.hasNextInt() && ind < 3) {
                date[ind] = lineScan.nextInt();
                ind++;
            }
            if (date.length < 3) {
                throw new Error("Error: Incorrect command (add): incorrect date parameters");
            }
            name = lineScan.nextLine().substring(1);
        }
        ThingType t;
        switch (thingT) {
            case "appointment": 
            t = ThingType.appointment;
            case "reminder":
            t = ThingType.reminder;
            default: // else Task
            t = ThingType.task;
        }
        LocalDate tempLD = LocalDate.of(date[0], date[1], date[2]);
        if (tempLD.isBefore(LocalDate.now())) {
            overdues.addItem(t, date[1], date[2], date[0], name);
            System.out.println("Successfully added task to overdues");
        } else {
            allThings.addItem(t, date[1], date[2], date[0], name);
            System.out.println("Successfully added task to list");
        }
    }

    private static int markAsDone(String userInput, Agenda allThings, Agenda overdues) {
        // complete type YYYY MM DD name
        int ans = 0;
        Scanner lineScan = new Scanner(userInput);
        lineScan.next();
        String thingT = "";
        int[] date = new int[3];
        int ind = 0;
        String name = "";
        while (lineScan.hasNext()) {
            String temp = lineScan.next();
            if (temp.equalsIgnoreCase("appointment") || temp.equalsIgnoreCase("task") || temp.equalsIgnoreCase("reminder")) {
                thingT = temp.toLowerCase();
                if (!thingT.equals("reminder")) {
                    ans = healthRegen;
                }
            } else {
                throw new Error("Error: Incorrect command (add): incorrect ThingType parameter");
            }
            while (lineScan.hasNextInt() && ind < 3) {
                date[ind] = lineScan.nextInt();
                ind++;
            }
            if (date.length < 3) {
                throw new Error("Error: Incorrect command (add): incorrect date parameters");
            }
            name = lineScan.nextLine().substring(1);
        }
        ThingType t;
        switch (thingT) {
            case "appointment": 
            t = ThingType.appointment;
            case "reminder":
            t = ThingType.reminder;
            default: // else Task
            t = ThingType.task;
        }
        if (!allThings.delItem(t, date[1], date[2], date[0], name)) {
            overdues.delItem(t, date[1], date[2], date[0], name);
            ans -= 2;
        }
        System.out.println("Health increased by " + ans + "; Gained 10XP"); // XP values hard coded in :(
        return ans;
    }

    private static void helpList() {
        System.out.println("Add Thing format:\n\t add [Appointment/Task/Reminder] YYYY MM DD [name]");
        System.out.println("Complete Thing format:\n\t complete [Appointment/Task/Reminder] YYYY MM DD [name]");
        System.out.println("View Today's Items and Stats:\n\t today");
        System.out.println("Pet plant:\n\t pet");
        System.out.println("Water plant:\n\t water"); 
        System.out.println(); // Human care not supported. yet. :)
    }

    // Display Tamagotchi Stats
    private static void displayStats(Agenda allTasks, Agenda overdues, Plant francis, Scanner userInput) {
        System.out.println(francis);
        System.out.println("Overdue Tasks: \n" + overdues);
        System.out.println();
        System.out.println("Upcoming Tasks: \n" + allTasks);
        System.out.println("\n");
    }


    private static void debug() {
        String thingT = "";
        int[] date = new int[3];
        int ind = 0;
        String name = "";
        Scanner lineScan = new Scanner("add task 2021 03 05 Buy Milk");
        lineScan.next();
        while (lineScan.hasNext()) {
            String temp = lineScan.next();
            System.out.print(temp);
            if (temp.equalsIgnoreCase("appointment") || temp.equalsIgnoreCase("task") || temp.equalsIgnoreCase("reminder")) {
                thingT = temp.toLowerCase();
            } else {
                throw new Error("Error: Incorrect command (add): incorrect ThingType parameter");
            }
            while (lineScan.hasNextInt() && ind < 3) {
                date[ind] = lineScan.nextInt();
                ind++;
            }
            if (date.length < 3) {
                throw new Error("Error: Incorrect command (add): incorrect date parameters");
            }
            name = lineScan.nextLine();
        }
        for (int i = 0; i < date.length; i++) {
            System.out.println(date[i]);
        }
    }
}
