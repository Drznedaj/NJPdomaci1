package api;

import annotations.Type;
import annotations.enumerators.FieldType;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import entities.Prodavnica;
import entities.Proizvod;

public class DAO {
	
	
	private static DAO instance = null;
	private ORM orm;


	
	//prave se 2 entiteta koja ce da presretne aspect i posalje query za kreiranje tabela.
	
	public ORM getOrm() {
		return orm;
	}
	public void setOrm(ORM orm) {
		this.orm = orm;
	}
	public boolean insert(ORM orm, Class<?> klazz) {
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

	public boolean update(ORM orm, Class<?> klazz) {
        String kolonePlusValues = "";
        ArrayList<String> kol = new ArrayList<>();
        String whereStatement ="";

		for (String s: orm.getTableColumns(klazz)) {
			kol.add(s);
		}

        for (String s: kol) {
            kolonePlusValues+=kol;
            kolonePlusValues+="=";
            try {
                for (Annotation a: klazz.getField(s).getAnnotations()) {
                    if(a instanceof Type){
                        if (((Type) a).name() == FieldType.VARCHAR){

                        }
                    }
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
		System.out.printf("UPDATE %s SET %s WHERE %s",orm.getTableName(klazz),kolonePlusValues,whereStatement);
		return true;
	}
	public static DAO getInstance() {
		if(instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	
	
	
}
