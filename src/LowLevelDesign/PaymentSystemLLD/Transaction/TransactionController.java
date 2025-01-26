package LowLevelDesign.PaymentSystemLLD.Transaction;

import java.util.List;

public class TransactionController {

    TransactionService transactionService;

    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    public TransactionDAO makePayment(TransactionDAO transactionDAO) {
        return  transactionService.makePayment(transactionDAO);
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return transactionService.getTransactionHistory(userId);
    }
}
