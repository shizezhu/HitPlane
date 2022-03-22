package cn.szz.plane.core.entity.sound;

import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.utils.CheckUtils;

public class DefaultBgSound extends DefaultSound implements BgSound {
    
    protected AudioClip audioClip;

    public DefaultBgSound(SoundPathEnum soundPath) {
        this(soundPath.getURL(), soundPath.getFormat());
    }

    public DefaultBgSound(URL url, String format) {
        super(url, format);
        this.audioClip = JApplet.newAudioClip(url);
    }

    @Override
    public DefaultBgSound play() {
        if (CheckUtils.isEquals(WAV, format)) {
            audioClip.play();
        }
        return this;
    }

    @Override
    public DefaultBgSound loop() {
        if (CheckUtils.isEquals(WAV, format)) {
            audioClip.loop();
        }
        return this;
    }

    @Override
    public DefaultBgSound stop() {
        if (CheckUtils.isEquals(WAV, format)) {
            audioClip.stop();
        }
        return this;
    }

}
