package com.example.simpleloginpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostListAdapter(private var PostList: ArrayList<PostDetails>) :
    RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {


    //First Step
    override fun getItemCount() = PostList.size


    //Step 2 - ViewHolder class
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleNameTextView: TextView
        val useridTextView: TextView
        val bodylistTextView: TextView
        val postIdTextView: TextView


        init {
            titleNameTextView = view.findViewById(R.id.title)
            bodylistTextView = view.findViewById(R.id.body)
            useridTextView = view.findViewById(R.id.userId)
            postIdTextView = view.findViewById(R.id.postId)
        }

    }


    //Step 3 returns View Holder class
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostListAdapter.PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_card_view, parent, false)

        return PostViewHolder(view)
    }


    //Final step - UI DATA map -> draw
    override fun onBindViewHolder(holder: PostListAdapter.PostViewHolder, position: Int) {

        val product = PostList[position]

        holder.titleNameTextView.text = product.title.toString()
        holder.useridTextView.text = product.userId.toString()
        holder.bodylistTextView.text = product.body.toString()
        holder.postIdTextView.text = product.postId.toString()





    }


    // Method to update the list and notify the adapter
    fun updatePost(newItemList: ArrayList<PostDetails>) {
        PostList = newItemList
        notifyDataSetChanged() // Notify that the data has changed
    }


}