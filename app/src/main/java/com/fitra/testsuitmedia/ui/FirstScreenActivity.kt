package com.fitra.testsuitmedia.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.fitra.testsuitmedia.data.Preference
import com.fitra.testsuitmedia.databinding.ActivityFirstScreenBinding

class FirstScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val pref = Preference(this)
            val username = binding.etName.text.toString()
            pref.username = username
            val intent = Intent(this, SecondScreenActivity::class.java)
            startActivity(intent)
        }

        binding.btnCheck.setOnClickListener {
            val palindrome = binding.etPalindrome.text.toString().trim()
            val isPalindrome = isPalindrome(palindrome)
            if (palindrome.isNullOrEmpty()){
                Toast.makeText(this, "Input Word First!!", Toast.LENGTH_SHORT).show()
            }else{
                showDialogPalindrome(isPalindrome)
            }

        }
    }

    private fun showDialogPalindrome(isPalindrome: Boolean) {
        val msg = if (isPalindrome) "isPalindrome" else "not Palindrome"
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage(msg)
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
        val dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun isPalindrome(text: String): Boolean {
        val reverseString = text.toLowerCase().replace("\\W".toRegex(), "")
        return reverseString == reverseString.reversed()
    }
}