package hr.infomare.cop.jaxb;

import hr.infomare.cop.opci.Pomocna;

import java.io.File;

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
            System.err.println("Poslodavac");
            Pomocna.debugObjekta(opObrasci.getPoslodavac());
            System.err.println("Zaposlenik 1");
            Pomocna.debugObjekta(opObrasci.getZaposlenik().get(0));
            System.err.println("Zaposlenik 2");
            Pomocna.debugObjekta(opObrasci.getZaposlenik().get(1));            
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
