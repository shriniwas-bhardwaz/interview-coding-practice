package LowLevelDesign.PaymentSystemLLD.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService{
    @Override
    public InstrumentDAO addInstrument(InstrumentDAO instrumentDAO) {
        //Card specific logic here
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.instrumentId = new Random().nextInt(100)+10;
        cardInstrument.cardNumber = instrumentDAO.cardNumber;
        cardInstrument.cvvNumber = instrumentDAO.cvv;
        cardInstrument.instrumentType = InstrumentType.CARD;
        cardInstrument.userId = instrumentDAO.userId;

        List<Instrument> userInstrumentsList = userVsInstruments
                .computeIfAbsent(cardInstrument.userId, k -> new ArrayList<>());

        userInstrumentsList.add(cardInstrument);
        return mapCardInstrumentToInstrumentDao(cardInstrument);
    }

    @Override
    public List<InstrumentDAO> getInstrumentsByUserId(int userId) {
        List<Instrument> userInstruments = userVsInstruments.get(userId);
        List<InstrumentDAO> userInstrumentsFetched = new ArrayList<>();

        for(Instrument instrument : userInstruments) {
            if(instrument.getInstrumentType() == InstrumentType.CARD) {
                userInstrumentsFetched.add(mapCardInstrumentToInstrumentDao((CardInstrument) instrument));
            }
        }
        return  userInstrumentsFetched;
    }


    public InstrumentDAO mapCardInstrumentToInstrumentDao(CardInstrument cardInstrument) {
        InstrumentDAO instrumentDAO = new InstrumentDAO();
        instrumentDAO.instrumentType = cardInstrument.instrumentType;
        instrumentDAO.instrumentId = cardInstrument.instrumentId;
        instrumentDAO.cardNumber = cardInstrument.cardNumber;
        instrumentDAO.cvv = cardInstrument.cvvNumber;
        instrumentDAO.userId = cardInstrument.userId;
        return instrumentDAO;
    }
}
