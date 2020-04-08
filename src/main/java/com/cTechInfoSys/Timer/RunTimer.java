package com.cTechInfoSys.Timer;

import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RunTimer {

	public static void main(String[] args) {

		TimerTask tm1 = new EmailTo();
		TimerTask tm2 = new CleanUpFiles();
		
		Timer time = new Timer();
		Date dtFirst = new Date(System.currentTimeMillis()+20000);
		
		time.schedule(tm1, 2000,20000);
		time.schedule(tm2, 10000, 5000);
		time.schedule(tm1, dtFirst);
		System.out.println("timer task has scheduled...");
		time.cancel();
		
	}

}
