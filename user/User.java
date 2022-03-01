package user;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import location.Location;
import posts.*;
// creates the user class.
public class User  {
    // static user id for each user and it wont changeable later.
    private static int userID = 0;
    private int id;
    private boolean isLogin = false;
    private String name;
    private String userName;
    private String password;
    private Date dateOfBirth;
    private Date lastLoginDate;
    private String graduatedSchoolName;
    private ArrayList<String> friends;
    private ArrayList<String> blockedUsers;
    private ArrayList<Post> Posts;

    // I create two type constructer one of them with variables.
    public User( String name, String userName, String password, Date dateOfBirth, String graduatedSchoolName) {
        userID++;
        this.id = userID;
        this.isLogin = false;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.lastLoginDate = lastLoginDate;
        this.graduatedSchoolName = graduatedSchoolName;
        this.friends = new ArrayList<String>();
        this.blockedUsers = new ArrayList<String>();
        this.Posts = new ArrayList<Post>();
    }
    // other constructer is without parameter.
    public User() {
        userID++;
        this.id = userID;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.lastLoginDate = lastLoginDate;
        this.graduatedSchoolName = graduatedSchoolName;
        this.isLogin = false;
        this.friends = new ArrayList<String>();
        this.blockedUsers = new ArrayList<String>();
        this.Posts = new ArrayList<Post>();
    }
    // *******************
// Getter and setter methods for paramters
    // *******************

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) throws ParseException {
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(lastLoginDate);
        this.lastLoginDate = date;

    }


    // some important getter and setter methods are initialized.

    public int getId() {
        return this.id;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin() {
        isLogin = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        SimpleDateFormat forme = new SimpleDateFormat("MM/dd/yyyy");
        String str = forme.format(this.dateOfBirth);
        return str;
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException {

        //its turns string value to date type
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);

        this.dateOfBirth = date;
    }

    public String getGraduatedSchoolName() {
        return graduatedSchoolName;
    }

    public void setGraduatedSchoolName(String graduatedSchoolName) {
        this.graduatedSchoolName = graduatedSchoolName;
    }


    public ArrayList<String> getFriends() {
        return friends;
    }
    // if the user is logged it add friends parameter of username to arraylist
    public void addFriends(String userName, ArrayList<User> userList) throws FileNotFoundException, ParseException {
        if (this.isLogin){
            boolean flag= false;
            for (User user:userList){
                if (user.getUserName().equals(userName)) {
                    flag = true;
                    if(!this.friends.contains(userName)){
                        this.friends.add(user.getUserName());
                        System.out.println(userName + " has been successfully added to your friend list.");
                    }
                    else
                        System.out.println("This user is already in your friend list!");

                }
            }
            if (!flag)
                System.out.println("No such user!");

        }
        else
            System.out.println("Error: Please sign in and try again.");

    }
// if user is logged and it contains the friend it removes otherwise error.
    public void removefriend(String userName){
        if (this.isLogin) {
            if (this.friends.contains(userName)){
                this.friends.remove(userName);
                System.out.println(userName + " has been successfully removed from your friend list.");
            }
            else
                System.out.println("No such friend!");
        }else
            System.out.println("Error: Please sign in and try again.");
    }

    public ArrayList<String> getBlockedUsers() {
        return blockedUsers;
    }
// add a user to blockked useer list.
    public void addBlockedUsers(String userName, ArrayList<User> userList) throws FileNotFoundException, ParseException {
        if (this.isLogin) {
            for (User user : userList) {
                if (user.getUserName().equals(userName)) {
                    if (!this.blockedUsers.contains(userName)) {
                        this.blockedUsers.add(userName);
                        System.out.println(userName + " has been successfully blocked.");
//                        if (this.getFriends().contains(userName))
//                            this.removefriend(userName);

                    } else if (this.blockedUsers.contains(userName))
                        System.out.println(userName + " this user is already in your blocked list!");
                }
            }
            boolean flag = true;
            for (User user1 : userList)
                if ( user1.getUserName().equals(userName))
                    flag = false;

                if (flag)
                    System.out.println("No such user!");
                // Mainde user valiği kontrol edilecek.....

            }

         else
            System.out.println("Error: Please sign in and try again.");
    }
    // removes user from blocked user list.
    public void removeBlockedUsers(String userName, ArrayList<User> userList) throws FileNotFoundException, ParseException {
        if (this.isLogin){
            boolean flag = false;
            for(User user : userList){
                if(user.getUserName().equals(userName)) {
                    flag = true;
                    if (this.blockedUsers.contains(userName)) {
                        this.blockedUsers.remove(userName);
                        System.out.println(userName + " has been successfully unblocked.");
                    }else
                        System.out.println("No such user in your blocked-user list!");
                }
            }
            if (!flag){
                System.out.println("No such user!");
            }

        }
        else
            System.out.println("Error: Please sign in and try again.");
    }
    // print out the friend list.
    public void listFriends(ArrayList<User> userLst) throws FileNotFoundException, ParseException {
        for (String friend:this.friends){
            for (User user:userLst){
                if (user.getUserName().equals(friend)){
                    System.out.println("Name: " + user.getName());
                    System.out.println("Username: " + user.getUserName());
                    System.out.println("Date of Birth: " + user.getDateOfBirth());
                    System.out.println("School: " + user.getGraduatedSchoolName());
                    //System.out.println("id: " + user.getId());
                    System.out.println("---------------------------");
                }
            }
        }
        if (this.getFriends().isEmpty()){
            System.out.println("You have not added any friend yet");
        }
    }
    // prints the users from blocked user list.
    public  void showBlockedFriends(ArrayList<User> userLst) throws FileNotFoundException, ParseException {
        if (this.isLogin) {
            boolean flag = false;

            for (String friend : this.getBlockedUsers()) {
                if (this.friends.contains(friend)) {
                    for (User user : userLst) {
                        if (user.getUserName().equals(friend)) {
                            flag = true;
                            System.out.println("Name: " + user.getName());
                            System.out.println("Username: " + user.getUserName());
                            System.out.println("Date of Birth: " + user.getDateOfBirth());
                            System.out.println("School: " + user.getGraduatedSchoolName());
                            // System.out.println("id: " + user.getId());
                            System.out.println("---------------------------");
                        }
                    }
                }
            }
            if (!flag)
                System.out.println("You haven't blocked any friend yet");
        }else
            System.out.println("Error Please sign in and try again.");
    }

    //shows the all blocked users. from blocked user list.
    public void showBlockedUser(ArrayList<User> userLst) throws FileNotFoundException, ParseException {
        if (this.isLogin) {
            boolean flag = false;
            for (String blockedusername : this.getBlockedUsers()) {
                    for (User user : userLst) {
                        if (user.getUserName().equals(blockedusername)) {
                            flag = true;
                            System.out.println("Name: " + user.getName());
                            System.out.println("Username: " + user.getUserName());
                            System.out.println("Date of Birth: " + user.getDateOfBirth());
                            System.out.println("School: " + user.getGraduatedSchoolName());
                            //System.out.println("id: " + user.getId());
                            System.out.println("---------------------------");
                        }
                    }
            }
            if (!flag)
                System.out.println("You haven't blocked any user yet!");
        }else
            System.out.println("Error Please sign in and try again.");
    }


    public ArrayList<Post> getPosts() {
        return Posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        Posts = posts;
    }
    // sign in to the account if pass is correct.
    public void signIn(String userName, String userPass){
        if (this.getUserName().equals(userName) && this.getPassword().equals(userPass)){
            this.isLogin = true;
            System.out.println("You have successfully signed in.");
            //setIsLogin(boolean true);
        }

        else{
            System.out.println(" Invalid username or password! Please try again.");
        }
    }
    // signout from the user.
    public void signOut() throws ParseException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        this.setLastLoginDate(strDate);
        this.isLogin = false;
        //System.out.println(this.getLastLoginDate());
        System.out.println("You have successfully signed out.");
    }
    // updates the user profile.
    public void updateProfile(String name, String dateOfBirth, String graduatedSchoolName) throws ParseException {
        if (this.isLogin){
            this.setName(name);
            this.setGraduatedSchoolName(graduatedSchoolName);
            this.setDateOfBirth(dateOfBirth);
            //System.out.println("Your user profile has been successfully updated");
        }
        else {
            System.out.println("Error: Please sign in and try again.");
        }
        //this.setDateOfBirth(dateOfBirth);
    }

    // updates the user password
    public void updatePassword(String password ,String nPassword){
        if (this.isLogin) {
            if (this.getPassword().equals(password)) {
                this.setPassword(nPassword);
                System.out.println("Password has changed");

            }
            else if (!this.getPassword().equals(password))
                System.out.println("Password mismatch!");
        }
        else{
            System.out.println("Error: Please sign in and try again.");
        }

    }
    // lists all users from user list.
    public void listUsers(ArrayList<User> userLst) throws FileNotFoundException, ParseException {
        if (isLogin){
            for (User user:userLst){
                System.out.println("Name: " + user.getName());
                System.out.println("Username: " + user.getUserName());
                System.out.println("Date of Birth: " + user.getDateOfBirth());
                System.out.println("School: " + user.getGraduatedSchoolName());
                //System.out.println("id: " + user.getId());
                System.out.println("---------------------------");
            }

        }
        else
            System.out.println("Error: Please sign in and try again.");
    }
    // add a text post to the post arraylist.
    public void addPost(String lat, String  longt, String text, String tagFri, ArrayList<User> userList){
        if (this.isLogin){
            Location location = new Location(Double.parseDouble(lat),Double.parseDouble(longt));

            String[] pieces = tagFri.split(":");
            ArrayList<String> taggedFriendsList = new ArrayList<String>();
            for (String userName :pieces){
                if (this.getFriends().contains(userName)){
                    taggedFriendsList.add(userName);
                }
                else
                    System.out.println(userName + " is not your friend, and will not be tagged!");
            }
            String newFriendsTag = taggedFriendsList.stream().collect(Collectors.joining(", "));

            Post post1 = new TextPost(text, location, newFriendsTag );

            this.Posts.add(post1);
            System.out.println("The post has been successfully added.");
        }
        else
            System.out.println("Error: Please sign in and try again.");
    }
    // add a image  post to the post arraylist
    public void addPost(String text, String lat, String longt, String tagFri, String path, String resolution, ArrayList<User> userList){

        if (this.isLogin){
            Location location = new Location(Double.parseDouble(lat),Double.parseDouble(longt));

            String[] pieces = tagFri.split(":");
            ArrayList<String> taggedFriendsList = new ArrayList<String>();
            for (String userName :pieces){
                if (this.getFriends().contains(userName)){
                    taggedFriendsList.add(userName);
                }
                else
                    System.out.println(userName + " is not your friend, and will not be tagged!");
            }
            String newFriendsTag = taggedFriendsList.stream().collect(Collectors.joining(", "));

            Post post1 = new imagePost(text, location, newFriendsTag, path,resolution );

            this.Posts.add(post1);
            System.out.println("The post has been successfully added.");
        }
        else
            System.out.println("Error: Please sign in and try again.");

    }
    // add a video post to the post arraylist
    public void addPost(String text, String lat, String longt, String tagFri, String path, int duration, ArrayList<User> userList){

        if (this.isLogin){
            if (duration > 10)
                System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
            else {

                Location location = new Location(Double.parseDouble(lat),Double.parseDouble(longt));

                String[] pieces = tagFri.split(":");
                ArrayList<String> taggedFriendsList = new ArrayList<String>();
                for (String userName :pieces){
                    if (this.getFriends().contains(userName)){
                        taggedFriendsList.add(userName);
                    }
                    else
                        System.out.println(userName + " is not your friend, and will not be tagged!");
                }
                String newFriendsTag = taggedFriendsList.stream().collect(Collectors.joining(", "));

                Post post1 = new videoPost(text, location, newFriendsTag, path,duration );

                this.Posts.add(post1);
                System.out.println("The post has been successfully added.");
            }

        }
        else
            System.out.println("Error: Please sign in and try again.");

    }



    //remove the last post from post arraylis.t
    public void removePost(){
        if (this.isLogin){
            if (!Posts.isEmpty()){
                int size = this.Posts.size();
                this.Posts.remove(size-1);
                System.out.println("Your last post has been successfully removed.");
            }
            else
                System.out.println("Error: You do not have any post.");

        }

        else
            System.out.println("Error: Please sign in and try again.");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isLogin=" + isLogin +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", lastLoginDate=" + lastLoginDate +
                ", graduatedSchoolName='" + graduatedSchoolName + '\'' +
                ", friends=" + friends +
                ", blockedUsers=" + blockedUsers +
                ", Posts=" + Posts +
                '}';
    }
}
