package com.example.practiceone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import com.app.splashscreen.R
import com.example.practiceone.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

//import com.example.practiceone.R.id.btnSend

class MainActivity : AppCompatActivity() {

    //edit text for input the data
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobile: EditText
    lateinit var etAddress: EditText
    lateinit var etDob: EditText
    lateinit var etPass1: EditText
    lateinit var etPass2: EditText

    private lateinit var dbref: DatabaseReference


    // button for pass the data to another activity
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.name)
        etEmail = findViewById(R.id.email)
        etMobile = findViewById(R.id.pno)
        etAddress = findViewById(R.id.address)
        etDob = findViewById(R.id.dob)
        etPass1 = findViewById(R.id.pass1)
        etPass2 = findViewById(R.id.pass2)

        btnSend = findViewById(R.id.btnSend)

        dbref = FirebaseDatabase.getInstance().getReference("PracticeOne")


        btnSend.setOnClickListener {
            saveDataBase()
//            val bundle = Bundle()
//            bundle.putString("name", etName.text.toString())
//            bundle.putString("email", etEmail.text.toString())
//            bundle.putString("mobile", etMobile.text.toString())
//            bundle.putString("address", etAddress.text.toString())
//            bundle.putString("dob", etDob.text.toString())
//            bundle.putString("password", etPass1.text.toString())
//            bundle.putString("confirmPassword", etPass2.text.toString())
//
//
//            val intent = Intent(this, ReceiverActivity::class.java)
//            intent.putExtras(bundle)
//            startActivity(intent)

        }
    }

    private fun saveDataBase() {
        val studName = etName.text.toString()
        val studEmail = etEmail.text.toString()
        val studMobile=etMobile.text.toString()
        val studAddress=etAddress.text.toString()
        val studDob=etDob.text.toString()
        val studPass1=etPass1.text.toString()
        val studPass2=etPass2.text.toString()

        if (studName.isBlank() && studMobile.isBlank() && studEmail.isBlank() && studMobile.isBlank() && studAddress.isBlank()
            && studDob.isBlank() && studPass1.isBlank() && studPass2.isBlank()) {
            Toast.makeText(this, "Please", Toast.LENGTH_LONG).show()
        } else {
            val studId = dbref.push().key!!

            val studData = PassDataModel(studId, studName,studEmail,studAddress,studDob,studPass1,studPass2)

            dbref.child(studId).setValue(studData)
                .addOnCompleteListener {
                    Toast.makeText(this, "saved", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error ${it.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}