package it.mondogrua.javafx_count_view;

import it.mondogrua.valuemodel.ValueModel;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;

public class JFXDisplayBox extends Label  {

    public JFXDisplayBox(ValueModel valueModel) {
        textProperty().bind(Bindings.convert(valueModel.asSimpleStringProperty()));
    }
}
