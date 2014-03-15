package ql.gui.element;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ql.ast.Questionnaire;
import ql.gui.element.widget.LabelInputPair;
import ql.gui.renderer.GuiRenderer;

/**
 * @author orosu
 */
public class QuestionnaireFrame extends JFrame implements IGuiElement
{
    private static final long serialVersionUID = 1L;
    private final JPanel _panel;
    private final LinkedHashMap<String, LabelInputPair> _labelInputPairs;

    public QuestionnaireFrame(final Questionnaire questionnaire, final GuiRenderer guiRenderer)
    {
        this._labelInputPairs = new LinkedHashMap<String, LabelInputPair>();

        // General Configuration
        this.setTitle(questionnaire.getId());
        this.setLocationByPlatform(true);

        // Close Event
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we) {
                // Check if other frames are still running, otherwise exit
                if (guiRenderer.getQuestionnaires().size() == 1) {
                    System.exit(0);
                } else {
                    guiRenderer.removeQuestionnaire(questionnaire);
                }
            }
        });

        // Build Form
        this._panel = new JPanel();
        this._panel.setLayout(new GridBagLayout());
        this.setMinimumSize(new Dimension(200, 20));

        this.add(this._panel);
    }

    public void build()
    {
        int i = 0;
        for (LabelInputPair labelInputPair: this._labelInputPairs.values()) {
            this._panel.add(labelInputPair.label, this._createGridBagConstraints(0, i));
            this._panel.add(labelInputPair.input.getJComponent(), this._createGridBagConstraints(1, i));
            i++;
        }

        // Resize
        this.pack();
    }

    public void addLabelInputPair(String id, LabelInputPair labelInputPair)
    {
        this._labelInputPairs.put(id, labelInputPair);
    }

    public boolean containsLabelInputPair(String id)
    {
        return this._labelInputPairs.containsKey(id);
    }

    public LabelInputPair getLabelInputPairById(String id)
    {
        return this._labelInputPairs.get(id);
    }

    private GridBagConstraints _createGridBagConstraints(int x, int y)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x; // column
        gbc.gridy = y; // row
        gbc.anchor = GridBagConstraints.WEST; // align left
        gbc.insets = new Insets(1, 2, 2, 2);
        return gbc;
     }
}
