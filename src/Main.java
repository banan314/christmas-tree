public class Main {

    public static void main(String[] args) {
        int height;

        try {
            height = fetchHeight(args[0]);
        } catch (Exception e) {
            System.out.println("Przyjmuję domyślną wartość 5!");
            height = 5;
        }

        DIRECTION direction;

        switch (args[1]) {
            case "UP": direction = DIRECTION.UP;
                break;
            case "DOWN": direction = DIRECTION.DOWN;
                break;
            case "LEFT": direction = DIRECTION.LEFT;
                break;
            case "RIGHT": direction = DIRECTION.RIGHT;
                break;
            default: direction = DIRECTION.UP;
        }

        ChristmasTreeCreator christmasTreeCreator = new ChristmasTreeCreator();
        christmasTreeCreator.setHeight(height);
        christmasTreeCreator.setDirection(direction);
        christmasTreeCreator.create();
    }

    private static int wrongTimes = 0;
    private static int fetchHeight(String arg) throws Exception {
        int height;
        try {
            height = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            wrongTimes++;
            height = retryFetchHeight(arg, wrongTimes);
        }
        return height;
    }

    private static int retryFetchHeight(String arg, int wrongTimes) throws Exception {
        final int maxTimes = 3;
        if(wrongTimes > maxTimes) {
            throw new Exception("Too many wrong tries");
        }
        /*if(wrongTimes > maxTimes)
            return -1;*/
        return fetchHeight(arg);
    }
}
