package com.example.chao_corountine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class SchoolActivity : AppCompatActivity() {

    lateinit var viewModel: SchoolViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SchoolViewModel:: class.java)

        viewModel.school.observe(this, Observer { school ->
            //todo doing some logic on ui for the school we fetch from server
        })

        viewModel.setSchoolId("123")

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs() // we dont want leave the network request pending on the background -> equaly to pass lifecycle to service layer
    }
}
