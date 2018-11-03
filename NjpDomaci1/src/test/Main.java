package test;

import api.DAO;
import entities.Prodavnica;
import entities.Proizvod;

public class Main {

	public static void main(String[] args) {
		
		DAO.getInstance();
//        System.out.println(DAO.getInstance().getTableName(p.getClass()));
//        System.out.println(DAO.getInstance().getTableColumns(p.getClass()));
		
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
