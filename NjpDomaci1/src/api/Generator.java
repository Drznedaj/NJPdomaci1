package api;

import entities.Prodavnica;
import entities.Proizvod;

public class Generator {

    private static Generator instance;

    public static Generator getInstance(){
        if(instance == null){
            return new Generator();
        }
        return instance;
    }

    public void generateObjects(){
        Prodavnica p1 = new Prodavnica();
        Prodavnica p2 = new Prodavnica();
        Prodavnica p3 = new Prodavnica();
        Prodavnica p4 = new Prodavnica();
        Prodavnica p5 = new Prodavnica();
        Prodavnica p6 = new Prodavnica();

        Proizvod pr1 = new Proizvod();
        Proizvod pr2 = new Proizvod();
        Proizvod pr3 = new Proizvod();
        Proizvod pr4 = new Proizvod();
        Proizvod pr5 = new Proizvod();
        Proizvod pr6 = new Proizvod();
        Proizvod pr7 = new Proizvod();
        Proizvod pr8 = new Proizvod();
        Proizvod pr9 = new Proizvod();
        Proizvod pr10 = new Proizvod();
        Proizvod pr11 = new Proizvod();
        Proizvod pr12 = new Proizvod();

        p1.setIme("prodavnica 1");
        p2.setIme("prodavnica 2");
        p3.setIme("prodavnica 3");
        p4.setIme("prodavnica 4");
        p5.setIme("prodavnica 5");
        p6.setIme("prodavnica 6");
        p1.setAdresa("Narodnih Heroja 1");
        p2.setAdresa("Narodnih Heroja 2");
        p3.setAdresa("Narodnih Heroja 3");
        p4.setAdresa("Narodnih Heroja 4");
        p5.setAdresa("Narodnih Heroja 5");
        p6.setAdresa("Narodnih Heroja 6");

        pr1.setNaziv("Paradajz1");
        pr2.setNaziv("Paradajz12");
        pr3.setNaziv("Paradajz13");
        pr4.setNaziv("Paradajz14");
        pr5.setNaziv("Paradajz15");
        pr6.setNaziv("Paradajz16");
        pr7.setNaziv("Paradajz17");
        pr8.setNaziv("Paradajz18");
        pr9.setNaziv("Paradajz19");
        pr10.setNaziv("Paradajz19");
        pr11.setNaziv("Paradajz19");
        pr12.setNaziv("Paradajz19");

    }

}
