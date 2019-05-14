package com.adriano.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Numeros
        button1.setOnClickListener { appendOnExpression("1", true) }
        button2.setOnClickListener { appendOnExpression("2", true) }
        button3.setOnClickListener { appendOnExpression("3", true) }
        button4.setOnClickListener { appendOnExpression("4", true) }
        button5.setOnClickListener { appendOnExpression("5", true) }
        button6.setOnClickListener { appendOnExpression("6", true) }
        button7.setOnClickListener { appendOnExpression("7", true) }
        button8.setOnClickListener { appendOnExpression("8", true) }
        button9.setOnClickListener { appendOnExpression("9", true) }
        button0.setOnClickListener { appendOnExpression("0", true) }


        //Operações
        buttonponto.setOnClickListener { appendOnExpression(".", true) }
        buttonsomar.setOnClickListener { appendOnExpression("+", true) }
        buttondiminuir.setOnClickListener { appendOnExpression("-", true) }
        buttondividir.setOnClickListener { appendOnExpression("/", true) }
        buttonmultiplicar.setOnClickListener { appendOnExpression("*", true) }


        buttondel.setOnClickListener {
            conta.text = ""
            resultado.text = ""

        }

        buttonigual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(conta.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    resultado.text = longResult.toString()
                else
                    resultado.text = result.toString()
            } catch (e: Exception) {
                Log.d("Exeption", "Message :" + e.message)
            }
        }


    }

    fun appendOnExpression(string: String, canClear: Boolean) {

        if (resultado.text.isNotEmpty()) {
            conta.text = resultado.text
        }
        if (canClear) {
            resultado.text = ""
            conta.append(string)
        } else {
            conta.append(resultado.text)
            conta.append(string)
            resultado.text = ""
        }

    }
}
