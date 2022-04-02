package org.ersun.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "Pet modeli",description = "Pet sınıfı - POJO")
public class Pet {

    @ApiModelProperty(value = "Pet nesnesinin tekil ID alanı")
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin tekil NAME alanı")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin tekil DATE alanı")
    private Date date;

}
