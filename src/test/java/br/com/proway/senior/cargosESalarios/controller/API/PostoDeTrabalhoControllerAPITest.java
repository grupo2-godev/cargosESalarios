package br.com.proway.senior.cargosESalarios.controller.API;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.cargosESalarios.controller.CBO1994Controller;
import br.com.proway.senior.cargosESalarios.controller.CBO2002Controller;
import br.com.proway.senior.cargosESalarios.controller.CargoController;
import br.com.proway.senior.cargosESalarios.controller.GrauInstrucaoController;
import br.com.proway.senior.cargosESalarios.controller.HorasMesController;
import br.com.proway.senior.cargosESalarios.controller.NivelController;
import br.com.proway.senior.cargosESalarios.controller.PostoDeTrabalhoController;
import br.com.proway.senior.cargosESalarios.controller.SetorController;
import br.com.proway.senior.cargosESalarios.model.CBO1994Model;
import br.com.proway.senior.cargosESalarios.model.CBO2002Model;
import br.com.proway.senior.cargosESalarios.model.CargoModel;
import br.com.proway.senior.cargosESalarios.model.GrauInstrucaoModel;
import br.com.proway.senior.cargosESalarios.model.HorasMesModel;
import br.com.proway.senior.cargosESalarios.model.NivelModel;
import br.com.proway.senior.cargosESalarios.model.PostoDeTrabalhoModel;
import br.com.proway.senior.cargosESalarios.model.SetorModel;
import br.com.proway.senior.cargosESalarios.model.DAO.CargoDAO;
import br.com.proway.senior.cargosESalarios.model.DTO.PostoDeTrabalhoModelDTO;
import br.com.proway.senior.cargosESalarios.utilidades.Insalubridade;
import br.com.proway.senior.cargosESalarios.utilidades.Periculosidade;

public class PostoDeTrabalhoControllerAPITest {

    static String nomePosto = "Desenvolvedor(a)";

    static Double salario = 1800.00;

    static PostoDeTrabalhoControllerAPI controllerApi = new PostoDeTrabalhoControllerAPI();
    static PostoDeTrabalhoController controller = PostoDeTrabalhoController.getInstancia();

    static CargoModel cargo;
    static int idCargo;
    static int idNivel;
    static int idSetor;
    static CargoModel cargo1;
    static SetorModel setor;
    static SetorModel setor2;
    static NivelModel nivel;
    static Integer codigoCbo2002;
    static Integer codigoCbo1994;
    static Integer idHorasMes;
    static Integer idGrauInstrucao;
    static String experienciaMinima = "1";
    static String atribuicoes = "Desenvolvedor";
    static Boolean status = true;
    static Integer idPermissao = 1;
    static GrauInstrucaoModel grauInstrucao;
    static CBO2002Model cbo2002;
    static CBO1994Model cbo1994;
    static HorasMesModel horasMes;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        nomePosto = "Desenvolvedor(a)";

        salario = 1800.00;

        controller.deletarTodos();
        NivelController.getInstancia().deletarTodosNiveis();
        SetorController.getInstancia().deletarTodosSetores();
        CargoController.getInstancia().deletarTodosCargos();
        GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
        CBO2002Controller.getInstancia().deletarTodosCBO2002();
        CBO1994Controller.getInstancia().deletarTodosCBO1994();
        HorasMesController.getInstancia().deletarTodosHorasMes();

        popularTabelas();
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {

        controller.deletarTodos();
        NivelController.getInstancia().deletarTodosNiveis();
        SetorController.getInstancia().deletarTodosSetores();
        CargoController.getInstancia().deletarTodosCargos();
        GrauInstrucaoController.getInstancia().deletarTodasInstrucoes();
        CBO2002Controller.getInstancia().deletarTodosCBO2002();
        CBO1994Controller.getInstancia().deletarTodosCBO1994();
        HorasMesController.getInstancia().deletarTodosHorasMes();
        controllerApi = new PostoDeTrabalhoControllerAPI();
    }

    /**
     * Devemos popular as tabelas que sao chaves estrangeiras da tabela
     * PostoDeTrabalho. Essa funcao gera (apenas uma vez) as entradas que vao ser
     * utilizadas em todos os testes.
     *
     * @throws Exception
     */
    public static void popularTabelas() throws Exception {
        idGrauInstrucao = GrauInstrucaoController.getInstancia().cadastrarInstrucao("Ensino superior completo");
        grauInstrucao = GrauInstrucaoController.getInstancia().buscarInstrucaoPorID(idGrauInstrucao);

        codigoCbo2002 = CBO2002Controller.getInstancia().cadastrarCBO2002(666666, "Desenvolvedor", 0.1,
                0.3);
        cbo2002 = CBO2002Controller.getInstancia().buscarCBO2002PorCodigo(codigoCbo2002);

        codigoCbo1994 = CBO1994Controller.getInstancia().cadastrarCBO1994(55555, "Desenvolvedor", 0.1,
                0.3);
        cbo1994 = CBO1994Controller.getInstancia().buscarCBO1994(codigoCbo1994);

        idHorasMes = HorasMesController.getInstancia().cadastrarHorasMes(240d);
        horasMes = HorasMesController.getInstancia().buscarHorasMes(idHorasMes);

        cargo = new CargoController().construirCargo("Gerente", LocalDateTime.now(), LocalDateTime.now(), cbo2002,
                cbo1994, horasMes, grauInstrucao, "12", "Administrar Equipes", true, 1);

        idCargo = CargoController.getInstancia().cadastrarCargo(cargo);
        idNivel = NivelController.getInstancia().cadastrarNivel("Junior");
        idSetor = SetorController.getInstancia().cadastrarSetor("Financeiro", idCargo);
        int idSetor2 = SetorController.getInstancia().cadastrarSetor("Recursos Humanos", idCargo);

        cargo = CargoDAO.getInstancia().buscar(CargoModel.class, idCargo);
        setor = SetorController.getInstancia().buscarSetorPorId(idSetor);
        setor2 = SetorController.getInstancia().buscarSetorPorId(idSetor2);
        nivel = NivelController.getInstancia().buscarNivel(idNivel);
    }

