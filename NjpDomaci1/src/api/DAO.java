package api;

import annotations.Type;
import annotations.enumerators.FieldType;
import entities.Prodavnica;
import entities.Proizvod;
import entities.Tip;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DAO {
	
	
	private static DAO instance = null;
	private ORM orm;

    private ArrayList<Prodavnica> prodavnice = new ArrayList<>();
    private ArrayList<Proizvod> proizvodi = new ArrayList<>();
    private ArrayList<Tip> tipovi = new ArrayList<>();
	
	//prave se 2 entiteta koja ce da presretne aspect i posalje query za kreiranje tabela.
	
	public ORM getOrm() {
		return orm;
	}
	public void setOrm(ORM orm) {
		this.orm = orm;
	}
	public boolean insert(ORM orm, Class<?> klazz, Object o) {
		String koloneFormat="(";
		String valuesFormat="(";
		for (String s: orm.getTableColumns(klazz)) {
			koloneFormat += s+",";
		}
		koloneFormat+=")";
		for(String s: orm.getFieldValues(klazz)){
			valuesFormat+=s+",";
		}
		valuesFormat+=")";
		System.out.printf("INSERT INTO %s %s VALUES %s",orm.getTableName(klazz),koloneFormat,valuesFormat);
		return true;
	}

	public boolean updateOne(Object o, String colu, String value) {
	    Class<?> klazz = o.getClass();
        String kolonaPlusValues = colu+"="+value;
        String whereStatement ="";

        String id = null;
        for (Proizvod p : this.proizvodi){
            if(o.equals(p)){
                id = ((Proizvod) o).getId();
                break;
            }
        }
        for (Prodavnica p : this.prodavnice){
            if(o.equals(p)){
                id = ((Prodavnica) o).getId();
                break;
            }
        }
        for (Tip p : this.tipovi){
            if(o.equals(p)){
                id = ((Tip) o).getId();
                break;
            }
        }

        whereStatement += ORM.getInstance().getSuperClassId(klazz)+"="+id;

		System.out.printf("UPDATE %s SET %s WHERE %s",ORM.getInstance().getTableName(klazz),kolonaPlusValues,whereStatement);
		return true;
	}

	public void create(Class<?> klazz) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE "+ORM.getInstance().getTableName(klazz) + " (");
		
		sb.append(ORM.getInstance().getConstraintsForClass(klazz));
		sb.append(")");
		System.out.println(sb);
    }

    public ArrayList<Prodavnica> getProdavnice() {
        return prodavnice;
    }

    public void setProdavnice(ArrayList<Prodavnica> prodavnice) {
        this.prodavnice = prodavnice;
    }

    public ArrayList<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(ArrayList<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public ArrayList<Tip> getTipovi() {
        return tipovi;
    }

    public void setTipovi(ArrayList<Tip> tipovi) {
        this.tipovi = tipovi;
    }

    public static DAO getInstance() {
		if(instance == null) {
			instance = new DAO();
		}
		return instance;
	}
}
