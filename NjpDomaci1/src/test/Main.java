package test;

import api.DAO;
import api.ORM;
import entities.Proizvod;

public class Main {

	public static void main(String[] args) {
		Proizvod p = new Proizvod();
		
		DAO.getInstance();
		System.out.printf(p.getClass().getPackageName());
//        System.out.println(DAO.getInstance().getTableName(p.getClass()));
//        System.out.println(DAO.getInstance().getTableColumns(p.getClass()));
		
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
