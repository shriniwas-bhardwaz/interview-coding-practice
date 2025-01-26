package LowLevelDesign.PaymentSystemLLD;

import LowLevelDesign.PaymentSystemLLD.Instrument.InstrumentController;
import LowLevelDesign.PaymentSystemLLD.Instrument.InstrumentDAO;
import LowLevelDesign.PaymentSystemLLD.Instrument.InstrumentType;
import LowLevelDesign.PaymentSystemLLD.Transaction.Transaction;
import LowLevelDesign.PaymentSystemLLD.Transaction.TransactionController;
import LowLevelDesign.PaymentSystemLLD.Transaction.TransactionDAO;
import LowLevelDesign.PaymentSystemLLD.User.UserController;
import LowLevelDesign.PaymentSystemLLD.User.UserDAO;

import java.util.List;

public class PaymentGateway {

    public static void main(String[] args) {

        InstrumentController instrumentController = new InstrumentController();
        UserController userController = new UserController();
        TransactionController transactionController = new TransactionController();

        //1. add USER1
        UserDAO user1 = new UserDAO();
        user1.setName("Ak");
        user1.setMail("Abc@gmail.com");
        UserDAO user1Details = userController.addUser(user1);

        //1. add USER2
        UserDAO user2 = new UserDAO();
        user2.setName("Rk");
        user2.setMail("rac@gmail.com");
        UserDAO user2Details = userController.addUser(user2);

        // add bank to User1
        InstrumentDAO bankInstrumentDao = new InstrumentDAO();
        bankInstrumentDao.setBankAccountNumber("21123231");
        bankInstrumentDao.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDao.setUserId(user1Details.getUserId());
        bankInstrumentDao.setIfsc("ER234");
        InstrumentDAO user1BankInstrument = instrumentController.addInstrument(bankInstrumentDao);
        System.out.println("Bank Instrument created for User1: " + user1BankInstrument.getInstrumentId());


        // add Card to User2
        InstrumentDAO cardInstrumentDao = new InstrumentDAO();
        cardInstrumentDao.setCardNumber("23123123");
        cardInstrumentDao.setInstrumentType(InstrumentType.CARD);
        cardInstrumentDao.setCvv("234");
        cardInstrumentDao.setUserId(user2Details.getUserId());
        InstrumentDAO user2CardInstrument = instrumentController.addInstrument(cardInstrumentDao);
        System.out.println("Card Instrument created for User2: " + user2CardInstrument.getInstrumentId());


        // make Payment
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.setAmount(10);
        transactionDAO.setSenderId(user1Details.getUserId());
        transactionDAO.setReceiverId(user2Details.getUserId());
        transactionDAO.setDebitInstrumentId(user1BankInstrument.getInstrumentId());
        transactionDAO.setCreditInstrumentId(user2CardInstrument.getInstrumentId());
        transactionController.makePayment(transactionDAO);

        // get All instruments of User1
        List<InstrumentDAO> user1Instruments = instrumentController.getAllInstruments(user1Details.getUserId());
        for(InstrumentDAO instrumentDAO : user1Instruments) {
            System.out.println("User1 InstID: " + instrumentDAO.getInstrumentId()
                            + " : UserID: "+  instrumentDAO.getUserId() +
                            " : Instrumnet Type: " + instrumentDAO.getInstrumentType().name());
        }

        // get All instruments of User2
        List<InstrumentDAO> user2Instruments = instrumentController.getAllInstruments(user2Details.getUserId());
        for(InstrumentDAO instrumentDAO : user2Instruments) {
            System.out.println("User2 InstID: " + instrumentDAO.getInstrumentId()
                    + " : UserID: "+  instrumentDAO.getUserId() +
                    " : Instrumnet Type: " + instrumentDAO.getInstrumentType().name());
        }

        //get All transaction history
        List<Transaction> user1TransactionList = transactionController.getTransactionHistory(user1Details.getUserId());
        for (Transaction transaction : user1TransactionList) {
            System.out.println("User1 txnId: "+ transaction.getTransactionId()
                        + " : Amount: "+transaction.getAmount()
                        + " : receiver: " + transaction.getReceiverId());
        }
    }
}
