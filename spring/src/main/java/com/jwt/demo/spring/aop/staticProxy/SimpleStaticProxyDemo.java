package com.jwt.demo.spring.aop.staticProxy;

/**
 * 静态代理demo -->   代理类代码在写程序时固定的
 *                  如果再添1个服务，不同服务对应的前置和后置处理不同，比如打印跟踪调试信息，则需要为不同服务分别创建代理，很不方便。
 */
public class SimpleStaticProxyDemo {

    interface IService {
        void sayHello();
    }

    static class RealService implements IService {
        public void sayHello() {
            System.out.println("Hello!");
        }
    }

    static class StaticProxyService implements IService {

        private IService realService;

        public StaticProxyService(IService realService) {
            this.realService = realService;
        }

        public void sayHello() {
            System.out.println("start...");
            realService.sayHello();
            System.out.println("end...");
        }
    }

    public static void main(String[] args) {
        StaticProxyService staticProxy = new StaticProxyService(new RealService());
        staticProxy.sayHello();
    }


}
