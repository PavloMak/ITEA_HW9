package ua.itea;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Integer> idList = new ArrayList<Integer>();
		FlowOne fl1 = new FlowOne();
		new FlowTwo(idList);
		new FlowThree(idList, fl1);
		

	}

}
