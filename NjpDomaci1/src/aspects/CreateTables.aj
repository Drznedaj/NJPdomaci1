package aspects;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import api.DAO;
import api.ORM;
import entities.Prodavnica;
import entities.Proizvod;

public aspect CreateTables{
	
<<<<<<< HEAD
	pointcut initTables() : initialization(DAO.new());
//	pointcut insertTables() : initialization(ORM.new(..));
=======
	pointcut initTables() : call(ORM.new(..));
	//pointcut insertTables() : initialization(ORM.new(..));
>>>>>>> 4cadd6aee67c17e926ca350b279089ee43aa1a32
	
	after() : initTables() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
		Proizvod p = new Proizvod();
<<<<<<< HEAD
		Prodavnica prodavnica = new Prodavnica();
		
		Class<?> cl = p.getClass();
		create(cl);
//		ArrayList<String> columns = 
//		for(String s: columns) {
//			System.out.println(s);
//		}
		
	}
	
	private void create(Class<?> klazz) {
		Map<String, Object> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE "+ORM.getInstance().getTableName(klazz) + " (");
		ArrayList<String> columns = ORM.getInstance().getTableColumns(klazz);
		for(int i = 0; i < columns.size();i++) {
			sb.append(columns.get(i));
			
			if(i < columns.size()-1) {
				sb.append(",");
			}
		}
		sb.append(")");
		System.out.println(sb);
=======
		Class<?> klazzP = p.getClass();
		Annotation[] anotacije = klazzP.getAnnotations();
//		Arraylist<Field> fieldovi = new ArrayList<>();
//		Class<?> cl = p.getClass();
		System.out.printf("blasjldkj");
>>>>>>> 4cadd6aee67c17e926ca350b279089ee43aa1a32
	}
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}