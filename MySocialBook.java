import user.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


public class MySocialBook {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        mySocialBook mySocialBook =new mySocialBook(args[0]);

        Scanner scanner = new Scanner(new File(args[1]));
        int counter = 1;// ı use it to print line number of command counter is for this purpose in this file
        System.out.println("-----------------------");
        // In a while loop we read the command files line by line
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            String[] pieces = data.split("\t");// it splits the inputs with tab seperator
            counter++;

            if (pieces[0].equals("ADDUSER")){
                System.out.println("Command: "+ data);//prints the command line
                mySocialBook.addUser(pieces[1],pieces[2],pieces[3],pieces[4], pieces[5]);
                System.out.println("-----------------------");
            }
            else if(pieces[0].equals("REMOVEUSER")){
                System.out.println("Command: "+ data);//prints the command line
                mySocialBook.removeUser(Integer.parseInt(pieces[1]));
                System.out.println("-----------------------");
            }
            else if(pieces[0].equals("SIGNIN")){
                // checks user if the user of platform or not
                if(mySocialBook.userOfPlatform(pieces[1])){
                    if (mySocialBook.includesUserName(pieces[1])){
                        int flage = 0;
                        for (User user: mySocialBook.getUserList()){ //finds the user from the arraylist to apply operations after login
                            try {
                                if (user.getUserName().equals(pieces[1]) && user.getPassword().equals(pieces[2])){// checks equality of user informations.
                                   flage = 1;
                                    System.out.println("Command: "+ data);//prints the command line
                                    user.signIn(pieces[1],pieces[2]);// try to sign in with signin method
                                    System.out.println("-----------------------");

                                    //**************************
                                    // In this while loop program checks with if and else whether the commands equality then it calls to appropriate method.
                                    //**************************
                                    while (scanner.hasNextLine() && user.isLogin()){//in a loop applies the operations of logged user
                                        counter++;
                                        data = scanner.nextLine();
                                        pieces = data.split("\t");
                                        if (pieces[0].equals("UPDATEPROFILE")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.updateProfile(pieces[1],pieces[2],pieces[3]);// calls update profile funct
                                            System.out.println("-----------------------");

                                        }
                                        else if(pieces[0].equals("LISTUSERS")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            mySocialBook.showUsers();//calls show users method
                                            System.out.println("---------------------------");
                                        }
                                        else if(pieces[0].equals("CHPASS")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.updatePassword(pieces[1],pieces[2]);//calls update password method
                                            System.out.println("-----------------------");
                                        }

                                        else if(pieces[0].equals("ADDPOST-TEXT")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            //System.out.println(user.getFriends());
                                            user.addPost(pieces[3],pieces[2],pieces[1],pieces[4], mySocialBook.getUserList());//calls add text post method
                                            System.out.println("-----------------------");

                                        }
                                        else if(pieces[0].equals("ADDPOST-IMAGE")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            //System.out.println(user.getFriends());
                                            user.addPost(pieces[1],pieces[3],pieces[2],pieces[4],pieces[5],pieces[6], mySocialBook.getUserList());
                                            System.out.println("-----------------------");

                                        }

                                        else if(pieces[0].equals("ADDPOST-VIDEO")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            //System.out.println(user.getFriends());
                                            user.addPost(pieces[1],pieces[3],pieces[2],pieces[4],pieces[5],Integer.parseInt(pieces[6]), mySocialBook.getUserList());
                                            System.out.println("-----------------------");

                                        }
                                        else if(pieces[0].equals("SHOWPOSTS")){

                                            System.out.println("Command: "+ data);//prints the command line
                                            mySocialBook.showAllPosts(pieces[1]);// calls show all posts method
                                            System.out.println("-----------------------");
                                        }
                                        else if(pieces[0].equals("REMOVELASTPOST")){

                                            System.out.println("Command: "+ data);//prints the command line
                                            user.removePost();
                                            System.out.println("-----------------------");

                                        }


                                        else if(pieces[0].equals("ADDFRIEND")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.addFriends(pieces[1], mySocialBook.getUserList());
                                            System.out.println("-----------------------");
                                        }
                                        else if(pieces[0].equals("REMOVEFRIEND")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.removefriend(pieces[1]);
                                            System.out.println("-----------------------");


                                        }
                                        else if(pieces[0].equals("LISTFRIENDS")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.listFriends(mySocialBook.getUserList());
                                            System.out.println("-----------------------");
                                        }
                                        else if(pieces[0].equals("BLOCK")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.addBlockedUsers(pieces[1], mySocialBook.getUserList());
                                            System.out.println("-----------------------");
                                        }
                                        else if (pieces[0].equals("SHOWBLOCKEDUSERS")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.showBlockedUser(mySocialBook.getUserList());
                                            System.out.println("-----------------------");
                                        }
                                        else if(pieces[0].equals("SHOWBLOCKEDFRIENDS")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.showBlockedFriends(mySocialBook.getUserList());
                                            System.out.println("-----------------------");

                                        }
                                        else if(pieces[0].equals("SIGNOUT")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.signOut();

                                        }
                                        else if(pieces[0].equals("UNBLOCK")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            user.removeBlockedUsers(pieces[1], mySocialBook.getUserList());
                                            System.out.println("-----------------------");

                                        }
                                        else if (pieces[0].equals("ADDUSER")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            mySocialBook.addUser(pieces[1],pieces[2],pieces[3],pieces[4], pieces[5]);
                                            System.out.println("-----------------------");
                                        }
                                        else if(pieces[0].equals("REMOVEUSER")){
                                            System.out.println("Command: "+ data);//prints the command line
                                            mySocialBook.removeUser(Integer.parseInt(pieces[1]));// removes user from the system
                                            //System.out.println(mySocialBook.getUserList());
                                            System.out.println("-----------------------");
                                        }
                                    }
                                }
                                else if (flage == 0){
                                    System.out.println("-----------------------");
                                    flage++;
                                }
                            }catch (ArrayIndexOutOfBoundsException e){

                            }
                        }
                    }
                    else if (!mySocialBook.includesUserName(pieces[1]))
                        System.out.println("Command: "+ data);
                }
                else
                    System.out.println("Command: "+ data);
            }
            else{
                // if user is not logged in it prints
                System.out.println("-----------------------");
                System.out.println("Error: Please sign in and try again.");
            }
        }
        scanner.close();
    }
}
