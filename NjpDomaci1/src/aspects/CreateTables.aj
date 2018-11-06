package aspects;

import api.ORM;
import api.DAO;
import entities.Prodavnica;
import entities.Proizvod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public aspect CreateTables{
	

	pointcut initTables() : initialization(DAO.new(..));
//	pointcut insertTables() : initialization(ORM.new(..));
	
	after() : initTables() {
		Proizvod p = new Proizvod();
		Prodavnica prod = new Prodavnica();

		Class<?> cl = p.getClass();
		create(cl);

        Class<?> cl1 = prod.getClass();
        create(cl1);
	}
	
	private void create(Class<?> klazz) {
		Map<String, Object> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE "+ORM.getInstance().getTableName(klazz) + " (");
		ArrayList<String> columns = ORM.getInstance().getTableColumns(klazz);
		for(int i = columns.size()-1; i >= 0;i--) {
			sb.append(columns.get(i));
			
			if(i != 0) {
				sb.append(",");
			}
		}
		sb.append(")");
		System.out.println(sb);
}
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}