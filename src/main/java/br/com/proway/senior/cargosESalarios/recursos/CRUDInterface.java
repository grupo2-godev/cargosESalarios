package br.com.proway.senior.cargosESalarios.recursos;

import java.util.ArrayList;

<<<<<<< Updated upstream
import br.com.proway.senior.cargosESalarios.Cargo.Cargo;

=======
/**
 * Interface para implementa��o de CRUD nas classes DAO do sistema.
 * Cont�m os m�todos Create, Retrive, Update, Delete e getAll.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grij�, Samuel Levi 
 * @param <T> Generics, utilize uma classe de entidade.
 */
>>>>>>> Stashed changes
public interface CRUDInterface<T> {

	public void Create(T obj);

<<<<<<< Updated upstream
	public T Retrieve(int id);
=======
	public T Retrieve(int  id);
>>>>>>> Stashed changes

	public void Update(T obj);

	public void Delete(int id);
	
	public ArrayList<T> getAll();

}
