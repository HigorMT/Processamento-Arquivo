package com.processamentoarquivoapi.core.utils;

import com.processamentoarquivoapi.domain.entity.xml.FileXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class XmlParse {

    public static FileXml xmlToObj(String stringXml) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(FileXml.class);
            var unmarshaller = context.createUnmarshaller();
            return (FileXml) unmarshaller.unmarshal(new StreamSource(new StringReader(stringXml))
            );
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
