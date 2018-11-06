package aspects;
import entities.Proizvod;
import entities.Prodavnica;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Field;

public aspect InsertAspect {

    pointcut insertOneColumn() : execution(public void entities.*.*(..));

    after() : insertOneColumn() {
        Object[] o = thisJoinPoint.getArgs();

        String parametarMetode =o[0].toString();

        System.out.println("dodajem "+parametarMetode);
    }
}
