package MiniTextGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private int roomId;
    private String roomName;
    private ArrayList<String> descriptions;
    private boolean wasVisited;
    private HashMap<String,Integer> navTable;
    public Room() {
        this.descriptions = new ArrayList<>();
        this.navTable = new HashMap<>();
    }

    public Room(int roomId, String roomName, boolean wasVisited) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.wasVisited = wasVisited;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean getWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(ArrayList<String> descriptions) {
        this.descriptions = descriptions;
    }

    public HashMap<String, Integer> getNavTable() {
        return navTable;
    }

    public void setNavTable(HashMap<String, Integer> navTable) {
        this.navTable = navTable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", descriptions=" + descriptions +
                ", wasVisited=" + wasVisited +
                ", navTable=" + navTable +
                '}';
    }
}




