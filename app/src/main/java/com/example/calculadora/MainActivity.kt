package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var numero1EditText : EditText;
    private lateinit var numero2EditText : EditText;

    private lateinit var adicaoButton : Button;
    private lateinit var substracaoButton : Button;
    private lateinit var multiplicacaoButton : Button;
    private lateinit var divisaoButton : Button;

    private lateinit var resultadoTextView : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        vincularComponentes();
        criarListeners();
    }


    private fun vincularComponentes(){
        numero1EditText = findViewById(R.id.numero1EditText);
        numero2EditText = findViewById(R.id.numero2EditText);

        adicaoButton = findViewById(R.id.adicaoButton);
        substracaoButton =  findViewById(R.id.subtracaoButton);
        multiplicacaoButton = findViewById(R.id.multiplicacaoButton);
        divisaoButton = findViewById(R.id.divisaoButton);

        resultadoTextView = findViewById(R.id.resultadoTextView);

    }

    private fun criarListeners(){
        adicaoButton.setOnClickListener {
            adicionar(); };

        substracaoButton.setOnClickListener {
            substrair();
        };

        multiplicacaoButton.setOnClickListener {
            multiplicar();
        };

        divisaoButton.setOnClickListener {
            dividir();
        };
    }

    private fun adicionar(){
        val numero1String = numero1EditText.text.toString();
        val numero2String = numero2EditText.text.toString();

        if ( numero1String.isEmpty() || numero2String.isEmpty() ){
            Toast.makeText(this,"Digite os dois números", Toast.LENGTH_LONG).show();
            return;
        }

        val numero1 = numero1String.toDouble();
        val numero2 = numero2String.toDouble();

        val resultado =  numero1 + numero2 ;

        resultadoTextView.text = resultado.toString();

    }

    private  fun substrair(){

        val numero1String = numero1EditText.text.toString();
        val numero2String = numero2EditText.text.toString();

        if(numero1String.isEmpty() || numero2String.isEmpty()){
            Toast.makeText(this,"Digite os dois números", Toast.LENGTH_LONG).show();
            return;
        }

        val numero1 = numero1String.toDouble();
        val numero2 = numero2String.toDouble();

        val resultado = numero1 - numero2 ;

        resultadoTextView.text = resultado.toString();
    }

    private fun multiplicar(){

        val numero1String = numero1EditText.text.toString();
        val numero2String = numero2EditText.text.toString();

        if (numero1String.isEmpty() || numero2String.isEmpty()){
            Toast.makeText(this, "Digite os dois números", Toast.LENGTH_LONG).show();
            return;
        }

        val numero1 = numero1String.toDouble();
        val numero2 = numero2String.toDouble();

        val resultado = numero1 * numero2 ;
        resultadoTextView.text = resultado.toString();
    }

    private fun dividir(){

        val numero1String = numero1EditText.text.toString();
        val numero2String = numero2EditText.text.toString();

        if(numero1String.isEmpty() || numero2String.isEmpty()){
            Toast.makeText(this,"Digite os dois números", Toast.LENGTH_LONG).show();

            return;
        }



        val numero1 = numero1String.toDouble();
        val numero2 = numero2String.toDouble();
        if (numero2 == 0.0 ){
            Toast.makeText(this,"Não é possivel dividir por 0",Toast.LENGTH_LONG).show();
            return;
        }


        val resultado = numero1 / numero2 ;

        resultadoTextView.text = resultado.toString();
    }
}