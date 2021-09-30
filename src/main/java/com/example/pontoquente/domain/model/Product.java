package com.example.pontoquente.domain.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String site_id;
    public String title;
    public int id_integracao;
    public String subtitle;
    public int seller_id;
    public int price;
    public int base_price;
    public int original_price;
    public String currency_id;
    public int initial_quantity;
    public int available_quantity;
    public Date start_time;
    public Date stop_time;
    public String condition;
    public String permalink;

    @OneToOne
    public SellerAddress seller_address;

    public String seller_contact;

    @OneToMany
    public List<Attribute> attributes;

}
