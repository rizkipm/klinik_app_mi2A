package com.rizki.klinikapp_mi2a.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rizki.klinikapp_mi2a.R
import com.rizki.klinikapp_mi2a.model.ModelListDoctors
import com.rizki.klinikapp_mi2a.model.ModelMenuIcon

class AdapterListDoctor(
    val  itemMenuDoctor : List<ModelListDoctors>
) : RecyclerView.Adapter<AdapterListDoctor.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgDoctor : ImageView = itemView.findViewById(R.id.imgDoctor)
        var txtNamaDoctor : TextView = itemView.findViewById(R.id.txtNamaDoctor)
        var txtBidangDoctor : TextView = itemView.findViewById(R.id.txtBidangDoctor)
        var txtJumlahRating : TextView = itemView.findViewById(R.id.txtJumlahRating)
        var txtAngkaRating : TextView = itemView.findViewById(R.id.txtAngkaRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listdoctors, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return  itemMenuDoctor.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemMenuDoctor[position]
        holder.txtNamaDoctor.text = currentItem.namaDoctor
        holder.txtBidangDoctor.text = currentItem.spesDoctor
        holder.txtJumlahRating.text = currentItem.jumlahReview
        holder.txtAngkaRating.text = currentItem.angkaRating
        holder.imgDoctor.setImageResource(currentItem.imgDoctor)
    }
}