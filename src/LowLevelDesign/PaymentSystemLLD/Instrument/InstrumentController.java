package LowLevelDesign.PaymentSystemLLD.Instrument;

import java.util.List;

public class InstrumentController {

    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController() {
        this.instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public InstrumentDAO addInstrument(InstrumentDAO instrumentDAO) {
        InstrumentService instrumentService = instrumentServiceFactory
                .getInstrumentService(instrumentDAO.getInstrumentType());

        return  instrumentService.addInstrument(instrumentDAO);
    }

    public List<InstrumentDAO> getAllInstruments(int userId) {
        InstrumentService bankInstrumentController = instrumentServiceFactory
                .getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentController = instrumentServiceFactory
                .getInstrumentService(InstrumentType.CARD);
        List<InstrumentDAO> instrumentDAOList = bankInstrumentController.getInstrumentsByUserId(userId);
        instrumentDAOList.addAll(cardInstrumentController.getInstrumentsByUserId(userId));
        return instrumentDAOList;
    }

    public InstrumentDAO getInstrumentById(int userId, int instrumentId) {
        List<InstrumentDAO> instrumentDAOList = getAllInstruments(userId);
        for(InstrumentDAO instrumentDAO : instrumentDAOList) {
            if(instrumentDAO.getInstrumentId() == instrumentId) {
                return instrumentDAO;
            }
        }
        return null;
    }
}
