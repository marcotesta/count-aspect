package it.mondogrua.valuemodel;

import java.util.Observable;

public class JavaUtilsObservable extends Observable {
	
	private ValueModel valueModel;

	public JavaUtilsObservable(ValueModel count) {
		this.valueModel = count;
	}
	
    public void changed(String attribute) {
        setChanged();
        notifyObservers(attribute);
        clearChanged();
    }
    
    public Object getValue() {
        return valueModel.getValue();
    }

}
