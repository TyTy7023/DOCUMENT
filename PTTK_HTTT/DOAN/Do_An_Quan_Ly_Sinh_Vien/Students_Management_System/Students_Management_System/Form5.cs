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

namespace Students_Management_System
{
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        string chuoiketnoi = @"Data Source=-PC\TYTY;Initial Catalog=QL_HOC_SINH;Integrated Security=True; Integrated Security=SSPI;";
        string sql;
        SqlConnection ketnoi;
        SqlCommand thuchien;
        SqlDataReader docdulieu;
        int i = 0;


        private void Form5_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'qL_HOC_SINHDataSet.KETQUA' table. You can move, or remove it, as needed.
            this.kETQUATableAdapter.Fill(this.qL_HOC_SINHDataSet.KETQUA);
            // TODO: This line of code loads data into the 'qL_HOC_SINHDataSet.MONHOC' table. You can move, or remove it, as needed.
            this.mONHOCTableAdapter.Fill(this.qL_HOC_SINHDataSet.MONHOC);
            // TODO: This line of code loads data into the 'qL_HOC_SINHDataSet.SINHVIEN' table. You can move, or remove it, as needed.
            this.sINHVIENTableAdapter.Fill(this.qL_HOC_SINHDataSet.SINHVIEN);
            ketnoi = new SqlConnection(chuoiketnoi);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ketnoi.Open();
            sql = @"INSERT INTO KETQUA(ID_SV, ID_MH, DIEM) VALUES (N'" + comboBox1.Text + @"', N'" + comboBox3.Text + @"', N'" + textBox1.Text + @"')";

            thuchien = new SqlCommand(sql, ketnoi);
            thuchien.ExecuteNonQuery();
            ketnoi.Close();

        }
    }
}
