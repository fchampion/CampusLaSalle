package com.flavienclara.campuslasalle.ADO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavienclara.campuslasalle.classes.Element;

import java.util.ArrayList;

/**
 * Created by Clara on 09/02/2018.
 */

public class ElementADO {
    private Element elem;

    public ElementADO(){
        elem = new Element();
    }

    public static String createTable(){
        return "CREATE TABLE " + Element.TABLE  + "("
                + Element.KEY_ElementID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Element.KEY_ElementNom + " TEXT, "
                + Element.KEY_url + " TEXT, "
                + Element.KEY_CategorieID   + " INTEGER )";
    }
    public int insert(Element elem) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Element.KEY_ElementNom, elem.getNom());
        values.put(Element.KEY_url, elem.getUrl());
        values.put(Element.KEY_CategorieID, elem.getCategorieId());
        // Inserting Row
        long id = db.insert(elem.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return (int)id;
    }
    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Element.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public ArrayList<Element> getAllElements() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor c = db.query(Element.TABLE, new String[] {}, null, null, null, null, Element.KEY_CategorieID);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        ArrayList<Element> elementList = new
                ArrayList<Compte> ();
        while (c.moveToNext()) {
            Element elem = new Element();
            elem.setId(c.getInt(0));
            elem.setNom(c.getString(1));
            elem.setUrl(c.getString(2));
            elem.setCategorieId(c.getInt(3));
            elementList.add(elem);
        }
        c.close();
        return elementList;
    }
}
