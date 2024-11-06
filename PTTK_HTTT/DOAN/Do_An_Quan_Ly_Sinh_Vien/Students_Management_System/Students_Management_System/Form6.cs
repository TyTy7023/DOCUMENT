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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void sINHVIENBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.sINHVIENBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.qL_HOC_SINHDataSet);

        }

        private void Form6_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'qL_HOC_SINHDataSet.SINHVIEN' table. You can move, or remove it, as needed.
            this.sINHVIENTableAdapter.Fill(this.qL_HOC_SINHDataSet.SINHVIEN);

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string conn = global::Students_Management_System.Properties.Settings.Default.QL_HOC_SINHConnectionString;
            string str;

            // Truy vấn lấy điểm các môn học của SV có mã số được chọn
            str = string.Format("Select TEN_MH, DIEM From KETQUA,MONHOC where [KETQUA].ID_MH = [MONHOC].ID AND ID_SV = {0}", comboBox1.Text);

            SqlDataAdapter da = new SqlDataAdapter(str, conn);
            DataSet ds = new DataSet();

            // Đổ vào dataset
            da.Fill(ds);

            // Hiển thị ra DataGridView
            dataGridView1.DataSource = ds.Tables[0];
            //comboBox1.ValueMember = null;
        }

        private void iDComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void hO_TENComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
