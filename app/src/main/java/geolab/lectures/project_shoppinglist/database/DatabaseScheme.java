package geolab.lectures.project_shoppinglist.database;

/**
 * Created by Jay on 6/26/2015.
 */
public class DatabaseScheme {

    public static final String SHOPPING_LIST_TABLE = "SHOPPING_LIST_TABLE";
    public static final String SHOPPING_LIST_ID = "Id";
    public static final String SHOPPING_LIST_TITLE = "Title";
    public static final String SHOPPING_LIST_TYPE = "Type";
    public static final String SHOPPING_LIST_DATE = "Date";


    public static final String SHOPPING_LIST_ITEM_TABLE = "SHOPPING_LIST_ITEM_TABLE";
    public static final String SHOPPING_LIST_ITEM_ID = "Id";
    public static final String SHOPPING_LIST_ITEM_PARENT_ID = "ParentId";
    public static final String SHOPPING_LIST_ITEM_VALUE = "Value";
    public static final String SHOPPING_LIST_ITEM_ISCHECKED = "IsChecked";
}
