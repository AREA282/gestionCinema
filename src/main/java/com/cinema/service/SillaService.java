package com.cinema.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.model.Silla;
import com.cinema.repository.SillaDao;
import com.cinema.response.RespuestaPersonalizada;

@Service
public class SillaService {
	
	@Autowired
	private SillaDao sillaDao;
	
	private static final Logger logger = Logger.getLogger(SillaService.class); 
	
	public ResponseEntity<Object>crearSilla(@RequestBody Silla silla){
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Se guardó el asiento con exito", HttpStatus.OK);
			res.setObjetoRespuesta(sillaDao.save(silla));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de guardar el asiento en la sala",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}
	
	public ResponseEntity<Object> eliminarSilla(@RequestParam int idSilla){
		ResponseEntity<Object> respuesta;
		try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("El asiento fue eliminado correctamente", HttpStatus.OK);
            res.setObjetoRespuesta(sillaDao.findById(idSilla));
            sillaDao.deleteById(idSilla);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el asiento ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
	}
	
	public ResponseEntity<Object>obtenerSillasDisponibles(){
		ResponseEntity<Object> respuesta;
		try {
			List<Silla> sillas = sillaDao.sillasDisponibles();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las sillas disponibles exitosa",
					HttpStatus.OK);
			res.setObjetoRespuesta(sillas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las sillas disponibles",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}
	
	public ResponseEntity<Object>obtenerSillasSala(long idSala){
		ResponseEntity<Object> respuesta;
		try {
			List<Silla> sillas = sillaDao.sillasSala(idSala);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las sillas disponibles exitosa",
					HttpStatus.OK);
			res.setObjetoRespuesta(sillas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las sillas disponibles",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}
	
	public Boolean eliminarTodas(long idPelicula) {
		
		List<Silla>sillasEliminar = this.sillaDao.sillasPelicula(idPelicula);
		for (Silla sillaEli : sillasEliminar) {
			this.sillaDao.delete(sillaEli);
		}
		return true;
	}
	
	/*public List<Silla> obtenerSillasDisponibles(){
		return sillaDao.sillasDisponibles();
	}*/

}
