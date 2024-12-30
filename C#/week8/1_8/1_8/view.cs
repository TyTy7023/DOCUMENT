using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _1_8
{
    internal class view : Form
    {
        public TextBox NumberInput1 = new TextBox();
        public TextBox NumberInput2 = new TextBox();
        public Button addButton = new Button();
        public Button subButton = new Button();
        public Button mulButton = new Button();
        public Button divButton = new Button();
        public Button clearButton = new Button();
        public Label result = new Label();

        public view()
        {
            this.Text = "Caculator";
            this.Size = new System.Drawing.Size(600, 250);

            Label input_1 = new Label
            {
                Text = "Number 1: ",
                Location = new System.Drawing.Point(80, 35),
                AutoSize = true
            };
            Label input_2 = new Label
            {
                Text = "Number 2: ",
                Location = new System.Drawing.Point(80, 65),
                AutoSize = true
            };

            Label caculator = new Label
            {
                Text = "Result : ",
                Location = new System.Drawing.Point(80, 110),
                AutoSize = true
            };

            NumberInput1.Location = new System.Drawing.Point(180,30);
            NumberInput1.Width = 300;
            NumberInput2.Location = new System.Drawing.Point(180, 60);
            NumberInput2.Width = 300;

            addButton.Text = "add";
            addButton.Location = new System.Drawing.Point(150, 150);
            subButton.Text = "sub";
            subButton.Location = new System.Drawing.Point(250, 150);
            mulButton.Text = "mul";
            mulButton.Location = new System.Drawing.Point(350, 150);
            divButton.Text = "div";
            divButton.Location = new System.Drawing.Point(450, 150);
            clearButton.Text = "clear";
            clearButton.Location = new System.Drawing.Point(50, 150);

            result.Location = new System.Drawing.Point(150, 110);
            result.AutoSize = true;

            Controls.Add(result);
            Controls.Add(input_1);
            Controls.Add(input_2);
            Controls.Add(caculator);
            Controls.Add(NumberInput1);
            Controls.Add(NumberInput2);
            Controls.Add(addButton);
            Controls.Add(divButton);
            Controls.Add(subButton);
            Controls.Add(mulButton);
            Controls.Add(clearButton);
        }

        public double GetNumberInput1()
        {
            if (double.TryParse(NumberInput1.Text, out double number))
            { return number; }
            else
            { throw new FormatException("Invalid input"); }
        }
        public double GetNumberInput2()
        {
            if (double.TryParse(NumberInput2.Text, out double number))
            { return number; }
            else
            { throw new FormatException("Invalid input"); }
        }

        public void DisplayCaculator(double Result)
        {
            result.Text = $"Result: {Result:F2}";
        }

        public void showErroMessage(string message)
        {
            MessageBox.Show(message, "Erroe", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
    }
}
