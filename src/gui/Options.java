package gui;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Main.SaveLoad;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Options extends JFrame {
    private static final long serialVersionUID = 1L;
    private boolean           soundEnabled     = true;
    private JPanel            contentPane;
    private JLabel            lblSound;
    private JButton           btnSound;
    
    public Options() {
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel pnlSaveLoad = new JPanel();
        pnlSaveLoad
            .setBorder(new TitledBorder(null, "Save & Load", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlSaveLoad.setBounds(10, 16, 252, 71);
        contentPane.add(pnlSaveLoad);
        pnlSaveLoad.setLayout(null);
        
        JLabel lblLoadProtection = new JLabel("<html> After loading a game <br> "
            + "there will be a  <br>  4 round of LoadProtection </html>");
        lblLoadProtection.setHorizontalAlignment(SwingConstants.CENTER);
        if (Main.Main.loadProtection) lblLoadProtection.setText(" Load Protection ");
        lblLoadProtection.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblLoadProtection.setBounds(272, 16, 153, 71);
        contentPane.add(lblLoadProtection);
        setBounds(100, 100, 451, 480);
        
        
        
        // Save Load
        
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(10, 16, 112, 45);
        btnSave.addActionListener(al -> {
            SaveLoad.save();
        });
        pnlSaveLoad.add(btnSave);
        
        JButton btnLoad = new JButton("Load");
        btnLoad.setBounds(130, 16, 112, 45);
        btnLoad.addActionListener(al -> {
            SaveLoad.load();
            btnLoad.setEnabled(false);
        });
        btnLoad.setEnabled(!Main.Main.loadProtection);
        pnlSaveLoad.add(btnLoad);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 98, 415, 2);
        contentPane.add(separator);
        
        
        
        // Sound
        
        ImageIcon iconSoundEnable = new ImageIcon("SoundEnable.PNG");
        ImageIcon iconSoundMute = new ImageIcon("SoundMute.PNG");
        btnSound = new JButton(iconSoundEnable);
        btnSound.setBounds(25, 111, 60, 70);
        contentPane.add(btnSound);
        btnSound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sounds silenced."); // TODO disable sound
                if (soundEnabled) {
                    soundEnabled = false;
                    lblSound.setText("Muted");
                    btnSound.setIcon(iconSoundMute);
                }
                else {
                    soundEnabled = true;
                    lblSound.setText("Music playing. Enjoy :)");
                    btnSound.setIcon(iconSoundEnable);
                }
            }
        });
        btnSound.setContentAreaFilled(false);
        btnSound.setFocusable(false);
        btnSound.setOpaque(false);
        
        lblSound = new JLabel("");
        lblSound.setHorizontalAlignment(SwingConstants.CENTER);
        lblSound.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblSound.setBounds(105, 111, 137, 70);
        contentPane.add(lblSound);
        
        
    }
}
