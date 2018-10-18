package test;

import annotations.Table;
import entities.Proizvod;

import java.lang.annotation.Annotation;

public class Main {

	public static void main(String[] args) {
		Proizvod p = new Proizvod();

		Class<?> klasaP = p.getClass();

        Annotation[] anotacijeP = klasaP.getAnnotations();
        String tableName = "";
        for (Annotation anotacija : anotacijeP) {
            if (anotacija instanceof Table){
                tableName = ((Table)anotacija).name();
                break;
            }
        }
        System.out.println(tableName);
	}

}
