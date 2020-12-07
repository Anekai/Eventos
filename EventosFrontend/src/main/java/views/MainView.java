
package views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import configuration.ConexaoBD;
import entities.Evento;
import entities.Pessoa;
import entities.RegistroEvento;
import entities.RegistroEventoTemp;
import framework.CalendarDeserializer;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.RegistroEventoTempService;
import types.SimNaoType;
import types.TipoEventoType;

public class MainView {
    
    public static void main(String[] args) throws IOException {
        
        /*RegistroEventoTempService service = SpringConfig.context.getBean(RegistroEventoTempService.class);

        RegistroEventoTemp entity = new RegistroEventoTemp();

        entity.setId(1);

        service.find(entity);*/
        
        MainView r = new MainView();
        
        //r.postTest();
        //r.getTest();
        //r.postEventoTest();
        //r.getEventoTest();
        //r.postRegistroEventoTest();
        //r.getRegistroEventoTest();
        //r.deleteRegistroEventoTeste();
        //r.synchronizeTest();
        //r.registroEventoTempFindTest();
        //r.registroEventoTeste();
        r.enviarCertificadoEmail();
    }
    
    public void getTest() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/login/loginUsuario/alexandre.klabunde@universo.univates.br/teste123");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String p = response.readEntity(String.class);
        System.out.println(p);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        //List<Pessoa> e = g.fromJson(p, new TypeToken<ArrayList<Pessoa>>(){}.getType());
        
        Pessoa e = g.fromJson(p, Pessoa.class);
        
        if ( e != null ) {
            System.out.println(e.getId());
            System.out.println(e.getNome());
            System.out.println(e.getCpf());
            System.out.println(e.getEmail());
            System.out.println(e.getDataNascimento());
        } else {
            System.out.println("Usuário não encontrado");
        }
        
    }
    
    public void postTest() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        Date data = null;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse("15/03/1996");
        } catch (ParseException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Pessoa obj = new Pessoa(null, "Leandro Augusto", "96314785245", "leandro.augusto@universo.univates.br", data, "teste123");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/cadastrarUsuario");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
    
    public void getEventoTest() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        Evento evento = new Evento(null, "Industria 4.0", null, null);
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/buscarEventos");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(evento, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String r = response.readEntity(String.class);
        System.out.println(r);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        List<Evento> eventos = g.fromJson(r, new TypeToken<ArrayList<Evento>>(){}.getType());
        
        System.out.println(eventos);
    }
    
    public void postEventoTest() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        Date data = null;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020");
        } catch (ParseException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Evento obj = new Evento(null, "Industria 4.0", TipoEventoType.PALESTRA, data);
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/cadastrarEvento");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
    
    public void getRegistroEventoTest() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosConsultaCancelamentoInscricao");
        
        RegistroEvento inscricao = new RegistroEvento(new Pessoa("1 - Alexandre Klabunde"), null, null, null);
        
        WebTarget resourceWebTarget = webTarget.path("rest/consultaInscricao/consultarInscricoes");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(inscricao, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String r = response.readEntity(String.class);
        System.out.println(r);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        List<RegistroEvento> inscricoes = g.fromJson(r, new TypeToken<ArrayList<RegistroEvento>>(){}.getType());
        System.out.println(inscricoes);
    }
    
    public void postRegistroEventoTest() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosInscricaoCompletaRapida");
        
        RegistroEvento inscricao = new RegistroEvento(new Pessoa("1 - Alexandre Klabunde"), new Evento("1 - Indústria 4.0"), SimNaoType.NAO, null);
        
        WebTarget resourceWebTarget = webTarget.path("rest/inscricaoCompleta/inscricaoCompleta");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(inscricao, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }
    
    public void deleteRegistroEventoTeste() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        //WebTarget webTarget = client.target("http://localhost:8080/EventosConsultaCancelamentoInscricao");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cancelamentoInscricao/cancelarInscricao/2/1");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.delete();
        
        System.out.println("Response: " + response.readEntity(String.class));
    }
    
    private void synchronizeTest() {
        Client client = ClientBuilder.newClient();
        
        List<RegistroEventoTemp> inscricoesTemp = new ArrayList<>();
        
        inscricoesTemp.add(new RegistroEventoTemp(1, 7, 1, SimNaoType.SIM, null, null, null));
        inscricoesTemp.add(new RegistroEventoTemp(2, 7, 2, SimNaoType.SIM, null, null, null));

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/synchronize");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(inscricoesTemp, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }
    
    private void registroEventoTempFindTest() {
        for ( RegistroEventoTemp temp : new RegistroEventoTempService().find() ) {
            System.out.println("ID: " + temp.getId());
            System.out.println("ID Usuario: " + temp.getIdUsuario());
            System.out.println("ID Evento: " + temp.getIdEvento());
            System.out.println("Presença: " + temp.getPresenca());
            System.out.println("Nome Usuario: " + temp.getNomeUsuario());
            System.out.println("CPF Usuario: " + temp.getCpfUsuario());
            System.out.println("Email Usuario: " + temp.getEmailUsuario());
        }
    }
    
    private void registroEventoTeste() {
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT * ")
               .append(" FROM   registro_evento_temp ")
               .append(" ORDER BY id_registro_evento_temp ");
            
            ArrayList<RegistroEventoTemp> resultados = new ArrayList<>();
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
            
            while (resultado.next()) {
                RegistroEventoTemp p = new RegistroEventoTemp();

                p.setId(resultado.getInt("id_registro_evento_temp"));
                System.out.println("--- TESTE: " + resultado.getString("id_usuario"));
                p.setIdUsuario(resultado.getInt("id_usuario"));
                p.setIdEvento(resultado.getInt("id_evento"));
                p.setPresenca(resultado.getString("presenca") != null ? SimNaoType.valueOf(resultado.getString("presenca")) : null);
                p.setNomeUsuario(resultado.getString("nome_usuario"));
                p.setCpfUsuario(resultado.getString("cpf_usuario"));
                p.setEmailUsuario(resultado.getString("email_usuario"));
                
                resultados.add(p);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar inscrições temporárias: " + e);
        }
    }
    
    public void enviarCertificadoEmail() {
        Client client = ClientBuilder.newClient();

        //http://177.44.248.90:8080/EventosEnvioEmail-1.0/rest/evento/enviarCertificadoEmail/5123456789005/alexandre.klabunde@universo.univates.br
        WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosEnvioEmail-1.0");
        
        WebTarget resourceWebTarget = webTarget.path("rest/evento/enviarCertificadoEmail/" + "5123456789005" + "/" + "alexandre.klabunde@universo.univates.br");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        System.out.println("Response: " + response.readEntity(String.class));
    }
    
}
