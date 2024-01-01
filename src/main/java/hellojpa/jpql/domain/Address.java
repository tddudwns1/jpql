package hellojpa.jpql.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
