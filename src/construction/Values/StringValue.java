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
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author svene_000
 */
public class StringValue implements Value, ActionListener {

    String value = "";
    ValueChangedListener valueChangedListener;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public Value getValue() {
        return this;
    }

    public String getStringValue() {
        return value;
    }

    @Override
    public JComponent getControlComponent(boolean isReadOnly) {
        JTextField cb = new JTextField();
        cb.setText(value);
        cb.setEnabled(!isReadOnly);
        cb.addActionListener(this);
        return cb;
    }

    @Override
    public void setValueChangedListener(ValueChangedListener vcl) {
        valueChangedListener = vcl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        value = e.getActionCommand();
        if (valueChangedListener != null) {
            valueChangedListener.valueChanged(new StringValue(value));
        }
    }

    public String toString() {
        return value;
    }
}
