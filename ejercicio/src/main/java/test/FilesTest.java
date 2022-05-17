package test;

import java.util.List;

import util.FilesUtil;
import util.FilesUtil.Beneficio;

public class FilesTest {


	public static void main(String[] args) {
		//List<Beneficio> beneficios = FilesUtil.leerArchivoSK();
		List<Beneficio> beneficios = FilesUtil.leerArchivoTH();

		for (Beneficio b : beneficios) {

			System.out.println(b);

		}
	}

}
