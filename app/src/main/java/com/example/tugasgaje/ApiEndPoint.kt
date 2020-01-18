package com.example.tugasgaje

class ApiEndPoint {
    companion object{

        private val SERVER = "http://192.168.1.1/belajar_kotlin"
        val  CREATE = SERVER+"create_fakultas.php"
        val  READ = SERVER+"read_fakultas.php"
        val UPDATE = SERVER+"update_fakultas.php"
        val DELETE = SERVER+"delete_fakultas.php"
    }

}