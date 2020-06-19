package com.example.resetsliders.controller.activity

import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.resetsliders.MainFragment

/**
 * Created by alberto on 25/11/17.
 */
class MainActivityController {
    companion object {
        fun addFragment(supportFragmentManager: FragmentManager, contenedor: View, fragment: Fragment) {
            supportFragmentManager.beginTransaction().add(contenedor.id, fragment).commit()
        }

        fun actualizarNumeroAleatorio(fragment: MainFragment, etMin: EditText, etMax: EditText) {
            val min = comprobarNumeroEntrada(etMin)
            val max = comprobarNumeroEntrada(etMax)
            if (min < max) {
                fragment.actualizarNumero(min, max)
            } else {
                throw Exception()
            }
        }


        fun changeText(fragment: MainFragment){
            fragment.changeTextFragment();
        }


        fun comprobarNumeroEntrada(et: EditText): Int {
            return if (et.text.toString().isNullOrEmpty()) 0 else et.text.toString().toInt()
        }
    }
}