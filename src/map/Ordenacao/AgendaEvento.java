package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEvento {

    Map<LocalDate,Evento> eventoMap;

    public AgendaEvento() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventoMap.put(data,new Evento(nome,atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate,Evento> eventosOrdenados = new TreeMap<>(eventoMap);
        if(!eventoMap.isEmpty()){
            for (Map.Entry<LocalDate,Evento> entry : eventosOrdenados.entrySet()){
                LocalDate dataEvento = entry.getKey();
                Evento evento = entry.getValue();
                System.out.println("Data: " + dataEvento + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
            }
        }else{
            throw new RuntimeException("A agenda está vazia");
        }
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        if(!eventoMap.isEmpty()){
            for (Map.Entry<LocalDate,Evento> entry : eventoMap.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                if(dataEvento.equals(dataAtual)||dataEvento.isAfter(dataAtual)){
                    proximaData = dataEvento;
                    proximoEvento = entry.getValue();
                    break;
                }
            }
            if (proximoEvento != null) {
                System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximaData);
            } else {
                System.out.println("Não há eventos futuros na agenda.");
            }
        }else{
            throw new RuntimeException("A agenda está vazia");
        }
    }

    public static void main(String[] args) {
        AgendaEvento agendaEventos = new AgendaEvento();

        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");


        agendaEventos.exibirAgenda();


        agendaEventos.obterProximoEvento();
    }




}
