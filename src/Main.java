public class Main {

    public static void main(String[] args) {
        int height;
        DIRECTION direction;

        try {
            height = TreeInterviewer.fetchHeight();

        } catch (Exception e) {
            System.out.print(e.getMessage() + ". ");
            System.out.println("Przyjmuję domyślną wartość 5!");
            height = 5;
        }

        try {
            direction = TreeInterviewer.fetchDirection();
        } catch (Exception e) {
            System.out.println("Przyjmuję wartość domyślną UP!");
            direction = DIRECTION.UP;
        }

        ChristmasTreeCreator christmasTreeCreator = new ChristmasTreeCreator();
        christmasTreeCreator.setHeight(height);
        christmasTreeCreator.setDirection(direction);
        christmasTreeCreator.create();
    }
}
