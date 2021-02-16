package com.target.targetcasestudy.ui

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.StaticData
import com.target.targetcasestudy.data.dealslist.DealListResponse
import com.target.targetcasestudy.data.dealslist.Product


class DealItemAdapter(private var data: DealListResponse, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<DealItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.deal_list_item, parent, false)
        return DealItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return StaticData.deals.size
    }

    override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
        val item = data.products?.get(position)
        viewHolder.bindData(item) {
            listener.invoke(it)
        }
    }

    fun updateItems(newData: DealListResponse) {
        data = newData
        notifyDataSetChanged()
    }
}

class DealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(
        item: Product?,callback: (id:Int)->Unit
    ) {
        itemView.findViewById<TextView>(R.id.deal_list_item_title).text = item?.title
        itemView.findViewById<TextView>(R.id.deal_list_item_price).text =
            item?.regularPrice?.displayString

        val imageView: ImageView = itemView.findViewById(R.id.deal_list_item_image_view)

        Picasso.get().load(item?.imageUrl).placeholder(R.drawable.ic_launcher_background).into(imageView)

        val shipText = "ship"
        val spannableString = SpannableString("ship or")
        val foregroundSpan = ForegroundColorSpan(Color.BLACK)
        spannableString.setSpan(
            foregroundSpan,
            0,
            shipText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val textView: TextView =itemView.findViewById(R.id.deal_list_item_ship)
        textView.text = spannableString

        itemView.findViewById<TextView>(R.id.deal_list_item_ship_aisle).text =
            item?.aisle

        itemView.setOnClickListener {
            item?.id?.let { it1 -> callback.invoke(it1) }
        }
    }
}