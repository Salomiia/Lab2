package com.example.labarticles.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.labarticles.R

class ArticleDetailsFragment : Fragment(R.layout.fragment_article_details) {
    private lateinit var titleView: TextView
    private lateinit var contentView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = ArticleDetailsFragmentArgs.fromBundle(requireArguments()).article

        titleView = view.findViewById(R.id.article_title)
        contentView = view.findViewById(R.id.article_content)

        titleView.text = article!!.title
        contentView.text = article!!.content
    }
}
