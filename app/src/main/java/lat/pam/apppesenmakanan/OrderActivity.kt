package lat.pam.apppesenmakanan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val tvNamaUser: TextView = findViewById(R.id.tvNamaUser)
        val tvPesanan: TextView = findViewById(R.id.tvPesanan)
        val btnKirim: Button = findViewById(R.id.btnKirim)

        val namaUser = intent.getStringExtra("namaLengkap") ?: "User"
        val namaPizza = intent.getStringExtra("pizzaName") ?: "-"

        tvNamaUser.text = "Halo $namaUser,"
        tvPesanan.text = "Pesanan saya:\n$namaPizza"

        btnKirim.setOnClickListener {
            val intent = Intent(this, AlamatPengirimanActivity::class.java)

            // Kirim juga data pesanan (optional)
            intent.putExtra("namaLengkap", namaUser)
            intent.putExtra("pizzaName", namaPizza)

            startActivity(intent)
        }
    }
}
