package com.prproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.prproject.R
import com.prproject.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragement_discription.*

class NewsDescription : Fragment() {


    private var model: NewsViewModel?=null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_discription, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        new_title.text=arguments?.getString("author")
        content.text=arguments?.getString("description")
        date.text=arguments?.getString("publishedAt")

        val media = arguments?.getString("urlToImage")
        if (media !== null) {
            Glide.with(requireActivity())
                .load(media)
                .into(image)
        } else {
            image.setImageResource(R.drawable.ic_launcher_background)
        }

    }

    private fun setDataOnView() {
        val name = requireActivity().intent.getStringExtra("name")
        val description = requireActivity().intent.getStringExtra("description")
        val publishedAt = requireActivity().intent.getStringExtra("publishedAt")
        val media = requireActivity().intent.getStringExtra("urlToImage")



    }

}
