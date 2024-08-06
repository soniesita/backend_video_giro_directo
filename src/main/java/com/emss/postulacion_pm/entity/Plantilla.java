package com.emss.postulacion_pm.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "plantilla",schema = "pre_max_anexo_01")
@AllArgsConstructor
@NoArgsConstructor
public class Plantilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nit;
	
	@Column(name = "razon_social", columnDefinition = "varchar(1200)")
	private String razonSocial;
	
	@Column(name = "numero_docto")
	private String numeroDocto;
	
	@Column(columnDefinition = "varchar(1200)")
	private String notas;
	
	@Column(name = "total_COP", columnDefinition = "numeric(15,2)")
    private BigDecimal totalCOP;
	
	@Column(name = "cuenta_cobro")
	private String cuentaCobro;
	
	@Column(name = "numero_radicado")
	private String numeroRadicado;
	
	@Column(name = "valor_pagar", columnDefinition = "numeric(15,2)")
    private BigDecimal valorPagar;

}