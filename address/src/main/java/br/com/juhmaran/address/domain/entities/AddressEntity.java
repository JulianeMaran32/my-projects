package br.com.juhmaran.address.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class AddressEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "street", length = 150)
    private String street;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "complement", length = 150)
    private String complement;

    @Column(name = "neighborhood", length = 100)
    private String neighborhood;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "state_abbreviation", length = 2)
    private String stateAbbreviation;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "user_id", nullable = false)
    private Long userId;

}
