package com.yosr.vetements.dto;

import java.util.Date;

import com.yosr.vetements.entities.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetementDTO {
		private Long idVet;
		private String nomVet;
		private Double prix;
		private Date dateCreation;
		private Genre genre;
		private String nomGen ; 
		
}
