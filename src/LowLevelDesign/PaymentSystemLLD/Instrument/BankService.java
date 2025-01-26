package LowLevelDesign.PaymentSystemLLD.Instrument;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService{

    /* To ensure SRP is followed created two services BankService and UserService
    to deal with Bank specific and card specific logics.
     */

    @Override
    public InstrumentDAO addInstrument(InstrumentDAO instrumentDAO) {
        //bank specific logic here
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentId = new Random().nextInt(100)+10;
        bankInstrument.bankAccountNumber = instrumentDAO.bankAccountNumber;
        bankInstrument.ifscCode = instrumentDAO.ifsc;
        bankInstrument.instrumentType = instrumentDAO.instrumentType;
        bankInstrument.userId = instrumentDAO.userId;

        List<Instrument> userInstrumentsList = userVsInstruments
                .computeIfAbsent(bankInstrument.userId, k -> new ArrayList<>());

        userInstrumentsList.add(bankInstrument);
        return mapBankInstrumentToInstrumentDao(bankInstrument);
    }

    @Override
    public List<InstrumentDAO> getInstrumentsByUserId(int userId) {
        List<Instrument> userInstruments = userVsInstruments.get(userId);
        List<InstrumentDAO> userInstrumentsFetched = new ArrayList<>();

        for(Instrument instrument : userInstruments) {
            if(instrument.getInstrumentType() == InstrumentType.BANK) {
                userInstrumentsFetched.add(mapBankInstrumentToInstrumentDao((BankInstrument) instrument));
            }
        }
        return  userInstrumentsFetched;
    }


    public InstrumentDAO mapBankInstrumentToInstrumentDao(BankInstrument bankInstrument) {
        InstrumentDAO instrumentDAO = new InstrumentDAO();
        instrumentDAO.instrumentType = bankInstrument.instrumentType;
        instrumentDAO.instrumentId = bankInstrument.instrumentId;
        instrumentDAO.bankAccountNumber = bankInstrument.bankAccountNumber;
        instrumentDAO.ifsc = bankInstrument.ifscCode;
        instrumentDAO.userId = bankInstrument.userId;
        return instrumentDAO;
    }


}
