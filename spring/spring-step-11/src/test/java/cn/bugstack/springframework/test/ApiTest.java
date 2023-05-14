package cn.bugstack.springframework.test;

import cn.bugstack.springframework.aop.AdvisedSupport;
import cn.bugstack.springframework.aop.TargetSource;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.bugstack.springframework.aop.framwork.Cglib2AopProxy;
import cn.bugstack.springframework.aop.framwork.JdkDynamicAopProxy;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.IUserService;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 单元测试
 * @date 2022/03/10
 *
 *
 */
public class ApiTest {


    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.UserService.*(..))");

        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }
    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
