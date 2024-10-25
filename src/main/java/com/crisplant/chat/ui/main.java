package com.crisplant.chat.ui;

import com.crisplant.chat.Historial;
import javax.swing.ImageIcon;

public class main extends javax.swing.JFrame {

    public main() {
        setIconImage(new ImageIcon("/com/crisPlant/chat/ui/icon.png").getImage());
        initComponents();
        newChat();
    }
    
    private void newChat() {
        Historial.crearNuevoChat();
        out.setText("");
        historial.setListData(Historial.getNamesHistorial());
    }
    
    private void updateChatActual() {
        out.setText("");
        String allMesagge = "";
        String[] chat = Historial.chatActual;
        for (int i = 0; i < chat.length-1; i = i+1) {
            if (chat[i] != null) {
                allMesagge = allMesagge + "\n User: "+ chat[i] + "\n Bot: " + chat[i+1] + "\n";
            }
        }
        out.setText(allMesagge);
    }

    private void enviarMensaje() {
        String promt = input.getText();

        if (!promt.isEmpty()) {
            Historial.addMensaje(promt, promt);
            String respuesta = promt; // API.sendMessageAPI(promt);
            out.setText(out.getText() + "\n User:" + promt + "\n Bot: " + respuesta + "\n");
            input.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historial = new javax.swing.JList<>();
        input = new javax.swing.JTextField();
        enviar = new javax.swing.JButton();
        newChat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        out = new javax.swing.JTextArea();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatBot");
        setIconImage(new ImageIcon("/images/icono.png").getImage());
        setLocationByPlatform(true);
        setResizable(false);

        historial.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(historial);

        enviar.setBackground(new java.awt.Color(153, 255, 255));
        enviar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        enviar.setText("Enviar");
        enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarMouseClicked(evt);
            }
        });
        enviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enviarKeyTyped(evt);
            }
        });

        newChat.setBackground(new java.awt.Color(204, 255, 255));
        newChat.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        newChat.setText("Nuevo Chat");
        newChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newChatMouseClicked(evt);
            }
        });

        out.setColumns(20);
        out.setRows(5);
        jScrollPane2.setViewportView(out);

        reset.setText("Limpiar");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(newChat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(reset))
                            .addComponent(jScrollPane2))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newChat, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarMouseClicked
        enviarMensaje();
    }//GEN-LAST:event_enviarMouseClicked

    private void newChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newChatMouseClicked
        newChat();
    }//GEN-LAST:event_newChatMouseClicked

    private void historialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historialMouseClicked
        int indice = historial.getSelectedIndex();
        Historial.setChatActual(indice);

        updateChatActual();
    }//GEN-LAST:event_historialMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        Historial.deleteChatActual();
        
        updateChatActual();
    }//GEN-LAST:event_resetMouseClicked

    private void enviarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enviarKeyTyped
        // validar si se presionó la tecla Enter
        if (evt.getKeyCode() == 10) {
            enviarMensaje();
        }
        System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_enviarKeyTyped

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JList<String> historial;
    private javax.swing.JTextField input;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newChat;
    private javax.swing.JTextArea out;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
