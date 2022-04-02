package org.ersun.model.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ersun.model.coordinate.Coordinate;
import org.ersun.model.individual.Individual;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_ADDRESS" , allocationSize = 10)
    @GeneratedValue(generator = "SEQ_ADDRESS" , strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADDRESS",length = 200)
    private String address;

    @Enumerated
    private AdresTip adresTip;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "COORDINATE_ID",referencedColumnName = "id")
    private Coordinate coordinate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INDIVIDUAL_ID")
    private Individual individual;

    public Address(String address, AdresTip adresTip, Coordinate coordinate){
        this.address = address;
        this.adresTip = adresTip;
        this.isActive = true;
        this.coordinate = coordinate;
    }

    public Address(String address, AdresTip adresTip, Coordinate coordinate, Individual individual){
        this.address = address;
        this.adresTip = adresTip;
        this.isActive = true;
        this.individual = individual;
        this.coordinate = coordinate;
    }

}
