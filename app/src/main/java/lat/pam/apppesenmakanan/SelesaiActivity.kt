package lat.pam.apppesenmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelesaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selesai)

        val btnSelesai: Button = findViewById(R.id.btnSelesai)

        btnSelesai.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // supaya tidak bisa kembali ke halaman sebelumnya
        }
    }
}
