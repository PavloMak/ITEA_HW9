package ua.itea;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FlowThree implements Runnable {

	private List<Integer> idList;
	private Thread thread;
	private FlowOne flow;

	public FlowThree(List<Integer> idList, FlowOne flow) {
		this.idList = idList;
		this.flow = flow;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		int idToSend;
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!idList.isEmpty()) {
				idToSend = idList.get(0);
				flow.resume(idToSend);
				//System.out.println(idToSend + "uru");
				idList.remove(0);
			}
		}

	}
}
