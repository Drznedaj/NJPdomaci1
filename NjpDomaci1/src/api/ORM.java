package api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import annotations.Column;
import annotations.Id;
import annotations.PrimaryKey;
import annotations.SuperClass;
import annotations.Table;

public class ORM implements GetTableParameters{

	public String getTableName(Class<?> klasa) {
		Annotation[] anotacije = klasa.getAnnotations();
		String tableName = "";
		for (Annotation anotacija : anotacije) {
			if (anotacija instanceof Table) {
				tableName = ((Table) anotacija).name();
				break;
			}
		}
		return tableName;
	}

	public ArrayList<String> getFieldValues(Class<?> klasa){
		ArrayList<String> fieldValues = new ArrayList<>();
		for(Field f : klasa.getDeclaredFields()){
		    fieldValues.add(f.getName());
        }
		return fieldValues;
	}

	public String getTableColumnPlusValue(Class<?> klasa, String colName){
	    String col = null;
        for (Field field : klasa.getDeclaredFields()) {
            for (Annotation a : field.getAnnotations()) {
                if (a instanceof Column && (((Column) a).name()).equals(colName)) {
                    col = ((Column) a).name();
                    col += "=";

                }
            }
        }
        return col;
    }

	public ArrayList<String> getTableColumns(Class<?> klasa) {
		ArrayList<String> columns = new ArrayList<>();

		for (Field field : klasa.getDeclaredFields()) {
			for (Annotation a : field.getAnnotations()) {
				if (a instanceof Column) {
					columns.add(((Column) a).name());
				}

			}
		}
		Class<?> superClass = klasa.getSuperclass();
		if (superClass != null) {
			columns.addAll(getSuperClassId(superClass));
		}

		return columns;
	}

	// Prima super class i vraca njene kolone ukoliko postoji super class
	public ArrayList<String> getSuperClassId(Class<?> klasa) {
		Class<?> superClass = klasa;
		ArrayList<String> columns = new ArrayList<>();
		boolean isSuperClassFound = false;
		if (superClass != null) {
			Annotation[] annotations = superClass.getAnnotations();
			for (Annotation a : annotations) {
				if (a instanceof SuperClass) {
					isSuperClassFound = true;
					break;
				}
			}
		}
		if (isSuperClassFound) {

			Field[] fields = superClass.getDeclaredFields();
			for (Field f : fields) {
				boolean PK = false;
				boolean id = false;
				Annotation column = null;

				for (Annotation a : f.getAnnotations()) {
					if (a instanceof PrimaryKey) {
						PK = true;
					}
					if (a instanceof Id) {
						id = true;
					}
					if (a instanceof Column) { // Ovde ce da nam pokupi samo jedan column ja msm
						column = a;
					}
				}
				if (PK && id && column != null) {
					columns.add(((Column) column).name()); // Ovaj deo bi trebao unutar annotation for-a...
				}
			}
		}

		// System.out.println("SUPER KLASA: " + isSuperClassFound + " , " + pkey);
		return columns;
	}
}
