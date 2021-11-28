package pl.pp.store.store.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="suppliers")
public class Supplier extends User {

    @Id
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Supply> suppliesList;
    private String companyName;
}
