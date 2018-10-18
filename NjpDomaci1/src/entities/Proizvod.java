package entities;

import annotations.SuperClass;
import annotations.Table;
import annotations.enumerators.Tipovi;

@SuperClass
@Table(name = "proizvodi")
public abstract class Proizvod extends BasicEntity{

    private Tipovi tip;

    public Proizvod(){
        super();
    }

    public Tipovi getTip() {
        return tip;
    }

    public void setTip(Tipovi tip) {
        this.tip = tip;
    }
}
