package aleksey.wallet.dto;

import aleksey.wallet.status_operation.Operation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequest {
    @NotNull
    private UUID valetId;
    @NotNull
    private Operation operationType;
    @NotNull
    @Positive
    private Integer amount;

}
