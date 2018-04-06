package com.joblogic.log

import java.text.SimpleDateFormat

public class Logger {
	private File logFile = new File("C:\\tmp\\default_${new Date().format('yyyyMMdd', TimeZone.getTimeZone('UTC'))}.log")
	private String dateFormat = "dd.MM.yyyy;HH:mm:ss.SSS"
	private boolean printToConsole = false
 
	/**
	 * Catch all defined logging levels, throw  MissingMethodException otherwise
	 * @param name
	 * @param args
	 * @return
	 */
	def methodMissing(String name, args) {
		def messsage = args[0]
		if (printToConsole) {
			println messsage
		}
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat)
		String date = formatter.format(new Date())
		switch (name.toLowerCase()) {
			case "trace":
				logFile << "${date} TRACE ${messsage}\n"
				break
			case "debug":
				logFile << "${date} DEBUG ${messsage}\n"
				break
			case "info":
				logFile << "${date} INFO  ${messsage}\n"
				break
			case "warn":
				logFile << "${date} WARN  ${messsage}\n"
				break
			case "error":
				logFile << "${date} ERROR ${messsage}\n"
				break
			default:
				throw new MissingMethodException(name, delegate, args)
		}
	}
}
