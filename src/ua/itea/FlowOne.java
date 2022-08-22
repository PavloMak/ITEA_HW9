package ua.itea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FlowOne implements Runnable {

	private Thread thread;
	private Integer id;

	public FlowOne() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		int idToSend;
		while (true) {
			if (id != null) {
				String pattern = "yyyy-MM-dd  HH:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String date = simpleDateFormat.format(new Date());
				FileWriter fw;
				try {
					fw = new FileWriter("log.txt", true);
					 BufferedWriter bw = new BufferedWriter(fw);
					    bw.write(id + ": " + date);
					    bw.newLine();
					    bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				id = null;
			}
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void resume(Integer id) {
		notify();
		this.id = id;
	}
}
