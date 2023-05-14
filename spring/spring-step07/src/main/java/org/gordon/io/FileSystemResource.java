package org.gordon.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 15:34
 */
public class FileSystemResource implements Resource{
	private File file;

	public FileSystemResource(File file) {
		this.file = file;
	}

	@Override
	public InputStream getInputStream() {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
