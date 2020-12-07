
package service;

import apoio.ConexaoBD;
import apoio.SendAttachment;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import dao.EventoDAO;
import entidade.Evento;
import entidade.Pessoa;
import entidade.RegistroEvento;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import types.SimNaoType;

@Path("/evento")
public class EventoService {
    
    EventoDAO dao;
    
    public EventoService(){
        dao = new EventoDAO();
    }
    
    @GET
    @Path("/teste")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean teste(){
        return true;
    }
    
    @GET
    @Path("/enviarCertificadoEmail/{codigoValidacao}/{email}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public RegistroEvento enviarCertificadoEmail(@PathParam("codigoValidacao") String codigovalidacao, @PathParam("email") String email){
        RegistroEvento registro = new RegistroEvento();
        StringBuilder sql = new StringBuilder();
            
        sql.append(" SELECT re.* ")
           .append(" ,      p.nome AS nome_pessoa ")
           .append(" ,      e.nome_evento ")
           .append(" ,      p.email ")
           .append(" FROM   registro_evento re ")
           .append(" INNER JOIN pessoa p ON re.pessoa_id = p.id ")
           .append(" INNER JOIN evento e ON re.evento_id = e.id ")
           .append(" WHERE  re.codigo_validacao = '" + codigovalidacao + "' ");
            
        try {
            
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
                    
            while (resultado.next()) {
                registro = new RegistroEvento();

                registro.setUsuario(new Pessoa(resultado.getInt("pessoa_id"), resultado.getString("nome_pessoa"), resultado.getString("email")));
                registro.setEvento(new Evento(resultado.getInt("evento_id"), resultado.getString("nome_evento")));
                registro.setPresenca(SimNaoType.valueOf(resultado.getString("presenca")));
                registro.setCodigoValidacao(resultado.getString("codigo_validacao"));
            }
                
            if ( registro.getEvento() != null ) {
                String text = "Certificamos que " + registro.getUsuario().getNome() + " participou do evento " + registro.getEvento().getNomeEvento() + ". Codigo de validacao: " + codigovalidacao;
                Paragraph para = new Paragraph (text);
                String dest = Files.createTempFile(null, ".pdf").toString();
                        
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
                sa.sendMail(email, dest, registro.getUsuario().getNome() + "_" + codigovalidacao + ".pdf");
                
                System.out.println("PDF gerado em " + dest + " e enviado para o e-mail " + registro.getUsuario().getEmail());
                
                registro.setRetorno("Email enviado!");
                
                return registro;
            } else {
                System.out.println("Código de validação inválido!");
                registro.setRetorno("Código de validação inválido!");
                
                return registro;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar inscrições: " + ex);
            registro.setRetorno("Erro ao buscar inscrições: " + ex);
            return registro;
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao enviar email: " + ex);
            
            ex.printStackTrace();
            
            registro.setRetorno("Erro ao enviar email: " + ex);
            return registro;
        } catch (IOException ex) {
            System.out.println("Erro ao criar certificado: " + ex);
            
            ex.printStackTrace();
            
            registro.setRetorno("Erro ao criar certificado: " + ex);
            return registro;
        }
    }
    
}
