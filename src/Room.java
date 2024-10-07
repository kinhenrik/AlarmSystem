import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Room {

    private String location;
    private int numOfWindows;
    private boolean motionSensor;
    private boolean doorSensor;
    private boolean smokeSensor = true;

    public List<Sensor>listOfSensors = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Room(String location, int numOfWindows, boolean motionSensor, boolean doorSensor) {
        this.location = location;
        this.numOfWindows = numOfWindows;
        this.motionSensor = motionSensor;
        this.doorSensor = doorSensor;
        addSensorToRoom();
    }

    private void addSensorToRoom() {
        listOfSensors.add(new SmokeSensor(location, "Smoke Sensor"));
        for (int i = 0; i < numOfWindows; i++) {
            listOfSensors.add(new WindowSensor(location, "Window Sensor " + (i+1))); }
        if (motionSensor) {
            listOfSensors.add(new MotionSensor(location, "Motion Sensor")); }
        if (doorSensor) {
            listOfSensors.add(new DoorSensor(location, "Door Sensor")); }
    }

    public void createListOfSensors() {
        System.out.println("");
        System.out.println("--- Sensors in " + getLocation() + " ---");
        for (int i = 0; i < listOfSensors.size(); i++) {
            System.out.print((i+1) + ". " + listOfSensors.get(i).getSensorType());
            System.out.print(" " + (listOfSensors.get(i).isSensorActive() ? "[Active]" : "[Inactive]"));
            System.out.println(" " + (listOfSensors.get(i).isSensorTriggered() ? "[TRIGGERED]" : " "));
        }
        System.out.println((listOfSensors.size()+1) + ". Cancel");
        System.out.println("--------------------");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == listOfSensors.size()+1) {

        } else {
            choice = choice - 1;
            listOfSensors.get(choice).triggerSensor();
        }
    }

    public void listTriggeredSensors() {
        List<Sensor>listOfTriggeredSensors = new ArrayList<>();
        for (int i = 0; i < listOfSensors.size(); i++) {
            if (listOfSensors.get(i).isSensorTriggered()) {
                listOfTriggeredSensors.add(listOfSensors.get(i));
            }
        }
        for (int i = 0; i < listOfTriggeredSensors.size(); i++) {
            System.out.println("");
            System.out.println("--- SENSOR TRIGGERED ---");
            System.out.println("Location: [" + listOfTriggeredSensors.get(i).getSensorLocation() + "]");
            System.out.println("Sensor: [" + listOfTriggeredSensors.get(i).getSensorType() + "]");
            if (listOfTriggeredSensors.get(i).getSensorType().equals("Smoke Sensor")) {
                System.out.println("Sprinkler has been activated.");
            }
        }
    }

    public void activateSensors() {
        for (Sensor sensor : listOfSensors) {
            sensor.setSensorActive(true);
        }
    }

    public void deactivateSensors() {
        for (Sensor sensor : listOfSensors) {
            sensor.setSensorActive(false);
        }
    }

    public void simulateBurglary() {
        int randomSensor = random.nextInt(listOfSensors.size());
        if (!listOfSensors.get(randomSensor).sensorType.equals("Smoke Sensor")) {
            if (!listOfSensors.get(randomSensor).isSensorTriggered()) {
                listOfSensors.get(randomSensor).triggerSensor(); }
        } else {
            simulateBurglary();
        }
    }

    public void simulateFire() {
        int randomSensor = random.nextInt(listOfSensors.size());
        if (listOfSensors.get(randomSensor).getSensorType().equals("Smoke Sensor")) {
            if (!listOfSensors.get(randomSensor).isSensorTriggered()) {
                listOfSensors.get(randomSensor).triggerSensor(); }
        } else {
            simulateFire();
        }
    }

    public void simulateRandom() {
        Random random = new Random();
        int randomSensor = random.nextInt(listOfSensors.size());
        if (!listOfSensors.get(randomSensor).isSensorTriggered()) {
            listOfSensors.get(randomSensor).triggerSensor();
        } else {
            simulateRandom();
        }
    }

    //Getters & Setters
    public String getLocation() {
        return location;
    } public void setLocation(String location) {
        this.location = location; }

    public int getNumOfWindows() {
        return numOfWindows;
    } public void setNumOfWindows(int numOfWindows) {
        this.numOfWindows = numOfWindows; }

    public boolean hasMotionSensor() {
        return motionSensor;
    } public void setMotionSensor(boolean motionSensor) {
        this.motionSensor = motionSensor; }

    public boolean hasDoorSensor() {
        return doorSensor;
    } public void setDoorSensor(boolean doorSensor) {
        this.doorSensor = doorSensor; }

    public boolean hasSmokeSensor() {
        return smokeSensor;
    } public void setSmokeSensor(boolean smokeSensor) {
        this.smokeSensor = smokeSensor; }
}
