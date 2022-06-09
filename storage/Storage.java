package storage;

import model.Kamp;
import model.Spiller;

import java.util.ArrayList;

public class Storage {
    public static ArrayList<Kamp> kampe = new ArrayList<>();
    public static ArrayList<Spiller> spillere = new ArrayList<>();

    public static ArrayList<Kamp> getKampe(){
        return new ArrayList<>(kampe);
    }

    public static void addKamp(Kamp kamp){
        kampe.add(kamp);
    }

    public static ArrayList<Spiller> getSpillere(){
        return new ArrayList<>(spillere);
    }

    public static void addSpiller(Spiller spiller){
        spillere.add(spiller);
    }

}
