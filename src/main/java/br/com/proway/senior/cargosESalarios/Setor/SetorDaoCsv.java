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

/**
 * SetorDaoCsv
 * Classe DAO para realizar a persistência dos dados em CSV.
 * @author Elton Oliveira, Gabriel Simon, Guilherme Ezequiel, Lucas Grijó, Samuel Levi 
 *
 */
public class SetorDaoCsv implements CRUDInterface<Setor> {
	
	String uri = "../classes/br/com/proway/senior/cargosESalarios/recursos/cargos.csv";
	
	/**
	 * Create
	 * Adiciona um setor no csv.
	 * @param Setor obj
	 */
	public void create(Setor obj) {		
		if(verificarSetorJaExistente(obj)) {
			System.out.println("SETOR JA EXISTENTE. Não é possivel criar");
		} else {
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

	}

	/**
	 * Retrieve
	 * Busca um setor no csv através do seu id.
	 * @param int id
	 */
	public Setor retrieve(int id) {
		ArrayList<Setor> todosOsSetores = getAll();
		for(Setor s : todosOsSetores) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	/**
	 * Update
	 * Altera um setor no csv.
	 * @param Setor setor a ser alterado.
	 */
	public void update(Setor obj) {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(uri).toURI()));
			List<String[]> escrita = readAll(reader);
			for(String[] line : escrita) {
				if(line[0].equals(obj.getId().toString())) {
					line[1] = obj.getNomeSetor().toString();
					line[2] = obj.getCapacidade().toString();
					line[3] = obj.getIdPermissao().toString();	
				}
			}
			Path path = Paths.get(ClassLoader.getSystemResource(uri).toURI());
			this.csvWriterOneByOne(escrita, path);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Delete
	 * Deleta um setor do csv através do seu id.
	 * @param id
	 */
	public void delete(int id) {
		Setor setorASerDeletado = retrieve(id);
		if(setorASerDeletado != null) {
			try {
				Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(uri).toURI()));
				List<String[]> escrita = readAll(reader);
				for(String[] palavras : escrita) {
					if(palavras[0].equals(setorASerDeletado.getId().toString())) {						
						escrita.remove(palavras); //DELETE LINE
						break;
					}
				}
				
				Path path = Paths.get(ClassLoader.getSystemResource(uri).toURI());
				this.csvWriterOneByOne(escrita, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Get All.
	 * Método para retornar todos os setores salvos no csv.
	 * @return ArrayList<Setor> ArrayList de setores.
	 */
	public ArrayList<Setor> getAll() {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(uri).toURI()));
			List<String[]> minhaLista = readAll(reader);
			ArrayList<Setor> setoresLidos = new ArrayList<Setor>();
			
			for(String[] line : minhaLista) {
				if(line[0].equals("idSetor")) {
					continue;
				} else {
					Setor tempSetor = new Setor();
					tempSetor.setId(Integer.parseInt(line[0]));
					tempSetor.setNomeSetor(line[1]);
					tempSetor.setCapacidade(Integer.parseInt(line[2]));
					tempSetor.setIdPermissao(Integer.parseInt(line[3]));
					setoresLidos.add(tempSetor);
				}			
			}	
			return setoresLidos;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Verifica se já existe um setor no csv.
	 * @param setor
	 * @return true se existe, false se não existe.
	 */
	private boolean verificarSetorJaExistente(Setor setor) {
		if(retrieve(setor.getId()) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método interno para ler todos os dados de um arquivo csv.
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	private List<String[]> readAll(Reader reader) throws Exception {
		CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build();
		List<String[]> list = new ArrayList<>();
		list = csvReader.readAll();
		reader.close();
		csvReader.close();
		return list;
	}

	/**
	 * Método interno para sobre-escrever todos dados de um arquivo csv.
	 * @param stringArray
	 * @param path
	 * @throws Exception
	 */
	private void csvWriterOneByOne(List<String[]> stringArray, Path path) throws Exception {
		CSVWriter writer = new CSVWriter(new FileWriter(path.toString()), ';', CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		for (String[] array : stringArray) {
			writer.writeNext(array);
		}

		writer.close();
	}
	
	

}
