package org.ersun.model.address;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdresTip {

        EV_ADRESI(1,"Ev adresi"),
        IS_ADRESI(2,"İş adresi"),
        DIGER(3,"Diğer Adres");

        private final int value;
        private final String description;

}