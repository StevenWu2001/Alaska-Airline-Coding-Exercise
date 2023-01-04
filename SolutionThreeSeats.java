import java.util.HashMap;
import java.util.Map;

public class SolutionThreeSeats {

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
            char row = reserved.charAt(i), col = reserved.charAt(i + 1);
            byte curr = occupiedRows.getOrDefault(row, (byte) 0b1111);

            // Calculate how each reserved seat affects the current seating options in the row

            if (col == 'A' || col == 'B' || col == 'C') {
                curr &= 0b0111;
            } else if (col == 'D') {
                curr &= 0b1011;
            } else if (col == 'G') {
                curr &= 0b1101;
            } else if (col == 'E' || col == 'F') {
                curr &= 1001;
            } else if (col == 'H' || col == 'J' || col == 'K') {
                curr &= 0b1110;
            }

            occupiedRows.put(row, curr);
        }

        // Calculate available seats from the pre-computed bits

        for (char row : occupiedRows.keySet()) {
            int avail = occupiedRows.get(row);
            if (avail == 0b1111 || avail == 0b1011 || avail == 0b1101) {
                maxFamily += 3;
            } else if (avail == 0b1001 || avail == 0b0011 || avail == 0b1100 || avail == 0b1110 || avail == 0b0111) {
                maxFamily += 2;
            } else if (avail > 0) {
                maxFamily += 1; 
            }
        }

        //  Seats from unoccupied rows should also be included

        return maxFamily + (ROW - occupiedRows.size()) * 3;
    }
}
