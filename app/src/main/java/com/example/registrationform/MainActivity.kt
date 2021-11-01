package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingMainActivity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        bindingMainActivity.registerButton.setOnClickListener{
            checkIfFillElements()

        }
    }


    private fun checkIfFillElements() {
        if(bindingMainActivity.passwordEditText.text.toString().isEmpty() ||
            bindingMainActivity.editTextTextEmailAddress.text.toString().isEmpty() ||
                bindingMainActivity.editTextTextEmailAddress2.text.toString().isEmpty() ||
                bindingMainActivity.editTextDate.text.toString().isEmpty() ||
                bindingMainActivity.editTextTextEmailAddress3.text.toString().isEmpty()){

            bindingMainActivity.textView5.text = "Enter the information"

        } else {

            if(bindingMainActivity.editTextTextEmailAddress.text.toString() != bindingMainActivity.editTextTextEmailAddress2.text.toString()){
                bindingMainActivity.textView5.text = "Password doesn't match"
            }else{

                val gender = when(bindingMainActivity.radioGroup.checkedRadioButtonId){
                    R.id.male_radioBt -> "male"
                    R.id.female_radioBt -> "female"

                    else -> ""
                }

                if(bindingMainActivity.editTextTextEmailAddress3.text.toString().contains("@") && bindingMainActivity.editTextTextEmailAddress3.text.toString().contains(".")){
                    bindingMainActivity.textView5.text = "Name: ${bindingMainActivity.passwordEditText.text.toString()}\n " +
                            "Password: ${bindingMainActivity.editTextTextEmailAddress.text}\n Email: " +
                            "${bindingMainActivity.editTextTextEmailAddress3.text}\nBirthday: " +
                            "${bindingMainActivity.editTextDate.text}\nGender: ${gender}"

                }else{
                    bindingMainActivity.textView5.text = "Email is not valid"

                }






            }
        }


    }
}