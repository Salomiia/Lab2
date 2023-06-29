package com.example.labarticles.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labarticles.Article
import com.example.labarticles.R

class ArticleAdapter(private val listener: (Article) -> Unit) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var data = listOf<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, listener)
    }

    override fun getItemCount() = data.size

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = itemView.findViewById(R.id.article_title)
        val summary: TextView = itemView.findViewById(R.id.article_summary)
        val image: ImageView = itemView.findViewById(R.id.article_image)

        fun bind(article: Article, listener: (Article) -> Unit) {
            title.text = article.title
            summary.text = article.summary
            Glide.with(itemView.context).load(article.image).into(image)

            itemView.setOnClickListener { listener(article) }
        }
    }
}
