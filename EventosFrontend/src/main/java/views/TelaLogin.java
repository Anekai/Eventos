
package views;

import configuration.SendAttachment;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import configuration.ParamConfig;
import entities.Pessoa;
import entities.RegistroEvento;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import services.EventoService;
import services.PessoaService;
import services.RegistroEventoService;
public class TelaLogin extends javax.swing.JFrame {

    private Pessoa usuarioCadastro;
    
    private PessoaService pessoaService;
    private RegistroEventoService registroEventoService;
    
    public TelaLogin() {
        initComponents();
        pessoaService = new PessoaService();
        registroEventoService = new RegistroEventoService();
        
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCadastrar = new javax.swing.JDialog();
        buttonInsertSalvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldDataNascimentoUsuario = new javax.swing.JTextField();
        fieldCpfUsuario = new javax.swing.JTextField();
        fieldNomeUsuario = new javax.swing.JTextField();
        fieldEmailUsuario = new javax.swing.JTextField();
        fieldSenhaUsuario = new javax.swing.JPasswordField();
        dialogCertificados = new javax.swing.JDialog();
        buttonGerar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        fieldCodigoValidacao = new javax.swing.JTextField();
        buttonEnviarEmail = new javax.swing.JButton();
        panelLogin = new javax.swing.JPanel();
        labelLogin = new javax.swing.JLabel();
        fieldLogin = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        fieldSenha = new javax.swing.JPasswordField();
        labelLoginErro = new javax.swing.JLabel();
        buttonCadastrar = new javax.swing.JButton();
        buttonCertificados = new javax.swing.JButton();

        dialogCadastrar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogCadastrar.setTitle("Cadastrar Usuário");
        dialogCadastrar.setModal(true);
        dialogCadastrar.setResizable(false);
        dialogCadastrar.setSize(new java.awt.Dimension(400, 350));

        buttonInsertSalvar.setText("Cadastrar");
        buttonInsertSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertSalvarActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome:");

        jLabel9.setText("CPF:");

        jLabel13.setText("Email:");

        jLabel1.setText("Data Nascimento:");

        jLabel2.setText("Senha:");

        javax.swing.GroupLayout dialogCadastrarLayout = new javax.swing.GroupLayout(dialogCadastrar.getContentPane());
        dialogCadastrar.getContentPane().setLayout(dialogCadastrarLayout);
        dialogCadastrarLayout.setHorizontalGroup(
            dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInsertSalvar)
                    .addGroup(dialogCadastrarLayout.createSequentialGroup()
                        .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldSenhaUsuario)
                            .addComponent(fieldEmailUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(fieldCpfUsuario)
                            .addComponent(fieldNomeUsuario)
                            .addComponent(fieldDataNascimentoUsuario))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        dialogCadastrarLayout.setVerticalGroup(
            dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldCpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldDataNascimentoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fieldEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(buttonInsertSalvar)
                .addContainerGap())
        );

        dialogCertificados.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogCertificados.setTitle("Certificados");
        dialogCertificados.setModal(true);
        dialogCertificados.setResizable(false);
        dialogCertificados.setSize(new java.awt.Dimension(360, 200));

