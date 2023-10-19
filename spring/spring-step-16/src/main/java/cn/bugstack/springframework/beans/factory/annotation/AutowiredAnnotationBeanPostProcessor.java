package cn.bugstack.springframework.beans.factory.annotation;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.bugstack.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.bugstack.springframework.util.ClassUtils;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;

/**
 * @Author:dongchen
 * @Date: 2023/9/3 13:35
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        beanClass = ClassUtils.isCglibProxyClass(beanClass) ? beanClass.getSuperclass() : beanClass;

        Field[] declaredFields = beanClass.getDeclaredFields();

        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if(valueAnnotation != null){
                String value = valueAnnotation.value();
                value = this.beanFactory.resolveEmbeddedValue(value);
                //                pvs.addPropertyValue(new PropertyValue(field.getName(), value));
                BeanUtil.setFieldValue(bean,field.getName(),value);
            }
        }

        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation){
                Class<?> fieldType = field.getType();

                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                String dependentBeanName = null;
                Object dependentBean = null;
                if(null != qualifierAnnotation){
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = this.beanFactory.getBean(dependentBeanName,fieldType);
                }else {
                    dependentBean = this.beanFactory.getBean(fieldType);
                }
                //                pvs.addPropertyValue(new PropertyValue(field.getName(), dependentBean));
                BeanUtil.setFieldValue(bean,field.getName(),dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }
}
