/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rochel.jogodaveia;

/**
 *
 * @author RGR-PC
 */
public class jogoVelha {
    
    static tabela tabuleiro = new tabela();
    static int vez = 1;
    static boolean comecou = true;
    static boolean primJogada = true;
    
    public String resetarJogo() {
        tabuleiro = new tabela();
        tabuleiro.resetarTab();
        tabuleiro.jogadas = 0;
        vez = 1;
        comecou = true;
        primJogada = true;
        return "<h1><center>Jogo da Velha</center></h1><br>"
                + "<br><br>" + tabuleiro.exibiTab();
    }
    
    public String mudarJogador(){
        if(vez == 1){
            tabuleiro.jogador = "x";
            vez++;
        }
        else{
            tabuleiro.jogador = "o";
            vez = 1;
        }
        return tabuleiro.jogador;
    }
    
    public String verEstado(){
        if(tabuleiro.ganhou(tabuleiro.jogadas) != null){
            return tabuleiro.ganhou(tabuleiro.jogadas) +
                    tabuleiro.exibiTab();
        }
        return "<h1>Nenhum ganhado!<h1></br>"
                + tabuleiro.exibiTab();
    }
    public String mostraTabAtualizado(String jogada){
        if(tabuleiro.ganhou(tabuleiro.jogadas) == null){
            if(tabuleiro.validar(jogada) == false){
                return "<h2>jogada incorreta<h2>";
            }else{
                mudarJogador();
                tabuleiro.jogar(jogada, tabuleiro.jogador);
            }
        }
        return "<h1>"+tabuleiro.exibiTab()+"<h1>";
    }
    
    public String jogar (String jogada){
        
        if(primJogada){
            primJogada = false;
            return mostraTabAtualizado(jogada);
        }
        if(tabuleiro.ganhou(tabuleiro.jogada) == null){
            return mostraTabAtualizado(jogada);
        }
        return tabuleiro.exibiTab() + "<h1>Acabou o jogo!<h1>";
    }

}
