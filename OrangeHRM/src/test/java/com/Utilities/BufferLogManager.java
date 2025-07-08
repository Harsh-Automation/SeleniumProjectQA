package com.Utilities;

import java.util.ArrayList;
import java.util.List;

public class BufferLogManager {

	
	private static ThreadLocal<List<String>> logBuffer = ThreadLocal.withInitial(ArrayList::new);

	public static void bufferInfo(String message) {
		logBuffer.get().add(message);
	}

	public static void flushToExtentReport() {
		List<String> logs = logBuffer.get();
		if (ReportManager.getTest() != null) {
			for (String msg : logs) {
				ReportManager.getTest().info(msg);
			}
		}
		logBuffer.remove(); // clear buffer after use
	}
}

