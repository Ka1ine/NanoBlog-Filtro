package com.programem.consulta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity /*Indica que o banco de dados deve criar uma tabela para esse objeto*/
public class Dependente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer id;
    String nome;
    Integer idade;
    String endereco;

    public void setId(Integer id){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public Integer getIdade(){
        return this.idade;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return this.endereco;
    }
}
