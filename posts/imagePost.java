package posts;

import location.Location;
import java.text.SimpleDateFormat;
import java.util.Date;
// it extends from post class and additionally it has some special figures
public class imagePost extends Post{
    private String imagePath;
    private String resolution;
    private String text;

    public imagePost(String text, Location location, String taggedFriend, String imagePath, String resolution) {
        super(location, taggedFriend);
        this.imagePath = imagePath;
        this.resolution = resolution;
        this.text = text;
    }
// overriden showpost method shows the that type posts informations
    @Override
    public void showPost() {
        Date date1 = new Date();

        SimpleDateFormat forme = new SimpleDateFormat("MM/dd/yyyy");
        String str = forme.format(date1);
        System.out.println(this.text);
        System.out.println("Date: " + str);
        System.out.println("Location: "+ this.location.getLatitude() +" "+ this.location.getLongitude());
        if (!this.taggedFriend.isEmpty())// checks if tagged friend is empty or not
            System.out.println("Friends tagged in this post:: " + this.taggedFriend);
        System.out.println("Image: "+ this.imagePath);
        System.out.println("Resolution: " + this.resolution);
    }
}
