package com.ata.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.ata.newsapp.R
import com.ata.newsapp.databinding.FragmentArticleBinding
import com.ata.newsapp.ui.NewsActivity
import com.ata.newsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs() // Access arguments using navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article // Get article object from arguments

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url.let { // Safe null check for article.url
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Favorilere eklendi", Snackbar.LENGTH_SHORT).show()
        }
    }
}
