namespace QL_Csharp
{
    partial class StatementList
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
            this.statementListPanel = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // statementListPanel
            // 
            this.statementListPanel.AutoScroll = true;
            this.statementListPanel.AutoSize = true;
            this.statementListPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.statementListPanel.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.statementListPanel.Location = new System.Drawing.Point(0, 0);
            this.statementListPanel.Name = "statementListPanel";
            this.statementListPanel.Size = new System.Drawing.Size(57, 16);
            this.statementListPanel.TabIndex = 0;
            this.statementListPanel.WrapContents = false;
            // 
            // StatementList
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.Controls.Add(this.statementListPanel);
            this.Name = "StatementList";
            this.Size = new System.Drawing.Size(57, 16);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel statementListPanel;
    }
}
