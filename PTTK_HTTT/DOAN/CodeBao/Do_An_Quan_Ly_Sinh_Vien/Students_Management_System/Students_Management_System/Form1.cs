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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Form2 fSinhVien = new Form2();
            fSinhVien.Show();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            Form3 fKhoa = new Form3();
            fKhoa.Show();
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            Form4 fMonHoc = new Form4();
            fMonHoc.Show();
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            Form6 fNhapDiem = new Form6();
            fNhapDiem.Show();
        }

        private void toolStripButton5_Click(object sender, EventArgs e)
        {
            Form5 fDiemSinhVien = new Form5();
            fDiemSinhVien.Show();
        }
    }
}
