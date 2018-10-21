package aspects;

public aspect CreateTables{
	
	pointcut initTables() : initialization(ORM.new(..));
	
	before() : initTables() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
	}
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}