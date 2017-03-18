/**
 * Created by Kamil on 18-Mar-17.
 */
enum DIRECTION {
    LEFT, UP, RIGHT, DOWN
};

public class ChristmasTreeCreator {
    final static char SPACE = ' ';
    final static char SPIKE = '*';

    private int height;


    public void setHeight(int height) {
        this.height = height;
    }


    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    private DIRECTION direction;

    void create() {
        StringBuffer tree = new StringBuffer("");
        switch (direction) {
            case DOWN:
                for (int height = 1; height <= this.height; height++) {
                    tree.append(createLevel(height))
                            .append("\n");
                }
                break;
            case UP:
                for (int height = this.height; height >= 1; height--) {
                    tree.append(createLevel(height))
                            .append("\n");
                }
        }
        //System.out.println(height + " " + direction.toString());
        System.out.println(tree.toString());
    }

    private String createLevel(int levelHeight) {
        StringBuffer level = new StringBuffer("");
        level.append(createLeftSpace(levelHeight))
                .append(createCore(levelHeight))
        //.append(createRightSpace())
        ;
        return level.toString();
    }

    private String createCore(int levelHeight) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < 1 + 2 * (height - levelHeight); i++) {
            stringBuffer.append(SPIKE);
        }
        return stringBuffer.toString();
    }

    private String createLeftSpace(int levelHeight) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < levelHeight - 1; i++) {
            stringBuffer.append(SPACE);
        }
        return stringBuffer.toString();
    }
}
