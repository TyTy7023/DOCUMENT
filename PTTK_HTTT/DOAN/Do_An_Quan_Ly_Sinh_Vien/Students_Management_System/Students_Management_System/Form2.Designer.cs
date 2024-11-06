namespace Students_Management_System
{
    partial class Form2
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form2));
            System.Windows.Forms.Label iDLabel;
            System.Windows.Forms.Label hO_TENLabel;
            System.Windows.Forms.Label gIOI_TINHLabel;
            System.Windows.Forms.Label nGAY_SINHLabel;
            System.Windows.Forms.Label dIA_CHILabel;
            System.Windows.Forms.Label sDTLabel;
            System.Windows.Forms.Label iD_KHOALabel;
            this.qL_HOC_SINHDataSet = new Students_Management_System.QL_HOC_SINHDataSet();
            this.sINHVIENBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sINHVIENTableAdapter = new Students_Management_System.QL_HOC_SINHDataSetTableAdapters.SINHVIENTableAdapter();
            this.tableAdapterManager = new Students_Management_System.QL_HOC_SINHDataSetTableAdapters.TableAdapterManager();
            this.sINHVIENBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.sINHVIENBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.iDTextBox = new System.Windows.Forms.TextBox();
            this.hO_TENTextBox = new System.Windows.Forms.TextBox();
            this.gIOI_TINHCheckBox = new System.Windows.Forms.CheckBox();
            this.nGAY_SINHDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.dIA_CHITextBox = new System.Windows.Forms.TextBox();
            this.sDTTextBox = new System.Windows.Forms.TextBox();
            this.iD_KHOATextBox = new System.Windows.Forms.TextBox();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.iDDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.hOTENDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.gIOITINHDataGridViewCheckBoxColumn = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.nGAYSINHDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dIACHIDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sDTDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.iDKHOADataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            iDLabel = new System.Windows.Forms.Label();
            hO_TENLabel = new System.Windows.Forms.Label();
            gIOI_TINHLabel = new System.Windows.Forms.Label();
            nGAY_SINHLabel = new System.Windows.Forms.Label();
            dIA_CHILabel = new System.Windows.Forms.Label();
            sDTLabel = new System.Windows.Forms.Label();
            iD_KHOALabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.qL_HOC_SINHDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sINHVIENBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sINHVIENBindingNavigator)).BeginInit();
            this.sINHVIENBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // qL_HOC_SINHDataSet
            // 
            this.qL_HOC_SINHDataSet.DataSetName = "QL_HOC_SINHDataSet";
            this.qL_HOC_SINHDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sINHVIENBindingSource
            // 
            this.sINHVIENBindingSource.DataMember = "SINHVIEN";
            this.sINHVIENBindingSource.DataSource = this.qL_HOC_SINHDataSet;
            // 
            // sINHVIENTableAdapter
            // 
            this.sINHVIENTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.KETQUATableAdapter = null;
            this.tableAdapterManager.KHOATableAdapter = null;
            this.tableAdapterManager.MONHOCTableAdapter = null;
            this.tableAdapterManager.SINHVIENTableAdapter = this.sINHVIENTableAdapter;
            this.tableAdapterManager.UpdateOrder = Students_Management_System.QL_HOC_SINHDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // sINHVIENBindingNavigator
            // 
            this.sINHVIENBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.sINHVIENBindingNavigator.BindingSource = this.sINHVIENBindingSource;
            this.sINHVIENBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.sINHVIENBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.sINHVIENBindingNavigator.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.sINHVIENBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.sINHVIENBindingNavigatorSaveItem});
            this.sINHVIENBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.sINHVIENBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.sINHVIENBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.sINHVIENBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.sINHVIENBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.sINHVIENBindingNavigator.Name = "sINHVIENBindingNavigator";
            this.sINHVIENBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.sINHVIENBindingNavigator.Size = new System.Drawing.Size(800, 27);
            this.sINHVIENBindingNavigator.TabIndex = 0;
            this.sINHVIENBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(29, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(29, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 27);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(45, 20);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 6);
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
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 6);
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
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(29, 24);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // sINHVIENBindingNavigatorSaveItem
            // 
            this.sINHVIENBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.sINHVIENBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("sINHVIENBindingNavigatorSaveItem.Image")));
            this.sINHVIENBindingNavigatorSaveItem.Name = "sINHVIENBindingNavigatorSaveItem";
            this.sINHVIENBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 23);
            this.sINHVIENBindingNavigatorSaveItem.Text = "Save Data";
            this.sINHVIENBindingNavigatorSaveItem.Click += new System.EventHandler(this.sINHVIENBindingNavigatorSaveItem_Click);
            // 
            // iDLabel
            // 
            iDLabel.AutoSize = true;
            iDLabel.Location = new System.Drawing.Point(63, 70);
            iDLabel.Name = "iDLabel";
            iDLabel.Size = new System.Drawing.Size(23, 16);
            iDLabel.TabIndex = 1;
            iDLabel.Text = "ID:";
            // 
            // iDTextBox
            // 
            this.iDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "ID", true));
            this.iDTextBox.Location = new System.Drawing.Point(152, 67);
            this.iDTextBox.Name = "iDTextBox";
            this.iDTextBox.Size = new System.Drawing.Size(200, 22);
            this.iDTextBox.TabIndex = 2;
            // 
            // hO_TENLabel
            // 
            hO_TENLabel.AutoSize = true;
            hO_TENLabel.Location = new System.Drawing.Point(63, 98);
            hO_TENLabel.Name = "hO_TENLabel";
            hO_TENLabel.Size = new System.Drawing.Size(61, 16);
            hO_TENLabel.TabIndex = 3;
            hO_TENLabel.Text = "HO TEN:";
            // 
            // hO_TENTextBox
            // 
            this.hO_TENTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "HO_TEN", true));
            this.hO_TENTextBox.Location = new System.Drawing.Point(152, 95);
            this.hO_TENTextBox.Name = "hO_TENTextBox";
            this.hO_TENTextBox.Size = new System.Drawing.Size(200, 22);
            this.hO_TENTextBox.TabIndex = 4;
            // 
            // gIOI_TINHLabel
            // 
            gIOI_TINHLabel.AutoSize = true;
            gIOI_TINHLabel.Location = new System.Drawing.Point(63, 128);
            gIOI_TINHLabel.Name = "gIOI_TINHLabel";
            gIOI_TINHLabel.Size = new System.Drawing.Size(71, 16);
            gIOI_TINHLabel.TabIndex = 5;
            gIOI_TINHLabel.Text = "GIOI TINH:";
            // 
            // gIOI_TINHCheckBox
            // 
            this.gIOI_TINHCheckBox.DataBindings.Add(new System.Windows.Forms.Binding("CheckState", this.sINHVIENBindingSource, "GIOI_TINH", true));
            this.gIOI_TINHCheckBox.Location = new System.Drawing.Point(152, 123);
            this.gIOI_TINHCheckBox.Name = "gIOI_TINHCheckBox";
            this.gIOI_TINHCheckBox.Size = new System.Drawing.Size(200, 24);
            this.gIOI_TINHCheckBox.TabIndex = 6;
            this.gIOI_TINHCheckBox.Text = "checkBox1";
            this.gIOI_TINHCheckBox.UseVisualStyleBackColor = true;
            // 
            // nGAY_SINHLabel
            // 
            nGAY_SINHLabel.AutoSize = true;
            nGAY_SINHLabel.Location = new System.Drawing.Point(63, 157);
            nGAY_SINHLabel.Name = "nGAY_SINHLabel";
            nGAY_SINHLabel.Size = new System.Drawing.Size(83, 16);
            nGAY_SINHLabel.TabIndex = 7;
            nGAY_SINHLabel.Text = "NGAY SINH:";
            // 
            // nGAY_SINHDateTimePicker
            // 
            this.nGAY_SINHDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.sINHVIENBindingSource, "NGAY_SINH", true));
            this.nGAY_SINHDateTimePicker.Location = new System.Drawing.Point(152, 153);
            this.nGAY_SINHDateTimePicker.Name = "nGAY_SINHDateTimePicker";
            this.nGAY_SINHDateTimePicker.Size = new System.Drawing.Size(200, 22);
            this.nGAY_SINHDateTimePicker.TabIndex = 8;
            // 
            // dIA_CHILabel
            // 
            dIA_CHILabel.AutoSize = true;
            dIA_CHILabel.Location = new System.Drawing.Point(423, 73);
            dIA_CHILabel.Name = "dIA_CHILabel";
            dIA_CHILabel.Size = new System.Drawing.Size(57, 16);
            dIA_CHILabel.TabIndex = 9;
            dIA_CHILabel.Text = "DIA CHI:";
            // 
            // dIA_CHITextBox
            // 
            this.dIA_CHITextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "DIA_CHI", true));
            this.dIA_CHITextBox.Location = new System.Drawing.Point(512, 70);
            this.dIA_CHITextBox.Name = "dIA_CHITextBox";
            this.dIA_CHITextBox.Size = new System.Drawing.Size(200, 22);
            this.dIA_CHITextBox.TabIndex = 10;
            // 
            // sDTLabel
            // 
            sDTLabel.AutoSize = true;
            sDTLabel.Location = new System.Drawing.Point(423, 101);
            sDTLabel.Name = "sDTLabel";
            sDTLabel.Size = new System.Drawing.Size(38, 16);
            sDTLabel.TabIndex = 11;
            sDTLabel.Text = "SDT:";
            // 
            // sDTTextBox
            // 
            this.sDTTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "SDT", true));
            this.sDTTextBox.Location = new System.Drawing.Point(512, 98);
            this.sDTTextBox.Name = "sDTTextBox";
            this.sDTTextBox.Size = new System.Drawing.Size(200, 22);
            this.sDTTextBox.TabIndex = 12;
            // 
            // iD_KHOALabel
            // 
            iD_KHOALabel.AutoSize = true;
            iD_KHOALabel.Location = new System.Drawing.Point(423, 129);
            iD_KHOALabel.Name = "iD_KHOALabel";
            iD_KHOALabel.Size = new System.Drawing.Size(63, 16);
            iD_KHOALabel.TabIndex = 13;
            iD_KHOALabel.Text = "ID KHOA:";
            // 
            // iD_KHOATextBox
            // 
            this.iD_KHOATextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sINHVIENBindingSource, "ID_KHOA", true));
            this.iD_KHOATextBox.Location = new System.Drawing.Point(512, 126);
            this.iD_KHOATextBox.Name = "iD_KHOATextBox";
            this.iD_KHOATextBox.Size = new System.Drawing.Size(200, 22);
            this.iD_KHOATextBox.TabIndex = 14;
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.iDDataGridViewTextBoxColumn,
            this.hOTENDataGridViewTextBoxColumn,
            this.gIOITINHDataGridViewCheckBoxColumn,
            this.nGAYSINHDataGridViewTextBoxColumn,
            this.dIACHIDataGridViewTextBoxColumn,
            this.sDTDataGridViewTextBoxColumn,
            this.iDKHOADataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.sINHVIENBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(0, 209);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(800, 245);
            this.dataGridView1.TabIndex = 15;
            // 
            // iDDataGridViewTextBoxColumn
            // 
            this.iDDataGridViewTextBoxColumn.DataPropertyName = "ID";
            this.iDDataGridViewTextBoxColumn.HeaderText = "ID";
            this.iDDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.iDDataGridViewTextBoxColumn.Name = "iDDataGridViewTextBoxColumn";
            this.iDDataGridViewTextBoxColumn.Width = 125;
            // 
            // hOTENDataGridViewTextBoxColumn
            // 
            this.hOTENDataGridViewTextBoxColumn.DataPropertyName = "HO_TEN";
            this.hOTENDataGridViewTextBoxColumn.HeaderText = "HO_TEN";
            this.hOTENDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.hOTENDataGridViewTextBoxColumn.Name = "hOTENDataGridViewTextBoxColumn";
            this.hOTENDataGridViewTextBoxColumn.Width = 125;
            // 
            // gIOITINHDataGridViewCheckBoxColumn
            // 
            this.gIOITINHDataGridViewCheckBoxColumn.DataPropertyName = "GIOI_TINH";
            this.gIOITINHDataGridViewCheckBoxColumn.HeaderText = "GIOI_TINH";
            this.gIOITINHDataGridViewCheckBoxColumn.MinimumWidth = 6;
            this.gIOITINHDataGridViewCheckBoxColumn.Name = "gIOITINHDataGridViewCheckBoxColumn";
            this.gIOITINHDataGridViewCheckBoxColumn.Width = 125;
            // 
            // nGAYSINHDataGridViewTextBoxColumn
            // 
            this.nGAYSINHDataGridViewTextBoxColumn.DataPropertyName = "NGAY_SINH";
            this.nGAYSINHDataGridViewTextBoxColumn.HeaderText = "NGAY_SINH";
            this.nGAYSINHDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.nGAYSINHDataGridViewTextBoxColumn.Name = "nGAYSINHDataGridViewTextBoxColumn";
            this.nGAYSINHDataGridViewTextBoxColumn.Width = 125;
            // 
            // dIACHIDataGridViewTextBoxColumn
            // 
            this.dIACHIDataGridViewTextBoxColumn.DataPropertyName = "DIA_CHI";
            this.dIACHIDataGridViewTextBoxColumn.HeaderText = "DIA_CHI";
            this.dIACHIDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.dIACHIDataGridViewTextBoxColumn.Name = "dIACHIDataGridViewTextBoxColumn";
            this.dIACHIDataGridViewTextBoxColumn.Width = 125;
            // 
            // sDTDataGridViewTextBoxColumn
            // 
            this.sDTDataGridViewTextBoxColumn.DataPropertyName = "SDT";
            this.sDTDataGridViewTextBoxColumn.HeaderText = "SDT";
            this.sDTDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.sDTDataGridViewTextBoxColumn.Name = "sDTDataGridViewTextBoxColumn";
            this.sDTDataGridViewTextBoxColumn.Width = 125;
            // 
            // iDKHOADataGridViewTextBoxColumn
            // 
            this.iDKHOADataGridViewTextBoxColumn.DataPropertyName = "ID_KHOA";
            this.iDKHOADataGridViewTextBoxColumn.HeaderText = "ID_KHOA";
            this.iDKHOADataGridViewTextBoxColumn.MinimumWidth = 6;
            this.iDKHOADataGridViewTextBoxColumn.Name = "iDKHOADataGridViewTextBoxColumn";
            this.iDKHOADataGridViewTextBoxColumn.Width = 125;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(iDLabel);
            this.Controls.Add(this.iDTextBox);
            this.Controls.Add(hO_TENLabel);
            this.Controls.Add(this.hO_TENTextBox);
            this.Controls.Add(gIOI_TINHLabel);
            this.Controls.Add(this.gIOI_TINHCheckBox);
            this.Controls.Add(nGAY_SINHLabel);
            this.Controls.Add(this.nGAY_SINHDateTimePicker);
            this.Controls.Add(dIA_CHILabel);
            this.Controls.Add(this.dIA_CHITextBox);
            this.Controls.Add(sDTLabel);
            this.Controls.Add(this.sDTTextBox);
            this.Controls.Add(iD_KHOALabel);
            this.Controls.Add(this.iD_KHOATextBox);
            this.Controls.Add(this.sINHVIENBindingNavigator);
            this.Name = "Form2";
            this.Text = "Nhập Thông Tin Sinh Viên";
            this.Load += new System.EventHandler(this.Form2_Load);
            ((System.ComponentModel.ISupportInitialize)(this.qL_HOC_SINHDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sINHVIENBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sINHVIENBindingNavigator)).EndInit();
            this.sINHVIENBindingNavigator.ResumeLayout(false);
            this.sINHVIENBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private QL_HOC_SINHDataSet qL_HOC_SINHDataSet;
        private System.Windows.Forms.BindingSource sINHVIENBindingSource;
        private QL_HOC_SINHDataSetTableAdapters.SINHVIENTableAdapter sINHVIENTableAdapter;
        private QL_HOC_SINHDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator sINHVIENBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton sINHVIENBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox iDTextBox;
        private System.Windows.Forms.TextBox hO_TENTextBox;
        private System.Windows.Forms.CheckBox gIOI_TINHCheckBox;
        private System.Windows.Forms.DateTimePicker nGAY_SINHDateTimePicker;
        private System.Windows.Forms.TextBox dIA_CHITextBox;
        private System.Windows.Forms.TextBox sDTTextBox;
        private System.Windows.Forms.TextBox iD_KHOATextBox;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn iDDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn hOTENDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewCheckBoxColumn gIOITINHDataGridViewCheckBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nGAYSINHDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dIACHIDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn sDTDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn iDKHOADataGridViewTextBoxColumn;
    }
}