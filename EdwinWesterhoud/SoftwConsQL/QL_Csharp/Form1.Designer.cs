namespace QL_Csharp
{
    partial class Form1
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
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.checkBoxRealTime = new System.Windows.Forms.CheckBox();
            this.labelDemo = new System.Windows.Forms.Label();
            this.comboBoxDemos = new System.Windows.Forms.ComboBox();
            this.checkBoxTypeCheck = new System.Windows.Forms.CheckBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.textBoxSource = new System.Windows.Forms.RichTextBox();
            this.buttonGenerate = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.textBoxOutput = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            this.splitContainer1.Name = "splitContainer1";
            this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.checkBoxRealTime);
            this.splitContainer1.Panel1.Controls.Add(this.labelDemo);
            this.splitContainer1.Panel1.Controls.Add(this.comboBoxDemos);
            this.splitContainer1.Panel1.Controls.Add(this.checkBoxTypeCheck);
            this.splitContainer1.Panel1.Controls.Add(this.groupBox1);
            this.splitContainer1.Panel1.Controls.Add(this.buttonGenerate);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.groupBox2);
            this.splitContainer1.Size = new System.Drawing.Size(800, 627);
            this.splitContainer1.SplitterDistance = 362;
            this.splitContainer1.TabIndex = 1;
            // 
            // checkBoxRealTime
            // 
            this.checkBoxRealTime.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.checkBoxRealTime.AutoSize = true;
            this.checkBoxRealTime.Location = new System.Drawing.Point(109, 340);
            this.checkBoxRealTime.Name = "checkBoxRealTime";
            this.checkBoxRealTime.Size = new System.Drawing.Size(67, 17);
            this.checkBoxRealTime.TabIndex = 5;
            this.checkBoxRealTime.Text = "Realtime";
            this.checkBoxRealTime.UseVisualStyleBackColor = true;
            // 
            // labelDemo
            // 
            this.labelDemo.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.labelDemo.AutoSize = true;
            this.labelDemo.Location = new System.Drawing.Point(594, 341);
            this.labelDemo.Name = "labelDemo";
            this.labelDemo.Size = new System.Drawing.Size(40, 13);
            this.labelDemo.TabIndex = 4;
            this.labelDemo.Text = "Preset:";
            // 
            // comboBoxDemos
            // 
            this.comboBoxDemos.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.comboBoxDemos.FormattingEnabled = true;
            this.comboBoxDemos.Location = new System.Drawing.Point(640, 336);
            this.comboBoxDemos.Name = "comboBoxDemos";
            this.comboBoxDemos.Size = new System.Drawing.Size(144, 21);
            this.comboBoxDemos.TabIndex = 3;
            this.comboBoxDemos.SelectedValueChanged += new System.EventHandler(this.comboBoxDemos_SelectedValueChanged);
            // 
            // checkBoxTypeCheck
            // 
            this.checkBoxTypeCheck.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkBoxTypeCheck.AutoSize = true;
            this.checkBoxTypeCheck.Checked = true;
            this.checkBoxTypeCheck.CheckState = System.Windows.Forms.CheckState.Checked;
            this.checkBoxTypeCheck.Location = new System.Drawing.Point(182, 340);
            this.checkBoxTypeCheck.Name = "checkBoxTypeCheck";
            this.checkBoxTypeCheck.Size = new System.Drawing.Size(129, 17);
            this.checkBoxTypeCheck.TabIndex = 2;
            this.checkBoxTypeCheck.Text = "Enable Type Checker";
            this.checkBoxTypeCheck.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox1.Controls.Add(this.textBoxSource);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(776, 318);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Source Code";
            // 
            // textBoxSource
            // 
            this.textBoxSource.AcceptsTab = true;
            this.textBoxSource.DetectUrls = false;
            this.textBoxSource.Dock = System.Windows.Forms.DockStyle.Fill;
            this.textBoxSource.Font = new System.Drawing.Font("Lucida Console", 9.75F);
            this.textBoxSource.Location = new System.Drawing.Point(3, 16);
            this.textBoxSource.Name = "textBoxSource";
            this.textBoxSource.Size = new System.Drawing.Size(770, 299);
            this.textBoxSource.TabIndex = 1;
            this.textBoxSource.Text = "";
            this.textBoxSource.TextChanged += new System.EventHandler(this.textBoxSource_TextChanged);
            // 
            // buttonGenerate
            // 
            this.buttonGenerate.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.buttonGenerate.Location = new System.Drawing.Point(12, 336);
            this.buttonGenerate.Name = "buttonGenerate";
            this.buttonGenerate.Size = new System.Drawing.Size(88, 23);
            this.buttonGenerate.TabIndex = 1;
            this.buttonGenerate.Text = "Generate (F5)";
            this.buttonGenerate.UseVisualStyleBackColor = true;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.textBoxOutput);
            this.groupBox2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupBox2.Location = new System.Drawing.Point(0, 0);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(800, 261);
            this.groupBox2.TabIndex = 2;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Output";
            // 
            // textBoxOutput
            // 
            this.textBoxOutput.Dock = System.Windows.Forms.DockStyle.Fill;
            this.textBoxOutput.Font = new System.Drawing.Font("Lucida Console", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBoxOutput.Location = new System.Drawing.Point(3, 16);
            this.textBoxOutput.Multiline = true;
            this.textBoxOutput.Name = "textBoxOutput";
            this.textBoxOutput.ReadOnly = true;
            this.textBoxOutput.Size = new System.Drawing.Size(794, 242);
            this.textBoxOutput.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 627);
            this.Controls.Add(this.splitContainer1);
            this.Name = "Form1";
            this.Text = "QL Form";
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.TextBox textBoxOutput;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button buttonGenerate;
        private System.Windows.Forms.CheckBox checkBoxTypeCheck;
        private System.Windows.Forms.ComboBox comboBoxDemos;
        private System.Windows.Forms.Label labelDemo;
        private System.Windows.Forms.RichTextBox textBoxSource;
        private System.Windows.Forms.CheckBox checkBoxRealTime;
    }
}

