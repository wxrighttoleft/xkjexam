namespace ProjectAdmin
{
    partial class MainFrm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainFrm));
            this.mainMenu = new System.Windows.Forms.MenuStrip();
            this.adminToolsMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.projectSelectToolMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.publishToolMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.infoAdminToolMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.privateInfoToolMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.skinEngine1 = new Sunisoft.IrisSkin.SkinEngine(((System.ComponentModel.Component)(this)));
            this.mainMenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // mainMenu
            // 
            this.mainMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.adminToolsMenu,
            this.infoAdminToolMenu});
            this.mainMenu.Location = new System.Drawing.Point(0, 0);
            this.mainMenu.Name = "mainMenu";
            this.mainMenu.Size = new System.Drawing.Size(602, 25);
            this.mainMenu.TabIndex = 0;
            this.mainMenu.Text = "menuStrip1";
            // 
            // adminToolsMenu
            // 
            this.adminToolsMenu.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.projectSelectToolMenuItem,
            this.publishToolMenuItem});
            this.adminToolsMenu.Name = "adminToolsMenu";
            this.adminToolsMenu.Size = new System.Drawing.Size(83, 21);
            this.adminToolsMenu.Text = "项目管理(&P&)";
            // 
            // projectSelectToolMenuItem
            // 
            this.projectSelectToolMenuItem.Name = "projectSelectToolMenuItem";
            this.projectSelectToolMenuItem.Size = new System.Drawing.Size(124, 22);
            this.projectSelectToolMenuItem.Text = "项目查看";
            // 
            // publishToolMenuItem
            // 
            this.publishToolMenuItem.Name = "publishToolMenuItem";
            this.publishToolMenuItem.Size = new System.Drawing.Size(124, 22);
            this.publishToolMenuItem.Text = "项目发布";
            // 
            // infoAdminToolMenu
            // 
            this.infoAdminToolMenu.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.privateInfoToolMenuItem});
            this.infoAdminToolMenu.Name = "infoAdminToolMenu";
            this.infoAdminToolMenu.Size = new System.Drawing.Size(80, 21);
            this.infoAdminToolMenu.Text = "信息管理(&I&)";
            // 
            // privateInfoToolMenuItem
            // 
            this.privateInfoToolMenuItem.Name = "privateInfoToolMenuItem";
            this.privateInfoToolMenuItem.Size = new System.Drawing.Size(124, 22);
            this.privateInfoToolMenuItem.Text = "个人信息";
            // 
            // skinEngine1
            // 
            this.skinEngine1.SerialNumber = "";
            this.skinEngine1.SkinFile = "F:\\学习资料\\WinForm皮肤包\\Skins\\Vista1\\vista1.ssk";
            this.skinEngine1.SkinStreamMain = ((System.IO.Stream)(resources.GetObject("skinEngine1.SkinStreamMain")));
            // 
            // MainFrm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(602, 262);
            this.Controls.Add(this.mainMenu);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.mainMenu;
            this.Name = "MainFrm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "项目管理（龙腾工作室）";
            this.Load += new System.EventHandler(this.MainFrm_Load);
            this.mainMenu.ResumeLayout(false);
            this.mainMenu.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip mainMenu;
        private System.Windows.Forms.ToolStripMenuItem adminToolsMenu;
        private System.Windows.Forms.ToolStripMenuItem projectSelectToolMenuItem;
        private System.Windows.Forms.ToolStripMenuItem publishToolMenuItem;
        private Sunisoft.IrisSkin.SkinEngine skinEngine1;
        private System.Windows.Forms.ToolStripMenuItem infoAdminToolMenu;
        private System.Windows.Forms.ToolStripMenuItem privateInfoToolMenuItem;
    }
}

