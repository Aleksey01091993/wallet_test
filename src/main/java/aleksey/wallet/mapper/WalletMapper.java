package aleksey.wallet.mapper;

import aleksey.wallet.dto.WalletRequest;
import aleksey.wallet.dto.WalletResponse;
import aleksey.wallet.error.ConflictError;
import aleksey.wallet.model.Wallet;
import aleksey.wallet.status_operation.Operation;


public class WalletMapper {

    public static Wallet mapOperation(WalletRequest request, Wallet wallet) {
        if (request.getOperationType() == Operation.DEPOSIT) {
            wallet.setBalance(wallet.getBalance() + request.getAmount());
        }
        if (request.getOperationType() == Operation.WITHDRAW) {
            if (wallet.getBalance() - request.getAmount() <= 0) {
                throw new ConflictError("there are not enough funds on the balance sheet");
            }
            wallet.setBalance(wallet.getBalance() - request.getAmount());
        }
        return wallet;
    }

    public static WalletResponse getBalance(Wallet wallet) {
        return WalletResponse.builder().balance(wallet.getBalance()).build();
    }
}
