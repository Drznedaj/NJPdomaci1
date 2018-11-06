package api;

import entities.Prodavnica;
import entities.Proizvod;

import java.util.ArrayList;

public class Generator {

    private static Generator instance;

    public static Generator getInstance(){
        if(instance == null){
            return new Generator();
        }
        return instance;
    }

    public void generateObjects(){

        ArrayList<Prodavnica> prod = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            prod.add(new Prodavnica());
        }

        DAO.getInstance().setProdavnice(prod);

        ArrayList<Proizvod> proiz = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            proiz.add(new Proizvod());
        }

        DAO.getInstance().setProizvodi(proiz);

        for (int i = 0; i < DAO.getInstance().getProizvodi().size()-1; i++) {
            DAO.getInstance().getProizvodi().get(i).setNaziv("paradajz "+i);
        }
    }

}
