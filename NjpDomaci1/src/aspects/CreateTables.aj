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
	
	pointcut initTables() : initialization(DAO.new());
//	pointcut insertTables() : initialization(ORM.new(..));
	
	after() : initTables() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
		Proizvod p = new Proizvod();
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
	}
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}