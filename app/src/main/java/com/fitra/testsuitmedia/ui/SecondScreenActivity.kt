package com.fitra.testsuitmedia.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fitra.testsuitmedia.data.DataItem
import com.fitra.testsuitmedia.data.Preference
import com.fitra.testsuitmedia.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icBack.setOnClickListener {
            onBackPressed()
        }

        val pref = Preference(this)
        val data = intent.getParcelableExtra<DataItem>(USERNAME)
        if (data == null){
            binding.tvUsername.text = pref.username
            binding.tvSelectedUsername
        }else{
            binding.tvUsername.text = pref.username
            binding.tvSelectedUsername.text = data?.firstName + " " + data?.lastName
        }

        binding.btnChooseUser.setOnClickListener {
            startActivity(Intent(this, ThirdScreenActivity::class.java))
        }
    }

    companion object{
        const val USERNAME = "username"
    }
}