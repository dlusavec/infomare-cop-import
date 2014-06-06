package hr.infomare.cop.app;


import hr.infomare.cop.jaxb.OpObrasci;

import hr.infomare.cop.jaxb.ZaposlenikType;

import java.io.File;

import java.util.Collection;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import hr.infomare.cop.jaxb.*;

public class Run {
    public Run() {
        super();
    }

    public static void main(String[] args) throws JAXBException {
        Forma frm = new Forma();
        frm.setLocationRelativeTo(null);   // da se pokrene u centru ekrana
        frm.show();
        
        

    }
}
