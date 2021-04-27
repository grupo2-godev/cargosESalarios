package br.com.proway.senior.cargosESalarios.Setor;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import br.com.proway.senior.cargosESalarios.recursos.CRUDInterface;

// TO-DO
public class SetorDaoCsv implements CRUDInterface<Setor> {
	
	String uri = "../classes/br/com/proway/senior/cargosESalarios/recursos/cargos.csv";
	
	public void create(Setor obj) {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(uri).toURI()));
			List<String[]> escrita = readAll(reader);
			 
			String[] palavras = { obj.getId().toString(), obj.getNomeSetor(), obj.getCapacidade().toString(), obj.getIdPermissao().toString()};
			escrita.add(palavras);

			Path path = Paths.get(ClassLoader.getSystemResource(uri).toURI());
			this.csvWriterOneByOne(escrita, path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Setor retrieve(int id) {
		return null;
	}

	public void update(Setor obj) {

	}

	public void delete(int id) {

	}

	public ArrayList<Setor> getAll() {
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(uri).toURI()));
		List<String[]> minhaLista = setorDAO.readAll(reader);
		for(String[] line : minhaLista) {
			for(String word : line) {
				System.out.println(word);
			}			
		}	
		return null;
	}

	public List<String[]> readAll(Reader reader) throws Exception {
		CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build();
		List<String[]> list = new ArrayList<>();
		list = csvReader.readAll();
		reader.close();
		csvReader.close();
		return list;
	}

	public void csvWriterOneByOne(List<String[]> stringArray, Path path) throws Exception {
		CSVWriter writer = new CSVWriter(new FileWriter(path.toString()), ';', CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		for (String[] array : stringArray) {
			writer.writeNext(array);
		}

		writer.close();
	}

}
