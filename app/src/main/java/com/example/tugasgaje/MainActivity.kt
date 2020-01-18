package com.example.tugasgaje


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adus = findViewById<EditText>(R.id.adus)
        val pass = findViewById<EditText>(R.id.pass)

        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener{
            val adus = adus.text.toString()
            val pass = pass.text.toString()

            if(adus == "admin" && pass == "admin123"){
                val intent = Intent(this@MainActivity,admin::class.java)
                startActivity(intent)
            }
            else if (adus == "user" && pass == "user123"){
                val intent = Intent(this@MainActivity,user::class.java)
                startActivity(intent)
            }
            else{
                toast("Anda Siapa ? ", Toast.LENGTH_LONG)
            }
        }
    }
    private fun toast(pesan: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, pesan, length).show()

    }
}
