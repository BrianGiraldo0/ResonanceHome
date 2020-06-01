package com.resonance.model.txt;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.resonance.model.archivos.FileManager;
import com.resonance.model.hospedajes.Reserva;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Factura {

	private String anfitrion;
	private String huesped;
	private Reserva reserva;
	private Tarjeta tarjeta;
	private File facturaURL;
	private String nombreAnfitrion;
	private String emailAnfitrion;
	private String nombreHuesped;
	private double precioComision;
	private double precioCompleto;
	private double precioLimpieza;
	

	private static String ruta;
	private static String rutaImagen;
	private static String cabecera;
	private static String contenido;
	private static String piePagina;
	
	private static Font fuenteBold = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
	private static Font fuenteNormal = new Font(Font.FontFamily.COURIER, 14, Font.NORMAL);
	private static Font fuenteItalic = new Font(Font.FontFamily.COURIER, 12, Font.BOLDITALIC);
	
	/**
	 * Metodo constructor
	 * @param anfitrion
	 * @param huesped
	 * @param reserva
	 * @param tarjeta
	 */
	public Factura(String anfitrion, String huesped, Reserva reserva, Tarjeta tarjeta) {
		super();
		this.anfitrion = anfitrion;
		this.huesped = huesped;
		this.reserva = reserva;
		this.tarjeta = tarjeta;
//		this.facturaURL = new File(FileManager.urlMain + "/Usuarios/Huespedes/Facturas" + huesped+".pdf");
		ruta = FileManager.urlMain + "/Usuarios/Huespedes/" + huesped + "/Facturas/";
		

	
	}
	
	/**
	 * Metodo para generar el pdf de la factura.
	 */
	public void crearPDF()
	{
		if (!new File(ruta).exists())
			(new File(ruta)).mkdirs();

		File[] files = (new File(ruta)).listFiles();
		String ruta = "";
		if (files.length == 0) {
			ruta = this.ruta + huesped + "0" + ".pdf";
		} else {
			String path = files[files.length - 1].getAbsolutePath();
			String num = path.substring(path.length() - 5, path.length() - 4);

			ruta = this.ruta + huesped + (Integer.parseInt(num) + 1) + ".pdf";
		}

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		
		cabecera = "\n"+"Resonance Home" + "\n"+ 
                "Armenia, Quindio" +  "\n" + 
                "Colombia" +  "\n\n" + 
				"Fecha " + reserva.getFecha().toString() + "\n\n\n";
		contenido = "Reserva de hospedaje: "+ reserva.getHospedaje().getId() +  "\n" +  
             	"Titulo del Hospedaje: " + reserva.getHospedaje().getTitulo() + " " + "\n" +
             	"Dirección: " + reserva.getHospedaje().getDireccion().getDireccion() + ", " +  reserva.getHospedaje().getDireccion().toString() + "\n" +
				"Anfitrion: " + nombreAnfitrion + "\n" + "Correo: " + emailAnfitrion + "\n\n\n" + "Huesped: "
				+ nombreHuesped + "\n" +
             	"Metodo de pago: " + reserva.getTarjeta().getNumeroT() + " Tarjeta de credito" + "\n\n" +
             	formato.format(reserva.getFechaInicial()) + " hasta "+ formato.format(reserva.getFechaFinal()) +"\n\n" +
             	"Descripcion															valor" + "\n\n" + 
				"Huespedes" + "															  "
				+ reserva.getNumeroHuespedes() + "\n" +
				"Alojamiento" + "													  " + precioCompleto + "\n"
				+ "Tarifa de limpieza" + "				   	 " + precioLimpieza + "\n" + "Comision por servicio"
				+ "					" + precioComision + "\n\n";
		piePagina = "TOTAL " + "              " + "$ " + reserva.getValor() + "\n"    ;
		
		try {
			FileOutputStream archivo = new FileOutputStream(ruta);
			Document doc = new Document(PageSize.A5, 10, 10, 10, 10);
			PdfWriter.getInstance(doc, archivo);
			doc.open();
			doc.add(obtenerCabecera(cabecera));
			doc.add(obtenerContenido(contenido));
			doc.add(obtenerPiePagina(piePagina));
			doc.close();
			this.ruta = ruta;
		}
		catch (Exception e) {
			System.out.println("" +  e);
		}

	}
	
	/**
	 * Método que obtiene la cabecera
	 * @param texto
	 * @return
	 */
	private static Paragraph obtenerCabecera(String texto)
	{
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_LEFT);
		c.append(texto);
		c.setFont(fuenteItalic);
		p.add(c);
		
		return p;
	}
	
	/**
	 * Metodo que obtiene el contenido
	 * @param texto
	 * @return
	 */
	private static Paragraph obtenerContenido(String texto)
	{
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_LEFT);
		c.append(texto);
		c.setFont(fuenteNormal);
		p.add(c);
		
		return p;
	}
	
	/**
	 * Metodo que obtine el pie de pagina
	 * @param texto
	 * @return
	 */
	private static Paragraph obtenerPiePagina(String texto)
	{
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_LEFT);
		c.append(texto);
		c.setFont(fuenteBold);
		p.add(c);
		
		return p;
	}
	
	public static String getRuta() {
		return ruta;
	}

	/*
	 * incio de getters and setters
	 */
	
	public String getAnfitrion() {
		return anfitrion;
	}

	public void setAnfitrion(String anfitrion) {
		this.anfitrion = anfitrion;
	}

	public String getHuesped() {
		return huesped;
	}

	public void setHuesped(String huesped) {
		this.huesped = huesped;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	public File getFacturaURL()
	{
		return facturaURL;
	}

	/**
	 * @return the nombreAnfitrion
	 */
	public String getNombreAnfitrion() {
		return nombreAnfitrion;
	}

	/**
	 * @param nombreAnfitrion the nombreAnfitrion to set
	 */
	public void setNombreAnfitrion(String nombreAnfitrion) {
		this.nombreAnfitrion = nombreAnfitrion;
	}

	/**
	 * @return the precioComision
	 */
	public double getPrecioComision() {
		return precioComision;
	}

	/**
	 * @param precioComision the precioComision to set
	 */
	public void setPrecioComision(double precioComision) {
		this.precioComision = precioComision;
	}

	/**
	 * @return the precioCompleto
	 */
	public double getPrecioCompleto() {
		return precioCompleto;
	}

	/**
	 * @param precioCompleto the precioCompleto to set
	 */
	public void setPrecioCompleto(double precioCompleto) {
		this.precioCompleto = precioCompleto;
	}

	/**
	 * @return the precioLimpieza
	 */
	public double getPrecioLimpieza() {
		return precioLimpieza;
	}

	/**
	 * @param precioLimpieza the precioLimpieza to set
	 */
	public void setPrecioLimpieza(double precioLimpieza) {
		this.precioLimpieza = precioLimpieza;
	}

	/**
	 * @return the emailAnfitrion
	 */
	public String getEmailAnfitrion() {
		return emailAnfitrion;
	}

	/**
	 * @param emailAnfitrion the emailAnfitrion to set
	 */
	public void setEmailAnfitrion(String emailAnfitrion) {
		this.emailAnfitrion = emailAnfitrion;
	}

	/**
	 * @return the nombreHuesped
	 */
	public String getNombreHuesped() {
		return nombreHuesped;
	}

	/**
	 * @param nombreHuesped the nombreHuesped to set
	 */
	public void setNombreHuesped(String nombreHuesped) {
		this.nombreHuesped = nombreHuesped;
	}

	/*
	 * fin de getters and setters
	 */
	
	
}
