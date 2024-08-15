package aleksey.wallet.service;

import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;
import aleksey.wallet.error.NotFoundException;
import aleksey.wallet.mapper.WalletMapper;
import aleksey.wallet.model.Wallet;
import aleksey.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    @Transactional
    public void updateBalance(WalletRequest request) {
        walletRepository.save(WalletMapper.mapOperation(request, getWallet(request.getValetId())));
    }

    public WalletResponse getBalance(UUID walletUUID) {
        return WalletMapper.getBalance(getWallet(walletUUID));
    }

    private Wallet getWallet(UUID walletUUID) {
        return walletRepository.findById(walletUUID).orElseThrow(
                () -> new NotFoundException("Wallet not found")
        );
    }
}
