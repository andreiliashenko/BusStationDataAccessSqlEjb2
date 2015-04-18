package com.anli.busstation.dal.ejb2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

public class EjbExceptionHandler implements InvocationHandler {

    protected Object proxied;
    protected Collection<Class<? extends Throwable>> manageableExceptions;

    public EjbExceptionHandler(Object proxied,
            Collection<Class<? extends Throwable>> manageableExceptions) {
        this.proxied = proxied;
        this.manageableExceptions = manageableExceptions;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method actualMethod = proxied.getClass().getMethod(method.getName(), method.getParameterTypes());
        try {
            return actualMethod.invoke(proxied, args);
        } catch (InvocationTargetException exception) {
            Throwable cause = exception.getCause();
            throw getActualException(cause);
        }
    }

    public boolean isManageable(Class<? extends Throwable> exceptionClass) {
        for (Class<? extends Throwable> manageable : manageableExceptions) {
            if (manageable.isAssignableFrom(exceptionClass)) {
                return true;
            }
        }
        return false;
    }

    public Throwable getActualException(Throwable exception) {
        Throwable current = exception;
        while (current != null) {
            if (isManageable(current.getClass())) {
                return current;
            }
            current = current.getCause();
        }
        return exception;
    }
}
