package aspects;

import api.DAO;
import api.ORM;
import entities.Proizvod;

public aspect CreateTables{
	
	pointcut initTables() : initialization(ORM.new(..));
	pointcut insertTables() : initialization(ORM.new(..));
	
	after() : initTables() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
		
		
		
	}
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}