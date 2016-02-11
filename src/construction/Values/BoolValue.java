/*
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction.Values;

import construction.RenderElements.ValueChangedListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

/**
 *
 * @author svene_000
 */
public class BoolValue implements Value, ItemListener {
    
    boolean value = false;
    ValueChangedListener valueChangedListener;
    
    public BoolValue(boolean value) {
        this.value = value;
    }
    
    @Override
    public Value getValue() {
        return this;
    }
    
    public boolean getBoolValue() {
        return value;
    }
    
    public boolean equals(Object o) {
        if (o instanceof BoolValue) {
            BoolValue b = (BoolValue) o;
            if (b.getBoolValue() == value) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void setValueChangedListener(ValueChangedListener vcl) {
        //  valueChangedListeners.clear();
        valueChangedListener = vcl;
    }
    
    @Override
    public JComponent getControlComponent(boolean isReadOnly) {
        JCheckBox cb = new JCheckBox("Ja/Nee");
        cb.setSelected(value);
        cb.setEnabled(!isReadOnly);
        cb.addItemListener(this);
        return cb;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        boolean newValue = false;
        if (e.getStateChange() == 1) {
            newValue = true;
        }
        value = newValue;
        if(valueChangedListener!=null) valueChangedListener.valueChanged(new BoolValue(value));
    }
    
    public String toString() {
        if (value) {
            return "True";
        } else {
            return "False";
        }
    }
}
