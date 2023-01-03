import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    Solution solution;

    @BeforeEach
    public void init() {
        solution = new Solution();
    }

    @Test
    public void testEmpty() {
        String input = "";
        assertEquals(10, solution.maxFamilySeats(input), "Wrong answer for no reservations");
    }

    @Test
    public void testAllReserved() {
        String input = "1A 1B 1C 1D 1E 1F 1G 1H 1J 1K " +
                       "2A 2B 2C 2D 2E 2F 2G 2H 2J 2K " +
                       "3A 3B 3C 3D 3E 3F 3G 3H 3J 3K " +
                       "4A 4B 4C 4D 4E 4F 4G 4H 4J 4K " +
                       "5A 5B 5C 5D 5E 5F 5G 5H 5J 5K";
        assertEquals(0, solution.maxFamilySeats(input), "Wrong answer for full reservations");
    }

    @Test
    public void test1() {
        String input = "5E 5F 4E 4F 3E 3F 2E 2F 1E 1F";
        assertEquals(0, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test2() {
        String input = "4J 3J 2J 1J 5J";
        assertEquals(5, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test3() {
        String input = "1B 1E 3A 3D 2H 4C 4E 5E";
        assertEquals(5, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test4() {
        String input = "1A 1K 2A 2K 3A 3K 4A 4K 5A 5K";
        assertEquals(10, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test5() {
        String input = "1B 1C 2D 3E 5E";
        assertEquals(6, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test6() {
        String input = "1E 2D 4C 4G 5B 5F";
        assertEquals(4, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test7() {
        String input = "3B";
        assertEquals(9, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test8() {
        String input = "1A";
        assertEquals(10, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void test9() {
        String input = "2F 4B 5J";
        assertEquals(7, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }
}
