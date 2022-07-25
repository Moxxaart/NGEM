package RPG2D;

import RPG2D.Util.FileOpReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public final class App extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
//        FileOpReader.initialization();
//        String[] settingL = FileOpReader.getFileLines(FileOpReader.SETTINGS_PATH);
//        for(String line: settingL) {
//            if(line.contains("SCREEN_WIDTH")) {
//                settings.setWidth (Integer.parseInt(line.split("=")[1]));
//            } else if(line.contains("SCREEN_HEIGHT")) {
//                settings.setHeight (Integer.parseInt(line.split("=")[1]));
//            }
//        }
//        settings.setTitle("SimpleTitle");
    }

    @Override
    protected void initGame() {
        FXGL.entityBuilder()
                .at(150, 150)
                .view(new Rectangle(40, 40, Color.BLUE))
                .buildAndAttach();
    }

    public static void main(String[] args) {
        launch(args);
    }
}