package test;

import annotations.enumerators.FieldType;
import api.DAO;
import api.ORM;
import entities.Prodavnica;
import entities.Proizvod;

public class Main {

	public static void main(String[] args) {
		Prodavnica p = new Prodavnica();
		Prodavnica p2 = new Prodavnica();
		Proizvod p1 = new Proizvod();
//		DAO.getInstance().getOrm();
//        System.out.println(DAO.getInstance().getTableName(p.getClass()));
//        System.out.println(DAO.getInstance().getTableColumns(p.getClass()));
		
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
