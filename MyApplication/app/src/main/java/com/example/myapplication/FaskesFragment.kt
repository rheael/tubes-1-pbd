package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.MyAdapter
import com.example.myapplication.adapter.MyAdapterFaskes
import com.example.myapplication.repository.Repository

class FaskesFragment : Fragment() {
    private val myAdapter by lazy { MyAdapterFaskes() }
    /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    } */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        //val title_faskes: Button = requireView().findViewById(R.id.title_faskes)
        //title_faskes.setOnClickListener{}
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}