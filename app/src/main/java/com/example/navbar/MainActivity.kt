package com.example.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(recaudos())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.recaudos_menu -> replaceFragment(recaudos())
                R.id.saldos_menu -> replaceFragment(saldos())
                R.id.caja_menu -> replaceFragment(caja())

                else ->{

                }

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_contenido,fragment)
        fragmentTransaction.commit()
    }
}