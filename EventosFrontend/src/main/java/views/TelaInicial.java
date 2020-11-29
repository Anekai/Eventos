
package views;

import entities.Pessoa;
import entities.RegistroEvento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import services.EventoService;
import services.PessoaService;
import services.RegistroEventoService;

public class TelaInicial extends javax.swing.JFrame {
    
    private RegistroEvento entityPresenca;
    private RegistroEvento entityInscricao;
    
    private final RegistroEventoService registroEventoService;
    private final PessoaService pessoaService;
    private final EventoService eventoService;

    public TelaInicial() {
        initComponents();

        this.setLocationRelativeTo(null);
        
        registroEventoService = new RegistroEventoService();
        pessoaService = new PessoaService();
        eventoService = new EventoService();
        
        entityPresenca = new RegistroEvento();
        entityInscricao = new RegistroEvento();
        
        fieldIdEventoPresenca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldIdEventoPresenca.getText().equals("") ) {
                    entityPresenca.setEvento(eventoService.findById(Integer.valueOf(fieldIdEventoPresenca.getText())));
                } else {
                    entityPresenca.setEvento(null);
                }
                
                if ( entityPresenca.getEvento()!= null ) {
                    fieldNomeEventoPresenca.setText(entityPresenca.getEvento().getNomeEvento());
                    fieldIdUsuarioPresenca.requestFocus();
                } else {
                    fieldNomeEventoPresenca.setText("");
                    fieldIdEventoPresenca.requestFocus();
                }
            }
        });
        
        fieldIdUsuarioPresenca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldIdUsuarioPresenca.getText().equals("") ) {
                    entityPresenca.setUsuario(pessoaService.findById(Integer.valueOf(fieldIdUsuarioPresenca.getText())));
                } else {
                    entityPresenca.setUsuario(null);
                }
                
                if ( entityPresenca.getUsuario() != null ) {
                    fieldNomeUsuario.setText(entityPresenca.getUsuario().getNome());
                    buttonRegistrarPresenca.requestFocus();
                } else {
                    fieldNomeUsuario.setText("");
                    fieldIdUsuarioPresenca.requestFocus();
                }
            }
        });
        
        fieldIdEventoInscricao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldIdEventoInscricao.getText().equals("") ) {
                    entityInscricao.setEvento(eventoService.findById(Integer.valueOf(fieldIdEventoInscricao.getText())));
                } else {
                    entityInscricao.setEvento(null);
                }
                
                if ( entityInscricao.getEvento()!= null ) {
                    fieldNomeEventoInscricao.setText(entityInscricao.getEvento().getNomeEvento());
                    fieldIdUsuarioInscricao.requestFocus();
                } else {
                    fieldNomeEventoInscricao.setText("");
                    fieldIdEventoInscricao.requestFocus();
                }
            }
        });
        
        fieldIdUsuarioInscricao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldIdUsuarioInscricao.getText().equals("") ) {
                    entityInscricao.setUsuario(pessoaService.findById(Integer.valueOf(fieldIdUsuarioInscricao.getText())));
                } else {
                    entityInscricao.setUsuario(null);
                }
                
                if ( entityInscricao.getUsuario() != null ) {
                    fieldNomeUsuarioInscricao.setText(entityInscricao.getUsuario().getNome());
                    
                    fieldNomeUsuario.setText("");
                    fieldCpfUsuario.setText("");
                    fieldEmailUsuario.setText("");
                    
                    fieldNomeUsuario.setEditable(false);
                    fieldCpfUsuario.setEditable(false);
                    fieldEmailUsuario.setEditable(false);
                    
                    buttonInscricaoRapida.requestFocus();
                } else {
                    fieldNomeUsuarioInscricao.setText("");
                    
                    fieldNomeUsuario.setEditable(true);
                    fieldCpfUsuario.setEditable(true);
                    fieldEmailUsuario.setEditable(true);
                    
                    fieldIdUsuarioInscricao.requestFocus();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogProduto = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        panelRegistroPresenca = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonRegistrarPresenca = new javax.swing.JButton();
        fieldIdEventoPresenca = new javax.swing.JTextField();
        fieldNomeEventoPresenca = new javax.swing.JTextField();
        labelVendaMessage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldIdUsuarioPresenca = new javax.swing.JTextField();
        fieldNomeUsuarioPresenca = new javax.swing.JTextField();
        labelPresencaInfo = new javax.swing.JLabel();
        panelInscricaoRapida = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        buttonInscricaoRapida = new javax.swing.JButton();
        labelEncomendaMessage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldIdEventoInscricao = new javax.swing.JTextField();
        fieldNomeEventoInscricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldIdUsuarioInscricao = new javax.swing.JTextField();
        fieldNomeUsuarioInscricao = new javax.swing.JTextField();
        fieldNomeUsuario = new javax.swing.JTextField();
        fieldCpfUsuario = new javax.swing.JTextField();
        fieldEmailUsuario = new javax.swing.JTextField();
        labelInscricaoInfo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuItemEventos = new javax.swing.JMenuItem();
        menuItemInscricoes = new javax.swing.JMenuItem();
        menuItemUsuarios = new javax.swing.JMenuItem();

        jLabel5.setText("Produto:");

        jLabel6.setText("Quantidade:");

        jButton1.setText("Adicionar");

        javax.swing.GroupLayout dialogProdutoLayout = new javax.swing.GroupLayout(dialogProduto.getContentPane());
        dialogProduto.getContentPane().setLayout(dialogProdutoLayout);
        dialogProdutoLayout.setHorizontalGroup(
            dialogProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(dialogProdutoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        dialogProdutoLayout.setVerticalGroup(
            dialogProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventus");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelRegistroPresenca.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Presença"));

        jLabel1.setText("Evento:");

        buttonRegistrarPresenca.setText("Registrar");
        buttonRegistrarPresenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarPresencaActionPerformed(evt);
            }
        });

        labelVendaMessage.setForeground(new java.awt.Color(216, 176, 26));
        labelVendaMessage.setText("            ");

        jLabel3.setText("Usuário:");

        labelPresencaInfo.setText(" ");

        javax.swing.GroupLayout panelRegistroPresencaLayout = new javax.swing.GroupLayout(panelRegistroPresenca);
        panelRegistroPresenca.setLayout(panelRegistroPresencaLayout);
        panelRegistroPresencaLayout.setHorizontalGroup(
            panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelVendaMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                        .addComponent(buttonRegistrarPresenca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPresencaInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                    .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldIdEventoPresenca, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(fieldIdUsuarioPresenca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldNomeEventoPresenca)
                            .addComponent(fieldNomeUsuarioPresenca, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRegistroPresencaLayout.setVerticalGroup(
            panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldIdEventoPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeEventoPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldIdUsuarioPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeUsuarioPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(labelVendaMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegistrarPresenca)
                    .addComponent(labelPresencaInfo))
                .addContainerGap())
        );

        panelInscricaoRapida.setBorder(javax.swing.BorderFactory.createTitledBorder("Inscrição Rápida"));

        jLabel8.setText("Nome:");

        buttonInscricaoRapida.setText("Inscrever");
        buttonInscricaoRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInscricaoRapidaActionPerformed(evt);
            }
        });

        labelEncomendaMessage.setForeground(new java.awt.Color(216, 176, 26));
        labelEncomendaMessage.setText("            ");

        jLabel9.setText("CPF:");

        jLabel13.setText("Email:");

        jLabel2.setText("Evento:");

        jLabel4.setText("Usuário:");

        labelInscricaoInfo.setText(" ");

        javax.swing.GroupLayout panelInscricaoRapidaLayout = new javax.swing.GroupLayout(panelInscricaoRapida);
        panelInscricaoRapida.setLayout(panelInscricaoRapidaLayout);
        panelInscricaoRapidaLayout.setHorizontalGroup(
            panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(239, 239, 239)
                        .addComponent(labelEncomendaMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                        .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                                .addComponent(buttonInscricaoRapida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelInscricaoInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                                        .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldIdEventoInscricao)
                                            .addComponent(fieldIdUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldNomeEventoInscricao)
                                            .addComponent(fieldNomeUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(fieldEmailUsuario)
                                    .addComponent(fieldCpfUsuario)
                                    .addComponent(fieldNomeUsuario))))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInscricaoRapidaLayout.setVerticalGroup(
            panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldIdEventoInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeEventoInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldIdUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldCpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEncomendaMessage)
                    .addComponent(jLabel13)
                    .addComponent(fieldEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInscricaoRapida)
                    .addComponent(labelInscricaoInfo))
                .addContainerGap())
        );

        menuCadastro.setText("Menu");

        menuItemEventos.setText("Eventos");
        menuItemEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEventosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemEventos);

        menuItemInscricoes.setText("Inscrições");
        menuItemInscricoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInscricoesActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemInscricoes);

        menuItemUsuarios.setText("Usuários");
        menuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsuariosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemUsuarios);

        jMenuBar1.add(menuCadastro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegistroPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInscricaoRapida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRegistroPresenca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInscricaoRapida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEventosActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEvento(new TelaInicial(), true).setVisible(true);
            }
        });
    }//GEN-LAST:event_menuItemEventosActionPerformed

    private void menuItemInscricoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInscricoesActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInscricao(new TelaInicial(), true).setVisible(true);
            }
        });
    }//GEN-LAST:event_menuItemInscricoesActionPerformed

    private void menuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUsuariosActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario(new TelaInicial(), true).setVisible(true);
            }
        });
    }//GEN-LAST:event_menuItemUsuariosActionPerformed

    private void buttonRegistrarPresencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarPresencaActionPerformed
        if ( registroEventoService.registrarPresenca(entityPresenca) ) {
            labelPresencaInfo.setText("Presença confirmada!");
            
            fieldIdEventoPresenca.setText("");
            fieldNomeEventoPresenca.setText("");
            fieldIdUsuarioPresenca.setText("");
            fieldNomeUsuarioPresenca.setText("");
            
            entityPresenca = new RegistroEvento();
        } else {
            labelPresencaInfo.setText("Erro ao confirmar presença!");
        }
    }//GEN-LAST:event_buttonRegistrarPresencaActionPerformed

    private void buttonInscricaoRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInscricaoRapidaActionPerformed
        if ( entityInscricao.getUsuario() == null ) {
            entityInscricao.setUsuario(new Pessoa(null, fieldNomeUsuario.getText(), fieldCpfUsuario.getText(), fieldEmailUsuario.getText(), null, null));
        }
        
        if ( registroEventoService.inscricaoRapida(entityInscricao) ) {
            labelPresencaInfo.setText("Inscrição confirmada!");
            
            fieldIdEventoInscricao.setText("");
            fieldNomeEventoInscricao.setText("");
            fieldIdUsuarioInscricao.setText("");
            fieldNomeUsuarioInscricao.setText("");
            
            fieldNomeUsuario.setText("");
            fieldCpfUsuario.setText("");
            fieldEmailUsuario.setText("");
                    
            fieldNomeUsuario.setEditable(true);
            fieldCpfUsuario.setEditable(true);
            fieldEmailUsuario.setEditable(true);
            
            entityInscricao = new RegistroEvento();
        } else {
            labelPresencaInfo.setText("Erro ao confirmar inscrição!");
        }
    }//GEN-LAST:event_buttonInscricaoRapidaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInicial frame = new TelaInicial();
                
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInscricaoRapida;
    private javax.swing.JButton buttonRegistrarPresenca;
    private javax.swing.JDialog dialogProduto;
    private javax.swing.JTextField fieldCpfUsuario;
    private javax.swing.JTextField fieldEmailUsuario;
    private javax.swing.JTextField fieldIdEventoInscricao;
    private javax.swing.JTextField fieldIdEventoPresenca;
    private javax.swing.JTextField fieldIdUsuarioInscricao;
    private javax.swing.JTextField fieldIdUsuarioPresenca;
    private javax.swing.JTextField fieldNomeEventoInscricao;
    private javax.swing.JTextField fieldNomeEventoPresenca;
    private javax.swing.JTextField fieldNomeUsuario;
    private javax.swing.JTextField fieldNomeUsuarioInscricao;
    private javax.swing.JTextField fieldNomeUsuarioPresenca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelEncomendaMessage;
    private javax.swing.JLabel labelInscricaoInfo;
    private javax.swing.JLabel labelPresencaInfo;
    private javax.swing.JLabel labelVendaMessage;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuItemEventos;
    private javax.swing.JMenuItem menuItemInscricoes;
    private javax.swing.JMenuItem menuItemUsuarios;
    private javax.swing.JPanel panelInscricaoRapida;
    private javax.swing.JPanel panelRegistroPresenca;
    // End of variables declaration//GEN-END:variables
}
