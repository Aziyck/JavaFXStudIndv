package ceiti.me.example.javafxfirstprog.week7.incubatorPckg;

public class Incubator {
    private int temperature;
    private static final int MAX = 10;
    private static final int MIN = -10;

    public Incubator(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean increaseTemperature(){
        if (temperature+1 > MAX){
            return false;
        }
        else {
            temperature++;
            return true;
        }
    }

    public boolean decreaseTemperature(){
        if (temperature-1 < MIN){
            return false;
        }
        else {
            temperature--;
            return true;
        }
    }


}
