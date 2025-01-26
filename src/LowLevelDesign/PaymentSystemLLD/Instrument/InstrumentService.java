package LowLevelDesign.PaymentSystemLLD.Instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {

    /* One user can have multiple instruments so I created instrument service*/

    static Map<Integer, List<Instrument>> userVsInstruments = new HashMap<>();

    public abstract  InstrumentDAO addInstrument(InstrumentDAO instrumentDAO);

    public abstract  List<InstrumentDAO> getInstrumentsByUserId(int userId);
}
