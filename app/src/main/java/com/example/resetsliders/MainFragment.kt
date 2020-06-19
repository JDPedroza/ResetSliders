package com.example.resetsliders

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import com.example.resetsliders.util.Aleatorio


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    var onNumeroAleatorio: OnNumeroAleatorio? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    interface OnNumeroAleatorio {
        fun actualizado(numero: Int)
    }

    fun actualizarNumero(min: Int, max: Int) {
        val numeroAleatorio: Int = Aleatorio.generar(min, max)
        tvNumeroAleatorio.text = "$numeroAleatorio"
        onNumeroAleatorio?.actualizado(numeroAleatorio)
    }

    fun changeTextFragment(){
        tvNumeroAleatorio.text = "Prueba Correcta";
    }

    /*
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnNumeroAleatorio) {
            onNumeroAleatorio = context
        } else {
            throw RuntimeException(requireContext().toString() + " debe implementar OnNumeroAleatorio")
        }
    }
     */

    override fun onDetach() {
        super.onDetach()
        onNumeroAleatorio = null
    }
}
