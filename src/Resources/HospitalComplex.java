package Resources;

import java.io.Serializable;
import java.util.ArrayList;




public class HospitalComplex implements Serializable {

    private String name;
    private String address;
    private int paramedics;
    private int ambulances;
    private Ranking ranking;
    private ArrayList<Paramedic> medics = new ArrayList();
    private ArrayList<Ambulance> ambulancesObjects = new ArrayList();

    public HospitalComplex() {
    }

    public HospitalComplex(String name, String address, int paramedics, int ambulances, Ranking ranking) {
        this.name = name;
        this.address = address;
        this.paramedics = paramedics;
        this.ambulances = ambulances;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParamedics() {
        return paramedics;
    }

    public void setParamedics(int paramedics) {
        this.paramedics = paramedics;
    }

    public int getAmbulances() {
        return ambulances;
    }

    public void setAmbulances(int ambulances) {
        this.ambulances = ambulances;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public ArrayList<Paramedic> getMedics() {
        return medics;
    }

    public void setMedics(ArrayList<Paramedic> medics) {
        this.medics = medics;
    }

    public ArrayList<Ambulance> getAmbulancesObjects() {
        return ambulancesObjects;
    }

    public void setAmbulancesObjects(ArrayList<Ambulance> ambulancesObjects) {
        this.ambulancesObjects = ambulancesObjects;
    }

    @Override
    public String toString() {
        return name;
    }
}
