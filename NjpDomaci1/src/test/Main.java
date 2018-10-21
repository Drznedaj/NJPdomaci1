package test;

import api.ORM;
import entities.Proizvod;

public class Main {

	public static void main(String[] args) {
		Proizvod p = new Proizvod();
		ORM orm = new ORM();
		
        System.out.println(orm.getTableName(p.getClass()));
        System.out.println(orm.getTableColumns(p.getClass()));
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
