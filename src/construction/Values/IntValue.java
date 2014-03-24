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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author svene_000
 */
public class IntValue implements Value, ActionListener {

    int value = 0;
    List<ValueChangedListener> valueChangedListeners = new ArrayList();

    public IntValue(int value) {
        this.value = value;
    }

    @Override
    public Value getValue() {
        return this;
    }

    public int getIntValue() {
        return value;
    }

    public boolean equals(Object o) {
        if (o instanceof IntValue) {
            IntValue b = (IntValue) o;
            if (b.getIntValue() == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JComponent getControlComponent(boolean isReadOnly) {
        JTextField tf = new JTextField();
        tf.setText(String.valueOf(value));
        tf.setEnabled(!isReadOnly);
        tf.addActionListener(this);
        return tf;
    }

    @Override
    public void addValueChangedListener(ValueChangedListener vcl) {
        valueChangedListeners.clear();
        valueChangedListeners.add(vcl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        value = Integer.parseInt(e.getActionCommand());
        for (ValueChangedListener valueChangedListener : valueChangedListeners) {
            valueChangedListener.valueChanged(new IntValue(value));
        }
    }

    public String toString() {
        return String.valueOf(value);
    }
}
