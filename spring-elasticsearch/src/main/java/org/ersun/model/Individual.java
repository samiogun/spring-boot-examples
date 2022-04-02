package org.ersun.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

import static org.springframework.data.elasticsearch.annotations.DateFormat.basic_date;
import static org.springframework.data.elasticsearch.annotations.FieldType.Date;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(indexName = "individuals")
@Getter
@Setter
public class Individual {

    @Id
    private String id;

    @Field(name = "ad",type = Text)
    private String ad;

    @Field(name = "soyad",type = Text)
    private String soyad;

    @Field(name = "adres",type = Text)
    private String adres;

    @Field(name = "dogum_tarihi",type = Date,format = basic_date,pattern = "dd/MM/uuuu")
    private Date dogumTarihi;

}
