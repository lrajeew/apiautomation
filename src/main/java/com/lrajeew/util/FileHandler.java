package com.lrajeew.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FileHandler {

	private static Logger LOGGER = Logger.getLogger(FileHandler.class);

	public static Properties readPropertyFile(String fileName)
			throws IOException {
		Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream(fileName);
			properties.load(input);
		} catch (FileNotFoundException e) {
			LOGGER.error("Exception Occurred while reading the file "
					+ e.getMessage());
			throw e;
		} catch (IOException e) {
			LOGGER.error("Exception Occurred while reading the file "
					+ e.getMessage());
			throw e;
		}
		return properties;
	}

	public static void writeToFile(String filePath, String content) {
		File file = new File(filePath);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}
}
