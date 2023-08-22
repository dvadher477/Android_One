package com.example.practiceone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//import com.app.splashscreen.R
import com.example.practiceone.R

class ReceiverActivity : AppCompatActivity() {

    lateinit var tvName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvMobile: TextView
    lateinit var tvAddress: TextView
    lateinit var tvDob: TextView
    lateinit var tvPass1: TextView
    lateinit var tvPass2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        tvName = findViewById(R.id.tvNameData)
        tvEmail = findViewById(R.id.tvEmailData)
        tvMobile = findViewById(R.id.tvMobileData)
        tvAddress = findViewById(R.id.tvAddressData)
        tvDob = findViewById(R.id.tvDobData)
        tvPass1 = findViewById(R.id.tvPass1Data)
        tvPass2 = findViewById(R.id.tvPass2Data)


        val bundle = intent.extras

        if (bundle != null) {
            tvName.text = "${bundle.getString("name")}"
            tvEmail.text = "${bundle.getString("email")}"
            tvMobile.text = "${bundle.getString("mobile")}"
            tvAddress.text = "${bundle.getString("address")}"
            tvDob.text = "${bundle.getString("dob")}"
            tvPass1.text = "${bundle.getString("password")}"
            tvPass2.text = "${bundle.getString("confirmPassword")}"
        }
    }
}