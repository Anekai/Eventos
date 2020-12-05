
package views;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import configuration.ParamConfig;
import entities.Evento;
import entities.Pessoa;
import entities.RegistroEvento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.EventoService;
import services.PessoaService;
import services.RegistroEventoService;
import types.SimNaoType;

public class TelaInscricao extends javax.swing.JDialog {

    private RegistroEvento entitySearch;
    private RegistroEvento entity;
    private List<Evento> eventos;
    
    private final RegistroEventoService registroEventoService;
    private final PessoaService pessoaService;
    private final EventoService eventoService;
    
    public TelaInscricao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        registroEventoService = new RegistroEventoService();
        pessoaService = new PessoaService();
        eventoService = new EventoService();
        
        entitySearch = new RegistroEvento();
        
        loadEventos();
        
        fieldSearchIdUsuario.setText(new ParamConfig().getUsuarioLogado().getId().toString());
        fieldSearchNomeUsuario.setText(new ParamConfig().getUsuarioLogado().getNome());
        
        comboSearchEvento.removeAllItems();
        
        comboSearchEvento.addItem("");
        
        if ( eventos == null || eventos.isEmpty() ) {
            eventos = new ParamConfig().getEventos();
        }
        
        for ( Evento evento : eventos ) {
            comboSearchEvento.addItem(evento.getNomeEvento());
        }
        
