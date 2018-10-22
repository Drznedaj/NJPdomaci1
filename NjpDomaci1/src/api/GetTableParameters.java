package api;

import java.util.ArrayList;

public interface GetTableParameters {

    String getTableName(Class<?> klasa);
    ArrayList<String> getTableColumns(Class<?> klasa);
    ArrayList<String> getSuperClassId(Class<?> klasa);
}
