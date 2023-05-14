package org.gordon.io;

import cn.hutool.core.lang.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 17:09
 */
public class DefaultResourceLoader implements ResourceLoader {

	@Override
	public Resource getResource(String location) {
		Assert.notNull(location, "Location must not be null");
		if(location.startsWith(CLASSPATH_URL_PREFIX)){
			return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()),Thread.currentThread().getContextClassLoader());
		}
		try {
			URL url = new URL(location);
			return new UrlResource(url);
		} catch (MalformedURLException e) {
			return new FileSystemResource(new File(location));
		}

	}
}
