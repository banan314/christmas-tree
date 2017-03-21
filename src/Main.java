public class Main {

    public static void main(String[] args) {
        int height;

        try {
            height = TreeInterviewer.fetchHeight();
        } catch (Exception e) {
            System.out.println("Przyjmuję domyślną wartość 5!");
            height = 5;
        }

        DIRECTION direction;
        direction = TreeInterviewer.fetchDirection();

        ChristmasTreeCreator christmasTreeCreator = new ChristmasTreeCreator();
        christmasTreeCreator.setHeight(height);
        christmasTreeCreator.setDirection(direction);
        christmasTreeCreator.create();
    }
}
