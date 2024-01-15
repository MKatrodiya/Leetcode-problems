import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersWithZeroOrOneLosses {
  public List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> players = new HashMap<>();
    for (int[] match : matches) {
        if (!players.containsKey(match[0])) {
          players.put(match[0], 0);
        }
        if(!players.containsKey(match[1])) {
          players.put(match[1], 0);
        }
        players.put(match[1], players.get(match[1]) + 1);
    }

    List<Integer> noLoss = new ArrayList<>();
    List<Integer> oneLoss = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> player : players.entrySet()) {
      if (player.getValue() == 0) {
        noLoss.add(player.getKey());
      } else if (player.getValue() == 1) {
        oneLoss.add(player.getKey());
      }
    }
    Collections.sort(noLoss);
    Collections.sort(oneLoss);
    result.add(noLoss);
    result.add(oneLoss);
    return result;
  }
}
