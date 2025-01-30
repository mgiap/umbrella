import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load custom fonts
            Font.loadFont(getClass().getResource("/fonts/PixelifySans-Regular.ttf").toExternalForm(), 16);
            Font.loadFont(getClass().getResource("/fonts/PixelifySans-SemiBold.ttf").toExternalForm(), 16);
            Font.loadFont(getClass().getResource("/fonts/RobotoMono-Regular.ttf").toExternalForm(), 16);

            // Load IntroScene
            FXMLLoader introLoader = new FXMLLoader(getClass().getResource("IntroScreen.fxml"));
            Parent introRoot = introLoader.load();
            Scene introScene = new Scene(introRoot);

            // Set up IntroController with access to stage
            IntroController introController = introLoader.getController();
            introController.setStage(primaryStage);

            // Play background music
            getInstance().playSound();

            // Set initial scene to the intro scene
            primaryStage.setTitle("Umbrella Board Game");
            primaryStage.setScene(introScene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
        Media music = new Media(getClass().getResource("Jaunty Gumption.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop indefinitely
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}