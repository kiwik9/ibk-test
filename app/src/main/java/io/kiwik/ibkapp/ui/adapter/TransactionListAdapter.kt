package io.kiwik.ibkapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import io.kiwik.domain.model.Transaction
import io.kiwik.ibkapp.R
import io.kiwik.ibkapp.databinding.TransactionItemBinding
import io.kiwik.ibkapp.utils.OnItemClickListener
import org.joda.time.format.DateTimeFormat

class TransactionListAdapter(private val context: Context) :
    RecyclerView.Adapter<TransactionListAdapter.ViewHolder>() {

    private val list = mutableListOf<Transaction>()
    private var mListener: OnItemClickListener<Transaction>? = null

    private lateinit var mLayoutInflater: LayoutInflater

    fun submitList(data: List<Transaction>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener<Transaction>) {
        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionListAdapter.ViewHolder {
        if (!::mLayoutInflater.isInitialized) {
            mLayoutInflater = LayoutInflater.from(parent.context)
        }
        val binding = TransactionItemBinding.inflate(mLayoutInflater, parent, false)
        return ViewHolder(binding, binding.root)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TransactionListAdapter.ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(private val binding: TransactionItemBinding, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: Transaction) {
            binding.root.setOnClickListener {
                mListener?.invoke(item)
            }

            binding.txtTitle.text = item.name
            binding.txtAmount.text = "S/ ${item.transactionAmount}"
            binding.txtAmount.setTextColor(getColorByAmount(item.transactionAmount))
            binding.txtSubTitle.text = item.date.toString(DateTimeFormat.mediumDate())

        }
    }

    private fun getColorByAmount(amount: Double): Int {
        if (amount > 0) {
            return ContextCompat.getColor(context, R.color.green)
        }
        return ContextCompat.getColor(context, R.color.red)
    }
}