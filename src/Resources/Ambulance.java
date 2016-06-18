package Resources;

import java.io.Serializable;

public class Ambulance implements Serializable {

    private String plateNumber;
    private int year;
    private double speed;
    private HospitalComplex hospital = new HospitalComplex();
    private boolean active = true;

    public Ambulance(String plateNumber, int year, double speed) {
        this.plateNumber = plateNumber;
        this.year = year;
        this.speed = speed;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public HospitalComplex getHospital() {
        return hospital;
    }

    public void setHospital(HospitalComplex hospital) {
        this.hospital = hospital;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return plateNumber;
    }
}
