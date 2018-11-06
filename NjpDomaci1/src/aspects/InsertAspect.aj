package aspects;
import entities.Proizvod;
import entities.Prodavnica;
import org.aspectj.lang.JoinPoint;

public aspect InsertAspect {

    pointcut insertOneColumn(JoinPoint jp) : execution(public void entities.*.*(..));

    after() : insertOneColumn() {
        Object o = jp.getArgs();
        String s=null;

        System.out.println("dodajem "+o);
    }
}
