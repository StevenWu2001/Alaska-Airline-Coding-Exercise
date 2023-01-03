import java.util.HashMap;
import java.util.Map;

public class Solution {

    int ROW = 5;

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

    public int maxFamilySeats(String reserved) {
        Map<Character, Byte> occupiedRows = new HashMap<>(); // Stores status of occupied rows
        int maxFamily = 0;

        for (int i = 0; i < reserved.length(); i += 3){

            // Each row starts with 3 available seating options

            char row = reserved.charAt(i), col = reserved.charAt(i + 1);
            occupiedRows.putIfAbsent(row, (byte) 0b111);

            // Calculate how each reserved seat affects the current seating options in the row

            byte curr = occupiedRows.get(row);

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
                maxFamily += 1;
            }
        }

        //  Seats from unoccupied rows should also be included

        return maxFamily + (ROW - occupiedRows.size()) * 2;
    }
}