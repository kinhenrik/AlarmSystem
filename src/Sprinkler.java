public class Sprinkler extends Sensor{

    public Sprinkler(String sensorLocation, String sensorType) {
        super(sensorLocation, sensorType);
        this.sensorActive = true;
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

    /*
    public void activateSprinkler() {
        triggerSensor();
        System.out.println("[Sprinkler] in [" + sensorLocation + "] has been triggered!");
    }*/
}
