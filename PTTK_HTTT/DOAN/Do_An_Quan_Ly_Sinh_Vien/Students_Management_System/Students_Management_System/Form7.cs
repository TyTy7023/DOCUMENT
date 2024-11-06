using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Students_Management_System
{
    public partial class Form7 : Form
    {
        public Form7()
        {
            InitializeComponent();
        }

        private void kHOABindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.kHOABindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.qL_HOC_SINHDataSet);

        }

        private void Form7_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'qL_HOC_SINHDataSet.KHOA' table. You can move, or remove it, as needed.
            this.kHOATableAdapter.Fill(this.qL_HOC_SINHDataSet.KHOA);

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string conn = global::Students_Management_System.Properties.Settings.Default.QL_HOC_SINHConnectionString;
            string str;

            // Assuming comboBox1 contains a valid integer representing MaKhoa
            string selectedMaKhoa = iDComboBox.Text;

            // Corrected query: Use parameter for MaKhoa and enclose in square brackets
            str = string.Format("SELECT * FROM SINHVIEN WHERE [SINHVIEN].ID_KHOA = @MaKhoa", selectedMaKhoa);

            SqlDataAdapter da = new SqlDataAdapter(str, conn);
            da.SelectCommand.Parameters.AddWithValue("@MaKhoa", selectedMaKhoa); // Add parameter

            DataSet ds = new DataSet();
            da.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];
        }
    }
}
