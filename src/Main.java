import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class NFLPlayer implements Serializable {
    String name;
    double salary;
    double height;

    public NFLPlayer(String name, double salary, double height) {
        this.name = name;
        this.salary = salary;
        this.height = height;
    }
}

class PlayerSerializationRun {
    public static void serializeToCSV(String fileName, NFLPlayer... players) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (NFLPlayer player : players) {
                writer.write(player.name + "," + player.salary + "," + player.height);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<NFLPlayer> deserializeAllFromCSV(String fileName) {
        List<NFLPlayer> players = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    NFLPlayer player = new NFLPlayer(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]));
                    players.add(player);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    public static boolean checkEquality(NFLPlayer player1, NFLPlayer player2) {
        return player1.name.equals(player2.name) &&
                player1.salary == player2.salary &&
                player1.height == player2.height;
    }
}