package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Pessoa extends PanacheEntity {

    public String nome;
    public String anoNascimento;

    public static List<Pessoa> findByAnoNascimento(int ano){
        return find("anoNascimento", ano).list();
    }
}
