package aspects;

import api.ORM;
import entities.Prodavnica;
import entities.Proizvod;
import entities.Tip;

public aspect UpdateAspect {

    pointcut updateOneColumn() : execution(public void entities.*.*(..));

    after() : updateOneColumn() {
        Object[] o = thisJoinPoint.getArgs();
        String imeM = thisJoinPointStaticPart.getSignature().getName();
        imeM = imeM.substring(3).toLowerCase();
        Object thisO = thisJoinPoint.getThis();
        //System.out.printf(imeSet+"\n");
        String id = null;
        if (thisO instanceof Prodavnica) {
            id = ((Prodavnica) thisO).getId();
        } else if (thisO instanceof Proizvod) {
            id = ((Proizvod) thisO).getId();
        } else if (thisO instanceof Tip) {
            id = ((Tip) thisO).getId();
        }

        Class<?> klasica = thisJoinPoint.getSourceLocation().getWithinType();
        String ix = klasica.getName().substring(9).toLowerCase();
        String imeMetode = ix + "_" + imeM;
        String parametarMetode = o[0].toString();
        String kolonaFormat = ORM.getInstance().getTableColumn(klasica, imeMetode);
        String setQu = kolonaFormat + "=" + parametarMetode;
        String whereQu = "id="+id;

        System.out.printf("UPDATE %s SET %s WHERE %s\n", ORM.getInstance().getTableName(klasica), setQu, whereQu);
    }
}
