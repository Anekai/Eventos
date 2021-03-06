
package views;

import configuration.ParamConfig;
import entities.Evento;
import entities.Pessoa;
import entities.RegistroEvento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import services.EventoService;
import services.PessoaService;
import services.RegistroEventoService;
import services.RegistroEventoTempService;

public class TelaInicial extends javax.swing.JFrame {
    
    private RegistroEvento entityPresenca;
    private RegistroEvento entityInscricao;
    
    private List<Evento> eventos;
    private boolean simularOffline;
    private ParamConfig paramConfig;
    
    private final PessoaService pessoaService;
    private final EventoService eventoService;
    private final RegistroEventoService registroEventoService;
    private final RegistroEventoTempService registroEventoTempService;

    public TelaInicial() {
        initComponents();

        this.setLocationRelativeTo(null);
        
        pessoaService = new PessoaService();
        eventoService = new EventoService();
        registroEventoService = new RegistroEventoService();
        registroEventoTempService = new RegistroEventoTempService();
        
        simularOffline = false;
        paramConfig  = new ParamConfig();
        
        entityPresenca = new RegistroEvento();
        entityInscricao = new RegistroEvento();
        
        comboEventoPresenca.removeAllItems();
        comboEventoInscricao.removeAllItems();
        
        eventos = eventoService.find();
        
        if ( eventos != null ) {
            for ( Evento evento : eventos ) {
                comboEventoPresenca.addItem(evento.getNomeEvento());
                comboEventoInscricao.addItem(evento.getNomeEvento());
            }
        }
        
        fieldIdUsuarioPresenca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldIdUsuarioPresenca.getText().equals("") ) {
                    if ( simularOffline ) {
                        for ( Pessoa usuario : paramConfig.getUsuarios() ) {
                            if ( usuario.getId().equals(Integer.valueOf(fieldIdUsuarioPresenca.getText())) ) {
                                entityPresenca.setUsuario(usuario);
                            }
                        }
                    } else {
                        entityPresenca.setUsuario(pessoaService.findById(Integer.valueOf(fieldIdUsuarioPresenca.getText())));
                    }
                } else {
                    entityPresenca.setUsuario(null);
                }
                
