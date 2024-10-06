public class SmokeSensor extends Sensor{

    public SmokeSensor(String sensorLocation, String sensorType) {
        super(sensorLocation, sensorType);
        this.sensorActive = true;
    }

    @Override
    public void setSensorActive(boolean sensorActive) {
        super.setSensorActive(true);
    }

    @Override
    public void triggerSensor() {
        if (sensorActive) {
            Sprinkler sprinkler = new Sprinkler(sensorLocation, sensorType);
            sensorTriggered = true;
            System.out.println("[" + sensorType + "] in [" + sensorLocation + "] has been triggered!");
            sprinkler.activateSprinkler();
        } else {
            System.out.println("Inactive sensors can't be triggered.");
        }
    }

    @Override
    public void resetSensor() {
        super.resetSensor();
        System.out.println("[Sprinkler] in [" + sensorLocation + "] has been reset.");
    }
}
