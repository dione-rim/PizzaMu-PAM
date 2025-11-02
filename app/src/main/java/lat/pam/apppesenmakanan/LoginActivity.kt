package lat.pam.apppesenmakanan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLoginSubmit)

        // Ambil data user yang tersimpan dari RegisterActivity
        val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val savedUsername = sharedPref.getString("username", null)
        val savedPassword = sharedPref.getString("password", null)
        val savedNamaLengkap = sharedPref.getString("namaLengkap", "User")

        btnLogin.setOnClickListener {
            val inputUsername = etUsername.text.toString().trim()
            val inputPassword = etPassword.text.toString().trim()

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show()
            } else if (inputUsername == savedUsername && inputPassword == savedPassword) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                // Pindah ke halaman utama dan kirim nama
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("namaLengkap", savedNamaLengkap)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
