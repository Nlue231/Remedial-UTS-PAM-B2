package b2.uts1903040017.ariqfadhlurrahman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edNilai1: EditText
    private lateinit var edNilai2: EditText
    private lateinit var edNilai3: EditText
    private lateinit var bthitung: Button
    private lateinit var tvIpk: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        edNilai1 = findViewById(R.id.edNilai1)
        edNilai2 = findViewById(R.id.edNilai2)
        edNilai3 = findViewById(R.id.edNilai3)
        bthitung = findViewById(R.id.bthitung)
        tvIpk = findViewById(R.id.tvIpk)

        bthitung.setOnClickListener(this)

    }

    fun angka_ke_huruf(nilai: Double): String{
        var huruf = "E"
        if (nilai >= 86){
            huruf = "A"
        }else if (nilai >= 81){
            huruf = "A-"
        }else if (nilai >= 76){
            huruf = "B+"
        }else if (nilai >= 71){
            huruf = "B"
        }else if (nilai >= 66){
            huruf = "B-"
        }else if (nilai >= 61){
            huruf = "C+"
        }else if (nilai >= 56){
            huruf = "C"
        }else if (nilai >= 41){
            huruf = "D"
        }else huruf = "E"
        return huruf
    }

    fun huruf_ke_point(huruf: String): Double{
        var poin = 0.0
        if (huruf.equals("A")){
            poin = 4.0
        } else if (huruf.equals("A-")){
            poin = 3.75
        } else if (huruf.equals("B+")){
            poin = 3.5
        } else if (huruf.equals("B")){
            poin = 3.0
        } else if (huruf.equals("B-")){
            poin = 2.75
        } else if (huruf.equals("C+")){
            poin = 2.5
        } else if (huruf.equals("C")){
            poin = 2.0
        } else if (huruf.equals("D")){
            poin = 1.0
        } else if (huruf.equals("E")){
            poin = 0.0
        }

        return poin
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.bthitung) {
            val inputNilai1 = edNilai1.text.toString().trim()
            val inputNilai2 = edNilai2.text.toString().trim()
            val inputNilai3 = edNilai3.text.toString().trim()

            val hurufNilai1 = angka_ke_huruf(inputNilai1.toDouble())
            val pointNilai1 = huruf_ke_point(hurufNilai1)

            val hurufNilai2 = angka_ke_huruf(inputNilai2.toDouble())
            val pointNilai2 = huruf_ke_point(hurufNilai2)

            val hurufNilai3 = angka_ke_huruf(inputNilai3.toDouble())
            val pointNilai3 = huruf_ke_point(hurufNilai3)

            val jmlSks = 3 * 3
            var ipk = ((pointNilai1 * 3) + (pointNilai2 * 3) + (pointNilai3 * 3)) / jmlSks

            tvIpk.text = "IPK Kamu adalah " + ipk

        }
    }
}