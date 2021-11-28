package pl.pp.store.store.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="store_keepers")
public class StoreKeeper extends User {

    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = false)
    private Store store;
}
