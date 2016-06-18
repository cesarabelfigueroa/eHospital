package Services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ModelService {

    public void writeFiles(Application app) {
        File f = null;
        try {
            String ruta = "./batery.data";
            f = new File(ruta);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(app);
            try {
                oos.flush();
                oos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Application readFiles() {
        File f = null;
        FileInputStream fos = null;
        ObjectInputStream oos = null;
        try {
            String ruta = "./batery.data";
            try {
                f = new File(ruta);
                fos = new FileInputStream(f);
                oos = new ObjectInputStream(fos);
                Application bnt = (Application) oos.readObject();
                try {
                    oos.close();
                    fos.close();
                } catch (Exception ex) {
                
                    return null;
                }
                return bnt;
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
