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

	public boolean join(Class<?> k1, Class<?> k2, String[] colsK1, String[] colsK2){
	    String formatKolona = "";
	    String table1 = ORM.getInstance().getTableName(k1);
        String table2 = ORM.getInstance().getTableName(k2);
        for (String s: colsK1) {
            formatKolona += table1+"."+ORM.getInstance().getTableColumn(k1,s);
            formatKolona += ",";
        }
        for (int i = 0; i < colsK2.length; i++) {
            formatKolona += table2+"."+ORM.getInstance().getTableColumn(k2,colsK2[i]);
            if (i != colsK2.length-1){
                formatKolona += ",";
            }
        }
        String idFormat = "";
        idFormat+= table1+"."+ORM.getInstance().getClassId(k1)+"="+table2+"."+ORM.getInstance().getSuperClassId(k2);
        System.out.printf("SELECT %s FROM %s INNER JOIN %s ON %s\n",formatKolona,table1,table2,idFormat);
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

		System.out.printf("UPDATE %s SET %s WHERE %s\n",ORM.getInstance().getTableName(klazz),kolonaPlusValues,whereStatement);
		return true;
	}
	
	public boolean deleteAND(Class<?> klazz, ArrayList<String> columns, ArrayList<String> values) {
		String delete = "DELETE FROM %s WHERE %s";
		String columnsEqVals = "";
		for(int i=0; i < columns.size(); i++) {
			if(orm.getTableColumn(klazz, columns.get(i))==null) {
				System.err.println("Column: " + columns.get(i) +" is not defined in database!!! Could not delete");
				return false;
			}
			if(i < columns.size()-1) {
				columnsEqVals += columns.get(i) + " = " + values.get(i) + " AND ";
			}
			columnsEqVals += columns.get(i) + " = " + values.get(i);
		}
		delete = String.format(delete, orm.getTableName(klazz), columnsEqVals);
		
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
