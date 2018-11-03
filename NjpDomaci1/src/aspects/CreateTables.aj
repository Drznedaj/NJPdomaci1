package aspects;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import api.DAO;
import api.ORM;
import entities.Prodavnica;
import entities.Proizvod;

public aspect CreateTables{
	
	pointcut initTables() : initialization(ORM.new(..));
	pointcut insertTables() : initialization(ORM.new(..));
	
	after() : initTables() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
		Proizvod p = new Proizvod();
		Class<?> klazzP = p.getClass();
		Annotation[] anotacije = klazzP.getAnnotations();
//		Arraylist<Field> fieldovi = new ArrayList<>();
//		Class<?> cl = p.getClass();
	}
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}