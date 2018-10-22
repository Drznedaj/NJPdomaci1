package test;

import api.ORM;
import entities.Proizvod;

public class Main {

	public static void main(String[] args) {
		Proizvod p = new Proizvod();
		ORM orm = new ORM();
		
        System.out.println(orm.getTableName(p.getClass()));
        System.out.println(orm.getTableColumns(p.getClass()));
        String koloneFormat = "(";
		for (String s: orm.getTableColumns(p.getClass())
			 ) {
			koloneFormat += s+",";
		}
		koloneFormat+=")";
		System.out.printf("INSERT INTO %s %s VALUES (%s)",orm.getTableName(p.getClass()),koloneFormat,"valuesFormat");
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
