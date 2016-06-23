package Services;

import Graphics.eHospital;
import Resources.Despach;
import Resources.Emergency;
import Resources.HospitalComplex;
import Resources.Location;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

public class ThreadService extends Thread {

    static eHospital ehospital;
    static Location location;

    public ThreadService(eHospital hospital, Location location) {
        this.ehospital = hospital;
        this.location = location;
    }

    @Override
    public void run() {
        boolean end = false;

        if (location.getEmergencys().size() > 0) {
            ArrayList routes = getRoutes();

            while (!end || routes.isEmpty()) {
                int index = calculateIndexPath(routes);
                if (index >= 0 && index < routes.size()) {
                    int distance = calculateDistancePath((ArrayList) routes.get(index));
                    String hospital = ((ArrayList) routes.get(index)).get(0).toString();
                    HospitalComplex hc = (HospitalComplex) ehospital.app.getHospitalsPoints().get(findHospitalByName(hospital));
                    if (hc.getMedics().size() >= 1 && hc.getMedics().size() >= 3 && hc.getRanking().getValue() >= ((Emergency) location.getEmergencys().peekFirst()).getRanking().getValue()) {
                        JOptionPane.showMessageDialog(null, "La ruta a seguir es: " + routes.get(index));
                        Thread center = new Despach(location, hc, distance);
                        center.run();
                        end = true;
                        break;
                    } else {
                        routes.remove(index);
                    }
                } else {

                }
            }
            if (!end) {
                JOptionPane.showMessageDialog(null, "No hay ningun centro que pueda atender su solicitud.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La localización no tiene ninguna emergencia.");
        }
    }

    public int findHospitalByName(String name) {
        ArrayList<HospitalComplex> ap = ehospital.app.getHospitalsPoints();
        for (int i = 0; i < ap.size(); i++) {
            if (ap.get(i).toString().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int calculateIndexPath(ArrayList nodes) {
        int result = 0;
        int distanceMin = calculateDistancePath((ArrayList) nodes.get(0));
        for (int i = 0; i < nodes.size(); i++) {
            ArrayList ab = (ArrayList) nodes.get(i);
            int distance = calculateDistancePath(ab);
            if (distanceMin > distance) {
                result = 1;
            }
        }
        return result;
    }

    public int calculateDistancePath(ArrayList nodes) {
        int result = 0;
        for (int i = 0; i < nodes.size() - 1; i++) {
            String path = nodes.get(i).toString() + "-" + nodes.get(i + 1).toString();
            if (ehospital.app.getEdgesNames().indexOf(path) == -1) {
                path = nodes.get(i + 1).toString() + "-" + nodes.get(i).toString();
            }
            Edge ed = ehospital.graph.getEdge(path);
            int distance = ed.getAttribute("length");
            result += distance;
        }
        return result;
    }

    public ArrayList getRoutes() {
        ArrayList routes = new ArrayList();
        ArrayList initPoints = ehospital.app.getHospitalsPoints();
        for (Object initPoint : initPoints) {
            Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
            dijkstra.init(ehospital.graph);
            dijkstra.setSource(ehospital.graph.getNode(initPoint.toString()));
            dijkstra.compute();
            ArrayList result = new ArrayList();
            for (Node node : dijkstra.getPathNodes(ehospital.graph.getNode(location.toString()))) {
                result.add(0, node);
            }
            routes.add(result);
            dijkstra.clear();
        }
        return routes;
    }
}
