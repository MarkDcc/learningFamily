package cn.bugstack.springframework.context.annotation;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.hutool.core.util.ClassUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:dongchen
 * @Date: 2023/5/28 16:37
 */
public class ClassPathScanningCandidateComponentProvider {
	public Set<BeanDefinition> findCandidateComponents(String packageName){
		Set<BeanDefinition> result = new HashSet<>();
		Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(packageName, Component.class);
		for (Class<?> aClass : classes) {
			result.add(new BeanDefinition(aClass));
		}
		return result;
	}
}
