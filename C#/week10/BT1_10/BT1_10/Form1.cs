using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace BT1_10
{
    public partial class Form1 : Form
    {
        double result = 0;
        public Form1()
        {
            InitializeComponent();
        }
        private void num1_Click(object sender, EventArgs e)
        {
            textBox1.Text += "1";

        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void negative_Click(object sender, EventArgs e)
        {

            textBox1.Text = $"negative({textBox1.Text})";
        }

        private void num0_Click(object sender, EventArgs e)
        {
            textBox1.Text += "0";
        }

        private void buttonDot_Click(object sender, EventArgs e)
        {

        }

        private void buttonResult_Click(object sender, EventArgs e)
        {

        }

        private void num2_Click(object sender, EventArgs e)
        {
            textBox1.Text += "2";
        }

        private void num3_Click(object sender, EventArgs e)
        {
            textBox1.Text += "3";
        }

        private void num4_Click(object sender, EventArgs e)
        {
            textBox1.Text += "4";
        }

        private void num5_Click(object sender, EventArgs e)
        {
            textBox1.Text += "5";
        }

        private void num6_Click(object sender, EventArgs e)
        {
            textBox1.Text += "6";
        }

        private void num7_Click(object sender, EventArgs e)
        {
            textBox1.Text += "7";
        }

        private void num8_Click(object sender, EventArgs e)
        {
            textBox1.Text += "8";
        }

        private void num9_Click(object sender, EventArgs e)
        {
            textBox1.Text += "9";
        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            textBox1.Text += " + ";
        }

        private void buttonSub_Click(object sender, EventArgs e)
        {
            textBox1.Text += " - ";
        }

        private void buttonMul_Click(object sender, EventArgs e)
        {
            textBox1.Text += " x ";
        }

        private void buttonDiv_Click(object sender, EventArgs e)
        {
            textBox1.Text += " / ";
        }

        private void buttonDel_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            result = 0;
        }

        private void buttonSqrt_Click(object sender, EventArgs e)
        {
            textBox1.Text = $"sqrt({textBox1.Text})";
        }

        private void buttonPow_Click(object sender, EventArgs e)
        {
            textBox1.Text = $"({textBox1.Text})^2";
        }

        private void button1Div_Click(object sender, EventArgs e)
        {
            textBox1.Text = $"1 / ({textBox1.Text})";
        }
    }
}
