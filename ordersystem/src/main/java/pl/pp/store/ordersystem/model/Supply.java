package pl.pp.store.ordersystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "supplies")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 10, nullable = false)
    private String code;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;
    private Long quantity;
    @Column(length = 6, nullable = false)
    private String targetStoreCode;
    private Date arrivalDate;
    private Boolean isAccepted;

}
