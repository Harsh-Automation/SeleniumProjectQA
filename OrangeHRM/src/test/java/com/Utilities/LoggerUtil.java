package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

	private final Logger log = LogManager.getLogger(LoggerUtil.class);

	public void info(String infomsg) {
		log.info(infomsg);
	}

	public void warn(String warnmsg) {
		log.warn(warnmsg);
	}

	public void error(String errormsg) {
		log.error(errormsg);

	}

}
