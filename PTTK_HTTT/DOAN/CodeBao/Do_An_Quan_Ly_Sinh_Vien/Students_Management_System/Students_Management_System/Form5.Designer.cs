namespace Students_Management_System
{
    partial class Form5
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form5));
            System.Windows.Forms.Label maSoLabel;
            System.Windows.Forms.Label hoTenLabel;
            System.Windows.Forms.Label maKhoaLabel;
            this.qL_THONG_TIN_SINH_VIENDataSet = new Students_Management_System.QL_THONG_TIN_SINH_VIENDataSet();
            this.kETQUABindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.kETQUATableAdapter = new Students_Management_System.QL_THONG_TIN_SINH_VIENDataSetTableAdapters.KETQUATableAdapter();
            this.tableAdapterManager = new Students_Management_System.QL_THONG_TIN_SINH_VIENDataSetTableAdapters.TableAdapterManager();
            this.kETQUABindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.kETQUABindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.button1 = new System.Windows.Forms.Button();
            this.sINHVIENBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sINHVIENTableAdapter = new Students_Management_System.QL_THONG_TIN_SINH_VIENDataSetTableAdapters.SINHVIENTableAdapter();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.maSoComboBox = new System.Windows.Forms.ComboBox();
            this.hoTenComboBox = new System.Windows.Forms.ComboBox();
            this.maKhoaTextBox = new System.Windows.Forms.TextBox();
            maSoLabel = new System.Windows.Forms.Label();
            hoTenLabel = new System.Windows.Forms.Label();
            maKhoaLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.qL_THONG_TIN_SINH_VIENDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kETQUABindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kETQUABindingNavigator)).BeginInit();
            this.kETQUABindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.sINHVIENBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // qL_THONG_TIN_SINH_VIENDataSet
            // 
            this.qL_THONG_TIN_SINH_VIENDataSet.DataSetName = "QL_THONG_TIN_SINH_VIENDataSet";
            this.qL_THONG_TIN_SINH_VIENDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // kETQUABindingSource
            // 
            this.kETQUABindingSource.DataMember = "KETQUA";
            this.kETQUABindingSource.DataSource = this.qL_THONG_TIN_SINH_VIENDataSet;
            // 
            // kETQUATableAdapter
            // 
            this.kETQUATableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.KETQUATableAdapter = this.kETQUATableAdapter;
            this.tableAdapterManager.KHOATableAdapter = null;
            this.tableAdapterManager.MONHOCTableAdapter = null;
            this.tableAdapterManager.SINHVIENTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = Students_Management_System.QL_THONG_TIN_SINH_VIENDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // kETQUABindingNavigator
            // 
            this.kETQUABindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.kETQUABindingNavigator.BindingSource = this.kETQUABindingSource;
            this.kETQUABindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.kETQUABindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.kETQUABindingNavigator.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.kETQUABindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.kETQUABindingNavigatorSaveItem});
            this.kETQUABindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.kETQUABindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.kETQUABindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.kETQUABindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.kETQUABindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.kETQUABindingNavigator.Name = "kETQUABindingNavigator";
            this.kETQUABindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.kETQUABindingNavigator.Size = new System.Drawing.Size(612, 27);
            this.kETQUABindingNavigator.TabIndex = 0;
            this.kETQUABindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(45, 24);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 27);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 27);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 27);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 27);
            // 
            // kETQUABindingNavigatorSaveItem
            // 
            this.kETQUABindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.kETQUABindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("kETQUABindingNavigatorSaveItem.Image")));
            this.kETQUABindingNavigatorSaveItem.Name = "kETQUABindingNavigatorSaveItem";
            this.kETQUABindingNavigatorSaveItem.Size = new System.Drawing.Size(29, 24);
            this.kETQUABindingNavigatorSaveItem.Text = "Save Data";
            this.kETQUABindingNavigatorSaveItem.Click += new System.EventHandler(this.kETQUABindingNavigatorSaveItem_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(411, 74);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 40);
            this.button1.TabIndex = 10;
            this.button1.Text = "Xem";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // sINHVIENBindingSource
            // 
            this.sINHVIENBindingSource.DataMember = "SINHVIEN";
            this.sINHVIENBindingSource.DataSource = this.qL_THONG_TIN_SINH_VIENDataSet;
            // 
            // sINHVIENTableAdapter
            // 
            this.sINHVIENTableAdapter.ClearBeforeFill = true;
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(0, 217);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(612, 269);
            this.dataGridView1.TabIndex = 17;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // maSoLabel
            // 
            maSoLabel.AutoSize = true;
            maSoLabel.Location = new System.Drawing.Point(57, 55);
            maSoLabel.Name = "maSoLabel";
            maSoLabel.Size = new System.Drawing.Size(49, 16);
            maSoLabel.TabIndex = 17;
            maSoLabel.Text = "Ma So:";
            // 
            // maSoComboBox
            // 
            this.maSoComboBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "MaSo", true));
            this.maSoComboBox.DataSource = this.sINHVIENBindingSource;
            this.maSoComboBox.DisplayMember = "MaSo";
            this.maSoComboBox.FormattingEnabled = true;
            this.maSoComboBox.Location = new System.Drawing.Point(126, 52);
            this.maSoComboBox.Name = "maSoComboBox";
            this.maSoComboBox.Size = new System.Drawing.Size(121, 24);
            this.maSoComboBox.TabIndex = 18;
            this.maSoComboBox.SelectedIndexChanged += new System.EventHandler(this.maSoComboBox_SelectedIndexChanged);
            // 
            // hoTenLabel
            // 
            hoTenLabel.AutoSize = true;
            hoTenLabel.Location = new System.Drawing.Point(57, 86);
            hoTenLabel.Name = "hoTenLabel";
            hoTenLabel.Size = new System.Drawing.Size(55, 16);
            hoTenLabel.TabIndex = 18;
            hoTenLabel.Text = "Ho Ten:";
            // 
            // hoTenComboBox
            // 
            this.hoTenComboBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "HoTen", true));
            this.hoTenComboBox.DataSource = this.sINHVIENBindingSource;
            this.hoTenComboBox.DisplayMember = "HoTen";
            this.hoTenComboBox.FormattingEnabled = true;
            this.hoTenComboBox.Location = new System.Drawing.Point(126, 82);
            this.hoTenComboBox.Name = "hoTenComboBox";
            this.hoTenComboBox.Size = new System.Drawing.Size(121, 24);
            this.hoTenComboBox.TabIndex = 19;
            // 
            // maKhoaLabel
            // 
            maKhoaLabel.AutoSize = true;
            maKhoaLabel.Location = new System.Drawing.Point(57, 119);
            maKhoaLabel.Name = "maKhoaLabel";
            maKhoaLabel.Size = new System.Drawing.Size(63, 16);
            maKhoaLabel.TabIndex = 19;
            maKhoaLabel.Text = "Ma Khoa:";
            // 
            // maKhoaTextBox
            // 
            this.maKhoaTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "MaKhoa", true));
            this.maKhoaTextBox.Location = new System.Drawing.Point(126, 116);
            this.maKhoaTextBox.Name = "maKhoaTextBox";
            this.maKhoaTextBox.Size = new System.Drawing.Size(100, 22);
            this.maKhoaTextBox.TabIndex = 20;
            // 
            // Form5
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(612, 485);
            this.Controls.Add(maKhoaLabel);
            this.Controls.Add(this.maKhoaTextBox);
            this.Controls.Add(hoTenLabel);
            this.Controls.Add(this.hoTenComboBox);
            this.Controls.Add(maSoLabel);
            this.Controls.Add(this.maSoComboBox);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.kETQUABindingNavigator);
            this.Name = "Form5";
            this.Text = "Xem Điểm";
            this.Load += new System.EventHandler(this.Form5_Load);
            ((System.ComponentModel.ISupportInitialize)(this.qL_THONG_TIN_SINH_VIENDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kETQUABindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kETQUABindingNavigator)).EndInit();
            this.kETQUABindingNavigator.ResumeLayout(false);
            this.kETQUABindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.sINHVIENBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private QL_THONG_TIN_SINH_VIENDataSet qL_THONG_TIN_SINH_VIENDataSet;
        private System.Windows.Forms.BindingSource kETQUABindingSource;
        private QL_THONG_TIN_SINH_VIENDataSetTableAdapters.KETQUATableAdapter kETQUATableAdapter;
        private QL_THONG_TIN_SINH_VIENDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator kETQUABindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton kETQUABindingNavigatorSaveItem;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.BindingSource sINHVIENBindingSource;
        private QL_THONG_TIN_SINH_VIENDataSetTableAdapters.SINHVIENTableAdapter sINHVIENTableAdapter;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.ComboBox maSoComboBox;
        private System.Windows.Forms.ComboBox hoTenComboBox;
        private System.Windows.Forms.TextBox maKhoaTextBox;
    }
}