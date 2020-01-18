package com.example.tugasgaje

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_admin.*
import org.json.JSONObject

class user : AppCompatActivity() {
    lateinit var  i : Intent
    lateinit var  add: Button
    lateinit var edit: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        add = findViewById(R.id.btnCreate)
        edit = findViewById(R.id.btnUpdate)


        i = intent
        if (i.hasExtra("editMode")){
            if (i.getStringExtra("editMode").equals("1")){
                onEditMode()
            }
        }
        add.setOnClickListener {
            onCreate()
        }
        edit.setOnClickListener {
            onUpdate()
        }
    }
    private fun onEditMode(){

        txt_idfakultas.setText(i.getStringExtra("txt_idfakultas"))
        txt_kodefakultas.setText(i.getStringExtra("txt_kodefakultas"))
        txt_namafakultas.setText(i.getStringExtra("txt_namafakultas"))
        txt_idfakultas.isEnabled = false


        btnCreate.visibility = View.GONE
        btnUpdate.visibility = View.VISIBLE
        btnDelete.visibility = View.VISIBLE

    }

    private fun onCreate(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan Data .....")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.CREATE)
            .addBodyParameter("kode_fakultas",txt_kodefakultas.toString())
            .addBodyParameter("nama_fakultas",txt_namafakultas.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                    if (response?.getString("message")?.contains("succesfully")!!){
                        this@user.finish()
                    }
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Succesfull", Toast.LENGTH_SHORT).show()
                }
            })

    }
    private fun onUpdate(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan Data .....")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.UPDATE)
            .addBodyParameter("id_fakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("kode_fakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("nama_fakultas",txt_namafakultas.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                    if (response?.getString("message")?.contains("succesfully")!!){
                        this@user.finish()
                    }
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Succesfull", Toast.LENGTH_SHORT).show()
                }
            })

    }


}