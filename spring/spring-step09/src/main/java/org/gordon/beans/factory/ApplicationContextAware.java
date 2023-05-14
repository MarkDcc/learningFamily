package org.gordon.beans.factory;

import org.gordon.context.ApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2023/4/9 15:31
 */
public interface ApplicationContextAware extends Aware{
	void setApplicationContext(ApplicationContext applicationContext);
}
