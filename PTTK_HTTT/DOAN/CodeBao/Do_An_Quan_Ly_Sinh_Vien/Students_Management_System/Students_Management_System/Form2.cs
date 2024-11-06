using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Students_Management_System
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void sINHVIENBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.sINHVIENBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.qL_THONG_TIN_SINH_VIENDataSet);

        }

        private void Form2_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'qL_THONG_TIN_SINH_VIENDataSet.SINHVIEN' table. You can move, or remove it, as needed.
            this.sINHVIENTableAdapter.Fill(this.qL_THONG_TIN_SINH_VIENDataSet.SINHVIEN);

        }

        private void sINHVIENDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void maSoLabel_Click(object sender, EventArgs e)
        {

        }

        private void maSoTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void hoTenLabel_Click(object sender, EventArgs e)
        {

        }

        private void hoTenTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void ngaySinhLabel_Click(object sender, EventArgs e)
        {

        }

        private void ngaySinhDateTimePicker_ValueChanged(object sender, EventArgs e)
        {

        }

        private void gioiTinhLabel_Click(object sender, EventArgs e)
        {

        }

        private void gioiTinhCheckBox_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void diaChiLabel_Click(object sender, EventArgs e)
        {

        }

        private void diaChiTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void dienThoaiLabel_Click(object sender, EventArgs e)
        {

        }

        private void dienThoaiTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void maKhoaLabel_Click(object sender, EventArgs e)
        {

        }

        private void maKhoaTextBox_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
