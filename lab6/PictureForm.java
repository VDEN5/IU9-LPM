import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class PictureForm {
    private JPanel mainPanel;
    private JSpinner radiusSpinner;
    private JTextField areaField;
    private CanvasPanel canvasPanel;
    private JTextPane paintTextPane;
    private JSpinner numsspinner;

    public PictureForm() {
        radiusSpinner.setValue(100);
        numsspinner.setValue(3);
        radiusSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int radius = (int) radiusSpinner.getValue();
                canvasPanel.setRadius(radius);
                areaField.setText(String.format("%.2f", Math.PI * radius * radius));
            }
        });
        numsspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nums = (int) numsspinner.getValue();
                canvasPanel.setnums(nums);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Окружность");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}