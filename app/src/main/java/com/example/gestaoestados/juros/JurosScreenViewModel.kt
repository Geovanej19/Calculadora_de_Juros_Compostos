package com.example.gestaoestados.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gestaoestados.calculos.calcularJuros
import com.example.gestaoestados.calculos.calcularMontante

class JurosScreenViewModel: ViewModel() {
    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private  val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa

    private  val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo

    private val _juros = MutableLiveData<Double>()
    val juros: LiveData<Double> = _juros

    private val _montante = MutableLiveData<Double>()
    val montante: LiveData<Double> = _montante



    fun onCapitalChanged(novoCapital: String) {
        _capital.value = novoCapital
    }

    fun onTaxaChanged(novaTaxa: String) {
        _taxa.value = novaTaxa
    }

    fun onTempoChanged(novoTempo: String) {
        _tempo.value = novoTempo
    }

    fun calcularJurosInvetimento() {
        _juros.value = calcularJuros(
            this._capital.value!!.toDouble(), //Confia que vem um valor
            taxa = _taxa.value!!.toDouble(),
            tempo = _tempo.value!!.toDouble()
        )
    }

    fun calcularMontanteInvestimento() {
        _montante.value = calcularMontante(
            this._capital.value!!.toDouble(), //Confia que vem um valor
            juros = _juros.value!!
        )
    }
}