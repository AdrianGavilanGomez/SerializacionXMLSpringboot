package cat.prateducacio.dam.mp06.uf03.p02xml.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.prateducacio.dam.mp06.uf03.p02xml.model.domain.Empresa;
import cat.prateducacio.dam.mp06.uf03.p02xml.model.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@PostMapping("/add")
	public ResponseEntity<?> addEmpresa(@RequestBody Empresa empresa) {

		ResponseEntity<?> result = null;

		try {
			empresaService.add(empresa);
			result = ResponseEntity.status(HttpStatus.OK).body(empresa);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	@PutMapping("/upd")
	public ResponseEntity<?> updEmpresa(@RequestBody Empresa empresa) {

		ResponseEntity<?> result = null;

		try {
			empresaService.update(empresa);
			result = ResponseEntity.status(HttpStatus.OK).body(empresa);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	@DeleteMapping("/delete/{cif}")
	public ResponseEntity<?> updEmpresa(@PathVariable String cif) {

		ResponseEntity<?> result = null;

		try {
			empresaService.delete(cif);
			result = ResponseEntity.status(HttpStatus.OK).body("Empresa eliminada");
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {

		ResponseEntity<?> result = null;

		try {
			List<Empresa> empresas = empresaService.getAll();
			result = ResponseEntity.status(HttpStatus.OK).body(empresas);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}

	@GetMapping("/getOne/{cif}")
	public ResponseEntity<?> getByCif(@PathVariable String cif) {

		ResponseEntity<?> result = null;

		try {
			Empresa empresa = empresaService.getByCif(cif);

			if (empresa != null) {
				result = ResponseEntity.status(HttpStatus.OK).body(empresa);
			} else {
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La empresa amb CIF " + cif + " no existeix.");
			}
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}

}
