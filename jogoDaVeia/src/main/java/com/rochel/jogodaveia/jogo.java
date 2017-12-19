
import com.rochel.jogodaveia.jogoVelha;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RGR-PC
 */

@Path("jogo")
public class jogo {
    
    static jogoVelha jogo = new jogoVelha();
    
    @GET
    @Path("jogar")
    public String jogar (@QueryParam("posicao") String jogada){
        return jogo.jogar(jogada);
    }
    
    @GET
    @Path("verifica")
    public String verificar(){
        return jogo.verEstado();
    }
    
    @GET
    @Path("resetar")
    public String resetar(){
        return jogo.resetarJogo();
    }
    
}
