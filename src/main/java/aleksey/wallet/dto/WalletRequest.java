package aleksey.wallet.dto;

import aleksey.wallet.type_operation.Operation;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private UUID valetId;
    @NotNull
    @NotBlank
    private Operation operationType;
    @NotNull
    @NotBlank
    @Positive
    private Integer amount;

}
