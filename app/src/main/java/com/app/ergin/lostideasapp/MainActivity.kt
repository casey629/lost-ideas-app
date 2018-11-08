package com.app.ergin.lostideasapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        val db = DBHandler(context)
        btn_ideasave.setOnClickListener {
            if (et_ideaname.text.toString().length > 0 &&
                    et_ideatype.text.toString().length > 0){
                var idea = Idea(et_ideaname.text.toString(),et_ideatype.text.toString())
                Log.i("deneme","insert oncesi")
                db.insertData(idea)
            }else {
                Toast.makeText(context,"Boş alanları doldurunuz",Toast.LENGTH_SHORT).show()
            }


        }
    }
}
