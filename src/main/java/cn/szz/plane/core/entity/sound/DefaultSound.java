package cn.szz.plane.core.entity.sound;

import java.net.URL;

import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.utils.SoundUtils;

public class DefaultSound implements Sound {

    protected URL url;
    protected boolean asyn;
    protected String format;

    public DefaultSound(SoundPathEnum soundPath) {
        this(soundPath, true);
    }

    public DefaultSound(SoundPathEnum soundPath, boolean asyn) {
        this(soundPath.getURL(), asyn, soundPath.getFormat());
    }

    public DefaultSound(URL url, String format) {
        this(url, true, format);
    }

    public DefaultSound(URL url, boolean asyn, String format) {
        this.url = url;
        this.asyn = asyn;
        this.format = format;
    }

    @Override
    public DefaultSound play() {
        switch (format) {
        case WAV:
            SoundUtils.playWav(url, asyn);
            break;
        case MP3:
            SoundUtils.playMp3(url, asyn);
            break;
        default:
            break;
        }
        return this;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public boolean getAsyn() {
        return asyn;
    }

    public void setAsyn(boolean asyn) {
        this.asyn = asyn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (asyn ? 1231 : 1237);
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        DefaultSound other = (DefaultSound) obj;
        if (asyn != other.asyn) return false;
        if (format == null) {
            if (other.format != null) return false;
        } else if (!format.equals(other.format)) return false;
        if (url == null) {
            if (other.url != null) return false;
        } else if (!url.equals(other.url)) return false;
        return true;
    }
}
