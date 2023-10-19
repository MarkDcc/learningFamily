package cn.bugstack.springframework.context.annotation;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.hutool.core.util.StrUtil;
import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @Author:dongchen
 * @Date: 2023/5/28 16:36
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {


	private BeanDefinitionRegistry registry;

	public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

	public void doScan(String... basePackage){
		for (String packageName : basePackage) {
			Set<BeanDefinition> candidateComponents = findCandidateComponents(packageName);
			for (BeanDefinition definition : candidateComponents) {
				definition = resolveBeanScope(definition);
				registry.registerBeanDefinition(determineBeanName(definition),definition);
			}
		}
	}

	private String determineBeanName(BeanDefinition definition) {
		Component component = (Component) definition.getBeanClass().getAnnotation(Component.class);

		if(component != null){
			return component.value();
		}
		return StrUtil.lowerFirst(definition.getBeanClass().getSimpleName());

	}

	private BeanDefinition resolveBeanScope(BeanDefinition definition) {
		Class beanClass = definition.getBeanClass();
		Scope scope = (Scope) beanClass.getAnnotation(Scope.class);
		if(scope != null){
			definition.setScope(scope.value());
			return definition;
		}
		definition.setScope(StrUtil.EMPTY);
		return definition;
	}
}
