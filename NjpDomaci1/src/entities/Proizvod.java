package entities;

import annotations.Column;
import annotations.Table;
import api.GetTableParameters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

@Table(name = "proizvodi")
public class Proizvod extends BasicEntity implements GetTableParameters {

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

    @Override
    public String getTableName(Class<?> klasa) {
        Annotation[] anotacije = klasa.getAnnotations();
        String tableName = "";
        for (Annotation anotacija : anotacije) {
            if (anotacija instanceof Table){
                tableName = ((Table)anotacija).name();
                break;
            }
        }
        return tableName;
    }

    @Override
    public ArrayList<String> getTableColumns(Class<?> klasa) {
        ArrayList<String> columns = new ArrayList<>();

        for(Field field : klasa.getDeclaredFields()) {
            for(Annotation a : field.getAnnotations()) {
                if(a instanceof Column) {
                    columns.add(((Column) a).name());
                }

            }
        }
        
        return columns;
    }
}
