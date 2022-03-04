package com.example.myapplication.adapter

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import com.example.myapplication.model.Faskes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.FaskesActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.SecondActivity
import com.example.myapplication.model.Post
import com.example.myapplication.model.Results
import org.chromium.base.ContextUtils.getApplicationContext
import java.security.AccessController.getContext

class MyAdapterFaskes: RecyclerView.Adapter<MyAdapterFaskes.MyViewHolder>(){

    private var myList = emptyList<Faskes>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var title: TextView = itemView.findViewById(R.id.title_faskes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterFaskes.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_faskes, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = myList[position].nama;
        holder.title.setOnClickListener() {
            Log.d("Faskes", myList[position].nama)
            val context = holder.title.getContext();
            val intent = Intent(context, FaskesActivity::class.java)
            val extras = Bundle();
            extras.putString("nama", myList[position].nama)
            extras.putString("kode", myList[position].kode)
            extras.putString("alamat", myList[position].alamat)
            extras.putString("telp", myList[position].telp)
            extras.putString("jenis_faskes", myList[position].jenis_faskes)
            extras.putString("status", myList[position].status)
            intent.putExtras(extras);
            context.startActivity(intent);
        }
        }
//        val success: String,
//        val message: String,
//        val count_total: Int,
//        val results: List<Post>
    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Faskes>) {
        myList = newList;
        notifyDataSetChanged();
    }
}
