package com.cinema.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.cinema.model.Pelicula;
import com.cinema.model.Sala;
import com.cinema.repository.PeliculaDao;
import com.cinema.repository.SalaDao;
import com.cinema.response.RespuestaPersonalizada;

@Service
public class PeliculaService {
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	@Autowired
	private SalaService salaService;
	
	
	private static final Logger logger = Logger.getLogger(PeliculaService.class);
	
	public ResponseEntity<Object>crearPelicula(@RequestBody Pelicula pelicula) {
		ResponseEntity<Object> respuesta;
		try {			
			RespuestaPersonalizada res = new RespuestaPersonalizada("Se creó la película con exito", HttpStatus.OK);
			res.setObjetoRespuesta(peliculaDao.save(pelicula));
			res.setObjetoRespuesta(peliculaDao.findById(pelicula.getId()));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de crear la película",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
		
		
	}
	
	public ResponseEntity <Object> obtenerTodasPeliculas(){
		ResponseEntity<Object> respuesta;
		try {
			List<Pelicula> peliculas = peliculaDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las peliculas con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(peliculas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las Peliculas",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
		
	}
	
	public ResponseEntity <Object> obtenerPelicula(@RequestParam int id){
		ResponseEntity<Object> respuesta;
		try {
			List<Pelicula> pelicula =(List) peliculaDao.findById(id);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las peliculas con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(pelicula);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las Peliculas",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
		
	}
	
	public ResponseEntity<Object>modificarPelicula(@RequestBody Pelicula pelicula){
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion de la pelicula exitosa",
					HttpStatus.OK);
			res.setObjetoRespuesta(peliculaDao.save(pelicula));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar la pelicula",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}
	
	public ResponseEntity<Object>eliminarPelicula(@RequestParam int idPelicula) {
		ResponseEntity<Object> respuesta;
		try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("La pelicula fue eliminada correctamente", HttpStatus.OK);
            Pelicula peliculaAEliminar = this.peliculaDao.findById(idPelicula).get(0);
            peliculaDao.delete(peliculaAEliminar);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar la pelicula ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
		
        return respuesta;
	}
	
	

}
