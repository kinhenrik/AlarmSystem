public class Main {
    public static void main(String[] args) {

        CentralUnit centralUnit = new CentralUnit(1);

        Room poolArea = new Room("Pool area", 0, true, false);
        Room garage = new Room("Garage", 1, false, true);
        Room livingRoom = new Room("Living room", 2, true, false);
        Room kitchen = new Room("Kitchen", 1, false, false);
        Room bedroom1 = new Room("Erlichs room", 2, false, false);
        Room bedroom2 = new Room("Jians room", 1, true, true);
        Room bedroom3 = new Room("Richards room", 1, false, false);
        Room bedroom4 = new Room("Bertrams room", 2, false, false);
        Room bedroom5 = new Room("Dinesh's room", 1, false, false);
        Room hallway = new Room("Hallway", 1, true, true);

        centralUnit.addRoom(poolArea);
        centralUnit.addRoom(garage);
        centralUnit.addRoom(livingRoom);
        centralUnit.addRoom(kitchen);
        centralUnit.addRoom(bedroom1);
        centralUnit.addRoom(bedroom2);
        centralUnit.addRoom(bedroom3);
        centralUnit.addRoom(bedroom4);
        centralUnit.addRoom(bedroom5);
        centralUnit.addRoom(hallway);

        centralUnit.unitMenu();

    }
}