package controller;

import model.Deltagelse;
import model.Kamp;
import model.ProfSpiller;
import model.Spiller;
import storage.Storage;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid){
        Kamp kamp = new Kamp(sted,dato,tid);
        Storage.addKamp(kamp);
        return kamp;
    }

    public static Spiller createSpiller(String navn, int årgang){
        Spiller spiller = new Spiller(navn,årgang);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static ProfSpiller createProfSpiller(String navn, int årgang, double kamphonorar){
        ProfSpiller profSpiller = new ProfSpiller(navn,årgang,kamphonorar);
        Storage.addSpiller(profSpiller);
        return profSpiller;
    }

    public static ArrayList<Kamp> getKampe(){
        return Storage.getKampe();
    }

    public static ArrayList<Spiller> getSpillere(){
        return Storage.getSpillere();
    }
    public static void indskrivTilFil(Kamp kamp){
        String filnavn = "C:\\Users\\Peter\\IdeaProjects\\PRO1-Project\\L31-Semesterprojekt2015\\src\\controller\\spillerInfo.txt";
        try {
            kamp.spillerHonorar(filnavn);
        }catch (FileNotFoundException fe){

        }

    }

    /**
     * Opdaterer sammenhængen mellem spiller og deltagelse så de
     * linker til hinanden
     * Precondition: spiller != null og deltagelse != null
     */

    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse){
        spiller.addDeltagelse(deltagelse);
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2){
        ArrayList<Kamp> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while(i1 < list1.size() && i2 < list2.size()){
            if(list1.get(i1).compareTo(list2.get(i2))<=0){
                result.add(list1.get(i1));
                i1++;
            }else{
                result.add(list2.get(i2));
                i2++;
            }
        }

        while (i1 < list1.size()){
            result.add(list1.get(i1));
            i1++;
        }

        while (i2 < list2.size()){
            result.add(list2.get(i2));
            i2++;
        }
        return result;
    }

    private static void initStorage(){
        Spiller s1 = createSpiller("Jane Jensen", 1999);
        Spiller s2 = createSpiller("Lene Hansen", 2000);
        Spiller s3 = createSpiller("Mette Pedersen", 1999);

        ProfSpiller p1 = createProfSpiller("Sofia Kjeldsen",1999,50);
        ProfSpiller p2 = createProfSpiller("Maria Nielsen",2000,55);

        Kamp kamp1 = createKamp("Herning", LocalDate.of(2015,1,26), LocalTime.of(10,30));
        Kamp kamp2 = createKamp("Ikast", LocalDate.of(2015,1,27), LocalTime.of(13,30));

        Deltagelse d1 = kamp1.createDeltagelse(true,"Moster Oda har fødselsdag",s1);
        Deltagelse d2 = kamp1.createDeltagelse(false,"Kan godt",s2);
        Deltagelse d3 = kamp1.createDeltagelse(false,"Kan godt",s3);
        Deltagelse d4 = kamp1.createDeltagelse(false,"Kan godt",p1);
        Deltagelse d5 = kamp1.createDeltagelse(false,"Kan godt",p2);

        Deltagelse d6 = kamp2.createDeltagelse(false,"Kan godt",s1);
        Deltagelse d7 = kamp2.createDeltagelse(false,"Kan godt",s2);
        Deltagelse d8 = kamp2.createDeltagelse(false,"Kan godt",s3);
        Deltagelse d9 = kamp2.createDeltagelse(true,"Dårlig form",p1);
        Deltagelse d10 = kamp2.createDeltagelse(false,"Kan godt",p2);


    }

    public static void init(){
        initStorage();
    }
}
