package aleksey.wallet.controller;

import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface WalletController {
    @PostMapping("/wallet")
    void updateBalance(@RequestBody @Valid WalletRequest request);

    @GetMapping("/wallets/{uuid}")
    WalletResponse getBalance(@PathVariable UUID uuid);
}
