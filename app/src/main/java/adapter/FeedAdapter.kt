package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xr.coor.R
import model.Feed

class FeedAdapter(val feeds:ArrayList<Feed>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  val IMAGE = 0
    private  val NO_IMAGE = 1

    override fun getItemViewType(position: Int): Int {
        return if(feeds[position].imageUrl==null) NO_IMAGE else IMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View
        return when(viewType){
            NO_IMAGE->{
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed,parent,false)
                FeedNoImageViewHolder(view)
            }

            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_image,parent,false)
                FeedImageViewHolder(view)
            }
        }
    }

    override fun getItemCount() = feeds.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = feeds[position]
        if (holder is FeedImageViewHolder){
            holder.apply {
                Glide.with(ivUserProfile).load(feed.userImage).into(ivUserProfile)
                Glide.with(ivPost).load(feed.imageUrl).into(ivPost)
                tvUserName.text = feed.userName
                tvUserTitle.text = feed.userTitle
                tvPostTime.text = feed.postTime
                if (feed.isFollowed){
                    tvFollow.text = "Followed"
                }else{
                    tvFollow.text = "+ Follow"
                }
                tvPostShortText.text = feed.postText
                tvPostFullText.text = feed.postText

            }
        }
        if (holder is FeedNoImageViewHolder){
            holder.apply {

            }
        }
    }

    fun FeedAdapter(list: ArrayList<Feed>): FeedAdapter {

    }


    class FeedImageViewHolder(view:View):RecyclerView.ViewHolder(view){
        val ivUserProfile = view.findViewById<ImageView>(R.id.iv_profil)
        val tvUserName = view.findViewById<TextView>(R.id.tv_usename)
        val tvUserTitle = view.findViewById<TextView>(R.id.tv_titile)
        val tvPostTime = view.findViewById<TextView>(R.id.tv_time)
        val tvFollow = view.findViewById<TextView>(R.id.tv_follow)
        val tvPostShortText = view.findViewById<TextView>(R.id.tv_post_short_text)
        val tvPostFullText = view.findViewById<TextView>(R.id.tv_post_full_text)
        val tvLikesCount = view.findViewById<TextView>(R.id.tv_liked_count)
        val tvCommentCount = view.findViewById<TextView>(R.id.tv_comment_count)
        val tvLike = view.findViewById<TextView>(R.id.tv_like)
        val ivPost = view.findViewById<ImageView>(R.id.iv_post)
    }

    class FeedNoImageViewHolder(view:View):RecyclerView.ViewHolder(view){
        val ivUserProfile = view.findViewById<ImageView>(R.id.iv_profil)
        val tvUserName = view.findViewById<TextView>(R.id.tv_usename)
        val tvUserTitle = view.findViewById<TextView>(R.id.tv_titile)
        val tvPostTime = view.findViewById<TextView>(R.id.tv_time)
        val tvFollow = view.findViewById<TextView>(R.id.tv_follow)
        val tvPostShortText = view.findViewById<TextView>(R.id.tv_post_short_text)
        val tvPostFullText = view.findViewById<TextView>(R.id.tv_post_full_text)
        val tvLikesCount = view.findViewById<TextView>(R.id.tv_liked_count)
        val tvCommentCount = view.findViewById<TextView>(R.id.tv_comment_count)
        val tvLike = view.findViewById<TextView>(R.id.tv_like)
        val ivPost = view.findViewById<ImageView>(R.id.iv_post)
    }

}