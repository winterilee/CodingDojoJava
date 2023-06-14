import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Supermassive Black Hole", "Oh baby, you know I suffer? / Oh baby, can you hear me moan?");
        trackList.put("Uprising", "Paranoia is in bloom / The PR transmissions will resume");
        trackList.put("Starlight", "Far away / This ship is taking me far away");
        trackList.put("Madness", "I, I can't get these memories out of my mind / And some kind of madness has started to evolve");

        String starlightLyrics = trackList.get("Starlight");
        System.out.println(starlightLyrics);
        System.out.println("------------------------------");
        Set<String> keys = trackList.keySet();
        for(String key: keys) {
            System.out.println(key);
            System.out.println(trackList.get(key));
        }
    }
}
