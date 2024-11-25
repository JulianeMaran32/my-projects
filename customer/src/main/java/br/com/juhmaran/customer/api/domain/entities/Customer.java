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
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @PrePersist
    @PreUpdate
    public void processarCpf() {
        this.cpf = CpfUtil.removeMask(this.cpf);
    }

}
