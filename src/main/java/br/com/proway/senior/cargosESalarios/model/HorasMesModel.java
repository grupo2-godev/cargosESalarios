package br.com.proway.senior.cargosESalarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de apoio para persist�ncia via banco de dados. Registra o grau de instru��o e a
 * quantidade de horas trabalhadas por m�s.
 * 
 * @author Lorran P. Santos
 */

@Entity
@Table(name = "horas_mes")
public class HorasMesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idHorasMes;
	private Double quantidade;

	public HorasMesModel() {
	}

	public HorasMesModel(Integer idHorasMes, Double quantidade) {
		this.idHorasMes = idHorasMes;
		this.quantidade = quantidade;
	}
	
	/**
	 * Construtor secundário sem a ID, que é auto
	 * incrementada no banco de dados.
	 * @param quantidade
	 */
	public HorasMesModel(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getIdHorasMes() {
		return idHorasMes;
	}

	public void setIdHorasMes(Integer idHorasMes) {
		this.idHorasMes = idHorasMes;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "HorasMesModel [idHorasMes=" + idHorasMes + ", quantidade=" + quantidade + "]";
	}

}
