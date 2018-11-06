package test;

import api.Generator;

public class Main {

	public static void main(String[] args) {
		Generator.getInstance().generateObjects();
		//ORM.getInstance().getTableColumn((new Proizvod()).getClass(),"naziv");
//		DAO.getInstance().insert(ORM.getInstance(),p.getClass());
//        System.out.println(DAO.getInstance().getTableName(p.getClass()));
//        System.out.println(DAO.getInstance().getTableColumns(p.getClass()));
		
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
