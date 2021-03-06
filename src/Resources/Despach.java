package Resources;

import java.util.ArrayDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Despach extends Thread {

    Location location;
    HospitalComplex hospital;
    int distance;

    public Despach(Location location, HospitalComplex hospital, int distance) {
        this.location = location;
        this.hospital = hospital;
        this.distance = distance;
    }

    @Override
    public void run() {
        if ((Emergency) location.getEmergencys().peek() != null && hospital.getAmbulancesObjects().size() > 0) {
            Emergency emergency = (Emergency) location.getEmergencys().pop();
            ArrayDeque paramedics = hospital.getRankingParamedics();
            Ambulance ambulance = hospital.getAmbulancesObjects().get(0);
            hospital.getAmbulancesObjects().remove(0);
            JOptionPane.showMessageDialog(null, "Se enviaron los paramedicos necesarios.");
            long time = (long) ((double) distance / ambulance.getSpeed());
            JOptionPane.showMessageDialog(null, "El tiempo que se tardarán es: " + time);
            try {
                Thread.sleep(2 * time * 1000);
                while (!paramedics.isEmpty()) {
                    Paramedic element = ((Paramedic) paramedics.pop());
                    element.setActive(true);
                    hospital.getMedics().add(element);
                    hospital.getAmbulancesObjects().add(ambulance);
                }
                JOptionPane.showMessageDialog(null, "Regresaron los paramédicos.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Despach.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un error en el proceso, intente de nuevo, no se cumplieron los requisitos.");
        }
    }
}
