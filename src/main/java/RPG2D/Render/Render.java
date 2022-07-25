package RPG2D.Render;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import org.dionthorn.tacticalrpg2d.data.GameState;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public final class Render {
    public static GraphicsContext gc;
    public static Stage rootStage;
    public static StackPane rootPane;
    public static Image mainMenuBg;
    public static Image consoleBg;
    private static final int[] anchorUpperLeft = new int[2];
    public static double STAGE_PAD_WIDTH;
    public static double STAGE_PAD_HEIGHT;
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static int SCREEN_MAP_HEIGHT;
    public static int SCREEN_DEFAULT_HD = 1024;
    public static int SCREEN_DEFAULT_SD = 704;
    public static int SCREEN_MAP_DEFAULT_HD = 768;
    public static int SCREEN_MAP_DEFAULT_SD = 512;
    public static int TILE_SIZE = 32;
    public static final String GAME_FONT_NAME = "Arial";
    public static final Font SMALL_FONT = new Font(GAME_FONT_NAME, 12);
    public static final Font MEDIUM_FONT = new Font(GAME_FONT_NAME, 24);
    public static final Font LARGE_FONT = new Font(GAME_FONT_NAME, 32);

    private Render(){
        //-----------
    }

    private static void initialization(){
        //rootStage = Stage;
        Group rootGroup = new Group();
        Scene rootScene = new Scene(rootGroup, SCREEN_WIDTH, SCREEN_HEIGHT, Color.BLACK);
        rootStage.sizeToScene();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        rootPane = new StackPane(canvas);
        rootGroup.getChildren().add(rootPane);
        gc = canvas.getGraphicsContext2D();
        rootStage.setScene(rootScene);
        rootStage.show();
        STAGE_PAD_WIDTH = rootStage.getWidth() - SCREEN_WIDTH;
        STAGE_PAD_HEIGHT = rootStage.getHeight() - SCREEN_HEIGHT;
    }
}
