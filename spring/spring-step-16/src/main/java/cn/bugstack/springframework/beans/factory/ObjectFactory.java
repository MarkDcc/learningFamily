package cn.bugstack.springframework.beans.factory;

/**
 * @Author:dongcc
 * @Date: 2023/10/15 18:05
 */
@FunctionalInterface
public interface ObjectFactory<T> {
    T getObject();
}
