package cn.bugstack.springframework.aop;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:29
 */
public class TargetSource {

	private Object target;

	public TargetSource(Object target) {
		this.target = target;
	}

	public Class<?>[] getTargetClass() {
		return this.target.getClass().getInterfaces();
	}

	public Object getTarget() {
		return this.target;
	}
}
