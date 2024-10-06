public class DoorSensor extends Sensor {

    public DoorSensor(String sensorLocation, String sensorType) {
        super(sensorLocation, sensorType);
    }

    @Override
    public void triggerSensor() {
        if (sensorActive) {
            sensorTriggered = true;
            System.out.println("[" + sensorType + "] in [" + sensorLocation + "] has been triggered!");
        } else {
            System.out.println("Inactive sensors can't be triggered.");
        }
    }
}
