package Resources;

import java.io.Serializable;
import java.util.ArrayDeque;

public class Location implements Serializable {

    private String name;
    private ArrayDeque emergencys = new ArrayDeque();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayDeque getEmergencys() {
        return emergencys;
    }

    public void setEmergencys(ArrayDeque emergencys) {
        this.emergencys = emergencys;
    }

    @Override
    public String toString() {
        return name;
    }
}
