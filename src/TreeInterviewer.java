import java.util.Scanner;

/**
 * Created by Kamil on 19-Mar-17.
 */
public class TreeInterviewer {
    private static int wrongTimes = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static DIRECTION fetchDirection() {
        System.out.println("Podaj kierunek: Left, Right, Up, Down");
        switch (scanner.nextLine().toUpperCase()) {
            case "L":
            case "LEFT":
                return DIRECTION.LEFT;
            case "R":
            case "RIGHT":
                return DIRECTION.RIGHT;
            case "D":
            case "DOWN":
                return DIRECTION.DOWN;
            case "U":
            case "UP":
                return DIRECTION.UP;
            default:
                System.out.println("Przyjmuję wartość domyślną UP!");
                return DIRECTION.UP;
        }
    }

    public static int fetchHeight() throws Exception {
        System.out.println("Podaj wysokość drzewa:");
        String arg = scanner.nextLine();
        int height;
        try {
            height = Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
            wrongTimes++;
            height = retryFetchHeight(arg, wrongTimes, "To nie jest liczba!");
        }
		if(height > 100) {
            wrongTimes++;
			retryFetchHeight(arg, wrongTimes, "Zbyt dużo!");
		} else if(height < 0) {
            wrongTimes++;
			retryFetchHeight(arg, wrongTimes, "Nieujemna");
		}
        return height;
    }

    private static int retryFetchHeight(String arg, int wrongTimes, String reason) throws Exception {
        final int maxTimes = 3;
        System.out.println(reason);
        if(wrongTimes >= maxTimes) {
            throw new Exception("Too many wrong tries");
        }
        return fetchHeight();
    }
}
