package com.resonance.view.controller;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class ControladorGrafica {

	private StageR stage;

	private ResonanceHome resonance;

	private Hospedaje hospedaje;

	private int tipo;

	@FXML
	private AnchorPane lComentario;

	@FXML
	private Label lblNombreGrafica;

	@FXML
	private Label lblCalifiación;

	@FXML
	private BarChart<String, Number> grafica;

	
	public void inicializar() 
	{
		
		grafica.getXAxis().setLabel("Estrellas");
		grafica.getYAxis().setLabel("Calificaciones");

		XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number> ();
		
		if (tipo == 0) 
		{
			lblNombreGrafica.setText("Satisfaccion en Limpieza");
			lblCalifiación.setText(hospedaje.obtenerPromedioLimpieza() + "");
			
			dataSeries1.getData().add(new XYChart.Data<>("1 Estrella"   , obtenerCalificacionesLimpieza(1)));
	        dataSeries1.getData().add(new XYChart.Data<>("2 Estrellas"  , obtenerCalificacionesLimpieza(2)));
	        dataSeries1.getData().add(new XYChart.Data<>("3 Estrellas"  , obtenerCalificacionesLimpieza(3)));
	        dataSeries1.getData().add(new XYChart.Data<>("4 Estrellas"  , obtenerCalificacionesLimpieza(4)));
	        dataSeries1.getData().add(new XYChart.Data<>("5 Estrellas"  , obtenerCalificacionesLimpieza(5)));
	        
	        grafica.getData().add(dataSeries1);
	        
		} else if (tipo == 1) {
			lblNombreGrafica.setText("Profesionalismo del Anfitrion");
			lblCalifiación.setText(hospedaje.obtenerPromedioProfesionalismo() + "");
			
			dataSeries1.getData().add(new XYChart.Data<>("1 Estrella"   , obtenerCalificacionesProfesionalismo(1)));
	        dataSeries1.getData().add(new XYChart.Data<>("2 Estrellas"  , obtenerCalificacionesProfesionalismo(2)));
	        dataSeries1.getData().add(new XYChart.Data<>("3 Estrellas"  , obtenerCalificacionesProfesionalismo(3)));
	        dataSeries1.getData().add(new XYChart.Data<>("4 Estrellas"  , obtenerCalificacionesProfesionalismo(4)));
	        dataSeries1.getData().add(new XYChart.Data<>("5 Estrellas"  , obtenerCalificacionesProfesionalismo(5)));
	        
	        grafica.getData().add(dataSeries1);
	        
		} else if (tipo == 2) {
			lblNombreGrafica.setText("Atención del Servicio");
			lblCalifiación.setText(hospedaje.obtenerPromedioAtencion() + "");
			
			dataSeries1.getData().add(new XYChart.Data<>("1 Estrella"   , obtenerCalificacionesAtencion(1)));
	        dataSeries1.getData().add(new XYChart.Data<>("2 Estrellas"  , obtenerCalificacionesAtencion(2)));
	        dataSeries1.getData().add(new XYChart.Data<>("3 Estrellas"  , obtenerCalificacionesAtencion(3)));
	        dataSeries1.getData().add(new XYChart.Data<>("4 Estrellas"  , obtenerCalificacionesAtencion(4)));
	        dataSeries1.getData().add(new XYChart.Data<>("5 Estrellas"  , obtenerCalificacionesAtencion(5)));
	        
	        grafica.getData().add(dataSeries1);
	        
		} else if (tipo == 3) {
			lblNombreGrafica.setText("Satisfaccion de la Ubicacion");
			lblCalifiación.setText(hospedaje.obtenerPromedioUbicacion() + "");
			
			dataSeries1.getData().add(new XYChart.Data<>("1 Estrella"   , obtenerCalificacionesUbicacion(1)));
	        dataSeries1.getData().add(new XYChart.Data<>("2 Estrellas"  , obtenerCalificacionesUbicacion(2)));
	        dataSeries1.getData().add(new XYChart.Data<>("3 Estrellas"  , obtenerCalificacionesUbicacion(3)));
	        dataSeries1.getData().add(new XYChart.Data<>("4 Estrellas"  , obtenerCalificacionesUbicacion(4)));
	        dataSeries1.getData().add(new XYChart.Data<>("5 Estrellas"  , obtenerCalificacionesUbicacion(5)));
	        
	        grafica.getData().add(dataSeries1);
	        
		}
	}

	public int obtenerCalificacionesLimpieza(int estrella)
	{
		int total = 0;
		
		for(int i = 0; i < hospedaje.getCalificaciones().size(); i++)
		{
			if (hospedaje.getCalificaciones().get(i).getLimpieza() == estrella)
			{
				total = total + 1;
			}
		}
		return total;
	}
	
	public int obtenerCalificacionesProfesionalismo(int estrella)
	{
		int total = 0;
		
		for(int i = 0; i < hospedaje.getCalificaciones().size(); i++)
		{
			if (hospedaje.getCalificaciones().get(i).getProfesionalismoAnfitrion() == estrella)
			{
				total++;
			}
		}
		
		return total;
	}
	
	public int obtenerCalificacionesAtencion(int estrella)
	{
		int total = 0;
		
		for(int i = 0; i < hospedaje.getCalificaciones().size(); i++)
		{
			if (hospedaje.getCalificaciones().get(i).getAtencion() == estrella)
			{
				total++;
			}
		}
		
		return total;
	}
	
	public int obtenerCalificacionesUbicacion(int estrella)
	{
		int total = 0;
		
		for(int i = 0; i < hospedaje.getCalificaciones().size(); i++)
		{
			if (hospedaje.getCalificaciones().get(i).getUbicacion() == estrella)
			{
				total++;
			}
		}
		
		return total;
	}
	
	public StageR getStage() {
		return stage;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
