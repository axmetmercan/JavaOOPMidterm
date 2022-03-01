package posts;
import location.Location;

// its an abstract methot for posts.
public abstract class Post {
    Location location;// all posts has location
    String taggedFriend;// all posts have tagged friend
    public Post(Location location,String taggedFriend){
        this.location = location;
        this.taggedFriend = taggedFriend;
    }
// abstarct methods of an post
    public abstract void showPost();

    void printLocation(){
        System.out.println(this.location.getLatitude() + this.location.getLongitude());
    }

}

