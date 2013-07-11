package nz.co.nznetwork.minecraftplugin.utils;

import org.bukkit.command.CommandSender;

public class CountdownTimer extends Thread {

	CommandSender sender;
	CountdownListener listener;
	long startTime;
	int currentIndex;
	long[] timeIntervals = new long[]{18000,10800, 3600,1800,1200,600,300,120,60,30,20,10,5,4,3,2,1,0};

	/**
	 * Creating this object will automatically start a timer
	 * which will automatically call the response method
	 * which decrease as you get closer to the event
	 * 
	 * @param time How long to broadcast this message for (in seconds)
	 * @param listener this will be used when the broadcast is finished
	 */
	public CountdownTimer(long time, CountdownListener listener, CommandSender sender) {
		startTime = time;
		this.sender = sender;
		this.listener = listener;
		currentIndex = timeIntervals.length-1;
		while(startTime > timeIntervals[currentIndex]) {
			currentIndex--;
			if (currentIndex == -1) break;
		}
		start();
	}

	@Override
	public void run() {
		//wait until the closest time interval
		try{ Thread.sleep((startTime - timeIntervals[currentIndex])*1000); } catch(Exception e) {/*should probs log this*/ return;}
		//while there is time left on the clock
		for(int i = currentIndex; i < timeIntervals.length-1; i++) {
			listener.intervalTrigger(sender, timeIntervals[i]);
			try{Thread.sleep((timeIntervals[i]-timeIntervals[i+1])*1000);}catch(Exception e) {/*should probs log this*/ return;}
		}
		listener.countdownComplete(sender);
	}
}