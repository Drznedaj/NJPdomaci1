package aspects;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.aspectj.lang.ProceedingJoinPoint;

import api.DAO;
import api.ORM;
import entities.Prodavnica;
import entities.Proizvod;

public aspect CreateTables{
	

	pointcut initTables() : @annotation(annotations.Tabela);
	
	after() : initTables() {
		// TODO kreirati entitete i napuniti magijom tabele, create , insert.
		Class<?> cl = thisJoinPoint.getSignature().getDeclaringType();
		// return ret;
		DAO.getInstance().create(cl);
//		ArrayList<String> columns = 
//		for(String s: columns) {
//			System.out.println(s);
//		}
		
	}
	
	
//	pointcut createTables() : initialization(* type_pattern.new(..)) ;
}