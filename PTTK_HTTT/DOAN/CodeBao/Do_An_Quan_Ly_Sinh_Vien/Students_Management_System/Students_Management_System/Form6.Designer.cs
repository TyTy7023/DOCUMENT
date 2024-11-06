namespace Students_Management_System
{
    partial class Form6
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
            System.Windows.Forms.Label maMHLabel;
            System.Windows.Forms.Label tenMHLabel;
            System.Windows.Forms.Label maSoLabel;
            System.Windows.Forms.Label hoTenLabel;
            this.maMHTextBox = new System.Windows.Forms.TextBox();
            this.tenMHTextBox = new System.Windows.Forms.TextBox();
            this.maSoTextBox = new System.Windows.Forms.TextBox();
            this.hoTenTextBox = new System.Windows.Forms.TextBox();
            maMHLabel = new System.Windows.Forms.Label();
            tenMHLabel = new System.Windows.Forms.Label();
            maSoLabel = new System.Windows.Forms.Label();
            hoTenLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // maMHLabel
            // 
            maMHLabel.AutoSize = true;
            maMHLabel.Location = new System.Drawing.Point(227, 78);
            maMHLabel.Name = "maMHLabel";
            maMHLabel.Size = new System.Drawing.Size(53, 16);
            maMHLabel.TabIndex = 5;
            maMHLabel.Text = "Ma MH:";
            // 
            // maMHTextBox
            // 
            this.maMHTextBox.Location = new System.Drawing.Point(291, 75);
            this.maMHTextBox.Name = "maMHTextBox";
            this.maMHTextBox.Size = new System.Drawing.Size(100, 22);
            this.maMHTextBox.TabIndex = 6;
            // 
            // tenMHLabel
            // 
            tenMHLabel.AutoSize = true;
            tenMHLabel.Location = new System.Drawing.Point(227, 106);
            tenMHLabel.Name = "tenMHLabel";
            tenMHLabel.Size = new System.Drawing.Size(58, 16);
            tenMHLabel.TabIndex = 7;
            tenMHLabel.Text = "Ten MH:";
            // 
            // tenMHTextBox
            // 
            this.tenMHTextBox.Location = new System.Drawing.Point(291, 103);
            this.tenMHTextBox.Name = "tenMHTextBox";
            this.tenMHTextBox.Size = new System.Drawing.Size(100, 22);
            this.tenMHTextBox.TabIndex = 8;
            // 
            // maSoLabel
            // 
            maSoLabel.AutoSize = true;
            maSoLabel.Location = new System.Drawing.Point(230, 134);
            maSoLabel.Name = "maSoLabel";
            maSoLabel.Size = new System.Drawing.Size(49, 16);
            maSoLabel.TabIndex = 9;
            maSoLabel.Text = "Ma So:";
            // 
            // maSoTextBox
            // 
            this.maSoTextBox.Location = new System.Drawing.Point(312, 131);
            this.maSoTextBox.Name = "maSoTextBox";
            this.maSoTextBox.Size = new System.Drawing.Size(200, 22);
            this.maSoTextBox.TabIndex = 10;
            // 
            // hoTenLabel
            // 
            hoTenLabel.AutoSize = true;
            hoTenLabel.Location = new System.Drawing.Point(230, 162);
            hoTenLabel.Name = "hoTenLabel";
            hoTenLabel.Size = new System.Drawing.Size(55, 16);
            hoTenLabel.TabIndex = 11;
            hoTenLabel.Text = "Ho Ten:";
            // 
            // hoTenTextBox
            // 
            this.hoTenTextBox.Location = new System.Drawing.Point(312, 159);
            this.hoTenTextBox.Name = "hoTenTextBox";
            this.hoTenTextBox.Size = new System.Drawing.Size(200, 22);
            this.hoTenTextBox.TabIndex = 12;
            // 
            // Form6
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(maSoLabel);
            this.Controls.Add(this.maSoTextBox);
            this.Controls.Add(hoTenLabel);
            this.Controls.Add(this.hoTenTextBox);
            this.Controls.Add(maMHLabel);
            this.Controls.Add(this.maMHTextBox);
            this.Controls.Add(tenMHLabel);
            this.Controls.Add(this.tenMHTextBox);
            this.Name = "Form6";
            this.Text = "Nhập Điểm";
            this.Load += new System.EventHandler(this.Form6_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox maMHTextBox;
        private System.Windows.Forms.TextBox tenMHTextBox;
        private System.Windows.Forms.TextBox maSoTextBox;
        private System.Windows.Forms.TextBox hoTenTextBox;
    }
}