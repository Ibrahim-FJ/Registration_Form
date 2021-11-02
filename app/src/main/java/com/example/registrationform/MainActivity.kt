package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.registrationform.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {

    lateinit var bindingMainActivity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)



       val items = listOf("Male", "Female")
       val adapter = ArrayAdapter(this, R.layout.list_item, items)
        bindingMainActivity.textFieldGender.setAdapter(adapter)
        bindingMainActivity.registerButton.setOnClickListener{

            checkIfFillElements()

        }

        bindingMainActivity.editTextDate.setOnClickListener {

            val datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                    .build().show(supportFragmentManager, "tag")


        }
    }

    private fun changeTheme() {
        TODO("Not yet implemented")
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

//                val gender = when(bindingMainActivity.textFieldGender.){
//                    R.id.male_radioBt -> "male"
//                    R.id.female_radioBt -> "female"
//
//                    else -> ""
//                }
                val gender = bindingMainActivity.textFieldGender.text.toString()

                if(bindingMainActivity.editTextTextEmailAddress3.text.toString().contains("@") && bindingMainActivity.editTextTextEmailAddress3.text.toString().contains(".")){
                    bindingMainActivity.textView5.text = "Name: ${bindingMainActivity.passwordEditText.text.toString()}\n " +
                            "Password: ${bindingMainActivity.editTextTextEmailAddress.text}\n Email: " +
                            "${bindingMainActivity.editTextTextEmailAddress3.text}\nBirthday: " +
                            "${bindingMainActivity.editTextDate.text}\n$gender"


                }else{
                    bindingMainActivity.editTextTextEmailAddress3.error = "Email is not valid"
                   // bindingMainActivity.textView5.text = "Email is not valid"

                }


            }
        }


    }
}