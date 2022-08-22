package ua.itea;

import java.util.List;

public class FlowTwo implements Runnable {

	private List<Integer> idList;
	private Thread thread;

	public FlowTwo(List<Integer> idList) {
		this.idList = idList;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		int newId = 0;
		while (true) {
			newId++;
			idList.add((Integer) newId);
			try {
				Thread.sleep(120000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
