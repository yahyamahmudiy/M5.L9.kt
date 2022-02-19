package com.example.m5l9kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l9kt.Model.Story
import com.example.m5l9kt.R
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context,var items:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var ITEM_STORY_CREATE = 0
    private var ITEM_STORY_SIMPLE = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return ITEM_STORY_CREATE
        return ITEM_STORY_SIMPLE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_STORY_CREATE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_create,parent,false)
            return StoryViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val stories = items[position]

        if (holder is StoryViewHolder){
            var iv_background = holder.iv_background
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

            iv_background.setImageResource(stories.photo)
            iv_profile.setImageResource(stories.profile)
            tv_fullname.text = stories.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_background:ShapeableImageView
        var iv_profile:ShapeableImageView
        var tv_fullname:TextView

        init {
            iv_background = view.findViewById(R.id.iv_background)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
}