        buttonGerar.setText("Gerar");
        buttonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGerarActionPerformed(evt);
            }
        });

        jLabel10.setText("Código de validação");

        buttonEnviarEmail.setText("Enviar por e-mail");
        buttonEnviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogCertificadosLayout = new javax.swing.GroupLayout(dialogCertificados.getContentPane());
        dialogCertificados.getContentPane().setLayout(dialogCertificadosLayout);
        dialogCertificadosLayout.setHorizontalGroup(
            dialogCertificadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCertificadosLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(dialogCertificadosLayout.createSequentialGroup()
                .addGroup(dialogCertificadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogCertificadosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(fieldCodigoValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogCertificadosLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(buttonGerar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEnviarEmail)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        dialogCertificadosLayout.setVerticalGroup(
            dialogCertificadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCertificadosLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCodigoValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogCertificadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGerar)
                    .addComponent(buttonEnviarEmail))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventus");

        panelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Entre"));

        labelLogin.setText("Login:");

        labelSenha.setText("Senha:");

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        labelLoginErro.setForeground(java.awt.Color.red);

        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        buttonCertificados.setText("Certificados");
        buttonCertificados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCertificadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogin)
                    .addComponent(labelSenha))
                .addGap(10, 10, 10)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(fieldLogin)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLoginErro)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(buttonLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonCertificados)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin)
                    .addComponent(fieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha)
                    .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLoginErro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(buttonCadastrar)
                    .addComponent(buttonCertificados))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        buttonLogin.setEnabled(false);
        
        if ( fieldLogin.getText().equals("") || fieldSenha.getPassword().length < 1 ) {
            labelLoginErro.setText("Informe login e senha");
            labelLoginErro.setVisible(true);
        } else {
            Pessoa usuarioLogado = pessoaService.loginUsuario(fieldLogin.getText(), new String(fieldSenha.getPassword()));

            if ( usuarioLogado != null ){
                labelLoginErro.setText("");
                labelLoginErro.setVisible(false);
                
                ParamConfig config = new ParamConfig(usuarioLogado);

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        TelaLogin.this.setVisible(false);
                        new TelaInicial().setVisible(true);
                    }
                });
            } else {
                labelLoginErro.setText("Usuário ou senha incorretos.");
                labelLoginErro.setVisible(true);
            }
        }
        
        buttonLogin.setEnabled(true);
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        dialogCadastrar.setLocationRelativeTo(null);
        dialogCadastrar.setVisible(true);
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonCertificadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCertificadosActionPerformed
        dialogCertificados.setLocationRelativeTo(null);
        dialogCertificados.setVisible(true);
        
        
    }//GEN-LAST:event_buttonCertificadosActionPerformed

    private void buttonInsertSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                usuarioCadastro = new Pessoa();
                
                usuarioCadastro.setNome(fieldNomeUsuario.getText());
                usuarioCadastro.setCpf(fieldCpfUsuario.getText());
                usuarioCadastro.setEmail(fieldEmailUsuario.getText());
                usuarioCadastro.setSenha(new String(fieldSenhaUsuario.getPassword()));
                
                try {
                    usuarioCadastro.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(fieldDataNascimentoUsuario.getText()));
                } catch (ParseException ex) {
                    Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pessoaService.insert(usuarioCadastro);
                
                usuarioCadastro = pessoaService.loginUsuario(usuarioCadastro.getEmail(), usuarioCadastro.getSenha());
                
                ParamConfig config = new ParamConfig(usuarioCadastro);

                fieldNomeUsuario.setText("");
                fieldCpfUsuario.setText("");
                fieldDataNascimentoUsuario.setText("");
                fieldEmailUsuario.setText("");
                fieldSenhaUsuario.setText("");

                dialogCadastrar.dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        TelaLogin.this.setVisible(false);
                        new TelaInicial().setVisible(true);
                    }
                });
            }
        });
    }//GEN-LAST:event_buttonInsertSalvarActionPerformed

    private void buttonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGerarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                String codigo = fieldCodigoValidacao.getText();
                RegistroEvento re = registroEventoService.findByCodigo(codigo);
                
                if ( re != null ) {
                    String text = "Certificamos que "+re.getUsuario().getNome()+" participou do evento "+re.getEvento().getNomeEvento()+". Codigo de validacao: "+codigo;
                    Paragraph para = new Paragraph (text);
                    String dest = "C:/itextExamples/"+codigo+".pdf"; 
                    try {
                        File directory = new File("C:/itextExamples");
                        if (!directory.exists()){
                            directory.mkdir();
                        }
                        
                        PdfWriter writer = new PdfWriter(dest);
                        // Creating a PdfDocument  
                        PdfDocument pdfDoc = new PdfDocument(writer);
                        // Adding an empty page 
                        pdfDoc.addNewPage(); 
                        // Creating a Document   
                        Document document = new Document(pdfDoc); 
                        document.add(para);
                        document.close();
                        
                        SendAttachment sa = new SendAttachment();
                        sa.sendMail(re.getUsuario().getEmail(), dest);
                        JOptionPane.showMessageDialog(rootPane, "PDF gerado em "+dest+" e enviado para o e-mail " + re.getUsuario().getEmail());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_buttonGerarActionPerformed

    private void buttonEnviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarEmailActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                String codigo = fieldCodigoValidacao.getText();
                RegistroEvento re = registroEventoService.findByCodigo(codigo);
                
                
                if ( re != null ) {
                    String text = "Certificamos que "+re.getUsuario().getNome()+" participou do evento "+re.getEvento().getNomeEvento()+". Codigo de validacao: "+codigo;
                    Paragraph para = new Paragraph (text);
                    String dest = "C:/itextExamples/"+codigo+".pdf"; 
                    try {
                        File directory = new File("C:/itextExamples");
                        if (!directory.exists()){
                            directory.mkdir();
                        }
                        
                        PdfWriter writer = new PdfWriter(dest);
                        // Creating a PdfDocument  
                        PdfDocument pdfDoc = new PdfDocument(writer);
                        // Adding an empty page 
                        pdfDoc.addNewPage(); 
                        // Creating a Document   
                        Document document = new Document(pdfDoc); 
                        document.add(para);
                        document.close();              
                        JOptionPane.showMessageDialog(rootPane, "PDF gerado em "+dest);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_buttonEnviarEmailActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonCertificados;
    private javax.swing.JButton buttonEnviarEmail;
    private javax.swing.JButton buttonGerar;
    private javax.swing.JButton buttonInsertSalvar;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JDialog dialogCadastrar;
    private javax.swing.JDialog dialogCertificados;
    private javax.swing.JTextField fieldCodigoValidacao;
    private javax.swing.JTextField fieldCpfUsuario;
    private javax.swing.JTextField fieldDataNascimentoUsuario;
    private javax.swing.JTextField fieldEmailUsuario;
    private javax.swing.JTextField fieldLogin;
    private javax.swing.JTextField fieldNomeUsuario;
    private javax.swing.JPasswordField fieldSenha;
    private javax.swing.JPasswordField fieldSenhaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelLoginErro;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPanel panelLogin;
    // End of variables declaration//GEN-END:variables
}
