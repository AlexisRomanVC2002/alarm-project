package templates;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import services.DateService;

/**
 *
 * @author AlexisVC2002
 */
public class ClockTemplate extends javax.swing.JFrame {

    private DateService dateService;
    private String hourAlarm;

    public ClockTemplate() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        initComponents();
        dateService = new DateService(tagDate, tagHour);
        dateService.initTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        tagDate = new javax.swing.JLabel();
        tagHour = new javax.swing.JLabel();
        buttonStop = new javax.swing.JButton();
        comboSeconds = new javax.swing.JComboBox<>();
        comboHour = new javax.swing.JComboBox<>();
        comboMinute = new javax.swing.JComboBox<>();
        buttonSetAlarm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clock");
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(58, 63, 83));
        panelPrincipal.setForeground(new java.awt.Color(153, 153, 153));
        panelPrincipal.setLayout(null);

        tagDate.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        tagDate.setForeground(new java.awt.Color(255, 255, 255));
        tagDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelPrincipal.add(tagDate);
        tagDate.setBounds(43, 12, 413, 50);

        tagHour.setFont(new java.awt.Font("Monospaced", 1, 50)); // NOI18N
        tagHour.setForeground(new java.awt.Color(255, 255, 255));
        tagHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelPrincipal.add(tagHour);
        tagHour.setBounds(126, 68, 247, 71);

        buttonStop.setText("Stop");
        buttonStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });
        panelPrincipal.add(buttonStop);
        buttonStop.setBounds(280, 200, 140, 41);

        comboSeconds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        comboSeconds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSeconds.setFocusable(false);
        panelPrincipal.add(comboSeconds);
        comboSeconds.setBounds(320, 140, 72, 46);

        comboHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        comboHour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboHour.setFocusable(false);
        panelPrincipal.add(comboHour);
        comboHour.setBounds(140, 140, 72, 46);

        comboMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        comboMinute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboMinute.setFocusable(false);
        panelPrincipal.add(comboMinute);
        comboMinute.setBounds(230, 140, 72, 46);

        buttonSetAlarm.setText("Establecer Alarma");
        buttonSetAlarm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSetAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetAlarmActionPerformed(evt);
            }
        });
        panelPrincipal.add(buttonSetAlarm);
        buttonSetAlarm.setBounds(100, 200, 140, 41);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        dateService.stopTimerChangeColor();
        tagHour.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_buttonStopActionPerformed

    private void buttonSetAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetAlarmActionPerformed
        String hour = (String) comboHour.getSelectedItem();
        String minute = (String) comboMinute.getSelectedItem();
        String seconds = (String) comboSeconds.getSelectedItem();
        hourAlarm = hour + ":" + minute + ":" + seconds;

        dateService.setHourAlarm(hourAlarm);

        JOptionPane.showMessageDialog(null, "Se ha establecido la alarma a las: " + hourAlarm + " correctamente.");
    }//GEN-LAST:event_buttonSetAlarmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClockTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockTemplate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSetAlarm;
    private javax.swing.JButton buttonStop;
    private javax.swing.JComboBox<String> comboHour;
    private javax.swing.JComboBox<String> comboMinute;
    private javax.swing.JComboBox<String> comboSeconds;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel tagDate;
    private javax.swing.JLabel tagHour;
    // End of variables declaration//GEN-END:variables
}
