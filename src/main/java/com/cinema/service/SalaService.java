package com.cinema.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.model.Sala;
import com.cinema.repository.SalaDao;
import com.cinema.response.RespuestaPersonalizada;

@Service
public class SalaService {

	@Autowired
	private SalaDao salaDao;

	private static final Logger logger = Logger.getLogger(SalaService.class);

	public ResponseEntity<Object> crearSala(@RequestBody Sala salaNueva) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de la sala con exito", HttpStatus.OK);
			res.setObjetoRespuesta(salaDao.save(salaNueva));
			res.setObjetoRespuesta(salaDao.findById(salaNueva.getId()));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de crear la sala",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> obtenerSalas() {
		ResponseEntity<Object> respuesta;
		try {
			List<Sala> salas = salaDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las salas exitosa", HttpStatus.OK);
			res.setObjetoRespuesta(salas);
			;
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las salas",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> obtenerSalaPelicula(@RequestParam int idPelicula) {
		ResponseEntity<Object> respuesta;
		try {
			List<Sala> salas = salaDao.findByPelicula(idPelicula);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las salas exitosa", HttpStatus.OK);
			res.setObjetoRespuesta(salas);
			;
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las salas",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> modificarSala(@RequestBody Sala sala) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion de la sala exitosa", HttpStatus.OK);
			res.setObjetoRespuesta(salaDao.save(sala));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar la sala",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;

	}

	public ResponseEntity<Object> eliminarSala(@RequestParam Integer id) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("La sala fue eliminada correctamente",
					HttpStatus.OK);
			res.setObjetoRespuesta(salaDao.findById(id));
			salaDao.deleteById(id);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar la sala ",
					HttpStatus.BAD_REQUEST);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}
		return respuesta;
	}

	public void eliminarSalaByPelicula(@RequestParam int idPelicula) {
		Sala salaEliminar = this.salaDao.findByPeliculaminar(idPelicula);
		this.salaDao.delete(salaEliminar);
	}
}
