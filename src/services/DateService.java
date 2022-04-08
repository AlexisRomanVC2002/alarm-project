package services;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import javax.swing.JLabel;

/**
 *
 * @author AlexisVC2002
 */
public class DateService {

    private final JLabel date;
    private final JLabel hour;
    private Timer timeHour;
    private Timer timeChangeColorRed;
    private Timer timeChangeColorWhite;
    private String hourAlarm = "";

    private final DateFormat formatHour;
    private final DateFormat formatDate;

    private Clip clip;

    public DateService(JLabel date, JLabel hour) {
        this.date = date;
        this.hour = hour;

        formatHour = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        formatDate = DateFormat.getDateInstance(DateFormat.LONG);
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            System.err.println("Error: " + ex.getMessage());
        }

    }

    public void setHourAlarm(String hourAlarm) {
        this.hourAlarm = hourAlarm;
    }

    public void initTimer() {

        hour.setText(formatHour.format(new Date()));
        date.setText(formatDate.format(new Date()));

        ActionListener updateHour = (ActionEvent e) -> {

            String textHour = formatHour.format(new Date());
            String textDate = formatDate.format(new Date());

            hour.setText(textHour);
            date.setText(textDate);

            if (hourAlarm.equals(textHour)) {
                initTimerChangeColor();
            }
        };

        timeHour = new Timer(1000, updateHour);
        timeHour.start();

    }

    private void initTimerChangeColor() {
        ActionListener changeColorRed = (ActionEvent e) -> {
            hour.setForeground(Color.red);
            if (!clip.isOpen()) {
                runSoundAlarm();
            }else if(!clip.isRunning()){
                clip.close();
                runSoundAlarm();
            }
        };

        ActionListener changeColorWhite = (ActionEvent e) -> {
            hour.setForeground(Color.white);
        };

        timeChangeColorRed = new Timer(500, changeColorRed);
        timeChangeColorWhite = new Timer(680, changeColorWhite);

        timeChangeColorRed.start();
        timeChangeColorWhite.start();
    }

    private void runSoundAlarm() {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(DateService.class.getResourceAsStream("/resources/sound.wav"));
            clip.open(inputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void stopTimerChangeColor() {
        hourAlarm = "";
        timeChangeColorRed.stop();
        timeChangeColorWhite.stop();
        clip.close();
    }

}
