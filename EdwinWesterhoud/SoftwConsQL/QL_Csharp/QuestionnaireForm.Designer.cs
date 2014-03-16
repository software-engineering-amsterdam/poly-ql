namespace QL_Csharp
{
    partial class QuestionnaireForm
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

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.statementList1 = new QL_Csharp.StatementList();
            this.SuspendLayout();
            // 
            // statementList1
            // 
            this.statementList1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.statementList1.Location = new System.Drawing.Point(12, 12);
            this.statementList1.Name = "statementList1";
            this.statementList1.Size = new System.Drawing.Size(713, 444);
            this.statementList1.TabIndex = 0;
            // 
            // QuestionnaireForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(737, 468);
            this.Controls.Add(this.statementList1);
            this.Name = "QuestionnaireForm";
            this.Text = "QuestionnaireForm";
            this.ResumeLayout(false);

        }

        #endregion

        private StatementList statementList1;

    }
}