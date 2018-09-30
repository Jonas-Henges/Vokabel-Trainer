package Trainer;

import java.util.Date;

public class Vokabel {

    private String deutsch;
    private String englisch;

    private Date nextdate; //TODO

    private int phase;

    public Vokabel(String deutsch, String englisch, int phase) {

        this.deutsch = deutsch;
        this.englisch = englisch;
        this.phase = phase;
    }

    public boolean prüfenEnglisch(String englisch) {
        if(this.englisch.equals(englisch)) {
            phase++;
            return true;
        } else {
            phase--;
            return false;
        }
    }

    public String getDeutsch() {
        return this.deutsch;
    }

    public String getEnglisch() {
        return this.englisch;
    }

    public int getPhase() {
        return phase();
    }
}
