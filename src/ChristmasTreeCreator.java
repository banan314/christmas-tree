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
        StringBuffer[] tree = new StringBuffer[height];
        for (int i = 0; i < height; i++) {
            tree[i] = new StringBuffer("");
        }

        for (int height = 1; height <= this.height; height++) {
            tree[height - 1].append(createLevel(height));
        }

        StringBuffer treeDisplay = new StringBuffer();
        switch (direction)

        {
            case DOWN:
                for (int i = 0; i < height; i++) {
                    treeDisplay.append(tree[i]).append("\n");
                }
                break;
            case UP:
                for (int i = this.height - 1; i >= 0; i--) {
                    treeDisplay.append(tree[i]).append("\n");
                }
                break;
            case LEFT:
                for (int i = 0; i < 2*height-1; i++) {
                    for (int level = height-1; level >= 0; level--) {
                        treeDisplay.append(tree[level].charAt(i));
                    }
                    treeDisplay.append("\n");
                }
                break;
            case RIGHT:
                for (int i = 0; i < 2*height-1; i++) {
                    for (int level = 0; level < height; level++) {
                        treeDisplay.append(tree[level].charAt(i));
                    }
                    treeDisplay.append("\n");
                }
                break;
        }

        System.out.println(treeDisplay.toString());
    }

    private String createLevel(int levelHeight) {
        StringBuffer level = new StringBuffer("");
        level.append(createLeftSpace(levelHeight))
                .append(createCore(levelHeight))
                .append(createRightSpace(height))
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

    private String createRightSpace(int levelHeight) {
        return createLeftSpace(levelHeight);
    }
}
