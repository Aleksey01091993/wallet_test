package aleksey.wallet.controller;


import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;
import aleksey.wallet.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/wallet")
    public void updateBalance(@RequestBody @Valid WalletRequest request) {
        log.info("Пришел POST запрос api/v1/wallet с телом: {}", request);
        walletService.updateBalance(request);
        log.info("Отправлен ответ 200 без тела");
    }

    @GetMapping("/wallets/{uuid}")
    public WalletResponse getBalance(@PathVariable UUID uuid) {
        log.info("Пришел GET запрос /api/v1/wallets/{}", uuid);
        final WalletResponse response = walletService.getBalance(uuid);
        log.info("Отправлен ответ для GET запроса /api/v1/wallets/{} с телом: {}", uuid, response);
        return response;
    }


}
