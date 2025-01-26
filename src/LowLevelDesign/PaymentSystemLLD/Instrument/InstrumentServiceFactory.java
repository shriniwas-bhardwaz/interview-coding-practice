package LowLevelDesign.PaymentSystemLLD.Instrument;

public class InstrumentServiceFactory {
    /* Used to determine whether its a bank operation or a card operation */

    public InstrumentService getInstrumentService(InstrumentType instrumentType) {

        if(instrumentType == InstrumentType.BANK) {
            return  new BankService();
        }
        else if( instrumentType == InstrumentType.CARD) {
            return new CardService();
        }
        return null;
    }
}
