package LowLevelDesign.PaymentSystemLLD.Transaction;

import LowLevelDesign.PaymentSystemLLD.Instrument.InstrumentController;
import LowLevelDesign.PaymentSystemLLD.Instrument.InstrumentDAO;

import java.util.*;

public class TransactionService {

    public static Map<Integer, List<Transaction>> userVsTransactionList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return  userVsTransactionList.get(userId);
    }

    public TransactionDAO makePayment(TransactionDAO transactionDAO) {
        InstrumentDAO senderInstrumentDao = instrumentController.getInstrumentById(transactionDAO.senderId,transactionDAO.getDebitInstrumentId());
        InstrumentDAO receiverInstrumentDao = instrumentController.getInstrumentById(transactionDAO.receiverId,transactionDAO.getCreditInstrumentId());

        processor.processPayment(senderInstrumentDao,receiverInstrumentDao);
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDAO.getAmount());
        transaction.setTransactionId(new Random().nextInt(100) + 10);
        transaction.setSenderId(transactionDAO.getSenderId());
        transaction.setReceiverId(transactionDAO.getReceiverId());
        transaction.setDebitInstrumentId(transactionDAO.getDebitInstrumentId());
        transaction.setCreditInstrumentId(transactionDAO.getCreditInstrumentId());
        transaction.setStatus(TransactionStatus.SUCCESS);

        List<Transaction> senderTransactionList = userVsTransactionList.get(transaction.getSenderId());
        if(senderTransactionList == null) {
            senderTransactionList = new ArrayList<>();
            userVsTransactionList.put(transaction.getSenderId(),senderTransactionList);
        }
        senderTransactionList.add(transaction);

        List<Transaction> receiverTransactionList = userVsTransactionList.get(transaction.getReceiverId());
        if(receiverTransactionList == null) {
            receiverTransactionList = new ArrayList<>();
            userVsTransactionList.put(transaction.getReceiverId(),receiverTransactionList);
        }
        receiverTransactionList.add(transaction);

        transactionDAO.setTransactionId(transaction.getTransactionId());
        transactionDAO.setStatus(transaction.getStatus());
        return transactionDAO;

    }
}
