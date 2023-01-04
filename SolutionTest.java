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

    @Test
    public void testThreeFamily1() {
        String input = "";
        assertEquals(15, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void testThreeFamily2() {
        String input = "1A 1B 1C 1D 1E 1F 1G 1H 1J 1K " +
                "2A 2B 2C 2D 2E 2F 2G 2H 2J 2K " +
                "3A 3B 3C 3D 3E 3F 3G 3H 3J 3K " +
                "4A 4B 4C 4D 4E 4F 4G 4H 4J 4K " +
                "5A 5B 5C 5D 5E 5F 5G 5H 5J 5K";
        assertEquals(0, solution.maxFamilySeats(input), "Wrong answer for full reservations");
    }

    @Test
    public void testThreeFamily3() {
        String input = "4J 3J 2J 1J 5J";
        assertEquals(10, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void testThreeFamily4() {
        String input = "1E 2D 4C 4G 5B 5F";
        assertEquals(10, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }

    @Test
    public void testThreeFamily5() {
        String input = "1B 1E 3A 3D 2H 4C 4E 5E 6B 6E 7A 7D 8H 9C 9E 10E 11B 11E 13A 13D 12H 14C 14E 15E 16B 16E 17A 17D 18H 19C 19E 20E 21B 21E 23A 23D 22H 24C 24E 25E 26B 26E 27A 27D 28H 29C 29E 30E 35E 35F 34E 34F 33E 33F 32E 32F 31E 31F 40E 40F 39E 39F 38E 38F 37E 37F 36E 36F";
        assertEquals(10, solution.maxFamilySeats(input), "Wrong answer for input: " + input);
    }


}
