package entities;

import annotations.Column;
import annotations.Table;

@Table(name = "proizvodi")
public class Proizvod extends BasicEntity{

    @Column(name = "proizvod_idTipa")
    private String idTipa;
    @Column(name = "proizvod_naziv")
    private String naziv;

    private Tip tipProizvoda;

    public Proizvod(){
        super();
    }

    public Tip getTipProizvoda() {
        return tipProizvoda;
    }

    public void setTipProizvoda(Tip tipProizvoda) {
        this.tipProizvoda = tipProizvoda;
    }


    public String getIdTipa() {
        return idTipa;
    }

    public void setIdTipa(String idTipa) {
        this.idTipa = idTipa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
