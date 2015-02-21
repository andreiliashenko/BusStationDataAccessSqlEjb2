package com.anli.busstation.dal.ejb2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import javax.ejb.EJBException;

public class RemoteExceptionHandler implements InvocationHandler {

    protected Object proxied;

    public RemoteExceptionHandler(Object proxied) {
        this.proxied = proxied;
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

    public Throwable getActualException(Throwable exception) {
        while (exception instanceof RemoteException || exception instanceof EJBException) {
            exception = exception.getCause();
        }
        return exception;
    }
}
