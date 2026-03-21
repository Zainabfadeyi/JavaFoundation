public class ArrayTest {
    public static void main(String... args) {
        char[][] boards = {{'x', 'o', 'x'}, {'x', 'x', 'o'}, {'o', 'x', 'x'}};

        for (char[] row : boards) {

            for (char cell : row) {
                if (cell == 'x') {
                    System.out.print("1 ");
                } else if (cell == 'o') {
                    System.out.print("0 ");
                }
            }
            System.out.println();


        }
    }
}
