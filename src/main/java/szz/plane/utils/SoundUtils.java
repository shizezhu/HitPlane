package cn.szz.plane.utils;

import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import cn.szz.plane.exception.CheckException;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

/**
 * 声音工具
 *
 * @author Shi Zezhu
 * @date 2020年11月19日 上午11:05:04
 */
public class SoundUtils {

    public static void playWav(URL url, boolean asyn) {
        if (asyn) {
            ExecutorUtils.execute(() -> playWav(url));
        } else {
            playWav(url);
        }
    }

    public static void playMp3(URL url, boolean asyn) {
        if (asyn) {
            ExecutorUtils.execute(() -> playMp3(url));
        } else {
            playMp3(url);
        }
    }

    public static void playWav(URL url) {
        try (AudioInputStream input = AudioSystem.getAudioInputStream(url)) {
            AudioFormat target = input.getFormat();
            DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, target);
            int len = -1;
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(dinfo);
            line.open(target);
            line.start();
            byte[] buffer = new byte[1024];
            while ((len = input.read(buffer)) > 0) {
                line.write(buffer, 0, len);
            }
            line.drain();
            line.stop();
            line.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void playMp3(URL url) {
        AudioInputStream input = null;
        AudioInputStream dinput = null;
        try {
            MpegAudioFileReader mpegReader = new MpegAudioFileReader();
            input = mpegReader.getAudioInputStream(url);
            AudioFormat baseFormat = input.getFormat();
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
            dinput = AudioSystem.getAudioInputStream(format, input);
            AudioFormat target = dinput.getFormat();
            DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, target, AudioSystem.NOT_SPECIFIED);
            int len = -1;
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(dinfo);
            line.open(target);
            line.start();
            byte[] buffer = new byte[1024];
            while ((len = dinput.read(buffer)) > 0) {
                line.write(buffer, 0, len);
            }
            line.drain();
            line.stop();
            line.close();
        } catch (Exception e) {
            throw new CheckException(e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (dinput != null) {
                    dinput.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
