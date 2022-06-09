package model;

public class ProfSpiller extends Spiller{
    private double kampHonorar;

    public ProfSpiller(String navn, int årgang, double kampHonorar) {
        super(navn, årgang);
        this.kampHonorar = kampHonorar;
    }

    public double getKampHonorar() {
        return kampHonorar;
    }

    @Override
    public double kampHonorar(){
        double antalAfbud = 0;
        int antalKampe = 0;
        for(Deltagelse d : getDeltagelser()){
            if(d.isAfbud()){
                antalAfbud++;
            }
            antalKampe++;
        }
        return kampHonorar * (antalAfbud / antalKampe);
    }
}
