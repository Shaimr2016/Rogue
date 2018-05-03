package extra;

import helper.Helper;
import main.GameManager;

import javax.swing.*;
import java.awt.*;

public class GravePane extends JComponent {

    private JPanel panel;
    private JTextArea textArea;

    public GravePane() {
        GameManager.replaceContentPane(panel);

        setDefaults();
    }
    private void setDefaults() {
        textArea.setEditable(false);
        textArea.setBackground(Helper.BACKGROUND_COLOR);
        textArea.setForeground(Helper.FOREGROUND_COLOR);
        textArea.setFont(new Font(Helper.THEME_FONT, Font.BOLD, 30));
        addLine("     .-------.");
        addLine("   .'         '.");
        addLine("   |  R  I  P  |");
        addLine("   |           |");
        addLine("   |   score   |");
        addLine(scoreLine());
        addLine("   |           |");
        addLine(" ^^^^^^^^^^^^^^^^^");

        panel.setBackground(Helper.BACKGROUND_COLOR);
    }
    private void addLine(String text) {
        textArea.setText(textArea.getText() + "\n" + text);
    }
    private String scoreLine() {
        String string = "   |";
        for (int i = 0; i < (6 - GameManager.getPlayer().getExperienceDigitsNumber() / 2) - 1; i++) {
            string = string.concat(" ");
        }
        string = string.concat(String.valueOf(GameManager.getPlayer().getExperience()));
        for (int i = 0; i < (6 - GameManager.getPlayer().getExperienceDigitsNumber() / 2) - 1; i++) {
            string = string.concat(" ");
        }
        string = string.concat("|");
        return string;
    }
}