        /*fieldSearchIdUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldSearchIdUsuario.getText().equals("") ) {
                    entitySearch.setUsuario(pessoaService.findById(Integer.valueOf(fieldSearchIdUsuario.getText())));
                } else {
                    entitySearch.setUsuario(null);
                }
                
                if ( entitySearch.getUsuario() != null ) {
                    fieldSearchNomeUsuario.setText(entitySearch.getUsuario().getNome());
                    fieldSearchIdEvento.requestFocus();
                } else {
                    fieldSearchNomeUsuario.setText("");
                    fieldSearchIdUsuario.requestFocus();
                }
            }
        });
        
        fieldSearchIdEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldSearchIdEvento.getText().equals("") ) {
                    entitySearch.setEvento(eventoService.findById(Integer.valueOf(fieldSearchIdEvento.getText())));
                } else {
                    entitySearch.setEvento(null);
                }
                
                if ( entitySearch.getEvento()!= null ) {
                    fieldSearchNomeEvento.setText(entitySearch.getEvento().getNomeEvento());
                    buttonPesquisar.requestFocus();
                } else {
                    fieldSearchNomeEvento.setText("");
                    fieldSearchIdEvento.requestFocus();
                }
            }
        });
        
        fieldUpdateIdUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldUpdateIdUsuario.getText().equals("") ) {
                    entity.setUsuario(pessoaService.findById(Integer.valueOf(fieldUpdateIdUsuario.getText())));
                } else {
                    entity.setUsuario(null);
                }
                
                if ( entity.getUsuario() != null ) {
                    fieldUpdateNomeUsuario.setText(entity.getUsuario().getNome());
                    fieldUpdateIdEvento.requestFocus();
                } else {
                    fieldUpdateNomeUsuario.setText("");
                    fieldUpdateIdUsuario.requestFocus();
                }
            }
        });
        
        fieldInsertIdEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !fieldInsertIdEvento.getText().equals("") ) {
                    entity.setEvento(eventoService.findById(Integer.valueOf(fieldInsertIdEvento.getText())));
                } else {
                    entity.setEvento(null);
                }
                
                if ( entity.getEvento()!= null ) {
                    fieldInsertNomeEvento.setText(entity.getEvento().getNomeEvento());
                    buttonInsertSalvar.requestFocus();
                } else {
                    fieldInsertNomeEvento.setText("");
                    fieldInsertIdEvento.requestFocus();
                }
            }
        });*/
    }
    
    private void load() {
        entitySearch.setUsuario(new ParamConfig().getUsuarioLogado());
        
        if (comboSearchEvento.getSelectedIndex() != 0) {
            entitySearch.setEvento(eventos.get(comboSearchEvento.getSelectedIndex()-1));
        }
        
        populateTable(registroEventoService.find(entitySearch));
        
        entitySearch = new RegistroEvento();
    }
    
    private void loadEventos() {
        eventos = eventoService.find();
    }
    
    private void populateTable(List<RegistroEvento> list) {
        DefaultTableModel model = (DefaultTableModel) tableInscricao.getModel();
        Object rowData[] = new Object[5];
        model.setRowCount(0);
        
        for ( RegistroEvento registroEvento : list ) {
            rowData[0] = registroEvento.getUsuario().getId() + " - " + registroEvento.getUsuario().getNome();
            rowData[1] = registroEvento.getEvento().getId() + " - " + registroEvento.getEvento().getNomeEvento();

            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogInsert = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        fieldInsertIdUsuario = new javax.swing.JTextField();
        buttonInsertSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fieldInsertNomeUsuario = new javax.swing.JTextField();
        comboInsertEvento = new javax.swing.JComboBox<>();
        dialogUpdate = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        fieldUpdateIdUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldUpdateIdEvento = new javax.swing.JTextField();
        fieldUpdatePresenca = new javax.swing.JTextField();
        fieldUpdateNomeUsuario = new javax.swing.JTextField();
        fieldUpdateNomeEvento = new javax.swing.JTextField();
        buttonGerarCertificado = new javax.swing.JButton();
        buttonCancelarInscricao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldUpdateCodigoValidacao = new javax.swing.JTextField();
        buttonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInscricao = new javax.swing.JTable();
        fieldSearchIdUsuario = new javax.swing.JTextField();
        buttonPesquisar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        fieldSearchNomeUsuario = new javax.swing.JTextField();
        comboSearchEvento = new javax.swing.JComboBox<>();

        dialogInsert.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInsert.setTitle("Inscrever-se");
        dialogInsert.setModal(true);
        dialogInsert.setResizable(false);
        dialogInsert.setSize(new java.awt.Dimension(360, 200));

        jLabel6.setText("Usuário:");

        fieldInsertIdUsuario.setEditable(false);
        fieldInsertIdUsuario.setFocusable(false);

        buttonInsertSalvar.setText("Salvar");
        buttonInsertSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("Evento:");

        fieldInsertNomeUsuario.setEditable(false);
        fieldInsertNomeUsuario.setFocusable(false);

        javax.swing.GroupLayout dialogInsertLayout = new javax.swing.GroupLayout(dialogInsert.getContentPane());
        dialogInsert.getContentPane().setLayout(dialogInsertLayout);
        dialogInsertLayout.setHorizontalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addComponent(buttonInsertSalvar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dialogInsertLayout.createSequentialGroup()
                                .addComponent(fieldInsertIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldInsertNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboInsertEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        dialogInsertLayout.setVerticalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldInsertIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldInsertNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboInsertEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(buttonInsertSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogUpdate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogUpdate.setTitle("Atualizar Inscrição");
        dialogUpdate.setModal(true);
        dialogUpdate.setResizable(false);
        dialogUpdate.setSize(new java.awt.Dimension(440, 300));

        jLabel4.setText("Usuário:");

        fieldUpdateIdUsuario.setEditable(false);
        fieldUpdateIdUsuario.setFocusable(false);

        jLabel10.setText("Evento:");

        jLabel11.setText("Presença:");

        fieldUpdateIdEvento.setEditable(false);
        fieldUpdateIdEvento.setFocusable(false);

        fieldUpdatePresenca.setEditable(false);
        fieldUpdatePresenca.setFocusable(false);

        fieldUpdateNomeUsuario.setEditable(false);
        fieldUpdateNomeUsuario.setFocusable(false);

        fieldUpdateNomeEvento.setEditable(false);
        fieldUpdateNomeEvento.setFocusable(false);

        buttonGerarCertificado.setText("Gerar Certificado");
        buttonGerarCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGerarCertificadoActionPerformed(evt);
            }
        });

        buttonCancelarInscricao.setText("Cancelar Inscrição");
        buttonCancelarInscricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarInscricaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Código:");

        fieldUpdateCodigoValidacao.setFocusable(false);

        javax.swing.GroupLayout dialogUpdateLayout = new javax.swing.GroupLayout(dialogUpdate.getContentPane());
        dialogUpdate.getContentPane().setLayout(dialogUpdateLayout);
        dialogUpdateLayout.setHorizontalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fieldUpdateIdEvento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(fieldUpdateIdUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldUpdateNomeEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(fieldUpdateNomeUsuario)))
                            .addComponent(fieldUpdatePresenca)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addComponent(buttonCancelarInscricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGerarCertificado))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogUpdateLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(fieldUpdateCodigoValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 122, Short.MAX_VALUE))
        );
        dialogUpdateLayout.setVerticalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldUpdateIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldUpdateNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fieldUpdateIdEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldUpdateNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(fieldUpdatePresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldUpdateCodigoValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGerarCertificado)
                    .addComponent(buttonCancelarInscricao))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscrições");

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário:");

        jLabel2.setText("Evento:");

        tableInscricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Evento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInscricao.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableInscricao);
        if (tableInscricao.getColumnModel().getColumnCount() > 0) {
            tableInscricao.getColumnModel().getColumn(0).setResizable(false);
            tableInscricao.getColumnModel().getColumn(1).setResizable(false);
        }

        fieldSearchIdUsuario.setFocusable(false);

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        fieldSearchNomeUsuario.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldSearchIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldSearchNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboSearchEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldSearchIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSearchNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboSearchEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPesquisar)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new RegistroEvento();
                
                entity.setUsuario(new Pessoa((String) tableInscricao.getValueAt(tableInscricao.getSelectedRow(), 0)));
                entity.setEvento(new Evento((String) tableInscricao.getValueAt(tableInscricao.getSelectedRow(), 1)));
                
                entity = registroEventoService.find(entity).get(0);

                fieldUpdateIdUsuario.setText(String.valueOf(entity.getUsuario().getId()));
                fieldUpdateNomeUsuario.setText(entity.getUsuario().getNome());
                fieldUpdateIdEvento.setText(String.valueOf(entity.getEvento().getId()));
                fieldUpdateNomeEvento.setText(entity.getEvento().getNomeEvento());
                fieldUpdatePresenca.setText(entity.getPresenca().getValue());
                fieldUpdateCodigoValidacao.setText(entity.getCodigoValidacao());
                
                dialogUpdate.setLocationRelativeTo(null);
                dialogUpdate.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        load();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new RegistroEvento();

                fieldInsertIdUsuario.setText(new ParamConfig().getUsuarioLogado().getId().toString());
                fieldInsertNomeUsuario.setText(new ParamConfig().getUsuarioLogado().getNome());
                
                comboInsertEvento.removeAllItems();
        
                for ( Evento evento : eventos ) {
                    comboInsertEvento.addItem(evento.getNomeEvento());
                }

                dialogInsert.setLocationRelativeTo(null);
                dialogInsert.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonInsertSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setUsuario(new ParamConfig().getUsuarioLogado());
                entity.setEvento(eventos.get(comboInsertEvento.getSelectedIndex()));
                entity.setPresenca(SimNaoType.NAO);
                entity.setCodigoValidacao(null);
                
                registroEventoService.inscricaoCompleta(entity);
                
                fieldInsertIdUsuario.setText("");
                fieldInsertNomeUsuario.setText("");
                
                dialogInsert.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonInsertSalvarActionPerformed

    private void buttonGerarCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGerarCertificadoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                String codigo = fieldUpdateCodigoValidacao.getText();
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
    }//GEN-LAST:event_buttonGerarCertificadoActionPerformed

    private void buttonCancelarInscricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarInscricaoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                registroEventoService.delete(entity);
                
                fieldUpdateIdUsuario.setText("");
                fieldUpdateNomeUsuario.setText("");
                fieldUpdateIdEvento.setText("");
                fieldUpdateNomeEvento.setText("");
                
                dialogUpdate.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonCancelarInscricaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInscricao dialog = new TelaInscricao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelarInscricao;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonGerarCertificado;
    private javax.swing.JButton buttonInsertSalvar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JComboBox<String> comboInsertEvento;
    private javax.swing.JComboBox<String> comboSearchEvento;
    private javax.swing.JDialog dialogInsert;
    private javax.swing.JDialog dialogUpdate;
    private javax.swing.JTextField fieldInsertIdUsuario;
    private javax.swing.JTextField fieldInsertNomeUsuario;
    private javax.swing.JTextField fieldSearchIdUsuario;
    private javax.swing.JTextField fieldSearchNomeUsuario;
    private javax.swing.JTextField fieldUpdateCodigoValidacao;
    private javax.swing.JTextField fieldUpdateIdEvento;
    private javax.swing.JTextField fieldUpdateIdUsuario;
    private javax.swing.JTextField fieldUpdateNomeEvento;
    private javax.swing.JTextField fieldUpdateNomeUsuario;
    private javax.swing.JTextField fieldUpdatePresenca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInscricao;
    // End of variables declaration//GEN-END:variables
}
