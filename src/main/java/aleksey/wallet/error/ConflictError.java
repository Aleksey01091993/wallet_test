package aleksey.wallet.error;

public class ConflictError extends RuntimeException{
    public ConflictError(String message) {
        super(message);
    }
}
