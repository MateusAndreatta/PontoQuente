package com.example.pontoquente.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    // TODO: Ver questão do request especificar o id do produto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String site_id;
    public String title;
    public long id_integracao;
    public String subtitle;
    @JsonProperty("seller_id")
    public long sellerId;
    public Float price;
    public Float base_price;
    public Float original_price;
    public String currency_id;
    public int initial_quantity;
    public int available_quantity;
    public Date start_time;
    public Date stop_time;
    @Column(name="condicao")
    public String condition;
    public String permalink;

    @OneToOne
    public SellerAddress seller_address;

    public String seller_contact;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Attribute> attributes;

}
