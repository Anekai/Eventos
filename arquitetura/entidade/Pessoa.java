package Entidade;

public class Pessoa{
	
	private int id;
	private String cpf;
	private String nome;
	private String email;
	private Date data_nasc;
	private boolean offline;
	private String senha;

	public Pessoa()
	{
	}

	public Pessoa(String cpf, String nome, String email, Date data_nasc)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.data_nasc = data_nasc;
	}

	public int getId(){
		return id;
	}

	public void set Id(int id)
	{
		this.id = id;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Date getData_nasc()
	{
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc)
	{
		this.data_nasc = data_nasc;
	}

	public Boolean getOffline()
	{
		return offline;
	}

	public void setOffline(boolean Offline)
	{
		this.offline = offline;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String senha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

}