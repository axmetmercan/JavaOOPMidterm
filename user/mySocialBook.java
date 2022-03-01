package user;

import posts.Post;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class mySocialBook {
    private ArrayList<User> userList = new ArrayList<User>();
    public  String path;

    // ıts initialaze the path of the users txt file
    public mySocialBook(String path) throws FileNotFoundException, ParseException {
        this.userList = new ArrayList<User>();//creates user type array list to hold them
        Scanner scanner = new Scanner(new File(path));// file reader

        // ın a while loop it reads tab seperated user infos.
        while (scanner.hasNextLine()){
            User auser = new User();
            // reads each line
            String data = scanner.nextLine();
            //hold tab  seperated values in pieces list
            String[] pieces = data.split("\t");
            // sets the user name in user list
            auser.setName(pieces[0]);
            //System.out.println(auser.getName());
            // sets the user username  in user list
            auser.setUserName(pieces[1]);
            //System.out.println(auser.getUserName());
            // sets the user pass in user list
            auser.setPassword(pieces[2]);
            //System.out.println(auser.getPassword());
            // sets the user dateof birth in user list
            auser.setDateOfBirth(pieces[3]);
            //System.out.println(auser.getDateOfBirth());
            // sets the user school in user list
            auser.setGraduatedSchoolName(pieces[4]);
            //System.out.println(auser.getGraduatedSchoolName());
            this.userList.add(auser);
        }
        scanner.close();
    }

    //gets the user list
    public ArrayList<User> getUserList() {
        return userList;
    }
    // to set user list
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
    // prints all the user informations by iterating each user
    public void showUsers(){
        for (User user:userList){
            System.out.println("Name: " + user.getName());
            System.out.println("Username: " + user.getUserName());
            System.out.println("Date of Birth: " + user.getDateOfBirth());
            System.out.println("School: " + user.getGraduatedSchoolName());
            //System.out.println("id: " + user.getId());
            System.out.println("---------------------------");
        }
    }
    // checks with the user name in array list whether (s)he is user of the platform and returns boolean
    public boolean userOfPlatform(String userName){
        for (User user: userList){
            if (user.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    // checks with the user name in array list whether (s)he is user of the platform and returns boolean
    public boolean includesUserName(String userName){
        ArrayList<String> userNamesList = new ArrayList<>();
        for (User user : this.getUserList())
            userNamesList.add(user.getUserName());

        if (userNamesList.contains(userName))
            return true;
        else
            return false;
    }
    // shows the selected user infos
    public void showUser(String userName){
        for (User user:this.getUserList()){
            if (user.getUserName().equals(userName)){
                System.out.println("Name: " + user.getName());
                System.out.println("Username: " + user.getUserName());
                System.out.println("Date of Birth: " + user.getDateOfBirth());
                System.out.println("School: " + user.getGraduatedSchoolName());
                //System.out.println("id: " + user.getId());
                System.out.println("---------------------------");
            }
        }
    }
    // checks the user if it is in the list or not if not it adds new user to the list
    public void addUser(String name, String userName, String pass, String dateOfBirth, String graduatedSchool) throws ParseException, FileNotFoundException {
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
        User user = new User(name, userName, pass, date ,graduatedSchool);
        if (!this.userOfPlatform(userName)){
            this.userList.add(user);
            System.out.println(name  + " has been successfully added.");
        }else {
            System.out.println("This user has already in users.");
        }

    }
    //removes the user with its id.
    public void removeUser(int id){
        boolean flag = false;
        for (int i = 0 ; i < userList.size();i++){
            if (userList.get(i).getId() == id){
                userList.remove(i);
                flag = true;
                System.out.println("User has been successfully removed.");
                }
           else if (userList.get(i).getId() != id && !flag){
                    if (i == userList.size()-1)
                        System.out.println("no such user!");
                }
            }
        }
        // by iterating and finding the user name it prints all posts of that user
    public void showAllPosts(String userName){
        for (User user:userList)
            if (user.getUserName().equals(userName)){
                System.out.println("**************\n" + user.getName() + "'s posts\n**************");
                //System.out.println(user.getUserName());
                        ArrayList<Post> clone = user.getPosts();
                        int flag = 0;
                        for (Post post : clone){
                            post.showPost();
                            System.out.println("----------------------");
                        }
            }
            if (!this.getuserNames().contains(userName)) {
                    System.out.println("No such user!");
            }
    }
    // returns the user names String list to compare.
    public  ArrayList<String> getuserNames(){
        ArrayList<String> usernames = new ArrayList<>();
        for(User user:userList)
            usernames.add(user.getUserName());
        return usernames;
    }
}


