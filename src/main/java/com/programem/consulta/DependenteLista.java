package com.programem.consulta;

public class DependenteLista {
    String Dependentelista (Iterable<Dependente> lista){
        String html = "";
        for(Dependente d : lista){
            html = html +
            "<h1>"+
            d.getNome()+"</h1>"+
            d.getIdade()+"<br>"+
            d.getEndereco()+"<br>"+
            "<br>"
            ;
        }
        return html;
    }
}