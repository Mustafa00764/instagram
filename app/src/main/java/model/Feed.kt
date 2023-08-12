package model

class Feed (
    val userImage:String,
    val userName:String,
    val userTitle:String,
    val postTime:String,
    val postText:String,
    val imageUrl:String?,
    var likesCount:Int,
    val commentCount:Int,
    val isLiked:Boolean = false,
    var isFollowed:Boolean = false

)
