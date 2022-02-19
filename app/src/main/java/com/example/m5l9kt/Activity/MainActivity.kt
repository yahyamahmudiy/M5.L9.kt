package com.example.m5l9kt.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l9kt.Adapter.FeedAdapter
import com.example.m5l9kt.Model.Feed
import com.example.m5l9kt.Model.Post
import com.example.m5l9kt.Model.Story
import com.example.m5l9kt.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this,1))

        refreshAdapter(getAllItems())
    }

    fun refreshAdapter(feeds:ArrayList<Feed>){
        val adapter = FeedAdapter(this,feeds)
        recyclerView.adapter = adapter
    }
    fun getAllItems():ArrayList<Feed>{
        val stories:ArrayList<Story> = ArrayList()

        stories.add(Story(R.drawable.img_2,"Create Story",R.drawable.profile))
        stories.add(Story(R.drawable.img_1,"Xurshidbek Kurbanov",R.drawable.img_3))
        stories.add(Story(R.drawable.img_1,"Xurshidbek Kurbanov",R.drawable.img_3))
        stories.add(Story(R.drawable.img_1,"Xurshidbek Kurbanov",R.drawable.img_3))
        stories.add(Story(R.drawable.img_1,"Xurshidbek Kurbanov",R.drawable.img_3))
        stories.add(Story(R.drawable.img_1,"Xurshidbek Kurbanov",R.drawable.img_3))

        val feeds:ArrayList<Feed> = ArrayList()

        feeds.add(Feed())

        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.img_1,"Xurshidbek",R.drawable.img) ))

        feeds.add(Feed(Post(R.drawable.img_1,"Xurshidbek", R.drawable.img,
            R.drawable.img,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile) ))

        feeds.add(Feed(Post(R.drawable.img_1,"Xurshidbek",R.drawable.img) ))

        feeds.add(Feed(Post(R.drawable.img_1,"Xurshidbek",R.drawable.img_1) ))

        feeds.add(Feed(Post(R.drawable.img_1,"Xurshidbek",R.drawable.img) ))
        feeds.add(Feed(Post(R.drawable.img_1,"Xurshidbek",R.drawable.img) ))

        return feeds
    }
}