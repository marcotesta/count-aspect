package it.mondogrua.valuemodel;

import java.util.Observer;

public aspect JavaUtilObserving {
	
	private JavaUtilsObservable ValueModel.javaUtilObservable = new JavaUtilsObservable(this);

    public void ValueModel.addObserver(Observer observer) {
    	javaUtilObservable.addObserver(observer);
    }
    
    public java.util.Observable ValueModel.asJavaUtilObservable() {
        return javaUtilObservable;
    }

    pointcut changes(ValueModel p): target(p) && call(void ValueModel.setValue(Object));

    after(ValueModel p): changes(p) {
    	p.javaUtilObservable.changed("getValue");
    }
}
