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

		DAO.getInstance().create(cl);
		
	}
}