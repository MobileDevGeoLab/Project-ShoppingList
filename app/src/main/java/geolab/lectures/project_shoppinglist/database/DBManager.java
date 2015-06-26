package geolab.lectures.project_shoppinglist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import geolab.lectures.project_shoppinglist.model.ShoppingListItemModel;
import geolab.lectures.project_shoppinglist.model.ShoppingListModel;

/**
 * Created by Jay on 6/26/2015.
 */
public class DBManager {
    private static DBHelper dbHelper;
    private static SQLiteDatabase db;

    public static void init(Context context){
        if(dbHelper == null){
            dbHelper = new DBHelper(context);
        }
    }

    public static void openWritable(){
        db = dbHelper.getWritableDatabase();
    }

    public static void openReadable(){
        db = dbHelper.getReadableDatabase();
    }

    public static void close(){
        db.close();
    }

    public static void dropTables(){
        DBHelper.dropTables(db);
    }

    /**
     * Shopping List Table Methods
     */
    public static long insertShoppingList(ShoppingListModel shoppingList){
        ContentValues values = new ContentValues();
        values.put(DatabaseScheme.SHOPPING_LIST_TYPE, shoppingList.getType());
        values.put(DatabaseScheme.SHOPPING_LIST_DATE, shoppingList.getDate());

        return db.insert(DatabaseScheme.SHOPPING_LIST_TABLE, null, values);
    }

    public static int updateShoppingList(ShoppingListModel shoppingList){
        ContentValues values = new ContentValues();
        values.put(DatabaseScheme.SHOPPING_LIST_TYPE, shoppingList.getType());
        values.put(DatabaseScheme.SHOPPING_LIST_TITLE, shoppingList.getTitle());

        return db.update(DatabaseScheme.SHOPPING_LIST_TABLE, values, DatabaseScheme.SHOPPING_LIST_ID + " = " + shoppingList.getId(), null);
    }

    public static ArrayList<ShoppingListModel> getShoppingList(String whereQuery, String orderBy){
        ArrayList<ShoppingListModel> shoppingList = new ArrayList<>();
        Cursor cursor = db.query(DatabaseScheme.SHOPPING_LIST_TABLE, null, whereQuery, null, null, null, orderBy);
        if(cursor.moveToFirst()){
            do {
                long id = cursor.getLong(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_ID));
                String date = cursor.getString(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_DATE));
                int type = cursor.getInt(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_TYPE));
                String title = cursor.getString(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_TITLE));
                ShoppingListModel shoppingListModel = new ShoppingListModel(type, date);
                shoppingListModel.setId(id);
                shoppingListModel.setTitle(title);
                shoppingList.add(shoppingListModel);
            } while(cursor.moveToNext());
        }

        return shoppingList;
    }

    /**
     * Shopping List Item Table Methods
     */
    public static long insertShoppingListItem(ShoppingListItemModel listItemModel){
        ContentValues values = new ContentValues();
        values.put(DatabaseScheme.SHOPPING_LIST_ITEM_PARENT_ID, listItemModel.getParentId());
        values.put(DatabaseScheme.SHOPPING_LIST_ITEM_VALUE, listItemModel.getValue());
        values.put(DatabaseScheme.SHOPPING_LIST_ITEM_ISCHECKED, listItemModel.getIsChecked());

        return db.insert(DatabaseScheme.SHOPPING_LIST_ITEM_TABLE, null, values);
    }

    public static int updateShoppingListItem(ShoppingListItemModel listItemModel){
        ContentValues values = new ContentValues();
        values.put(DatabaseScheme.SHOPPING_LIST_ITEM_PARENT_ID, listItemModel.getParentId());
        values.put(DatabaseScheme.SHOPPING_LIST_ITEM_VALUE, listItemModel.getValue());
        values.put(DatabaseScheme.SHOPPING_LIST_ITEM_ISCHECKED, listItemModel.getIsChecked());

        return db.update(DatabaseScheme.SHOPPING_LIST_ITEM_TABLE, values, DatabaseScheme.SHOPPING_LIST_ITEM_ID + " = " + listItemModel.getId(), null);
    }

    public static ArrayList<ShoppingListItemModel> getShoppingListItems(String whereQuery){
        ArrayList<ShoppingListItemModel> listItems = new ArrayList<>();
        Cursor cursor = db.query(DatabaseScheme.SHOPPING_LIST_ITEM_TABLE, null, whereQuery, null, null, null, null);
        if(cursor.moveToFirst()){
            do {
                long id = cursor.getLong(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_ITEM_ID));
                long parentId = cursor.getLong(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_ITEM_PARENT_ID));
                int isChecked = cursor.getInt(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_ITEM_ISCHECKED));
                String value = cursor.getString(cursor.getColumnIndex(DatabaseScheme.SHOPPING_LIST_ITEM_VALUE));
                ShoppingListItemModel listItem = new ShoppingListItemModel(parentId, value, isChecked);
                listItem.setId(id);
                listItems.add(listItem);
            } while(cursor.moveToNext());
        }
        return listItems;
    }
}
