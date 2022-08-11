package io.kiwik.ibkapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.kiwik.domain.model.Product
import io.kiwik.ibkapp.databinding.ProductItemBinding
import io.kiwik.ibkapp.utils.OnItemClickListener

class ProductListAdapter :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val list = mutableListOf<Product>()
    private var mListener: OnItemClickListener<Product>? = null

    private lateinit var mLayoutInflater: LayoutInflater

    fun submitList(data: List<Product>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener<Product>) {
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ViewHolder {
        if (!::mLayoutInflater.isInitialized) {
            mLayoutInflater = LayoutInflater.from(parent.context)
        }
        val binding = ProductItemBinding.inflate(mLayoutInflater, parent, false)
        return ViewHolder(binding, binding.root)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(private val binding: ProductItemBinding, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: Product) {
            binding.root.setOnClickListener {
                mListener?.invoke(item)
            }

            binding.txtTitle.text = item.name
            binding.txtSubTitle.text = "S/ ${item.accountMount}"
        }
    }

}