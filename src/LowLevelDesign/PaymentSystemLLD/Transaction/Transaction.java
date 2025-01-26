package LowLevelDesign.PaymentSystemLLD.Transaction;


public class Transaction {

    int amount;
    int transactionId;
    int senderId;
    int receiverId;
    int debitInstrumentId;
    int creditInstrumentId;
    TransactionStatus status;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getDebitInstrumentId() {
        return debitInstrumentId;
    }

    public void setDebitInstrumentId(int debitInstrumentId) {
        this.debitInstrumentId = debitInstrumentId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getCreditInstrumentId() {
        return creditInstrumentId;
    }

    public void setCreditInstrumentId(int creditInstrumentId) {
        this.creditInstrumentId = creditInstrumentId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
