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
@Table(name = "pago_soportado_factura",schema = "pre_max_anexo_01")
@AllArgsConstructor
@NoArgsConstructor
public class PagoSoportadoFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nit;
	
	@Column(name = "razon_social", columnDefinition = "varchar(1200)")
	private String razonSocial;
	
	@Column(name = "valor_posible_pago")
	private BigDecimal valorPosiblePago;
}
