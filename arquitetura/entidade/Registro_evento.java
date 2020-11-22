package Entidade;
import java.util.Date;
import java.io.Serializable;

public class Registro_evento{
	
	private int pessoa_id;
	private int evento_id;
	private String codigo_validacao;
	private boolean presenca;
	public boolean offline;

	public Registro_evento()
	{
	}

	public Registro_evento(String codigo_validacao, boolean presenca, boolean offline);
	{
		this.codigo_validacao = codigo_validacao;
		this.presenca = presenca;
		this.offline = offline;
	}


	public String getCodigo_validacao()
	{
		return codigo_validacao;
	}

	public void setCodigo_validacao(String codigo_validacao)
	{
		this.codigo_validacao = codigo_validacao;
	}

	public Boolean getPresenca()
	{
		return presenca;
	}

	public void setPresenca(boolean Presenca)
	{
		this.presenca = presenca;
	}

	public void getOffline()
	{
		return offline;
	}

	public Boolean setOffline(Boolean offline)
	{
		this.offline = offline;
	}
}