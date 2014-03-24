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
package construction.RenderElements;

import construction.QuestionElements.Question;
import construction.Values.BoolValue;
import construction.Values.Value;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

/**
 *
 * @author svene_000
 */
public class RenderedBooleanQuestion extends AbstractRenderedQuestion implements ItemListener {

    List<ValueChangedListener> valueChangedListeners = new ArrayList();
    Value value = new BoolValue(false);

    public RenderedBooleanQuestion(Question q) {
        super(q);
    }

    public RenderedBooleanQuestion(Question q, boolean enabled) {
        super(q, enabled);
    }

    @Override
    public JComponent getRender() {
        JComponent questionBox = super.getRender();
        JCheckBox cb = new JCheckBox("Ja/Nee");
        cb.setEnabled(enabled);
        questionBox.add(cb);
        cb.addItemListener(this);
        System.out.println("RENDERING QUESTION: " + this.q.getQuestionContent() + " of type: " + q.getQuestionType());
        return questionBox;
    }

    public void addValueChangedListener(ValueChangedListener valueChangedListener) {
        valueChangedListeners.add(valueChangedListener);
    }
    
    public Value getValue()
    {
        return value;
    }
    
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        boolean newValue = false;
        if (e.getStateChange() == 2) {
            newValue = true;
        }
        value = new BoolValue(newValue);
        for(ValueChangedListener valueChangedListener: valueChangedListeners)
        {
         //   valueChangedListener.valueChanged(this, new BoolValue(newValue));
        }

    }

}
