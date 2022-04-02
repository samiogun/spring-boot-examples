package org.ersun.model.individual;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ersun.model.address.Address;
import org.ersun.model.identity.Identity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "INDIVIDUAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Individual {

    public Individual(String firstName, String lastName, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }

    public Individual(String firstName, String lastName, List<Address> addresses, Identity identity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.identity = identity;
    }

    @Id
    @SequenceGenerator(name = "SEQ_INDIVIDUALS" , allocationSize = 10)
    @GeneratedValue(generator = "SEQ_INDIVIDUALS" , strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME",length = 30)
    private String firstName;

    @Column(name = "LAST_NAME",length = 30)
    private String lastName;

    @OneToMany(
            mappedBy = "individual",
            fetch = LAZY,
            cascade = ALL
    )
    private List<Address> addresses;

    @OneToOne(
            fetch = EAGER,
            cascade = ALL
    )
    @JoinColumn(
            name = "IDENTITY_NUMBER",
            referencedColumnName = "identityNumber"
    )
    private Identity identity;

}
