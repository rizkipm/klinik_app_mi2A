package com.rizki.klinikapp_mi2a

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rizki.klinikapp_mi2a.screen.HomeDoctorActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //splash screen
        //handle untuk delay selama bebrapa detik
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //ini setelah delay akan pindah ke page berikutnya secara otomatis
                val intent = Intent(this, HomeDoctorActivity::class.java)
                startActivity(intent)
                finish() //agar ketika sudah pindah ke page berikutnya, ini page nya gak back
            }, 3000
        )

        //TASK :
        //Splash Screen
        //Page page start screen --> klik button get started ini pindah ke login
        //pada page login, ketika klik tulisan sign up --> ini pindah ke page sign up
        //page page signup, ketika klik login --> pindah ke login
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}