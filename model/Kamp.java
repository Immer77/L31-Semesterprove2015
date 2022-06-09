package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp>{
    private String sted;
    private LocalDate dato;
    private LocalTime tid;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Kamp(String sted, LocalDate dato, LocalTime tid){
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public ArrayList<Deltagelse> getDeltagelser(){
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse){
        if(!deltagelser.contains(deltagelse)){
            deltagelser.add(deltagelse);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse){
        if(deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
        }
    }

    public Deltagelse createDeltagelse(boolean afbud, String begrundelse, Spiller spiller){
        Deltagelse deltagelse = new Deltagelse(afbud,begrundelse, spiller);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public ArrayList<String> afbud(){
        ArrayList<String> spillerAfbud = new ArrayList<>();
        for(Deltagelse d : deltagelser){
            if(d.isAfbud()){
                String s  = d.getSpiller().getNavn() + " " + d.getBegrundelse();
                spillerAfbud.add(s);
            }
        }
        return spillerAfbud;
    }

    public void spillerHonorar(String filnavn) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filnavn);
        for (Deltagelse d : deltagelser){
            if(!d.isAfbud()){
                String s = d.getSpiller().getNavn() + " " + d.getSpiller().kampHonorar();
                pw.println(s);
            }
        }
    }

    @Override
    public int compareTo(Kamp o) {
        int comp = this.dato.compareTo(o.dato);
        if(comp == 0){
            comp = this.tid.compareTo(o.tid);
            if(comp == 0){
                comp = this.sted.compareTo(o.sted);
            }
        }
        return comp;
    }

    @Override
    public String toString(){
        return sted + " " + dato + " " + tid;
    }


}
