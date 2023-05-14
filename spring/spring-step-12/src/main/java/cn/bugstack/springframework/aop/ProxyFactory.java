package cn.bugstack.springframework.aop;

import cn.bugstack.springframework.aop.framwork.AopProxy;
import cn.bugstack.springframework.aop.framwork.Cglib2AopProxy;
import cn.bugstack.springframework.aop.framwork.JdkDynamicAopProxy;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 20:14
 */
public class ProxyFactory {

	private AdvisedSupport advisedSupport;

	public ProxyFactory(AdvisedSupport advisedSupport) {
		this.advisedSupport = advisedSupport;
	}

	public Object getProxy(){
		return createProxy().getProxy();
	}

	private AopProxy createProxy() {
		if(advisedSupport.isProxyTargetClass()){
			return new Cglib2AopProxy(advisedSupport);
		}
		return new JdkDynamicAopProxy(advisedSupport);
	}
}
