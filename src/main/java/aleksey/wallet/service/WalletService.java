package aleksey.wallet.service;

import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;

import java.util.UUID;

public interface WalletService {

    void updateBalance(WalletRequest request);

    WalletResponse getBalance(UUID walletUUID);
}
