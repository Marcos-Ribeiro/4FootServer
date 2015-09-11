package br.com.fourtech.fourfoot.crud;

import java.util.List;

public interface Crud<T> {

	public List<T> getLista();
	public T getObject(Long id);
	public void inserir(T t);
	public void alterar(T t);
	public void deletar(Long id);	
	
}
