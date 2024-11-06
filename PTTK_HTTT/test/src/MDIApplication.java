import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MDIApplication {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MDI Application");
        JDesktopPane desktopPane = new JDesktopPane();

        JMenu menu = new JMenu("File");
        JMenuItem inputMenuItem = new JMenuItem("Data Input");
        JMenuItem statisticsMenuItem = new JMenuItem("Statistics/Reporting");

        JInternalFrame inputFrame = new JInternalFrame("Data Input", true, true, true, true);
        JInternalFrame statisticsFrame = new JInternalFrame("Statistics/Reporting", true, true, true, true);

        inputMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Data input function implementation
            }
        });

        statisticsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Statistics/reporting function implementation
            }
        });

        menu.add(inputMenuItem);
        menu.add(statisticsMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
        frame.add(desktopPane);

        inputFrame.setSize(400, 300);
        inputFrame.setVisible(true);
        desktopPane.add(inputFrame);

        statisticsFrame.setSize(400, 300);
        statisticsFrame.setVisible(true);
        desktopPane.add(statisticsFrame);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}