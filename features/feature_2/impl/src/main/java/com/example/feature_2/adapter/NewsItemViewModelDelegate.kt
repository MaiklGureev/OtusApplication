package com.example.feature_2.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.text.Html
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.feature_1.databinding.ItemMarketNewsBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.gureev.core.extensions.makeGone
import ru.gureev.core.extensions.makeVisible
import ru.gureev.delegates.ListViewModel
import ru.gureev.delegates.listener.ListItemClickListener
import ru.gureev.models.ui.MarketNewsUI

@SuppressLint("SetTextI18n")
fun marketNewsItemViewModelDelegate(onClickListener: ListItemClickListener) =
    adapterDelegateViewBinding<MarketNewsUI, ListViewModel, ItemMarketNewsBinding>(
        { layoutInflater, root -> ItemMarketNewsBinding.inflate(layoutInflater, root, false) }
    ) {
        with(binding) {
            root.setOnClickListener {
                onClickListener.onListItemClicked(item)
            }
            bind {
                tvTitle.text = "${item.headline}.${item.source}"
                tvDescription.text = Html.fromHtml(item.summary, Html.FROM_HTML_MODE_COMPACT)
                tvLink.text = item.url
                tvDate.text = item.datetime

                if (item.image.isNotBlank()) {
                    ivPhoto.makeVisible()
                    Glide.with(ivPhoto)
                        .load(item.image)
                        .placeholder(ru.gureev.design_system.R.drawable.ic_placeholder)
                        .centerCrop()
                        .into(ivPhoto)
                } else {
                    ivPhoto.makeGone()
                }

                tvLink.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                    ContextCompat.startActivity(context, intent, null)
                }

            }

        }


    }

