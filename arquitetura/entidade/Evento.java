/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;
import java.io.Serializable;

public class Evento{
	
	private int id;
	private String tipo_evento;
	private String nome_evento;
	private Date data;


	public Evento()
	{
	}

	public Evento(String tipo_evento, String nome_evento, String email, Date data)
	{
		this.tipo_evento = tipo_evento;
		this.nome_evento = nome_evento;
		this.email = email;
		this.data = data;
	}

	public int getId(){
		return id;
	}

	public void set Id(int id)
	{
		this.id = id;
	}

	public String getTipo_evento()
	{
		return tipo_evento;
	}

	public void setTipo_evento(String tipo_evento)
	{
		this.tipo_evento = tipo_evento;
	}

	public String getNome_evento()
	{
		return nome_evento;
	}

	public void setNome_evento(String nome_evento)
	{
		this.nome_evento = nome_evento;
	}

	public Date getData()
	{
		return data;
	}

	public void setData(Date data)
	{
		this.data = data;
	}
}