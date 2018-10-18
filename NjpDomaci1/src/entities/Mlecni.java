package entities;

import annotations.Column;
import annotations.enumerators.Tipovi;

public class Mlecni extends Proizvod {

    @Column(name = "proizvod_ime")
    private String ime;

    public Mlecni(){
        super();
        this.setTip(Tipovi.MLECNI);
    }
}
