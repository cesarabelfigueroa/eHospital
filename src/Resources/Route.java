package Resources;

import java.io.Serializable;

public class Route implements Serializable{

    private Object init;
    private Object end;
    private double distance;

    public Route(Object init, Object end, double distance) {
        this.init = init;
        this.end = end;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Object getInit() {
        return init;
    }

    public void setInit(Object init) {
        this.init = init;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return distance + " km";
    }
}
