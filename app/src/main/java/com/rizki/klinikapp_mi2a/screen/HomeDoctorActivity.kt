package com.rizki.klinikapp_mi2a.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rizki.klinikapp_mi2a.R
import com.rizki.klinikapp_mi2a.adapter.AdapterListDoctor
import com.rizki.klinikapp_mi2a.model.ModelListDoctors

class HomeDoctorActivity : AppCompatActivity() {

    private var rv_list_doctor : RecyclerView? = null
    private var homeDoctorAdapater : AdapterListDoctor? = null

    //array data doctors
    private var doctorList = mutableListOf<ModelListDoctors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctor)
        rv_list_doctor = findViewById(R.id.rv_doctor)

        doctorList = ArrayList()
        homeDoctorAdapater = AdapterListDoctor(doctorList)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        rv_list_doctor!!.layoutManager = layoutManager
        rv_list_doctor!!.adapter = homeDoctorAdapater
        //data dummy
        prepareDataDoctor()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareDataDoctor() {
        var itemDoctors = ModelListDoctors(
            R.drawable.dokter1,
            "Rizki Syaputra",
            "Dentist",
            "123",
            "5.0"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter4,
            "Rizki Bambang",
            "Dokter Umum",
            "100",
            "5.0"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter5,//pakai gambar yang selain dokter 2
            "Junaidi Dr",
            "Dokter Gigii",
            "88",
            "4.9"
        )
        doctorList.add(itemDoctors)
        homeDoctorAdapater!!.notifyDataSetChanged()

    }
}