package aleksey.wallet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "wallet")
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(name = "balance")
    private Long balance;
}
