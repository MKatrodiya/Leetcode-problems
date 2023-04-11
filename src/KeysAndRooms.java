import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(rooms.get(0));
        visited.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<Integer> keys = q.poll();
                for (int key: keys) {
                    if (!visited.contains(key)) {
                        q.add(rooms.get(key));
                        visited.add(key);
                    }
                }
            }
        }
        return rooms.size() == visited.size();
    }
}
