package aspects;


import java.lang.annotation.Annotation;
import org.aspectj.lang.ProceedingJoinPoint;

import api.ORM;
import api.DAO;
import entities.Prodavnica;
import entities.Proizvod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public aspect CreateTables{
	


	pointcut initTables1() : @annotation(annotations.Tabela);
	
	after() : initTables1() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
		Class<?> cl = thisJoinPoint.getSignature().getDeclaringType();
		// return ret;
		DAO.getInstance().create(cl);
//		ArrayList<String> columns = 
//		for(String s: columns) {
//			System.out.println(s);
//		}
		
	}
	
	

	pointcut initTables() : initialization(DAO.new(..));
//	pointcut insertTables() : initialization(ORM.new(..));
	
	after() : initTables() {
		Proizvod p = new Proizvod();
		Prodavnica prod = new Prodavnica();

		Class<?> cl = p.getClass();
//		create(cl);

        Class<?> cl1 = prod.getClass();
//        create(cl1);
	}

//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}