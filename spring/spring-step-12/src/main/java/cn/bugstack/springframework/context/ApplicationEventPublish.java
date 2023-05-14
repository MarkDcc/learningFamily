package cn.bugstack.springframework.context;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 15:05
 */
public interface ApplicationEventPublish {
	void publishEvent(ApplicationEvent event);
}
