import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CentralUnit {
    //Parameters
    private boolean systemOn = true;
    private boolean sensorsOn = false;
    private final int CODE = 1;
    private boolean access;

    //Constructor
    public CentralUnit() {}

    //Imports
    Scanner scanner = new Scanner(System.in);
    List<Room>roomList = new ArrayList<>();

    //Methods
    public void unitMenu() {
        while (systemOn) {
            String sensorStatus = (sensorsOn) ? "[on]/off" : "on/[off]";
            System.out.println("");
            System.out.println("--- CENTRAL UNIT ---");
            showTriggeredSensors();
            System.out.println("");
            System.out.println("1. Sensors " + sensorStatus);
            System.out.println("2. Reset alarm");
            System.out.println("3. List of rooms");
            System.out.println("4. Simulate");
            System.out.println("5. Quit");
            System.out.println("--------------------");
            System.out.print("Enter your choice: ");

            switch (scanner.nextInt()) {
                case 1:
                    askForCode();
                    if (access) {
                        turnSensorOnOff();
                    } else {
                        unitMenu();
                    }
                    break;
                case 2:
                    askForCode();
                    if (access) {
                        resetAllSensors();
                    } else {
                        unitMenu();
                    }
                    break;
                case 3:
                    createListOfRooms();
                    break;
                case 4:
                    simulateMenu();
                    break;
                case 5:
                    System.out.println("Shutting down...");
                    systemOn = false;
                    break;
            }
        }
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    private void askForCode() {
        System.out.println("");
        System.out.print("Enter code: ");
        int input = scanner.nextInt();
        if (input == CODE) {
            access = true;
        } else {
            access = false;
        }
    }

    private void showTriggeredSensors() {
        for (Room room : roomList) {
            room.listTriggeredSensors();
        }
    }

    private void turnSensorOnOff() {
        if (sensorsOn) {
            sensorsOn = false;
            for (int i = 0; i < roomList.size(); i++) {
                roomList.get(i).deactivateSensors();
            }
            System.out.println("All sensors turning off...");
        } else {
            sensorsOn = true;
            for (int i = 0; i < roomList.size(); i++) {
                roomList.get(i).activateSensors();
            }
            System.out.println("All sensors turning on...");
        }
    }

    private void resetAllSensors() {
        for (Room room : roomList) {
            for (int i = 0; i < room.listOfSensors.size(); i++) {
                if (room.listOfSensors.get(i).isSensorTriggered()) {
                    room.listOfSensors.get(i).resetSensor();
                }
            }
        }
    }

    private void createListOfRooms() {
        System.out.println("");
        System.out.println("--- List of rooms ---");
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println((i+1) + ". " + roomList.get(i).getLocation());
        }
        System.out.println((roomList.size()+1) + ". Exit to main menu");
        System.out.println("--------------------");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == (roomList.size() + 1)) {
            unitMenu();
        } else {
            choice = choice - 1;
            roomList.get(choice).createListOfSensors();
        }
    }

    private void simulateMenu() {
        Random random = new Random();
        System.out.println("");
        System.out.println("--- Type of simulation ---");
        System.out.println("1. Burglary");
        System.out.println("2. Fire");
        System.out.println("3. Random");
        System.out.println("4. Cancel");
        System.out.println("--------------------");
        System.out.print("Enter your choice: ");

        switch (scanner.nextInt()) {
            case 1:
                roomList.get(random.nextInt(roomList.size())).simulateBurglary();
                break;
            case 2:
                roomList.get(random.nextInt(roomList.size())).simulateFire();
                break;
            case 3:
                roomList.get(random.nextInt(roomList.size())).simulateRandom();
                break;
            case 4:
        }
    }


}
