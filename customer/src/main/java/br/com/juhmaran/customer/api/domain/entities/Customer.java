package br.com.juhmaran.customer.api.domain.entities;

import br.com.juhmaran.customer.core.util.CpfUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(name = "uk_customers_email", columnNames = {"email"}),
        @UniqueConstraint(name = "uk_customers_phone_number", columnNames = {"phone_number"}),
        @UniqueConstraint(name = "uk_customers_document_number", columnNames = {"document_number"})
})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "document_number", nullable = false, unique = true, length = 11)
    private String documentNumber;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @PrePersist
    @PreUpdate
    public void processarCpf() {
        this.documentNumber = CpfUtil.removeMask(this.documentNumber);
    }

}
