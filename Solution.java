import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Define row and column constants

    static int ROW = 5, COL = 10;

    /**
     * This solution manipulates binary bits to simulate the status of a row. Given the current seating, a row
     * only has 3 positions to fit a four-person family (B-E, D-G, F-J). We can use a 3-bit binary value to
     * represent the availability of each of the three assignments.
     *
     * Note: An occupied row can fit 2 four-person families
     *
     * @param reserved The String representation of a list of reserved seats, separated with single spaces
     * @return The maximum number of four-person families that will fit in the remaining seats
     *
     * Time Complexity: O(N), N is the number of reserved seats
     * Space Complexity: O(M), M is the number of occupied rows
     */

    public static int maxFamilySeats(String reserved) {
        Map<Character, Integer> occupiedRows = new HashMap<>();
        int maxFamily = 0;
        String[] split = reserved.split("\\s+");

        for (int i = 0; i < split.length; i++) {

            // Each row starts with 3 available seating options

            char row = split[i].charAt(0), col = split[i].charAt(1);
            occupiedRows.putIfAbsent(row, 0b111);

            // Calculate how each reserved seat affects the current seating options in the row

            int curr = occupiedRows.get(row);

            if (col == 'B' || col == 'C') {
                curr &= 0b011;
            } else if (col == 'D' || col == 'E') {
                curr &= 0b001;
            } else if (col == 'F' || col == 'G') {
                curr &= 0b100;
            } else if (col == 'H' || col == 'J') {
                curr &= 0b110;
            }

            occupiedRows.put(row, curr);
        }

        // Calculate available seats from the pre-computed bits

        for (char row : occupiedRows.keySet()) {
            int avail = occupiedRows.get(row);
            if (avail == 0b111 || avail == 0b101) {
                maxFamily += 2;
            } else if (avail > 0) {
                maxFamily++;
            }
        }

        // The returned value also needs to include seats from unoccupied rows

        return maxFamily + (ROW - occupiedRows.size()) * 2;
    }

    /**
     * The main method for testing
     * @param args
     */

    public static void main(String[] args) {
        String[] inputs = {
                "1A 2F 1C 3E 4F 5H",
                "5E 5F 4E 4F 3E 3F 2E 2F 1E 1F",
                "4J 3J 2J 1J 5J",
                "1B 1E 3A 2D 2H 4C 4E 5E",
                "2E 5E 4F 3G 4H"
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(maxFamilySeats(inputs[i]));
        }
    }
}
