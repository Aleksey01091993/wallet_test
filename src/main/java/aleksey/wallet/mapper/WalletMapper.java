package aleksey.wallet.mapper;

import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;
import aleksey.wallet.model.Wallet;
import aleksey.wallet.type_operation.Operation;

public class WalletMapper {

    public static Wallet mapOperation(WalletRequest request, Wallet wallet) {
        if (request.getOperationType() == Operation.DEPOSIT) {
            wallet.setBalance(wallet.getBalance() + request.getAmount());
        }
        if (request.getOperationType() == Operation.WITHDRAW) {
            wallet.setBalance(wallet.getBalance() - request.getAmount());
        }
        return wallet;
    }

    public static WalletResponse getBalance(Wallet wallet) {
        return WalletResponse.builder().balance(wallet.getBalance()).build();
    }
}
