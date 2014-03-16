namespace QL_Csharp
{
    partial class StatementControl
    {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.statementPanel = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // statementPanel
            // 
            this.statementPanel.AutoSize = true;
            this.statementPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.statementPanel.Location = new System.Drawing.Point(0, 0);
            this.statementPanel.Name = "statementPanel";
            this.statementPanel.Size = new System.Drawing.Size(57, 13);
            this.statementPanel.TabIndex = 0;
            // 
            // StatementControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.Controls.Add(this.statementPanel);
            this.Name = "StatementControl";
            this.Size = new System.Drawing.Size(57, 13);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel statementPanel;
    }
}
