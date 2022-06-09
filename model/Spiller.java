package model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private int årgang;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller(String navn, int årgang){
        this.navn = navn;
        this.årgang = årgang;
    }

    public String getNavn() {
        return navn;
    }

    public int getÅrgang() {
        return årgang;
    }

    public ArrayList<Deltagelse> getDeltagelser(){
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse){
        if(!deltagelser.contains(deltagelse)){
            deltagelser.add(deltagelse);
            deltagelse.setSpiller(this);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if(deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
            deltagelse.setSpiller(null);
        }
    }

    public double kampHonorar(){
        double kamphonorar = 0;
        for(Deltagelse d : deltagelser){
            if(!d.isAfbud()){
                kamphonorar += 10;
            }
        }
        return kamphonorar;
    }
}
