package com.app.ergin.lostideasapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "IdeaDB"
val TABLE_NAME = "Ideas"
val COL_ID = "id"
val COL_IDEA_NAME = "idea_name"
val COL_IDEA_TYPE = "idea_type"

class DBHandler (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    // Database'de table oluşturuldu.
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_IDEA_NAME + "VARCHAR(256)," +
                COL_IDEA_TYPE + "VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }



}