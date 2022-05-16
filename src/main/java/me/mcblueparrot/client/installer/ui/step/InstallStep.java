/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package me.mcblueparrot.client.installer.ui.step;

import java.awt.EventQueue;
import me.mcblueparrot.client.installer.InstallStatusCallback;
import me.mcblueparrot.client.installer.ui.InstallerFrame;

/**
 *
 * @author maks
 */
public class InstallStep extends javax.swing.JPanel implements InstallStatusCallback{
    private int lastMax = 100;
    /**
     * Creates new form InstallStep
     */
    public InstallStep(InstallerFrame frame) {
        initComponents();
        frame.getInstaller().install(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        installScrollPane = new javax.swing.JScrollPane();
        installLogArea = new javax.swing.JTextArea();
        installProgressBar = new javax.swing.JProgressBar();
        doneButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(0, 0));

        installScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        installScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        installScrollPane.setPreferredSize(new java.awt.Dimension(0, 0));

        installLogArea.setColumns(20);
        installLogArea.setRows(5);
        installScrollPane.setViewportView(installLogArea);

        doneButton.setText("Done");
        doneButton.setEnabled(false);
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(installScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(doneButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(installProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(installScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(installProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_doneButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doneButton;
    private javax.swing.JTextArea installLogArea;
    private javax.swing.JProgressBar installProgressBar;
    private javax.swing.JScrollPane installScrollPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setTextStatus(String status) {
        EventQueue.invokeLater(()-> installLogArea.setText(installLogArea.getText()+status+"\n"));
    }

    @Override
    public void setProgressBarValues(int max, int cur) {
        EventQueue.invokeLater(()-> {
            if(lastMax != max) {
                installProgressBar.setMaximum(max);
                lastMax = max;
            }
            installProgressBar.setValue(cur);
        });
    }

    @Override
    public void setProgressBarIndeterminate(boolean indeterminate) {
        EventQueue.invokeLater(()-> installProgressBar.setIndeterminate(indeterminate));
    }

    @Override
    public void onDone(boolean okay) {
        EventQueue.invokeLater(()-> {
            installProgressBar.setIndeterminate(false);
            installProgressBar.setValue(0);
            doneButton.setEnabled(true);
        });
    }
}