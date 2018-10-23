package id.go.lombokbaratkab.sumirah.sumirahsubmissionsatu

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.startActivity

class RecyclerViewAdapter (private val context: Context, private val items: List<Item>, private val listener : (Item) -> Unit )
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        fun bindItem(items : Item, listener : (Item) -> Unit){
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)

                itemView.setOnClickListener{
                itemView.context.startActivity<DetailItem>("image" to items.image,"name" to items.name,  "desc" to items.desc)
                listener(items)
            }
        }
    }
}