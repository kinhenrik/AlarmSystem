public class Sprinkler extends SmokeSensor{

    public Sprinkler(String sensorLocation, String sensorType) {
        super(sensorLocation, sensorType);
        this.sensorActive = true;
    }

    @Override
    public void setSensorActive(boolean sensorActive) {
        super.setSensorActive(true);
    }

    public void activateSprinkler() {
        sensorTriggered = true;
        System.out.println("[Sprinkler] in [" + sensorLocation + "] has been triggered!");
    }
}
