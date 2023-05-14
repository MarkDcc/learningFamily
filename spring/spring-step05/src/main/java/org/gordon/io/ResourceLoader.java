package org.gordon.io;

import java.security.PrivateKey;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 17:07
 */
public interface ResourceLoader {
	/**
	 * Pseudo URL prefix for loading from the class path: "classpath:"
	 */
	String CLASSPATH_URL_PREFIX = "classpath:";

	Resource getResource(String location);
}
