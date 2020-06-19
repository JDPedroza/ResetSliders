package com.example.resetsliders.controller.activity

import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.resetsliders.BurnerAssembly
import com.example.resetsliders.MainFragment

/**
 * Created by alberto on 25/11/17.
 */
class MainActivityController {
    companion object {
        fun addFragment(supportFragmentManager: FragmentManager, contenedor: View, fragment: Fragment) {
            supportFragmentManager.beginTransaction().add(contenedor.id, fragment).commit()
        }

        fun resetFragment(fragment: BurnerAssembly){
            fragment.resetForm();
        }

        fun changeText(fragment: MainFragment){
            fragment.changeTextFragment();
        }
    }
}