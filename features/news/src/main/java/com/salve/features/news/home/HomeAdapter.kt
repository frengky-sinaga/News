package com.salve.features.news.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.salve.common.core.domain.model.Article
import com.salve.common.utility.DateFormatUtils
import com.salve.features.news.R
import com.salve.features.news.databinding.ItemNewsBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val listContent = ArrayList<Article>()

    //TODO("implement diffUtil")
    fun setContents(newContents: List<Article>) {
        if (newContents.isNullOrEmpty()) return
        listContent.clear()
        listContent.addAll(newContents)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(listContent[position])

    override fun getItemCount(): Int = listContent.size

    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article) {

            binding.root.setOnClickListener {
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)
                it.findNavController().navigate(direction)
            }

            binding.imageNews.load(item.urlToImage) {
                crossfade(true)
                crossfade(500)
                placeholder(R.drawable.ic_loading_image)
                error(R.drawable.ic_error_load_image)
                scale(Scale.FILL)
            }

            binding.titleNews.text = item.title
            binding.author.text = item.author
            binding.publishedTime.text = DateFormatUtils.returnDateText(item.publishedAt)
        }
    }
}