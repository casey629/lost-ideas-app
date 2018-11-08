package com.app.ergin.lostideasapp

class Idea {
    var id : Int = 0
    var name: String = ""
    var type: String = ""

    constructor(name: String,type: String){
        this.name = name
        this.type = type
    }
    constructor(){

    }
}