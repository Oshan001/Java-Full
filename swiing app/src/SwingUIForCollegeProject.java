import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SwingUIForCollegeProject { // <--- Class name added

    public static void main(String[] args) {
        SwingUIForCollegeProject app = new SwingUIForCollegeProject();
        SwingUtilities.invokeLater(app::createAndShowGUI); // clean call via method reference
    }

    public void createAndShowGUI() {
        // Main frame
        JFrame frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());

        // Top bar
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topBar.setBackground(new Color(0xB19428));

        JLabel appLabel = new JLabel("📚 Menu");
        appLabel.setForeground(Color.WHITE);
        appLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topBar.add(appLabel);
        frame.add(topBar, BorderLayout.NORTH);

        // Grid panel
        JPanel gridPanel = new JPanel(new GridLayout(0, 4, 30, 30));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gridPanel.setBackground(Color.WHITE);

        // Label + icon data
        String[][] labels = {
                {"📅 Upcoming Event", "upcoming_event.jpg"},
                {"🏫 My Classroom"},
                {"📝 Exam & Result"},
                {"👥 My Classmates"},
                {"📚 My Notes"},
                {"❓ Ask Teacher"},
                {"💬 Chat with Mates"},
                {"📆 Calendar"},
                {"📖 Syllabus"},
                {"👨‍💻 About Developer"}
        };

        // Add items to grid
        for (String[] labelInfo : labels) {
            String text = labelInfo[0];
            String imagePath = (labelInfo.length > 1) ? labelInfo[1] : null;
            JPanel iconBox = createIconBox(text, imagePath);
            gridPanel.add(iconBox);
        }

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
    }

    private JPanel createIconBox(String labelText, String imagePath) {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setPreferredSize(new Dimension(130, 100));
        box.setBorder(new LineBorder(Color.LIGHT_GRAY));
        box.setBackground(new Color(0xF9F9F9));
        box.setCursor(new Cursor(Cursor.HAND_CURSOR));
        box.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Icon
        JLabel iconLabel;
        if (imagePath != null) {
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/photo/" + imagePath));
                Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                iconLabel = new JLabel(new ImageIcon(img));
            } catch (Exception e) {
                System.err.println("Image not found: " + imagePath + " - " + e.getMessage());
                iconLabel = new JLabel("❓", SwingConstants.CENTER);
                iconLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            }
        } else {
            iconLabel = new JLabel("📌", SwingConstants.CENTER);
            iconLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        }

        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label text
        JLabel textLabel = new JLabel("<html><center>" + labelText + "</center></html>", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Hover effect
        box.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                box.setBackground(new Color(0xE0E0E0));
                box.setBorder(new LineBorder(new Color(0xB19428)));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                box.setBackground(new Color(0xF9F9F9));
                box.setBorder(new LineBorder(Color.LIGHT_GRAY));
            }
        });

        box.add(Box.createVerticalGlue());
        box.add(iconLabel);
        box.add(Box.createVerticalStrut(5));
        box.add(textLabel);
        box.add(Box.createVerticalGlue());

        return box;
    }
}
