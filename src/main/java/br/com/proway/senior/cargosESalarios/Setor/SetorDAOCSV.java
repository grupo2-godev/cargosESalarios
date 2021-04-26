package br.com.proway.senior.cargosESalarios.Setor;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;

public class SetorDAOCSV implements CRUDInterface<Setor>{
	public void Create(Setor obj) {
		
	}

	public Setor Retrieve(String key) {
		return null;
	}
	


	public void Update(Setor obj) {
		
	}

	public void Delete(String key) {
		
	}
	
	public List<String[]> readAll(Reader reader) throws Exception {
	    CSVReader csvReader = new CSVReader(reader);
	    List<String[]> list = new ArrayList<>();
	    list = csvReader.readAll();
	    reader.close();
	    csvReader.close();
	    return list;
	}
	
	public ArrayList<Setor> getAll(){
		return null;
	}
}
