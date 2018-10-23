package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable
{
    @FXML Button minButton, secButton, pickButton, resetButton;
    @FXML Text minTime, secTime;
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;

    public void minBut(ActionEvent event)
    {
        minTime.setText(Integer.toString(02));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 60;
            int x = 60;
            int y = 60;
            public void run() {
                secTime.setText(Integer.toString(i--));
                if(i < 0) {
                    minTime.setText(Integer.toString(01));
                    secTime.setText(Integer.toString(x--));
                    if (x < 0) {
                        minTime.setText(Integer.toString(00));
                        secTime.setText(Integer.toString(y--));
                        if (y < 0) {
                            timer.cancel();
                            /*System.out.println("Play Media");
                            URL resource = getClass().getResource("blewIt.mp3");
                            Media media = new Media(resource.toString());
                            mediaPlayer3 = new MediaPlayer(media);
                            mediaPlayer3.play();
                            System.out.println("After Media");*/
                        }
                    }
                }
            }
        }, 0, 1000);
        System.out.println("minute button");
    }

    public void secBut(ActionEvent event)
    {
        minTime.setText(Integer.toString(01));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 30;
            int x = 60;
            public void run() {
                secTime.setText(Integer.toString(i--));
                if(i < 0){
                    minTime.setText(Integer.toString(00));
                    secTime.setText(Integer.toString(x--));
                    if (x < 0) {
                        timer.cancel();
                        /*System.out.println("Play Media");
                        URL resource = getClass().getResource("blewIt.mp3");
                        Media media = new Media(resource.toString());
                        mediaPlayer1 = new MediaPlayer(media);
                        mediaPlayer1.play();
                        System.out.println("After Media");*/
                    }
                }
            }
        }, 0, 1000);
        System.out.println("second button");
    }

    public void pickBut(ActionEvent event) {
        URL resource = getClass().getResource("draftSound.mp3");
        Media media = new Media(resource.toString());
        mediaPlayer2 = new MediaPlayer(media);
        mediaPlayer2.play();
        System.out.println("pick button");
    }

    public void resetBut() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Timer.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
