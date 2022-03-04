package com.example.myapplication.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.FaskesActivity
import com.example.myapplication.R
import com.example.myapplication.WebViewActivity
import com.example.myapplication.model.Post
import com.example.myapplication.model.Results

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var title: TextView = itemView.findViewById(R.id.title)
        var description: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = myList[position].title;
        holder.title.setOnClickListener() {
            val context = holder.title.getContext();
            val intent = Intent(context, WebViewActivity::class.java)
            val extras = Bundle();
            extras.putString("url", myList[position].link[0])
            intent.putExtras(extras);
            context.startActivity(intent);
        }
//        val success: String,
//        val message: String,
//        val count_total: Int,
//        val results: List<Post>
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>) {
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