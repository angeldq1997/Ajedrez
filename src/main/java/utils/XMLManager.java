package utils;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
public class XMLManager {

    /**
     * Función que permite escribir en un xml los datos de una clase para almacenarlos
     * @param t objeto concreto
     * @param fileName Nombre del archivo a almacenar
     * @return Devuelve TRUE si se ha guardado y FALSE si no se ha podido
     * @param <T> Genérico de clase a devolver
     */
    public static <T> boolean writeXML(T t , String fileName){
        boolean isWritten = false;
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(t , new File(fileName));
            isWritten = true;

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return isWritten;
    }

    /**
     * Función que permite cargar de un xml los datos de una clase para reasignarlos a otra clase
     * @param t objeto concreto
     * @param fileName Nombre del archivo a almacenar
     * @return Devuelve TRUE si se ha cargado y FALSE si no se ha podido
     * @param <T> Genérico de clase a devolver
     */
    public static <T> T readXML(T t,String fileName){
        T result = t;
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            result = (T) unmarshaller.unmarshal(new File(fileName));


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}