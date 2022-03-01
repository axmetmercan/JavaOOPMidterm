package posts;

import location.Location;
import java.text.SimpleDateFormat;
import java.util.Date;
// it s an type of post it inherates post class
public class TextPost extends Post{
    private String text;


    public TextPost(String text, Location location, String taggedFriend) {
        super(location, taggedFriend);
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
        System.out.println("Location: " + this.location.getLatitude() +" "+ this.location.getLongitude());
        if (!this.taggedFriend.isEmpty())
            System.out.println("Friends tagged in this post:: " + this.taggedFriend);

    }

}


