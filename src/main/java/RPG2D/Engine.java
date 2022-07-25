package RPG2D;
import Core.GameState;
import RPG2D.Render.Render;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import RPG2D.Util.FileOpReader;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Engine {
    private static final String SYS_LINE_SEP = System.lineSeparator();
    public static GameState gameState;
    private static long lastFrame;

    private Engine(){
        //---------
    }

    public static void initialization(Stage stage){
        FileOpReader.initialization();
        initScreen();
    }

    private static void initScreen (){
        String[] settingL = FileOpReader.getFileLines(FileOpReader.SETTINGS_PATH);
        for(String line: settingL) {
            if(line.contains("SCREEN_WIDTH")) {
                settings.setWidth (Integer.parseInt(line.split("=")[1]));
            } else if(line.contains("SCREEN_HEIGHT")) {
                settings.setHeight (Integer.parseInt(line.split("=")[1]));
            }
        }
        settings.setTitle("SimpleTitle");
    }
}
