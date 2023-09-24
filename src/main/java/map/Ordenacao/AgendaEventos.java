package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome,atracao);
        eventoMap.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventoTreeMap);
    }

    public void obterProximoEvento(){
        /* Set<LocalDate> dateSet = eventoMap.keySet();
        Collections<Evento> values = eventoMap.values(); */
        //eventoMap.get();
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        // organizar os eventos na ordem crescente
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            proximaData = entry.getKey();
            proximoEvento = entry.getValue();
            // se é igual a data atual hoje ou depois after a data atual
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O proximo evento: " + proximoEvento + " aconterá na data " + proximaData);
                break;
            }
        }
    }
    public static void main(String[] arg){
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atraçao 01");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Atraçao 02");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Evento 3", "Atraçao 03");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 9, 24), "Evento 4", "Atraçao 04");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 9, 25), "Evento 5", "Atraçao 05");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 24), "Evento 6", "Atraçao 06");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();

    }
}