    @Before
    public void before() throws Exception {
        controller.deletarTodos();
    }

    @Test
    public void testBuscarPostoDeTrabalhoPorId() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        PostoDeTrabalhoModelDTO postoProcurado = (PostoDeTrabalhoModelDTO) controllerApi.buscarPorID(id).getBody();
        assertEquals(nomePosto, postoProcurado.getNomePosto());
        assertEquals((Integer) idCargo, postoProcurado.getCargo().getIdCargo());
        assertEquals((Integer) idSetor, postoProcurado.getSetor().getId());
        assertEquals((Integer) idNivel, postoProcurado.getNivel().getId());
        assertEquals(salario, postoProcurado.getSalario());
    }

    @Test
    public void testBuscarPostoDeTrabalhoPorIdInvalido() throws Exception {
        String texto = (String) controllerApi.buscarPorID(0).getBody();
        assertEquals("ID invalido", texto);
    }

    @Test
    public void testBuscarTodosPostosDeTrabalho() throws Exception {
        controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        controller.cadastrarPostoDeTrabalho("Analista de Sistemas", cargo, setor, nivel, 3000.00);
        controller.cadastrarPostoDeTrabalho("Coordenador de RH", cargo, setor, nivel, 7000.00);
        assertEquals(3, ((ArrayList<PostoDeTrabalhoModelDTO>) (controllerApi.buscarTodos().getBody())).size());
    }

    @Test
    public void testBuscarTodosPostosDeTrabalhoSemPostosCadastrados() throws Exception {
        assertEquals("Não há nenhum posto de trabalho cadastrado", (String) controllerApi.buscarTodos().getBody());
    }

    @Test
    public void testInserirPosto() throws Exception {
        PostoDeTrabalhoModel posto = new PostoDeTrabalhoModel(nomePosto, cargo, setor, nivel, salario);
        assertTrue((Integer) controllerApi.inserirPosto(posto).getBody() > 0);
    }

    @Test
    public void testAtualizarPosto() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        PostoDeTrabalhoModel posto = controller.buscarPostoDeTrabalhoId(id);
        posto.setNomePosto("Novo nome do Posto");
        controllerApi.atualizarPosto(id, posto);
        assertEquals("Novo nome do Posto", posto.getNomePosto());
    }

    @Test
    public void testAtualizarPostoComIdInvalido() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        PostoDeTrabalhoModel posto = controller.buscarPostoDeTrabalhoId(id);
        posto.setNomePosto("Novo nome do Posto");
        String texto = (String) controllerApi.atualizarPosto(17, posto).getBody();
        assertEquals("ID invalido", texto);
    }

    @Test
    public void testDeletarPosto() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        assertTrue((boolean) controllerApi.deletarPosto(id).getBody());
    }

    @Test
    public void testDeletarPostoComIDInvalido() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        assertEquals((String) controllerApi.deletarPosto(1).getBody(), "ID invalido");
    }

    @Test
    public void testGetPostoDTO() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        PostoDeTrabalhoModel posto = controller.buscarPostoDeTrabalhoId(id);
        PostoDeTrabalhoModelDTO postoDTO = new PostoDeTrabalhoModelDTO(posto);
        assertEquals(postoDTO.getCargoDTO().getExperienciaMinima(), "12");
    }

    @Test
    public void testBuscarPostoPeloNome() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        PostoDeTrabalhoModelDTO posto = ((ArrayList<PostoDeTrabalhoModelDTO>) (controllerApi.buscarPostosPeloNome(nomePosto).getBody())).get(0);
        assertTrue(posto.getCargo().getNomeCargo().equals(cargo.getNomeCargo()));
    }

    @Test
    public void testBuscarPostoPeloNomeSemPostosCadastrados() throws Exception {
        String texto = (String) (controllerApi.buscarPostosPeloNome(nomePosto).getBody());
        assertEquals(texto, "Não há postos de trabalho cadastrados");
    }

    @Test
    public void testBuscarPostoPeloNomeComNomeNulo() throws Exception {
        int id = controller.cadastrarPostoDeTrabalho(nomePosto, cargo, setor, nivel, salario);
        PostoDeTrabalhoModelDTO posto = (((ArrayList<PostoDeTrabalhoModelDTO>) (controllerApi.buscarPostosPeloNome(null).getBody())).get(0));
        assertEquals(posto.getNomePosto(), nomePosto);
    }

    @Test
    public void testBuscarPostoPeloNomeComNomeInvalido() throws Exception {
        String texto = (String) controllerApi.buscarPostosPeloNome("#$%¨&*%#@").getBody();
        assertEquals(texto, "Nome Invalido");
    }
}
