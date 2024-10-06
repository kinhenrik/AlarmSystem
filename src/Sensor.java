public abstract class Sensor {

    public String sensorLocation;
    public String sensorType;
    public boolean sensorActive;
    public boolean sensorTriggered;

    public Sensor() {}
    public Sensor(String sensorLocation, String sensorType) {
        this.sensorLocation = sensorLocation;
        this.sensorType = sensorType;
    }

    public abstract void triggerSensor();

    public void resetSensor() {
        if (sensorTriggered) {
            sensorTriggered = false;
            System.out.println("[" + sensorType + "] in [" + sensorLocation + "] has been reset.");
        }
    }

    public String getSensorLocation() {
        return sensorLocation;
    } public void setSensorLocation(String sensorLocation) {
        this.sensorLocation = sensorLocation; }

    public String getSensorType() {
        return sensorType;
    } public void setSensorType(String sensorType) {
        this.sensorType = sensorType; }

    public boolean isSensorActive() {
        return sensorActive;
    } public void setSensorActive(boolean sensorActive) {
        this.sensorActive = sensorActive; }

    public boolean isSensorTriggered() {
        return sensorTriggered;
    } public void setSensorTriggered(boolean sensorTriggered) {
        this.sensorTriggered = sensorTriggered; }
}
