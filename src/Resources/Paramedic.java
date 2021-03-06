package Resources;

import java.io.Serializable;

public class Paramedic implements Serializable,  Comparable {

    private String name;
    private int age;
    private String id_number;
    private Ranking ranking;
    private HospitalComplex hospital = new HospitalComplex();
    private boolean active = true;

    public Paramedic() {
    }

    public Paramedic(String name, int age, String id_number, Ranking ranking) {
        this.name = name;
        this.age = age;
        this.id_number = id_number;
        this.ranking = ranking;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
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
        return name;
    }

    @Override
    public int compareTo(Object comparestu) {
        int compareage = ((Paramedic) comparestu).getRanking().getValue();
        return compareage - this.getRanking().getValue();
    }
}
