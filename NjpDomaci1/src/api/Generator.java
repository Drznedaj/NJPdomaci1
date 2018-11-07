package api;

import entities.Prodavnica;
import entities.Proizvod;
import entities.Tip;

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
        for (int i = 0; i < 10; i++) {
            proiz.add(new Proizvod());
        }

        DAO.getInstance().setProizvodi(proiz);

        for (int i = 0; i < DAO.getInstance().getProizvodi().size()-1; i++) {
            DAO.getInstance().getProizvodi().get(i).setNaziv("paradajz "+i);
            DAO.getInstance().getProizvodi().get(i).setId(Integer.toString(i+1));
        }

        for (int i = 0; i < DAO.getInstance().getProdavnice().size()-1; i++) {
            DAO.getInstance().getProdavnice().get(i).setId(Integer.toString(i+1));
            DAO.getInstance().getProdavnice().get(i).setIme("prodavnica "+i);
            DAO.getInstance().getProdavnice().get(i).setAdresa("Njegoseva "+i);
        }

        ArrayList<Tip> tips = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tips.add(new Tip());
        }
        DAO.getInstance().setTipovi(tips);
        for (int i = 0; i < DAO.getInstance().getTipovi().size()-1; i++) {
            DAO.getInstance().getTipovi().get(i).setNaziv("tip "+i);
            DAO.getInstance().getTipovi().get(i).setId(Integer.toString(i+1));
            DAO.getInstance().getProizvodi().get(i).setIdTipa(Integer.toString(i+1));
        }

    }

}
