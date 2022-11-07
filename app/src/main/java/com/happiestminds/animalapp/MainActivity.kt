package com.happiestminds.animalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.lang.reflect.Array.newInstance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = AnimalFragment.newInstance(2,1)
        supportFragmentManager.beginTransaction().add(R.id.placeholderF,frag).commit()

    }

    fun buttonClick(view: View) {
        when(view.id){
            R.id.wildB->
            {
                val frag = AnimalFragment.newInstance(2,2)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeholderF,frag)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.domB->{
                val frag = AnimalFragment.newInstance(2,1)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeholderF,frag)
                    .addToBackStack(null)
                    .commit()

            }
        }
    }
}