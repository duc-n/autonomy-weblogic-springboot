package com.cele.autonomy.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;

/**
 * Instantiate a BC Proxy class using {@link com.coface.corp.framework.remote.BcProxy} framework class for all fields marks with the BCProxy
 * annotation
 *
 * @author mikael_taraboletti
 *
 */
public class BcProxyPostProcessor implements BeanPostProcessor {
  static final Logger logger = LoggerFactory.getLogger(BcProxyPostProcessor.class);

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) {
    return bean;
  }

  @Override
  public Object postProcessBeforeInitialization(final Object bean, String beanName) {
    ReflectionUtils.doWithFields(bean.getClass(), new BCProxySetter(bean), new BcProxyFilter());
    return bean;
  }

  /**
   * Accept only fields marked with the BCProxy annotation
   *
   * @author mikael_taraboletti
   *
   */
  private final class BcProxyFilter implements FieldFilter {
    @Override
    public boolean matches(Field field) {
      return (field.getAnnotation(BcProxy.class) != null);

    }
  }

  /**
   * Set new instance of BCProxy to field
   *
   * @author mikael_taraboletti
   *
   */
  private final class BCProxySetter implements FieldCallback {
    private final Object bean;

    private BCProxySetter(Object bean) {
      this.bean = bean;
    }

    @Override
    public void doWith(Field field) throws IllegalAccessException {
      Annotation annotation = field.getAnnotation(BcProxy.class);
      BcProxy bcProxy = (BcProxy) annotation;
      String location = bcProxy.location();

      // Make the field accessible if defined private
      ReflectionUtils.makeAccessible(field);
      Class<?> proxyClass = field.getType();
      // Use framework to retrieve BcProxy instance with/without location
      Object instance = null;
      logger.debug("Initialazing the Bc Proxy {}", proxyClass.getName());

      if (location != null && location.trim().length() > 0) {
        instance = com.coface.corp.framework.remote.BcProxy.getInstance(proxyClass, location);
      } else {
        instance = com.coface.corp.framework.remote.BcProxy.getInstance(proxyClass);
      }

      field.set(this.bean, instance);
    }
  }
}
