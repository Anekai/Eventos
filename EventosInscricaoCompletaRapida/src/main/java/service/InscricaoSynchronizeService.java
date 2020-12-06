
package service;

import dao.InscricaoCompletaDAO;
import dao.InscricaoRapidaDAO;
import entidade.RegistroEventoTemp;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inscricaoSynchronize")
public class InscricaoSynchronizeService {
    
    private InscricaoCompletaDAO inscricaoCompletaDAO;
    private InscricaoRapidaDAO inscricaoRapidaDAO;

    public InscricaoSynchronizeService() {
        inscricaoCompletaDAO = new InscricaoCompletaDAO();
        inscricaoRapidaDAO = new InscricaoRapidaDAO();
    }
    
    @POST
    @Path("/synchronize")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean synchronize(List<RegistroEventoTemp> inscricoesTemp) {
        try {
            boolean result = true;
            
            if ( inscricoesTemp != null && !inscricoesTemp.isEmpty() ) {
                for ( RegistroEventoTemp temp : inscricoesTemp ) {
                    System.out.println("Inscrição temporaria: " + temp);
                    
                    if ( temp.getPresenca() != null ) {
                        result = result && inscricaoCompletaDAO.synchronizeMarcarPresenca(temp);
                    } else {
                        if ( temp.getIdUsuario() != null ) {
                            result = result && inscricaoRapidaDAO.synchronizeInscricaoRapidaWithUsuario(temp);
                        } else {
                            result = result && inscricaoRapidaDAO.synchronizeInscricaoRapidaWithoutUsuario(temp);
                        }
                    }
                }
            } else {
                System.out.println("Nenhuma inscrição recebida!");
            }
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
