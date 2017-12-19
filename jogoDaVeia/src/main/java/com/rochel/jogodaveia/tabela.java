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
public class tabela {
    
    static String jogador;
    static int jogadas = 0;
    static String[][] tabela = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    int jogada;
    
    public String resetarTab() {
        String tabResetada = "";

        tabela[0][0] = "1";
        tabela[0][1] = "2";
        tabela[0][2] = "3";
        tabela[1][0] = "4";
        tabela[1][1] = "5";
        tabela[1][2] = "6";
        tabela[2][0] = "7";
        tabela[2][1] = "8";
        tabela[2][2] = "9";

        tabResetada += tabela;

        return tabResetada;
    }

    public String exibiTab() {
        String tabelaExibir = "";
        tabelaExibir += "<table style='top:50%;left:50%>";
        for (int l = 0; l < 3; l++) {
            tabelaExibir += "<tr>";
            for (int c = 0; c < 3; c++) {
                tabelaExibir += "<td>" + tabela[l][c] + "</td>";
            }
            tabelaExibir += tabelaExibir + "</tr>";
        }

        return tabelaExibir;
    }

    public boolean validar(String posicao) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                if (tabela[l][c].equals(posicao)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void jogar(String posicao, String jogador) {
        if (posicao.equals("1")) {
            tabela[0][0] = jogador;
        } else if (posicao.equals("2")) {
            tabela[0][1] = jogador;
        } else if (posicao.equals("3")) {
            tabela[0][2] = jogador;
        } else if (posicao.equals("4")) {
            tabela[1][0] = jogador;
        } else if (posicao.equals("5")) {
            tabela[1][1] = jogador;
        } else if (posicao.equals("6")) {
            tabela[1][2] = jogador;
        } else if (posicao.equals("7")) {
            tabela[2][0] = jogador;
        } else if (posicao.equals("8")) {
            tabela[2][1] = jogador;
        } else if (posicao.equals("9")) {
            tabela[2][2] = jogador;
        }
        jogadas++;
    }

    public String ganhou(int jogadas) {
        String[] resultados = new String[8];
        String vencedor = null;
        if (jogadas == 9) {
            vencedor = "<h1><center>A velha Ganhou!</center></h1>";
        }
        resultados[0] = tabela[0][0] + tabela[0][1] + tabela[0][2];
        resultados[1] = tabela[1][0] + tabela[1][1] + tabela[1][2];
        resultados[2] = tabela[2][0] + tabela[2][1] + tabela[2][2];

        resultados[3] = tabela[0][0] + tabela[1][0] + tabela[2][0];
        resultados[4] = tabela[0][1] + tabela[1][1] + tabela[2][1];
        resultados[5] = tabela[0][2] + tabela[1][2] + tabela[2][2];

        resultados[6] = tabela[0][0] + tabela[1][1] + tabela[2][2];
        resultados[7] = tabela[0][2] + tabela[1][1] + tabela[2][0];

        for (int i = 0; i < resultados.length; i++) {
            if (resultados[i].equals("xxx")) {
                vencedor = "<h1><center>O jogador do X Ganhou!</center></h1>";
            } else if (resultados[i].equals("ooo")) {
                vencedor = "<h1><center>O jogador do O Ganhou!</center></h1>";
            }
        }

        return vencedor;

    }
    
}
