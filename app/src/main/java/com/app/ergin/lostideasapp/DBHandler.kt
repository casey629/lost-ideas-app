package com.app.ergin.lostideasapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

val DATABASE_NAME = "IdeaDB"
val TABLE_NAME = "Ideas"
val COL_ID = "idea_id"
val COL_IDEA_NAME = "idea_name"
val COL_IDEA_TYPE = "idea_type"

class DBHandler (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    // Database'de table oluşturuldu.
    override fun onCreate(db: SQLiteDatabase?) {
        Log.i("info","db 1")

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY," +
                COL_IDEA_NAME + " VARCHAR(256)," +
                COL_IDEA_TYPE + " VARCHAR(256)" + " )"
        db?.execSQL(createTable)
        Log.i("info","olusturuldu")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(idea: Idea) {
        val db = this.writableDatabase
        var content = ContentValues()
        content.put(COL_IDEA_NAME,idea.name)
        content.put(COL_IDEA_TYPE,idea.type)
        val result = db.insert(TABLE_NAME,null,content) // long tipinde result döndürüyor
        if (result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()

    }


}