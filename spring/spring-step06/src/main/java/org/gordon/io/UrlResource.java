package org.gordon.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 15:34
 */
public class UrlResource implements Resource{

	private URL url;

	public UrlResource(URL url) {
		this.url = url;
	}

	@Override
	public InputStream getInputStream() {
		URLConnection urlConnection = null;
		InputStream inputStream = null;
		try {
			urlConnection = url.openConnection();
			inputStream = urlConnection.getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return inputStream;
	}
}
