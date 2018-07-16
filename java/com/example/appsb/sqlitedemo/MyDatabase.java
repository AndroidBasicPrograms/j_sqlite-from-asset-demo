package com.example.appsb.sqlitedemo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;

/**
 * Created by appsb on 13-07-2018.
 */
public class MyDatabase extends SQLiteAssetHelper {

    public MyDatabase(Context context) {
        super(context, constants.DB_NAME, null, constants.DATABASE_VERSION);
    }

    public ArrayList<dbModel> getWord()
    {
        SQLiteDatabase db=getWritableDatabase();
        String[] columns={constants.WORD_WORDID,constants.WORD_WORD};
        Cursor cursor=db.query(constants.TB_WORD, columns, null, null, null, null, null);

        ArrayList<dbModel> wordList=new ArrayList<>();

        while(cursor.moveToNext()){
            dbModel wmodel=new dbModel();
            wmodel.wordid=cursor.getInt(cursor.getColumnIndex(constants.WORD_WORDID));
            wmodel.word=cursor.getString(cursor.getColumnIndex(constants.WORD_WORD));
            wordList.add(wmodel);
        }
        return wordList;
    }

    public ArrayList<dbModel> getImage(int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        String[] columns={constants.IMAGE_IMAGID,constants.IMAGE_IMAGENAME,constants.IMAGE_WORD_ID};

        Cursor cursor = db.rawQuery("SELECT * FROM "+ constants.TB_IMAGE +" WHERE wordID ="+ id , null);
        ArrayList<dbModel> wordList=new ArrayList<>();

        while(cursor.moveToNext()){
            dbModel wmodel=new dbModel();
            wmodel.wordid=cursor.getInt(cursor.getColumnIndex(constants.IMAGE_WORD_ID));
            wmodel.image=cursor.getString(cursor.getColumnIndex(constants.IMAGE_IMAGENAME));
            wordList.add(wmodel);
        }
        return wordList;
    }

}