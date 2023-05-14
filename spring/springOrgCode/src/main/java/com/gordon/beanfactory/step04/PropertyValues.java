package com.gordon.beanfactory.step04;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2023/3/12 14:25
 */
public class PropertyValues {
	private List<PropertyValue> propertyValueList = new ArrayList<>();

	public PropertyValue[] getPropertyValues(){
		return propertyValueList.toArray(new PropertyValue[0]);
	}

	public void addPropertyValue(PropertyValue propertyValue){
		propertyValueList.add(propertyValue);
	}
}
