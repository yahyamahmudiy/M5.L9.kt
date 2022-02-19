package com.example.m5l9kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l9kt.Model.Feed
import com.example.m5l9kt.Model.Story
import com.example.m5l9kt.R
import com.google.android.material.imageview.ShapeableImageView
import kotlin.coroutines.coroutineContext

class FeedAdapter(var context: Context, var items:ArrayList<Feed>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    private val TYPE_ITEM_CHANGED = 3


    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        if (position == 5){return TYPE_ITEM_CHANGED}

        if (feed.isHeader)
            return TYPE_ITEM_HEAD
        else if(feed.stories.size > 0)
            return TYPE_ITEM_STORY
        return TYPE_ITEM_POST
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_header,parent,false)
            return HeadViewHolder(context,view)
        }else if (viewType == TYPE_ITEM_STORY){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story,parent,false)
            return StoryViewHolder(context,view)
        }else if(viewType == TYPE_ITEM_CHANGED){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_changed_profile,parent,false)
            return ChangedViewHolder(view)
        }

        val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
            return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeadViewHolder){

        }

        if (holder is StoryViewHolder){
            val recyclerView = holder.recyclerView
            refreshAdapter(feed.stories,recyclerView)
        }
        if (holder is ChangedViewHolder){
            val iv_photo = holder.iv_photo
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_photo.setImageResource(feed.post!!.photo)
            iv_profile.setImageResource(feed.post!!.profile)
            tv_fullname.text = feed.post!!.fullname
        }

        if (holder is PostViewHolder){
            val iv_photo = holder.iv_photo
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname
            val iv_photo1 = holder.iv_photo1
            val iv_photo2 = holder.iv_photo2
            val iv_photo3 = holder.iv_photo3
            val iv_photo4 = holder.iv_photo4
            val linearLayout = holder.linearLayout
            val frame = holder.frame

            iv_photo.setImageResource(feed.post!!.photo)
            iv_profile.setImageResource(feed.post!!.profile)
            tv_fullname.text = feed.post!!.fullname

            iv_photo1.setImageResource(feed.post!!.photo1)
            iv_photo2.setImageResource(feed.post!!.photo2)
            iv_photo3.setImageResource(feed.post!!.photo3)
            iv_photo4.setImageResource(feed.post!!.photo4)

            if (feed.post?.photo1 != 0){
                iv_photo1.visibility = View.VISIBLE
                linearLayout.visibility = View.VISIBLE
                frame.visibility = View.VISIBLE
                iv_photo2.visibility = View.VISIBLE
                iv_photo3.visibility = View.VISIBLE
                iv_photo4.visibility = View.VISIBLE
            }


        }
    }

    fun refreshAdapter(stories:ArrayList<Story>,recyclerView: RecyclerView){
        val adapter = StoryAdapter(context,stories)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HeadViewHolder(context: Context,view: View):RecyclerView.ViewHolder(view)

    class StoryViewHolder(context: Context,view: View):RecyclerView.ViewHolder(view){
        var recyclerView:RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            recyclerView.setLayoutManager(manager)
        }
    }

    class ChangedViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_photo: ImageView
        var iv_profile:ShapeableImageView
        var tv_fullname:TextView
        init {
            iv_photo = view.findViewById(R.id.iv_photo)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }

    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_photo: ImageView
        var iv_photo1: ImageView
        var iv_profile:ShapeableImageView
        var tv_fullname:TextView
        var iv_photo2: ImageView
        var iv_photo3: ImageView
        var iv_photo4: ImageView
        var linearLayout:LinearLayout
        var frame:FrameLayout

        init {

            iv_photo = view.findViewById(R.id.iv_photo)
            iv_photo1 = view.findViewById(R.id.iv_photo_one)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)

            iv_photo2 = view.findViewById(R.id.iv_photo2)
            iv_photo3 = view.findViewById(R.id.iv_photo3)
            iv_photo4 = view.findViewById(R.id.iv_photo4)


            linearLayout = view.findViewById(R.id.linear)

            frame = view.findViewById(R.id.frame)
        }
    }
}