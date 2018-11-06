package entities;

import annotations.Column;
import annotations.Id;
import annotations.Table;

@Table(name = "tipovi")
public class Tip {

    @Id
    @Column(name = "tip_id")
    private String id;
    @Column(name = "tip_naziv")
    private String naziv;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
