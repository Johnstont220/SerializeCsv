import java.util.List;

public class PlayerSerialization {
    public static void main(String[] args) {
        // Create NFLPlayer objects
        NFLPlayer player1 = new NFLPlayer("Drew Brees", 30000.0, 5.11);
        NFLPlayer player2 = new NFLPlayer("Aaron Rodgers", 25000.0, 6.2);

        // Serialize NFL players to CSV file
        PlayerSerializationRun.serializeToCSV("players.csv", player1, player2);

        // Deserialize values and check for equality
        List<NFLPlayer> deserializedPlayers = PlayerSerializationRun.deserializeAllFromCSV("players.csv");

        // Assuming there are only two players in the CSV file
        NFLPlayer deserializedPlayer1 = deserializedPlayers.get(0);
        NFLPlayer deserializedPlayer2 = deserializedPlayers.get(1);

        // Check if deserialized values are equal
        boolean areEqual = PlayerSerializationRun.checkEquality(player1, deserializedPlayer1);
        System.out.println("Player 1 and Deserialized Player 1 are equal: " + areEqual);

        areEqual = PlayerSerializationRun.checkEquality(player2, deserializedPlayer2);
        System.out.println("Player 2 and Deserialized Player 2 are equal: " + areEqual);
    }
}