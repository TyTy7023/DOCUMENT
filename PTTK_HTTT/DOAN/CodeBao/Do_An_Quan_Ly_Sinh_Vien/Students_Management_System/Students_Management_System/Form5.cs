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
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        private void kETQUABindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.kETQUABindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.qL_THONG_TIN_SINH_VIENDataSet);

        }

        private void Form5_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'qL_THONG_TIN_SINH_VIENDataSet.SINHVIEN' table. You can move, or remove it, as needed.
            this.sINHVIENTableAdapter.Fill(this.qL_THONG_TIN_SINH_VIENDataSet.SINHVIEN);
            // TODO: This line of code loads data into the 'qL_THONG_TIN_SINH_VIENDataSet.KETQUA' table. You can move, or remove it, as needed.
            this.kETQUATableAdapter.Fill(this.qL_THONG_TIN_SINH_VIENDataSet.KETQUA);

        }

        private void kETQUADataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void maSoComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            string conn = global::Students_Management_System.Properties.Settings.Default.Data Source = LAPTOP - 8LBJ31SJ\SQLEXPRESS; Initial Catalog = QL_THONG_TIN_SINH_VIEN; Integrated Security = True; Trust Server Certificate = True;
        }
    }
}
