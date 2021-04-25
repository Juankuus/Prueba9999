import java.io.File;

public class Dir {
	private String directorio;
	private File carpeta;
	private File[] archivos;

	public Dir() {
		carpeta = new File(".");
		directorio = ".";
	}

	public Dir(String directorio) {
		this.directorio = directorio;
		if (longitudDirectorio()) {
			carpeta = new File(this.directorio.replace('/', File.separatorChar));
			if (!carpeta.exists()) {
				System.out.println("Ruta no valida, se asigna la del directorio actual.");
				System.out.println("");
				carpeta = new File(".");
				this.directorio = ".";
			}
		} else {
			carpeta = new File(".");
			this.directorio = ".";
		}
	}

	public boolean longitudDirectorio() {
		if (directorio.length() > 0)
			return true;
		else
			return false;
	}

	public void generarArchivos() {
		archivos = new File[carpeta.list().length];
		for (int i = 0; i < archivos.length; i++) {
			File temp = new File(carpeta, carpeta.list()[i]);
			archivos[i] = temp;
		}
	}

	public String generarEspacios(int mayorEspacios) {
		String espacios = "";
		for (int i = 0; i < mayorEspacios; i++) {
			espacios = espacios + " ";
		}
		return espacios;
	}

	public String comprobarNumeroEspacios() {
		int mayorEspacios = 0;

		for (int i = 0; i < archivos.length; i++) {
			if ((Long.toString(archivos[i].length())).length() > mayorEspacios) {
				mayorEspacios = (Long.toString(archivos[i].length())).length();
			}
		}
		return generarEspacios(mayorEspacios);
	}
}
