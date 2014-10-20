package hr.infomare.cop.jaxb;

import hr.infomare.cop.opci.Pomocna;

import java.io.File;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class RunJAXBTest {
    public RunJAXBTest() {
        super();
    }

    public static void main(String[] args) {

        File datoteka = new File("C:\\COP\\OP_obrazac.xml");
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(OpObrasci.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            OpObrasci opObrasci = (OpObrasci) unmarshaller.unmarshal(datoteka);            
            
            /*System.err.println("Poslodavac");
            Pomocna.debugObjekta(opObrasci.getPoslodavac());*/
            List<ZaposlenikType> lista = opObrasci.getZaposlenik();
            int i = 1;
            for (ZaposlenikType zaposlenikType : lista) {
                System.err.println("Zaposlenik " + i);
                Pomocna.debugObjekta(zaposlenikType);
                ++i;
            }

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
