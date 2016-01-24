package it.mondogrua.valuemodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;

public aspect PropertyObserving {
	
	private SimpleStringProperty ValueModel.propertyObservable = new SimpleStringProperty();

    public void ValueModel.addObserver(SimpleStringProperty propertyObserver) {
    	propertyObservable.bind(propertyObserver);
    }
    
    public void ValueModel.addObserver(ChangeListener<? super String> changeListener) {
    	propertyObservable.addListener(changeListener);
	}

	public SimpleStringProperty ValueModel.asSimpleStringProperty() {
		return propertyObservable;
	}

    pointcut changes(ValueModel p): target(p) && call(void ValueModel.setValue(Object));

    after(ValueModel p): changes(p) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	p.propertyObservable.set(p.getValue().toString());
            }
       });
    }

}
