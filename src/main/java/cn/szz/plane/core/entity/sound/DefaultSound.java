package cn.szz.plane.core.entity.sound;

import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.utils.ExecutorUtils;

public class DefaultSound implements Sound {

	protected URL url;
	protected boolean loop;
	protected boolean flag;

	public DefaultSound(SoundPathEnum soundPath) {
		this(soundPath, false);
	}

	public DefaultSound(SoundPathEnum soundPath, boolean loop) {
		this(soundPath.getURL(), loop);
	}

	public DefaultSound(URL url) {
		this(url, false);
	}

	public DefaultSound(URL url, boolean loop) {
		this.url = url;
		this.loop = loop;
		this.flag = true;
	}

	@Override
	public void play() {
		ExecutorUtils.execute(() -> {
			do {
				try (AudioInputStream input = AudioSystem.getAudioInputStream(url)) {
					AudioFormat target = input.getFormat();
					DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, target);
					int len = -1;
					SourceDataLine line = (SourceDataLine) AudioSystem.getLine(dinfo);
					line.open(target);
					line.start();
					byte[] buffer = new byte[32];
					while ((len = input.read(buffer)) > 0 && flag) {
						line.write(buffer, 0, len);
					}
					line.drain();
					line.stop();
					line.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			} while (loop && flag);
		});
	}

	@Override
	public void stop() {
		this.flag = false;
	}

	public URL getUrl() {
		return url;
	}

	public boolean getLoop() {
		return loop;
	}
}
