package com.cinema.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.model.Pelicula;
import com.cinema.model.Reserva;
import com.cinema.model.Sala;
import com.cinema.model.Silla;
import com.cinema.model.Usuario;
import com.cinema.repository.ReservaDao;
import com.cinema.repository.SalaDao;
import com.cinema.repository.SillaDao;
import com.cinema.repository.UsuarioDao;
import com.cinema.response.RespuestaPersonalizada;

@Service
public class ReservaService {

	@Autowired
	private ReservaDao reservaDao;

	@Autowired
	private SalaDao salaDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private SillaDao sillaDao;
	private static final Logger logger = Logger.getLogger(ReservaService.class);

	/*
	 * public ResponseEntity<Object>crearReserva(@RequestBody Reserva reserva){
	 * ResponseEntity<Object> respuesta; try { RespuestaPersonalizada res = new
	 * RespuestaPersonalizada("Se creó la reserva con exito", HttpStatus.OK);
	 * res.setObjetoRespuesta(reservaDao.save(reserva));
	 * reserva.setPelicula(reserva.getSala().getPelicula().getTitulo());
	 * reserva.setSilla(reserva.getSala().getSilla().get(reserva.getSilla()).
	 * getnumeroSilla()); respuesta = ResponseEntity.ok(HttpStatus.OK); respuesta =
	 * new ResponseEntity<>(res, HttpStatus.OK); } catch (Exception e) {
	 * logger.error(e); respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	 * respuesta = new
	 * ResponseEntity<>("Disculpa tenemos un error tratando de crear la reserva",
	 * HttpStatus.BAD_REQUEST);
	 * 
	 * } return respuesta;
	 * 
	 * 
	 * }
	 */

	public Reserva crearReserva(@RequestBody Reserva reserva) {
		Usuario user = usuarioDao.findById(reserva.getUsuario().getId());
		Sala sala = salaDao.findById(reserva.getSala().getId()).get(0);
		reserva.setPelicula(sala.getPelicula().getTitulo());
		reserva.setHora(sala.getPelicula().getHora());
		List<Silla> sillas = reserva.getSilla();
		for (Silla silla : sillas) {
			silla = sillaDao.getById(silla.getId());
			silla.setEstadoSilla(false);
		}
		reservaDao.save(reserva);
		return reservaDao.findById(reserva.getId()).get(0);
	}

	public Reserva eliminarReserva(@RequestParam int idReserva) {

		Reserva ReservaEliminar = (reservaDao.findById(idReserva).get(0));
		List<Silla> sillas = ReservaEliminar.getSilla();
		for (Silla silla : sillas) {
			silla = sillaDao.getById(silla.getId());
			silla.setEstadoSilla(true);
		}
		reservaDao.deleteById((int) ReservaEliminar.getId());
		return ReservaEliminar;

	}

	/*
	 * public ResponseEntity<Object>eliminarReserva(@RequestParam Reserva
	 * ReservaEliminar){ ResponseEntity<Object> respuesta; try {
	 * RespuestaPersonalizada res = new
	 * RespuestaPersonalizada("La reserva fue eliminada correctamente",
	 * HttpStatus.OK);
	 * res.setObjetoRespuesta(reservaDao.findById(ReservaEliminar.getId()));
	 * respuesta= ResponseEntity.ok(HttpStatus.OK); respuesta = new
	 * ResponseEntity<>(res, HttpStatus.OK); reservaDao.deleteById((int)
	 * ReservaEliminar.getId()); } catch (Exception e) { RespuestaPersonalizada res
	 * = new RespuestaPersonalizada("Error al eliminar la reserva ",
	 * HttpStatus.BAD_REQUEST); respuesta=
	 * ResponseEntity.ok(HttpStatus.BAD_REQUEST); respuesta = new
	 * ResponseEntity<>(res, HttpStatus.BAD_REQUEST); } return respuesta; }
	 */

	public ResponseEntity<Object> obtenerTodasReservas() {
		ResponseEntity<Object> respuesta;
		try {
			List<Reserva> reservas = reservaDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de las reservas con éxito",
					HttpStatus.OK);
			res.setObjetoRespuesta(reservas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las Reservas",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> obtenerReserva(@RequestParam int idUser) {
		ResponseEntity<Object> respuesta;
		try {
			List<Reserva> reserva = reservaDao.FindByIdUser(idUser);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de la reserva con éxito", HttpStatus.OK);
			res.setObjetoRespuesta(reserva);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar la reserva",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public ResponseEntity<Object> obtenerReservaId(@RequestParam int idReserva) {
		ResponseEntity<Object> respuesta;
		try {
			List<Reserva> reserva = reservaDao.findById(idReserva);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de la reserva con éxito", HttpStatus.OK);
			res.setObjetoRespuesta(reserva);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar la reserva",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

	public Reserva modificarReserva(@RequestBody Reserva reserva) {
		Sala sala = salaDao.findById(reserva.getSala().getId()).get(0);
		reserva.setPelicula(sala.getPelicula().getTitulo());
		reserva.setHora(sala.getPelicula().getHora());
		List<Silla> sillaModificar = reserva.getSilla();
		List<Silla> sillasReserva = new ArrayList<Silla>();
		for (Silla silla : sillaModificar) {
			Silla silla1 = sillaDao.getById(silla.getId());
			if (silla.isEstadoSilla() == false) {
				sillasReserva.add(silla);
			}
			if (silla.isEstadoSilla() != silla1.isEstadoSilla()) {				
				silla1.setEstadoSilla(silla.isEstadoSilla());
				sillaDao.save(silla1);
			}

		}
		if (sillasReserva.size() > 0) {
			reserva.getSilla().clear();
			for (Silla silla : sillasReserva) {
				reserva.getSilla().add(silla);
			}
		}

		reservaDao.save(reserva);
		return reservaDao.findById(reserva.getId()).get(0);
	}

	public ResponseEntity<Object> reservaByPelicula(@RequestParam int idPelicula) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de la reserva exitosa", HttpStatus.OK);
			res.setObjetoRespuesta(reservaDao.findByidSala(this.salaDao.findByPelicula(idPelicula).get(0).getId()));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar reservas",
					HttpStatus.BAD_REQUEST);

		}
		return respuesta;
	}

}
