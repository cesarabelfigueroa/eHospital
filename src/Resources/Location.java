package Resources;

import java.util.ArrayList;

public class Location {
    private String name;
    private ArrayList<Emergency> emergencys = new ArrayList();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Emergency> getEmergencys() {
        return emergencys;
    }

    public void setEmergencys(ArrayList<Emergency> emergencys) {
        this.emergencys = emergencys;
    }

    @Override
    public String toString() {
        return name ;
    }
}