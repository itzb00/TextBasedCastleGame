package MiniTextGame;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IOClass {
    private static ArrayList<Room> rooms;
    public static ArrayList<Room> getRooms() throws IOException {
        getRoomDataFromFile();
        return rooms;
    }
    public static void getRoomDataFromFile() throws IOException {
        rooms = new ArrayList<>();
        List<String> lines = FileUtils.readLines(new File("Rooms.txt"), "UTF-8");
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] words = line.split(",");
            Room room = new Room();
            int j = 0;
            room.setRoomId(Integer.parseInt(words[j]));
            j++;
            room.setRoomName(words[j]);
            j++;
            String str = words[j];
            ArrayList<String> descriptions = new ArrayList<>();
            while(str.compareTo("---") != 0) {
                descriptions.add(str);
                j++;
                str = words[j];
            }
            j++;
            room.setDescriptions(descriptions);
            room.setWasVisited(Boolean.parseBoolean(words[j]));
            j++;
            //System.out.println(room);
            HashMap<String,Integer> navigation = new HashMap<>();
            navigation.put("north",Integer.parseInt(words[j]));
            j++;
            navigation.put("east",Integer.parseInt(words[j]));
            j++;
            navigation.put("south",Integer.parseInt(words[j]));
            j++;
            navigation.put("west",Integer.parseInt(words[j]));
            room.setNavTable(navigation);
            rooms.add(room);
        }
    }
}
