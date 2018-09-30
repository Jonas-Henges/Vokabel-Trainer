package Trainer;

import Trainer.Vokabel;
import sample.Main;

import java.io.*;

public class FileManager {

    private File file;
    private Main m;


    public FileManager(String pfad, Main pM) {
        file = new File(pfad);
        m = pM;
    }

    public void readFile() {
        if (file.exists()) {
            FileReader fr = null;
            try {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while (br.readLine() != null) {
                    String deutsch = br.readLine().toString();
                    String englisch = br.readLine().toString();
                    int phase = Integer.parseInt(br.readLine());

                    Vokabel v = new Vokabel(deutsch, englisch, phase);
                    m.getInstance().getVokabeln().add(v);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gibt keine File zum auslesen.....");
        }
    }

    public void writeFile() {
        if (file.exists()) {
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                while(!this.m.getInstance().getVokabeln().isEmpty()) {
                    Vokabel v = m.getInstance().getVokabeln().get(0);

                    bw.write(v.getDeutsch());
                    bw.write(v.getEnglisch());
                    bw.write(v.getPhase());

                    bw.write("");
                    m.getInstance().getVokabeln().remove(0);
                }

                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
                writeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
