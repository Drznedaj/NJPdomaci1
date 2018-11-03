package api;

import java.util.ArrayList;

import entities.Prodavnica;
import entities.Proizvod;

public class DAO {
	
	
	private static DAO instance = null;
	private ORM orm = new ORM();
	
	//prave se 2 entiteta koja ce da presretne aspect i posalje query za kreiranje tabela.
	public DAO() {
		Proizvod p = new Proizvod();
		Prodavnica p2 = new Prodavnica();
	}
	public ORM getOrm() {
		return orm;
	}
	public void setOrm(ORM orm) {
		this.orm = orm;
	}
	public boolean insert(ORM orm, Class<?> klazz) {
		String koloneFormat="(";
		for (String s: orm.getTableColumns(klazz)) {
			koloneFormat += s+",";
		}
		koloneFormat+=")";
		System.out.printf("INSERT INTO %s %s VALUES (%s)",orm.getTableName(klazz),koloneFormat,"valuesFormat");
		return true;
	}
	public static DAO getInstance() {
		if(instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	
	
	
}
