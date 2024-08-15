package aleksey.wallet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletResponse {
    private Long balance;
}
