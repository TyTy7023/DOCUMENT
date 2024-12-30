using System;
using System.Windows.Forms;

namespace BTVN
{
    public partial class BookForm : Form
    {
        private BookController controller;

        public BookForm(BookController controller)
        {
            this.controller = controller;
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            this.listBoxBooks = new System.Windows.Forms.ListBox();
            this.buttonAddBook = new System.Windows.Forms.Button();
            this.buttonDeleteBook = new System.Windows.Forms.Button();
            this.buttonUpdateBook = new System.Windows.Forms.Button();
            this.buttonViewDetails = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // listBoxBooks
            // 
            this.listBoxBooks.FormattingEnabled = true;
            this.listBoxBooks.ItemHeight = 16;
            this.listBoxBooks.Location = new System.Drawing.Point(12, 12);
            this.listBoxBooks.Name = "listBoxBooks";
            this.listBoxBooks.Size = new System.Drawing.Size(400, 196);
            this.listBoxBooks.TabIndex = 0;
            this.listBoxBooks.SelectedIndexChanged += new System.EventHandler(this.listBoxBooks_SelectedIndexChanged);
            // 
            // buttonAddBook
            // 
            this.buttonAddBook.Location = new System.Drawing.Point(12, 230);
            this.buttonAddBook.Name = "buttonAddBook";
            this.buttonAddBook.Size = new System.Drawing.Size(75, 23);
            this.buttonAddBook.TabIndex = 1;
            this.buttonAddBook.Text = "Add";
            this.buttonAddBook.UseVisualStyleBackColor = true;
            this.buttonAddBook.Click += new System.EventHandler(this.ButtonAddBook_Click);
            // 
            // buttonDeleteBook
            // 
            this.buttonDeleteBook.Location = new System.Drawing.Point(93, 230);
            this.buttonDeleteBook.Name = "buttonDeleteBook";
            this.buttonDeleteBook.Size = new System.Drawing.Size(75, 23);
            this.buttonDeleteBook.TabIndex = 2;
            this.buttonDeleteBook.Text = "Delete";
            this.buttonDeleteBook.UseVisualStyleBackColor = true;
            this.buttonDeleteBook.Click += new System.EventHandler(this.ButtonDeleteBook_Click);
            // 
            // buttonUpdateBook
            // 
            this.buttonUpdateBook.Location = new System.Drawing.Point(174, 230);
            this.buttonUpdateBook.Name = "buttonUpdateBook";
            this.buttonUpdateBook.Size = new System.Drawing.Size(75, 23);
            this.buttonUpdateBook.TabIndex = 3;
            this.buttonUpdateBook.Text = "Update";
            this.buttonUpdateBook.UseVisualStyleBackColor = true;
            this.buttonUpdateBook.Click += new System.EventHandler(this.ButtonUpdateBook_Click);
            // 
            // buttonViewDetails
            // 
            this.buttonViewDetails.Location = new System.Drawing.Point(255, 230);
            this.buttonViewDetails.Name = "buttonViewDetails";
            this.buttonViewDetails.Size = new System.Drawing.Size(75, 23);
            this.buttonViewDetails.TabIndex = 4;
            this.buttonViewDetails.Text = "Details";
            this.buttonViewDetails.UseVisualStyleBackColor = true;
            this.buttonViewDetails.Click += new System.EventHandler(this.ButtonViewDetails_Click);
            // 
            // BookForm
            // 
            this.ClientSize = new System.Drawing.Size(424, 261);
            this.Controls.Add(this.buttonViewDetails);
            this.Controls.Add(this.buttonUpdateBook);
            this.Controls.Add(this.buttonDeleteBook);
            this.Controls.Add(this.buttonAddBook);
            this.Controls.Add(this.listBoxBooks);
            this.Name = "BookForm";
            this.Text = "Book Management";
            this.Load += new System.EventHandler(this.BookForm_Load);
            this.ResumeLayout(false);

        }

        private System.Windows.Forms.ListBox listBoxBooks;
        private System.Windows.Forms.Button buttonAddBook;
        private System.Windows.Forms.Button buttonDeleteBook;
        private System.Windows.Forms.Button buttonUpdateBook;
        private System.Windows.Forms.Button buttonViewDetails;

        // Button click events
        private void ButtonAddBook_Click(object sender, EventArgs e)
        {
            var book = controller.GetBookInput(); // Call to get input from user
            if (book != null)
            {
                controller.AddBook(book);
                UpdateBookList();
            }
        }

        private void ButtonDeleteBook_Click(object sender, EventArgs e)
        {
            int id = controller.GetBookIdInput();
            if (id > 0)
            {
                controller.DeleteBook(id);
                UpdateBookList();
            }
        }

        private void ButtonUpdateBook_Click(object sender, EventArgs e)
        {
            int id = controller.GetBookIdInput();
            if (id > 0)
            {
                var book = controller.GetBookInput();
                if (book != null)
                {
                    controller.UpdateBook(id, book);
                    UpdateBookList();
                }
            }
        }

        private void ButtonViewDetails_Click(object sender, EventArgs e)
        {
            int id = controller.GetBookIdInput();
            if (id > 0)
            {
                controller.ShowBookDetails(id);
            }
        }

        private void UpdateBookList()
        {
            var books = controller.GetAllBooks();
            listBoxBooks.Items.Clear();
            foreach (var book in books)
            {
                listBoxBooks.Items.Add(book.GetDetails());
            }
        }

        private void listBoxBooks_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void BookForm_Load(object sender, EventArgs e)
        {

        }
    }
}
