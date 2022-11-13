package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> playerList;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity - playerList.size() > 0) {
            playerList.add(player);
        }
    }

    public boolean removePlayer(String name) {
        if (!playerList.isEmpty()) {
            for (Player player : playerList) {
                if (player.getName().equals(name)) {
                    playerList.remove(player);
                    return true;
                }
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        if (!playerList.isEmpty()) {
            for (Player player : playerList) {
                if (player.getName().equals(name)) {
                    player.setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        if (!playerList.isEmpty()) {
            for (Player player : playerList) {
                if (player.getName().equals(name)) {
                    player.setRank("Trial");
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        for (Player player : playerList) {
            if (player.getClazz().equals(clazz)) {
                kickedPlayers.add(player);
            }
        }
        this.playerList = playerList.stream().filter(a -> !a.getClazz().equals(clazz)).collect(Collectors.toList());
        Player[] result = new Player[kickedPlayers.size()];
        for (int i = 0; i < kickedPlayers.size(); i++) {
            result[i] = kickedPlayers.get(i);
        }

        return result;
    }

    public int count() {
        return playerList.size();
    }

    public String report() {
        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":").append("\n");
        for (Player player : playerList) {
            sb.append(player).append("\n");
        }
        return sb.toString();
    }

}
