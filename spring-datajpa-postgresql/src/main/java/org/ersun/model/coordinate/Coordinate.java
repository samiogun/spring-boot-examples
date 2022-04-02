package org.ersun.model.coordinate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COORDINATE")
@NoArgsConstructor
@Getter
@Setter
public class Coordinate {

    @Id
    @SequenceGenerator(name = "SEQ_COORDINATE" , allocationSize = 10)
    @GeneratedValue(generator = "SEQ_COORDINATE",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    public Coordinate(double longitude, double latitude){

        this.longitude = longitude;
        this.latitude = latitude;

    }

}
