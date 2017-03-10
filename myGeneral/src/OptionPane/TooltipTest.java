package OptionPane;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 class TooltipTest extends JFrame {

    private JToolTip tooltip;
    private JLabel label;
    private JButton button;

    public TooltipTest() {
        super("tooltipFrame");
        label = new JLabel("label");
        tooltip = label.createToolTip();
        tooltip.setTipText("Toooooltip");
        add(label, BorderLayout.NORTH);

        button = new JButton("Show tooltip");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                PopupFactory popupFactory = PopupFactory.getSharedInstance();
                int x = label.getLocationOnScreen().x;
                int y = label.getLocationOnScreen().y;
                x+= label.getWidth()/2;
                y+= label.getHeight();
                final Popup tooltipContainer = popupFactory.getPopup(label, tooltip, x, y);

                tooltipContainer.show();
                (new Thread(new Runnable(){
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
        //                    Logger.getLogger(TooltipTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tooltipContainer.hide();
                    }

                })).start();
            }
        });

        add(button, BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        TooltipTest test = new TooltipTest();
    }
}