                if ( entityPresenca.getUsuario() != null ) {
                    fieldNomeUsuarioPresenca.setText(entityPresenca.getUsuario().getNome());
                    buttonRegistrarPresenca.requestFocus();
                } else {
                    fieldNomeUsuarioPresenca.setText("");
                    fieldIdUsuarioPresenca.requestFocus();
                }
            }
        });
        
        fieldIdUsuarioInscricao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldIdUsuarioInscricao.getText().equals("") ) {
                    if ( simularOffline ) {
                        for ( Pessoa usuario : paramConfig.getUsuarios() ) {
                            if ( usuario.getId().equals(Integer.valueOf(fieldIdUsuarioInscricao.getText())) ) {
                                entityInscricao.setUsuario(usuario);
                            }
                        }
                    } else {
                        entityInscricao.setUsuario(pessoaService.findById(Integer.valueOf(fieldIdUsuarioInscricao.getText())));
                    }
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

        panelRegistroPresenca = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonRegistrarPresenca = new javax.swing.JButton();
        labelVendaMessage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldIdUsuarioPresenca = new javax.swing.JTextField();
        fieldNomeUsuarioPresenca = new javax.swing.JTextField();
        labelPresencaInfo = new javax.swing.JLabel();
        comboEventoPresenca = new javax.swing.JComboBox<>();
        panelInscricaoRapida = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        buttonInscricaoRapida = new javax.swing.JButton();
        labelEncomendaMessage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldIdUsuarioInscricao = new javax.swing.JTextField();
        fieldNomeUsuarioInscricao = new javax.swing.JTextField();
        fieldNomeUsuario = new javax.swing.JTextField();
        fieldCpfUsuario = new javax.swing.JTextField();
        fieldEmailUsuario = new javax.swing.JTextField();
        labelInscricaoInfo = new javax.swing.JLabel();
        comboEventoInscricao = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuItemEventos = new javax.swing.JMenuItem();
        menuItemInscricoes = new javax.swing.JMenuItem();
        menuItemUsuarios = new javax.swing.JMenuItem();
        menuItemSincronizar = new javax.swing.JMenuItem();

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

        fieldNomeUsuarioPresenca.setFocusable(false);

        labelPresencaInfo.setText(" ");

        javax.swing.GroupLayout panelRegistroPresencaLayout = new javax.swing.GroupLayout(panelRegistroPresenca);
        panelRegistroPresenca.setLayout(panelRegistroPresencaLayout);
        panelRegistroPresencaLayout.setHorizontalGroup(
            panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelVendaMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                        .addComponent(buttonRegistrarPresenca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPresencaInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                        .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboEventoPresenca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                                .addComponent(fieldIdUsuarioPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNomeUsuarioPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRegistroPresencaLayout.setVerticalGroup(
            panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPresencaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboEventoPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldIdUsuarioPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeUsuarioPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(labelVendaMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
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
                            .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(comboEventoInscricao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(panelInscricaoRapidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelInscricaoRapidaLayout.createSequentialGroup()
                                        .addComponent(fieldIdUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldNomeUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(comboEventoInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
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

        menuItemSincronizar.setText("Sincronizar");
        menuItemSincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSincronizarActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemSincronizar);

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
        entityPresenca.setEvento(eventos.get(comboEventoPresenca.getSelectedIndex()));
        
        if ( registroEventoService.registrarPresenca(entityPresenca, simularOffline) ) {
            labelPresencaInfo.setText("Presença confirmada!");
            
            fieldIdUsuarioPresenca.setText("");
            fieldNomeUsuarioPresenca.setText("");
            
            entityPresenca = new RegistroEvento();
            
            if ( simularOffline ) {
                eventos = paramConfig.getEventos();
            } else {
                eventos = eventoService.find();
            }
            
            comboEventoPresenca.removeAllItems();
            comboEventoInscricao.removeAllItems();
        
            for ( Evento evento : eventos ) {
                comboEventoPresenca.addItem(evento.getNomeEvento());
                comboEventoInscricao.addItem(evento.getNomeEvento());
            }
        } else {
            labelPresencaInfo.setText("Erro ao confirmar presença!");
        }
    }//GEN-LAST:event_buttonRegistrarPresencaActionPerformed

    private void buttonInscricaoRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInscricaoRapidaActionPerformed
        if ( entityInscricao.getUsuario() == null ) {
            entityInscricao.setUsuario(new Pessoa(null, fieldNomeUsuario.getText(), fieldCpfUsuario.getText(), fieldEmailUsuario.getText(), null, null));
        }
        
        entityInscricao.setEvento(eventos.get(comboEventoInscricao.getSelectedIndex()));
        
        if ( registroEventoService.inscricaoRapida(entityInscricao, simularOffline) ) {
            labelInscricaoInfo.setText("Inscrição confirmada!");
            
            fieldIdUsuarioInscricao.setText("");
            fieldNomeUsuarioInscricao.setText("");
            
            fieldNomeUsuario.setText("");
            fieldCpfUsuario.setText("");
            fieldEmailUsuario.setText("");
                    
            fieldNomeUsuario.setEditable(true);
            fieldCpfUsuario.setEditable(true);
            fieldEmailUsuario.setEditable(true);
            
            entityInscricao = new RegistroEvento();
            
            if ( simularOffline ) {
                eventos = paramConfig.getEventos();
            } else {
                eventos = eventoService.find();
            }
            
            comboEventoPresenca.removeAllItems();
            comboEventoInscricao.removeAllItems();
        
            for ( Evento evento : eventos ) {
                comboEventoPresenca.addItem(evento.getNomeEvento());
                comboEventoInscricao.addItem(evento.getNomeEvento());
            }
        } else {
            labelInscricaoInfo.setText("Erro ao confirmar inscrição rápida!");
        }
    }//GEN-LAST:event_buttonInscricaoRapidaActionPerformed

    private void menuItemSincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSincronizarActionPerformed
        registroEventoTempService.synchronize();
        
        paramConfig = new ParamConfig(eventoService.find(), pessoaService.find(), registroEventoService.find());
        
        if ( paramConfig.getEventos() != null && !paramConfig.getEventos().isEmpty() ) {
            eventos = paramConfig.getEventos();
            
            comboEventoPresenca.removeAllItems();
            comboEventoInscricao.removeAllItems();
        
            for ( Evento evento : eventos ) {
                comboEventoPresenca.addItem(evento.getNomeEvento());
                comboEventoInscricao.addItem(evento.getNomeEvento());
            }
        }
        
        simularOffline = !simularOffline;
    }//GEN-LAST:event_menuItemSincronizarActionPerformed

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
    private javax.swing.JComboBox<String> comboEventoInscricao;
    private javax.swing.JComboBox<String> comboEventoPresenca;
    private javax.swing.JTextField fieldCpfUsuario;
    private javax.swing.JTextField fieldEmailUsuario;
    private javax.swing.JTextField fieldIdUsuarioInscricao;
    private javax.swing.JTextField fieldIdUsuarioPresenca;
    private javax.swing.JTextField fieldNomeUsuario;
    private javax.swing.JTextField fieldNomeUsuarioInscricao;
    private javax.swing.JTextField fieldNomeUsuarioPresenca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelEncomendaMessage;
    private javax.swing.JLabel labelInscricaoInfo;
    private javax.swing.JLabel labelPresencaInfo;
    private javax.swing.JLabel labelVendaMessage;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuItemEventos;
    private javax.swing.JMenuItem menuItemInscricoes;
    private javax.swing.JMenuItem menuItemSincronizar;
    private javax.swing.JMenuItem menuItemUsuarios;
    private javax.swing.JPanel panelInscricaoRapida;
    private javax.swing.JPanel panelRegistroPresenca;
    // End of variables declaration//GEN-END:variables
}
