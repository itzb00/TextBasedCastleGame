package MiniTextGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static ArrayList<Room> rooms = new ArrayList<>();
    public static Room currentRoom;
    public static boolean gameFlag = true;
    public static Scanner input = new Scanner(System.in);
    public static String choice;
    public static int nextRoomID;
    public static int commandType;
    //command type 1 is valid, command type 0 is invalid

    public static void main(String[] args) throws IOException {
        //System.out.println(IOClass.getRooms());
        rooms = IOClass.getRooms();
        System.out.println("Welcome to Castle Climb!");
        currentRoom = rooms.get(0);
        displayCurrentRoom();
        do {
            System.out.println("Which way do you want to go? [n,s,e,w, or quit]");
            System.out.print(">");
            choice = input.nextLine();
            processChoice();
            if (gameFlag == false) {
                break;
            }
            if (commandType == 1) {
                if (nextRoomID != 0) {
                    currentRoom = rooms.get(nextRoomID - 1);
                    displayCurrentRoom();
                } else {
                    System.out.println("You can't go that way.");
                }
            } else {
                System.out.println("Invalid command");
            }
        } while (gameFlag);
        System.out.println("Game was ended. Thanks for playing!");
    }

    public static void displayCurrentRoom() {
        if (currentRoom.getWasVisited() == true) {
            System.out.println("You've been here before.");
        } else {
            currentRoom.setWasVisited(true);
        }
        System.out.println(currentRoom.getRoomName());
        for (int i = 0; i < currentRoom.getDescriptions().size(); i++) {
            System.out.println(currentRoom.getDescriptions().get(i));
        }
    }

    public static void processChoice() {
        choice = choice.toLowerCase();
        Map <String,Integer> nav = currentRoom.getNavTable();
        if (choice.compareTo("north") == 0 || choice.compareTo("n") == 0) {
            nextRoomID = nav.get("north");
            commandType = 1;
        } else
        if (choice.compareTo("east") == 0 || choice.compareTo("e") == 0) {
            nextRoomID = nav.get("east");
            commandType = 1;
        } else
        if (choice.compareTo("west") == 0 || choice.compareTo("w") == 0) {
            nextRoomID = nav.get("west");
            commandType = 1;
        } else
        if (choice.compareTo("south") == 0 || choice.compareTo("s") == 0) {
            nextRoomID = nav.get("south");
            commandType = 1;
        } else
        if (choice.compareTo("quit") == 0 || choice.compareTo("q") == 0) {
            gameFlag = false;
            commandType = 1;
        }
        else {
            commandType = 0;
        }
    }
}

