package api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import annotations.Column;
import annotations.ForeinKey;
import annotations.Id;
import annotations.Mandatory;
import annotations.NotNull;
import annotations.PrimaryKey;
import annotations.SuperClass;
import annotations.Table;
import annotations.Type;
import annotations.enumerators.FieldType;

public class ORM {
	private static ORM instance = null;
	
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
	
	
	public StringBuilder getConstraintsForField(Field field) {
		Annotation[] annotationsForField = field.getAnnotations();
		StringBuilder constraint = new StringBuilder();
		for(Annotation a : annotationsForField) {
			constraint.append(" " + getStringForAnnotation(a));
		}
		return constraint;
	}
	
	public StringBuilder getConstraintsForClass(Class<?> klazz) {
		StringBuilder constraints = new StringBuilder();
		Field[] fields = klazz.getDeclaredFields();
		for(int i= 0; i < fields.length; i++) {
			if(Modifier.isStatic(fields[i].getModifiers())) {
				continue;
			}
			constraints.append(getConstraintsForField(fields[i]));
			
			constraints.append(",");
		}
		
		Class<?> superClass = klazz.getSuperclass();
		if (superClass != null) {
			fields = superClass.getDeclaredFields();
			for(int i= 0; i < fields.length; i++) {
				if(Modifier.isStatic(fields[i].getModifiers())) {
					continue;
				}
				constraints.append(getConstraintsForField(fields[i]));

				if(i < fields.length-2) {
					constraints.append(",");
				}
			}
		}
		return constraints;
	}
	public String getTableColumnPlusValue(Class<?> klasa, String colName, Object o){
	    String col = "";
        for (Field field : klasa.getDeclaredFields()) {
            for (Annotation a : field.getAnnotations()) {
                if (a instanceof Column && (((Column) a).name()).equals(colName)) {
                    col = ((Column) a).name();
                    col += "=";
                    try {
                        col += field.get(o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return col;
    }

	public String getTableColumn(Class<?> klasa, String colName) {
		String column = null;

		for (Field field : klasa.getDeclaredFields()) {
			for (Annotation a : field.getAnnotations()) {
				if (a instanceof Column && ((Column) a).name().equals(colName)) {
					column = ((Column) a).name();
				}

			}
		}

		return column;
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
			//columns.addAll(getSuperClassId(superClass));
		}

		return columns;
	}

	// Prima super class i vraca njene kolone ukoliko postoji super class
    //Ne trebaju nam kolone ovde tebra, treba nam samo ovaj ID :)
	public String getSuperClassId(Class<?> klasa) {
		Class<?> superClass = klasa.getSuperclass();
		String columns = null;
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
				boolean id = false;
				Annotation column = null;

				for (Annotation a : f.getAnnotations()) {
					if (a instanceof Id) {
						id = true;
					}
					if (a instanceof Column) {
						column = a;
                        if (id) {
                            columns = (((Column) column).name());
                            break;
                        }
					}
				}
                if (id && column != null) {
				    break;
                }
			}
		}
		return columns;
	}
	public String getStringForAnnotation(Annotation a) {
		if(a instanceof Column) {
			return ((Column) a).name();
		}
		if(a instanceof NotNull) {
			return "NOT NULL";
		}
		if(a instanceof PrimaryKey) {
			return "PRIMARY_KEY";
		}
		if(a instanceof Mandatory) {
			return "MANDATORY";
		}
		if(a instanceof ForeinKey) {
			return "FOREIGN_KEY";
		}
		if(a instanceof Type) {
//			INT,FLOAT,DOUBLE,VARCHAR,DATE,AUTO_INCREMENT;
			FieldType ft = ((Type) a).name();
			if(ft.equals(FieldType.AUTO_INCREMENT)) {
				return ft.name();
			}
			String field = ft.toString() + "(" + ((Type) a).length() + ")";
			return field;
		}
		
		return "";
	}
	
	public static ORM getInstance() {
		if(instance == null) {
			instance = new ORM();
		}
		return instance;
	}
}
