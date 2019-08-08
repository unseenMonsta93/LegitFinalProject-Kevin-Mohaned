package datanapps.retrofitkotlin.services.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import datanapps.retrofitkotlin.R
import datanapps.retrofitkotlin.services.users.model.Product

class  ProductRecyclerViewAdapter (private val onClick: (Product) -> Unit) : ListAdapter<Product, ProductViewHolder>(ProductDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_project, parent, false)

        return ProductViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.product = getItem(position)
    }
}

class ProductViewHolder(itemView: View, private val onClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
    // 06 holds the data that is bound to this ViewHolder
    var product: Product? = null
        set(value) {
            // checks if value is null, if not executes the code inside the {}
            value?.let {
                // field represents the variable employee.  This actually sets the value of employee
                field = it
                itemView.findViewById<TextView>(R.id.textViewVHProductName).text = it.id.toString()
                itemView.setOnClickListener { _ -> onClick(it) }
            }
        }
}
                class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
                    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                        // 06 Items are the same if they are saved in the same location in memory.
                        return oldItem === newItem
                    }

                    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                        /*
                        06 Because we used a 'data' class for our Employee Object, we get an implementation
                        of the equals function for us, that compares the content of two Objects.
                         */
                        return oldItem == newItem
        }
}