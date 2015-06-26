package geolab.lectures.project_shoppinglist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jay on 6/26/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "GeoLabShoppingList";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createShoppingListTable());
        db.execSQL(createShoppingListItemTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void dropTables(SQLiteDatabase db){
        db.execSQL(dropTable(DatabaseScheme.SHOPPING_LIST_TABLE));
        db.execSQL(dropTable(DatabaseScheme.SHOPPING_LIST_ITEM_TABLE));
    }

    private static String dropTable(String tableName){
        String query = "DROP TABLE IF EXISTS " + tableName;
        return query;
    }

    private String createShoppingListTable(){
        String query = "create table if not exists " +
                DatabaseScheme.SHOPPING_LIST_TABLE + "(" +
                DatabaseScheme.SHOPPING_LIST_ID + " integer primary key autoincrement," +
                DatabaseScheme.SHOPPING_LIST_TITLE + " text, " +
                DatabaseScheme.SHOPPING_LIST_TYPE + " integer not null);";
        return query;
    }

    private String createShoppingListItemTable(){
        String query = "create table if not exists " +
                DatabaseScheme.SHOPPING_LIST_ITEM_TABLE + "(" +
                DatabaseScheme.SHOPPING_LIST_ID + " integer primary key autoincrement," +
                DatabaseScheme.SHOPPING_LIST_ITEM_PARENT_ID + " integer, " +
                DatabaseScheme.SHOPPING_LIST_ITEM_VALUE + " text, " +
                DatabaseScheme.SHOPPING_LIST_ITEM_ISCHECKED + " integer default 0, " +
                " FOREIGN KEY(" + DatabaseScheme.SHOPPING_LIST_ITEM_PARENT_ID + ") REFERENCES " + DatabaseScheme.SHOPPING_LIST_TABLE +
                "(" + DatabaseScheme.SHOPPING_LIST_ID + "));";
        return query;
    }
}
