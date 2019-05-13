package se.kth.iv1350.view;

import se.kth.iv1350.model.PurchaseObserverInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Used to display the running total of a <code>Purchase</code>
 */
public class TotalRevenueView implements PurchaseObserverInterface {
    private JLabel numberLabel = new JLabel("", SwingConstants.CENTER);
    double runningTotal;

    /**
     * Creates instance of <code>TotalRevenueView</code>
     * and connects running total to display
     */
    public TotalRevenueView(){
        runningTotal = 0;
        initDisplay();
        showRunningTotal();
    }

    private void initDisplay() {
        JWindow frame = new JWindow();
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 50);
        numberLabel.setFont(labelFont);
        frame.getContentPane().setBackground(Color.BLACK);
        numberLabel.setForeground(Color.WHITE);
        frame.getContentPane().add(numberLabel);
        frame.setBounds(0, 0, 200, 80);
        frame.setVisible(true);
    }

    private void showRunningTotal(){
        numberLabel.setText(Double.toString(runningTotal));
    }

    @Override
    public void runningTotalUpdated(double newRunningTotal) {
        runningTotal = newRunningTotal;
        showRunningTotal();
    }
}
