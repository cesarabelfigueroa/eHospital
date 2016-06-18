package Services;

import Resources.Ambulance;
import Resources.HospitalComplex;
import Resources.Paramedic;
import java.io.Serializable;
import java.util.ArrayList;

public class Application implements Serializable {

    private ArrayList<HospitalComplex> hospitals = new ArrayList();

    public Application() {

    }

    public void addAmbulance(HospitalComplex hospital, Ambulance ambulance) {
        ArrayList<Ambulance> ambulances = hospital.getAmbulancesObjects();
        ambulance.setHospital(hospital);
        ambulances.add(ambulance);
    }

    public void addParamedic(HospitalComplex hospital, Paramedic paramedic) {
        ArrayList<Paramedic> paramedics = hospital.getMedics();
        paramedic.setHospital(hospital);
        paramedics.add(paramedic);
    }

    public void addHospital(HospitalComplex hospital) {
        hospitals.add(hospital);
    }

    public ArrayList getAllParamedics() {
        ArrayList<Paramedic> paramedics = new ArrayList();
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            for (int j = 0; j < hospital.getMedics().size(); j++) {
                Paramedic medic = hospital.getMedics().get(j);
                paramedics.add(medic);
            }
        }
        return paramedics;
    }

    public ArrayList getAllAmbulances() {
        ArrayList<Ambulance> ambulances = new ArrayList();
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            for (int j = 0; j < hospital.getAmbulancesObjects().size(); j++) {
                Ambulance ambulance = hospital.getAmbulancesObjects().get(j);
                ambulances.add(ambulance);
            }
        }
        return ambulances;
    }

    public ArrayList<HospitalComplex> getHospitals() {
        return hospitals;
    }

    public void setHospitals(ArrayList<HospitalComplex> hospitals) {
        this.hospitals = hospitals;
    }

    public void deleteHospital(HospitalComplex hospital) {
        hospitals.remove(hospital);
    }

    public void deleteParamedics(Paramedic paramedic) {
        HospitalComplex hospital = paramedic.getHospital();
        hospital.getMedics().remove(paramedic);
    }

    public void deleteAmbulance(Ambulance ambulance) {
        HospitalComplex hospital = ambulance.getHospital();
        hospital.getAmbulancesObjects().remove(ambulance);
    }
}
