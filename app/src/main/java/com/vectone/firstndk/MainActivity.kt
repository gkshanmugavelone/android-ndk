package com.vectone.firstndk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vectone.firstndk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //  binding.tvResult.text = add(100, 200).toString()
        //binding.welcome.text = stringFromJNI()

        binding.btnAdd.setOnClickListener {
            val a: Int = binding.etA.text.toString().toInt()
            val b: Int = binding.etB.text.toString().toInt()
            binding.tvResult.text = "Result: " + add(a, b).toString()
        }

        binding.btnSub.setOnClickListener {
            val a: Int = binding.etA.text.toString().toInt()
            val b: Int = binding.etB.text.toString().toInt()
            binding.tvResult.text = "Result: " + sub(a, b).toString()
        }

        binding.btnMul.setOnClickListener {
            val a: Int = binding.etA.text.toString().toInt()
            val b: Int = binding.etB.text.toString().toInt()
            binding.tvResult.text = "Result: " + mul(a, b).toString()
        }

        binding.btnDiv.setOnClickListener {
            val a: Int = binding.etA.text.toString().toInt()
            val b: Int = binding.etB.text.toString().toInt()
            binding.tvResult.text = "Result: " + div(a, b).toString()
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun add(x: Int, y: Int): Int
    external fun sub(x: Int, y: Int): Int
    external fun mul(x: Int, y: Int): Int
    external fun div(x: Int, y: Int): Int
    external fun inputFromJava(x: String): Unit

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
            System.loadLibrary("calculator")
        }
    }
}