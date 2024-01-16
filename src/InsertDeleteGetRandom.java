import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomizedSet {
  Map<Integer, Boolean> set;
  List<Integer> list;

  public RandomizedSet() {
    set = new HashMap<>();
    list = new ArrayList<>();
  }

  public boolean insert(int val) {
    if (set.containsKey(val)) {
      return false;
    }
    set.put(val, true);
    list.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (set.containsKey(val)) {
      set.remove(val);
      list.remove((Integer) val);
      return true;
    }
    return false;
  }

  public int getRandom() {
    int rand = (int) (Math.random() * set.size());
    return list.get(rand);
  }
}
