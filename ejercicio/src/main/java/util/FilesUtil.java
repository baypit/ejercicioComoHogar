package util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilesUtil {

	/**
	 * 
	 * @return
	 * @throws StreamReadException
	 * @throws DatabindException
	 * @throws IOException
	 */
	public static List<Beneficio> leerArchivoSK() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			//Path del archivo JSON
			String path = "C:\\Users\\BPS\\Documents\\GitHub\\ejercicioComoHogar\\ejercicio\\src\\main\\resources\\data\\sk_formato.json";
			Community c = objectMapper.readValue(new File(path), Community.class);
			return c.beneficios;
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
		}
		return null;
				

	}
	
	public static List<Beneficio> leerArchivoTH() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			//Path del archivo JSON
			String path = "C:\\Users\\BPS\\Documents\\GitHub\\ejercicioComoHogar\\ejercicio\\src\\main\\resources\\data\\th_formato.json";
			Community c = objectMapper.readValue(new File(path), Community.class);
			return c.beneficios;
		} catch (Exception e) {
			System.out.println("Error "+ e.getMessage());
		}
		return null;
				

	}

	public static class Community {
		private List<Beneficio> beneficios;

		public List<Beneficio> getBeneficios() {
			return beneficios;
		}

		public void setBeneficios(List<Beneficio> beneficios) {
			this.beneficios = beneficios;
		}

	}

	public static class Beneficio {

		public String name;
		

		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "sk_formato [ beneficio=" + name + "]";
		}

	}

}
