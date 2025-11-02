package lat.pam.apppesenmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val namaUser = intent.getStringExtra("namaLengkap") ?: "User"

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_order -> {
                    // nanti kamu bisa buat halaman riwayat order
                    true
                }
                else -> false
            }
        }

        val pizza1 = findViewById<LinearLayout>(R.id.cardPizzaMargherita)
        val pizza2 = findViewById<LinearLayout>(R.id.cardPizzaSpicy)
        val pizza3 = findViewById<LinearLayout>(R.id.cardPizzaBBQ)
        val pizza4 = findViewById<LinearLayout>(R.id.cardPizzaCheese)
        val pizza5 = findViewById<LinearLayout>(R.id.cardPizzaVeggie)
        val pizza6 = findViewById<LinearLayout>(R.id.cardPizzaBeefMushroom)
        val pizza7 = findViewById<LinearLayout>(R.id.cardPizzaMeatLovers)
        val pizza8 = findViewById<LinearLayout>(R.id.cardPizzaPepperoni)
        val pizza9 = findViewById<LinearLayout>(R.id.cardPizzaHawaiian)
        val pizza10 = findViewById<LinearLayout>(R.id.cardPizzaTunaMelt)

        pizza1.setOnClickListener { openOrderPage("Margherita Pizza\n Pizza klasik Italia dengan saus tomat segar, potongan mozzarella, dan daun basil. Simpel tapi kaya rasa!", namaUser) }
        pizza2.setOnClickListener { openOrderPage("Spicy Pizza\n Cocok untuk pecinta pedas! Perpaduan saus tomat pedas, cabai segar, dan daging cincang membuat tiap gigitan terasa menggigit \uD83D\uDD25", namaUser) }
        pizza3.setOnClickListener { openOrderPage("BBQ Pizza\n Dibalut saus barbeque manis-asam yang nikmat, ditambah potongan ayam panggang dan keju mozzarella yang lumer.", namaUser) }
        pizza4.setOnClickListener { openOrderPage("Cheese Pizza\n Surga bagi pecinta keju! Kombinasi mozzarella, cheddar, dan parmesan di atas roti lembut yang gurih.", namaUser) }
        pizza5.setOnClickListener { openOrderPage("Veggie Pizza\n Pilihan sehat dengan topping paprika, jamur, zaitun, tomat, dan jagung manis. Segar dan penuh warna \uD83C\uDF3F", namaUser) }
        pizza6.setOnClickListener { openOrderPage("Beef Mushroom Pizza\n Perpaduan daging sapi lembut dan jamur kancing segar di atas saus creamy yang gurih. Favorit sepanjang masa!", namaUser) }
        pizza7.setOnClickListener { openOrderPage("Meat Lovers Pizza\n Pizza dengan topping daging melimpah — sosis, daging asap, dan daging cincang. Bikin puas setiap gigitan! \uD83E\uDD69", namaUser) }
        pizza8.setOnClickListener { openOrderPage("Pepperoni Pizza\n Pilihan klasik Amerika dengan potongan pepperoni renyah di atas lelehan keju mozzarella dan saus tomat khas.", namaUser) }
        pizza9.setOnClickListener { openOrderPage("Hawaiian Pizza\n Paduan unik nanas manis dan daging ham gurih yang menciptakan sensasi tropis di setiap potongan \uD83C\uDF4D", namaUser) }
        pizza10.setOnClickListener { openOrderPage("Tuna Melt Pizza\n Topping tuna segar dan keju mozzarella yang meleleh sempurna, memberikan rasa gurih dan lembut yang khas laut.", namaUser) }
    }

    private fun openOrderPage(namaPizza: String, namaUser: String) {
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("pizzaName", namaPizza)
        intent.putExtra("namaLengkap", namaUser)
        startActivity(intent)
    }
}
