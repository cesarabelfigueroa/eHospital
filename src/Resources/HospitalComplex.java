package Resources;

import java.io.Serializable;

public class HospitalComplex implements Serializable{

    private String name;
    private String address;
    private int paramedics;
    private int ambulances;
    private String ranking;

    public HospitalComplex() {
    }

    public HospitalComplex(String name, String address, int paramedics, int ambulances, String ranking) {
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

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return name;
    }
}