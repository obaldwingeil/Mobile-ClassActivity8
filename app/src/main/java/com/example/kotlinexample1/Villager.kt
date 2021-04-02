package com.example.kotlinexample1

// data class ClassName (val x: type, val y: type)
data class Villager (val name: String, val birthday: String, val phrase: String,
                     val houseURL: String, val villagerURL: String, var clicked : Boolean){
    // automatically contains mathods
    // toString
        // Villager(name="Henry", birthday="...", ...)
    // getters
    // setters (when you have var type)
    // equals
    // etc.

}

// val -> do not come with setters
// var -> come with setters and getters