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

    public void deleteHospital(String hospitalName) {
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            if (hospital.getName().equals(hospitalName)) {
                hospitals.remove(hospital);
            }
        }
    }

    public void deleteParamedics(String hospitalName, String paramedicId) {
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            if (hospital.getName().equals(hospitalName)) {
                ArrayList<Paramedic> paramedics = hospital.getMedics();
                for (int j = 0; j < paramedics.size(); j++) {
                    Paramedic a = paramedics.get(j);
                    if (a.getId_number().equals(paramedicId)) {
                        paramedics.remove(a);
                    }
                }
            }
        }
    }

    public void deleteAmbulance(String hospitalName, String ambulancePlate) {
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            if (hospital.getName().equals(hospitalName)) {
                ArrayList<Ambulance> ambulances = hospital.getAmbulancesObjects();
                for (int j = 0; j < ambulances.size(); j++) {
                    Ambulance a = ambulances.get(j);
                    if (a.getPlateNumber().equals(ambulancePlate)) {
                        ambulances.remove(a);
                    }
                }
            }
        }
    }

    public void moveAmbulance(HospitalComplex newHospital, Ambulance ambulance) {
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            if (hospital.getAmbulancesObjects().contains(ambulance)) {
                hospital.getAmbulancesObjects().remove(ambulance);
                addAmbulance(newHospital, ambulance);
            }
        }
    }

    public void moveParamedics(HospitalComplex newHospital, Paramedic paramedic) {
        for (int i = 0; i < hospitals.size(); i++) {
            HospitalComplex hospital = hospitals.get(i);
            if (hospital.getMedics().contains(paramedic)) {
                hospital.getMedics().remove(paramedic);
                addParamedic(newHospital, paramedic);
            }
        }
    }
}
