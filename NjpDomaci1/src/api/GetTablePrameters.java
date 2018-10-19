package api;

import java.util.ArrayList;

public interface GetTablePrameters {

    String getTableName(Class<?> klasa);
    ArrayList<String> getTableColumns(Class<?> klasa);
}
