package com.prproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prproject.R
import com.prproject.listener.CellClickListener
import com.prproject.model.ModelList
import com.prproject.model.PRData
import com.prproject.view.adapter.RecyclerViewAdapter
import com.prproject.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragement_list.*


class NewsFeedList : Fragment(), CellClickListener {

    private lateinit var prActivityViewModel: NewsViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prActivityViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        prActivityViewModel.getPRDataFromServer()
        swipeRefreshLayout.setOnRefreshListener {
            prActivityViewModel.getPRDataFromServer()
        }
        prActivityViewModel.getAllPRData()?.observe(requireActivity()) { res ->
            val list = res.articles.toCollection(ModelList())
            progress_circular.visibility = View.GONE
            swipeRefreshLayout.isRefreshing = false
            setRecyclerView(list)
        }
    }

    private fun setRecyclerView(prList: ModelList) {
        LinearLayoutManager(
            context , LinearLayoutManager.VERTICAL,false
        ).apply {
            recyclerView.layoutManager = this
            recyclerView.adapter = RecyclerViewAdapter(requireActivity(), prList,this@NewsFeedList,)
        }
    }

    override fun onCellClickListener(data: PRData) {
        val bundle = Bundle()
        bundle.putString("author", data.author)
        bundle.putString("description", data.description)
        bundle.putString("urlToImage", data.urlToImage)
        bundle.putString("publishedAt", data.publishedAt)
        val fragmentTwo = NewsDescription()
        fragmentTwo.arguments = bundle
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragmentTwo)
        transaction.addToBackStack("NewsDescription");
        transaction.commit()
    }


}