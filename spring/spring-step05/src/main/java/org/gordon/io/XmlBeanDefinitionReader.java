package org.gordon.io;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.gordon.beans.BeansException;
import org.gordon.beans.PropertyValue;
import org.gordon.beans.PropertyValues;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanReference;
import org.gordon.beans.factory.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 17:28
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
		super(registry, resourceLoader);
	}

	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public void loadBeanDefinitions(Resource resource) throws BeansException, ClassNotFoundException {
		InputStream inputStream = resource.getInputStream();
		doLoadBeanDefinitions(inputStream);
	}

	@Override
	public void loadBeanDefinitions(Resource... resources) throws BeansException, ClassNotFoundException {
		for (Resource resource : resources) {
			loadBeanDefinitions(resource);
		}
	}

	@Override
	public void loadBeanDefinitions(String location) throws BeansException, ClassNotFoundException {
		ResourceLoader resourceLoader = getResourceLoader();
		Resource resource = resourceLoader.getResource(location);
		loadBeanDefinitions(resource);
	}

	private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
		Document doc = XmlUtil.readXML(inputStream);
		Element root = doc.getDocumentElement();
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			// 判断元素
			if (!(childNodes.item(i) instanceof Element)) continue;
			// 判断对象
			if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

			Element bean = (Element) childNodes.item(i);
			String id = bean.getAttribute("id");
			String aClass = bean.getAttribute("class");
			String name = bean.getAttribute("name");


			Class<?> tClass = Class.forName(aClass);
			//id>name
			String beanName = StrUtil.isNotEmpty(id) ? id : name;
			if(beanName.isEmpty()){
				beanName = StrUtil.lowerFirst(tClass.getSimpleName());
			}

			BeanDefinition beanDefinition = new BeanDefinition(tClass);
			PropertyValues propertyValues = new PropertyValues();

			//解析属性
			NodeList beanChildNodes = bean.getChildNodes();
			for (int i1 = 0; i1 < beanChildNodes.getLength(); i1++) {
				// 判断元素
				if (!(beanChildNodes.item(i1) instanceof Element)) continue;
				// 判断对象
				if (!"property".equals(beanChildNodes.item(i1).getNodeName())) continue;
				Element property = (Element) beanChildNodes.item(i1);
				String attrName = property.getAttribute("name");
				String attrValue = property.getAttribute("value");
				String attrRef = property.getAttribute("ref");
				Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
				propertyValues.addPropertyValue(new PropertyValue(attrName,value));
			}
			beanDefinition.setPropertyValues(propertyValues);
			if (getRegistry().containerBeanDefinition(beanName)){
				throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
			}

			getRegistry().registryBeanDefinition(beanDefinition, beanName);
		}
	}
}
