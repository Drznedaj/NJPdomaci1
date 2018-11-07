package aspects;
import api.ORM;
import entities.Proizvod;
import entities.Prodavnica;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Field;

public aspect InsertAspect {

    pointcut insertOneColumn() : execution(public void entities.*.*(..));

    after() : insertOneColumn() {
        Object[] o = thisJoinPoint.getArgs();
        String imeM = thisJoinPointStaticPart.getSignature().getName();

        if (!(imeM.substring(3).toLowerCase().equals("id"))){
            imeM = imeM.substring(3).toLowerCase();
            Class<?> klasica = thisJoinPoint.getSourceLocation().getWithinType();
            String ix = klasica.getName().substring(9).toLowerCase();
            String imeMetode = ix + "_" + imeM;
            String parametarMetode = o[0].toString();
            String kolonaFormat = ORM.getInstance().getTableColumn(klasica, imeMetode);
            System.out.printf("INSERT INTO %s (%s) VALUES (%s)\n", ORM.getInstance().getTableName(klasica), kolonaFormat, parametarMetode);
        }
    }
}
