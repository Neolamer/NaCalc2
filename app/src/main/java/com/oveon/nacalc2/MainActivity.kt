package com.oveon.nacalc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0.setOnClickListener{ setTextFields("0")}
        button1.setOnClickListener{ setTextFields("1")}
        button2.setOnClickListener{ setTextFields("2")}
        button3.setOnClickListener{ setTextFields("3")}
        button4.setOnClickListener{ setTextFields("4")}
        button5.setOnClickListener{ setTextFields("5")}
        button6.setOnClickListener{ setTextFields("6")}
        button7.setOnClickListener{ setTextFields("7")}
        button8.setOnClickListener{ setTextFields("8")}
        button9.setOnClickListener{ setTextFields("9")}

        buttonLeftBracket.setOnClickListener{ setTextFields("(")}
        buttonRightBracket.setOnClickListener{ setTextFields(")")}

        buttonPlus.setOnClickListener{
            if(calculation.text != ""){
                var checkStr: String = calculation.text.toString().takeLast(1)
                if(checkStr != "+" && checkStr != "-" && checkStr != "*" && checkStr != "/"){
                    setTextFields("+")
                }
            }
        }
        buttonMinus.setOnClickListener{
            if(calculation.text != ""){
                var checkStr: String = calculation.text.toString().takeLast(1)
                if(checkStr != "+" && checkStr != "-" && checkStr != "*" && checkStr != "/"){
                    setTextFields("-")
                }
            }
        }
        buttonDot.setOnClickListener{
            if(calculation.text != ""){
                var checkStr: String = calculation.text.toString().takeLast(1)
                if(checkStr != "+" && checkStr != "-" && checkStr != "*" && checkStr != "/"){
                    setTextFields(".")
                }
            }
        }
        buttonDivision.setOnClickListener{
            if(calculation.text != ""){
                var checkStr: String = calculation.text.toString().takeLast(1)
                if(checkStr != "+" && checkStr != "-" && checkStr != "*" && checkStr != "/"){
                    setTextFields("/")
                }
            }
        }

        buttonMultiplication.setOnClickListener{
            if(calculation.text != ""){
                var checkStr: String = calculation.text.toString().takeLast(1)
                if(checkStr != "+" && checkStr != "-" && checkStr != "*" && checkStr != "/"){
                    setTextFields("*")
                }
            }
        }

        buttonClear.setOnClickListener{
            calculation.text = ""
            result_text.text = ""
        }

        buttonDelete.setOnClickListener{
            val str = calculation.text.toString()
            if(str.isNotEmpty()){
                calculation.text = str.substring(0, str.length - 1)
                result_text.text = ""
            }
        }

        buttonEqual.setOnClickListener{
            if(calculation.text != ""){
                var str: String = calculation.text.toString()
                var checkStr: String = str.takeLast(1)
                if(checkStr == "+" || checkStr == "-" || checkStr == "*" || checkStr == "/"){
                    calculation.text = str.substring(0, str.length - 1)
                }
            }
            try {
                val ex = ExpressionBuilder(calculation.text.toString()).build()
                val result = ex.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()){
                    result_text.text = longResult.toString()
                }
            }catch (e: Exception){
                Log.d("ERROR ", " CODE in ${e.message}");
            }
        }
    }

    fun setTextFields(str: String){
        calculation.append(str)
    }

}