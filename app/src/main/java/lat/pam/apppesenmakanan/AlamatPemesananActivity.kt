package lat.pam.apppesenmakanan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlamatPengirimanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_pemesanan)

        val etNamaLengkap = findViewById<EditText>(R.id.etNamaLengkap)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val etPatokan = findViewById<EditText>(R.id.etPatokan)
        val btnOrderKirim = findViewById<Button>(R.id.btnOrderKirim)

        btnOrderKirim.setOnClickListener {
            val nama = etNamaLengkap.text.toString()
            val alamat = etAlamat.text.toString()
            val patokan = etPatokan.text.toString()

            if (nama.isEmpty() || alamat.isEmpty() || patokan.isEmpty()) {
                Toast.makeText(this, "Lengkapi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Pindah ke halaman selesai
                val intent = Intent(this, SelesaiActivity::class.java)
                intent.putExtra("namaLengkap", nama)
                startActivity(intent)
                finish() // optional: biar halaman alamat ditutup
            }
        }
    }
}
