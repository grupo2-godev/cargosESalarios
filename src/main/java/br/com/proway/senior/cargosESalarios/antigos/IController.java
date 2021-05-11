package br.com.proway.senior.cargosESalarios.antigos;

public interface IController<T> {

	public Integer cadastrarObj(String nome);

	public boolean deletarObj(Integer id);

	public boolean atualizarObj(Integer id, String nome);

	public T buscarTodosObjetos();

	public T buscarObj(Integer id);

}
