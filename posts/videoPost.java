package posts;

import location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;
// it extends from post class and additionally it has some special figures
public class videoPost extends Post{
    private String path;
    private double videoDuration;
    private String text;

    public videoPost(String text, Location location, String taggedFriend, String path, int videoDuration) {
        super(location, taggedFriend);
        this.path = path;
        this.videoDuration = videoDuration;
        this.text = text;
    }


    // overrides to show that type posts.
    @Override
    public void showPost() {
        Date date1 = new Date();
        SimpleDateFormat forme = new SimpleDateFormat("MM/dd/yyyy");
        String str = forme.format(date1);
        System.out.println(this.text);
        System.out.println("Date: " + str);
        System.out.println("Location: "+ this.location.getLatitude() +" "+ this.location.getLongitude());
        if (!this.taggedFriend.isEmpty())// overrides to show that type posts.
            System.out.println("Friends tagged in this post:: " + this.taggedFriend);
        System.out.println("Video: " + this.path);
        System.out.println("Video Duration: " + this.videoDuration+ " minutes");

    }
}
