package com.flavienclara.campuslasalle.ADO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.flavienclara.campuslasalle.classes.CategorieElement;

/**
 * Created by Clara on 09/02/2018.
 */

public class CategorieElementADO {
    private CategorieElement catElem;
    public CategorieElementADO(){catElem = new CategorieElement();}

    public static String createTable(){
        return "CREATE TABLE " + CategorieElement.TABLE  + "("
                + CategorieElement.KEY_CategorieElementID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + CategorieElement.KEY_CategorieElementNom + " TEXT )";
    }
    public int insert(CategorieElement catElem) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(CategorieElement.KEY_CategorieElementNom, catElem.getNom());

        // Inserting Row
        long id = db.insert(catElem.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return (int)id;
    }

    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(CategorieElement.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }


}
