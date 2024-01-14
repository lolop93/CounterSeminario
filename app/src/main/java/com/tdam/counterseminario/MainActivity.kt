package com.tdam.counterseminario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tdam.counterseminario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var counter : Int = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCount()

        binding.btnSum.setOnClickListener {
            counter++
            setCount()
        }

        binding.btnSum.setOnLongClickListener {
            counter--
            setCount()
            true
        }
    }

    private fun setCount() {
        binding.tvCount.text = counter.toString()
    }


    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)

        outState.run{
            putInt("counter", counter)
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter = savedInstanceState.getInt("counter")
        setCount()
    }

}