package cat.prateducacio.dam.mp06.uf03.p02xml.model.repository;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
class SerialitzacioXmlRepository {

	@Value("${empresas.db.xml}")
	public String DB_EMPRESAS;

	public void serialitza(Object object) {

		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(DB_EMPRESAS);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
		xmlEncoder.writeObject(object);
		xmlEncoder.close();
	}

	public Object deserialitza() {
		Object result = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(DB_EMPRESAS);
		} catch (FileNotFoundException e) {
			// throw new RuntimeException(e);
			result = null;
		}
		if (fileInputStream != null) {
			XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
			result = xmlDecoder.readObject();
			xmlDecoder.close();
		}
		return result;
	}

}
