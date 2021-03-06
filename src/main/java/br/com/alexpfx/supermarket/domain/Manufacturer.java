package br.com.alexpfx.supermarket.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexandre on 12/12/2015.
 */
@Entity
@Table(name = "tb_fabricante")
public class Manufacturer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String name;

    public Manufacturer() {
    }

    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
