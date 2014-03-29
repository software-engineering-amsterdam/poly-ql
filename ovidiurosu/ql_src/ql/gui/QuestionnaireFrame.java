package ql.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ql.ast.Questionnaire;
import ql.gui.renderer.GuiRenderer;
import ql.gui.widget.LabelInputPair;

/**
 * @author orosu
 */
public class QuestionnaireFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    private int _numHeaderMessages;
    private final JPanel _headerPanel;
    private final JPanel _mainPanel;
    private final LinkedHashMap<String, LabelInputPair> _labelInputPairs;

    public QuestionnaireFrame(final Questionnaire questionnaire, final GuiRenderer guiRenderer)
    {
        // General Configuration
        this.setTitle(questionnaire.getId());
        this.setLocationByPlatform(true);
        this.setMinimumSize(new Dimension(200, 20));
        this.setLayout(new BorderLayout());

        // Close Event
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we) {
                // Check if other frames are still running, otherwise exit
                if (guiRenderer.getQuestionnaireList().size() == 1) {
                    System.exit(0);
                } else {
                    guiRenderer.removeQuestionnaire(questionnaire);
                }
            }
        });

        // Header Panel
        this._headerPanel = new JPanel();
        this._headerPanel.setLayout(new GridBagLayout());
        this.add(this._headerPanel, BorderLayout.NORTH);
        this._numHeaderMessages = 0;

        this._labelInputPairs = new LinkedHashMap<String, LabelInputPair>();

        // Main Panel
        this._mainPanel = new JPanel();
        this._mainPanel.setLayout(new GridBagLayout());
        this.add(this._mainPanel, BorderLayout.CENTER);
    }

    public void build()
    {
        List<LabelInputPair> labelInputPairs = new ArrayList<LabelInputPair>
            (this._labelInputPairs.values());

        for (int i = 0; i < labelInputPairs.size(); i++) {
            LabelInputPair labelInputPair = labelInputPairs.get(i);
            this._mainPanel.add(labelInputPair.getLabel(), this._createGridBagConstraints(0, i));
            this._mainPanel.add(labelInputPair.getInput().getJComponent(),
                this._createGridBagConstraints(1, i));
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

    public void setHeaderMessage(String text)
    {
        Label label = new Label("");
        label.setForeground(Color.red);
        label.setText(text);
        label.setVisible(true);

        this._headerPanel.add(label, this._createGridBagConstraints(0, this._numHeaderMessages));
        this._numHeaderMessages++;
        this.pack();
    }

    public void clearHeaderMessages()
    {
        this._headerPanel.removeAll();
        this.pack();
    }

    private GridBagConstraints _createGridBagConstraints(int x, int y)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x; // column
        gridBagConstraints.gridy = y; // row
        gridBagConstraints.anchor = GridBagConstraints.WEST; // align left
        gridBagConstraints.insets = new Insets(1, 2, 2, 2);
        return gridBagConstraints;
     }
}
