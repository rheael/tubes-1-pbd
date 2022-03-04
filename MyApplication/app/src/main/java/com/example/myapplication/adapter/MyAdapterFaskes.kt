package com.example.myapplication.adapter

import com.example.myapplication.model.Faskes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.model.Results

class MyAdapterFaskes: RecyclerView.Adapter<MyAdapterFaskes.MyViewHolder>(){

    private var myList = emptyList<Faskes>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var title: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterFaskes.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = myList[position].nama;
//        val success: String,
//        val message: String,
//        val count_total: Int,
//        val results: List<Post>
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Faskes>) {
        myList = newList;
        notifyDataSetChanged();
    }
}

//import android.os.Bundle
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//
//class CustomAdapter(private val mList: List<Results>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//
//    // create new views
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // inflates the card_view_design view
//        // that is used to hold list item
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.activity_main, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    // binds the list items to a view
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        val Results = mList[position]
//
//        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(Results.results)
//
//        // sets the text to the textview from our itemHolder class
//        holder.textView.text = Results.results
//
//    }
//
//    // return the number of the items in the list
//    override fun getItemCount(): Int {
//        return mList.size
//    }
//
// Holds the views for adding it to image and text

//}