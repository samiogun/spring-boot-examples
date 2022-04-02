package org.ersun.model.identity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ersun.model.individual.Individual;

import javax.persistence.*;

@Entity
@Table(name = "IDENTITY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Identity {

    @Id
    private long identityNumber;

    @OneToOne(
            fetch = FetchType.LAZY
//            mappedBy = "identityNumber"
    )
    @JoinColumn(
            name = "INDIVIDUAL_ID",
            referencedColumnName = "id"
    )
    private Individual individual;

}
