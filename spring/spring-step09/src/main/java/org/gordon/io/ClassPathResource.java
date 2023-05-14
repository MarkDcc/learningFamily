package org.gordon.io;

import java.io.InputStream;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 15:34
 */
public class ClassPathResource implements Resource{
	private String path;
	private ClassLoader classLoader;
	@Override
	public InputStream getInputStream() {
		return classLoader.getResourceAsStream(path);
	}

	public ClassPathResource(String path, ClassLoader classLoader) {
		this.path = path;
		this.classLoader = classLoader;
	}
}