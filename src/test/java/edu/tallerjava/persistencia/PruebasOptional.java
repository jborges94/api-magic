package edu.tallerjava.persistencia;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;

public class PruebasOptional {

    // ejemplo que hace una u otra cosa en caso que este presente o no
    @Test
    public void pruebaOptional1x(){
        List<String> lista = new LinkedList<>();
        lista.add("seba");

        optional1(Optional.empty());
        optional1(Optional.of(lista));
    }

    private void optional1(Optional<List<String>> lista){

        lista.ifPresentOrElse(
                value -> System.out.println("Found: " + value),
                () -> System.out.println("Not found")
        );
    }

    //=========================================================

    // ejemplo que hace una cosa si esta presente o lanza una excepcion si no lo esta
    @Test(expected = Exception.class)
    public void pruebaOptional2() throws Exception {
        optional2(Optional.empty());
    }

    private void optional2(Optional<List<String>> lista) throws Exception {

        lista.ifPresent(
                value -> System.out.println("Found: " + value)
        );
        lista.orElseThrow(Exception::new);
    }

    //=========================================================
    // ejemplo que en caso de presente invoca un metodo de la clase
    // y en caso de no presente unvoca otro.
    @Test
    public void pruebaOptional3a(){
        optional3(Optional.empty());
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void pruebaOptional3b(){
        List<String> lista = new LinkedList<>();
        lista.add("seba");
        optional3(Optional.of(lista));
        assertThat(value).isEqualTo(1);
    }

    private Integer optional3(Optional<List<String>> lista) {

        lista.ifPresentOrElse(this::existe, this::noExiste);
        return value;
    }

    private void existe(List<String> f){
        this.value = f.size();
    }

    private void noExiste() {
        this.value = 0;
    }

    private Integer value;

    //=========================================================

    // ejemplo que en caso de presente o no presente devuelve distintos valores de un objeto de otra clase
    @Test
    public void pruebaOptional4a(){
        Integer value = optional4(Optional.empty());
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void pruebaOptional4b(){
        List<String> lista = new LinkedList<>();
        lista.add("seba");
        Integer value = optional4(Optional.of(lista));
        assertThat(value).isEqualTo(1);
    }

    private Integer optional4(Optional<List<String>> lista) {

        return lista.map(new Function<List<String>, Integer>() {
            @Override
            public Integer apply(List<String> values) {
                return values.size();
            }
        }).orElse(0);
    }

    //=========================================================
    // ejemplo que en caso de presente o no presente devuelve distintos valores de un objeto de otra clase
    // pero delegandolo en otro metodo de la clase

    @Test
    public void pruebaOptional5a(){
        Integer value = optional5(Optional.empty());
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void pruebaOptional5b(){
        List<String> lista = new LinkedList<>();
        lista.add("seba");
        Integer value = optional5(Optional.of(lista));
        assertThat(value).isEqualTo(1);
    }

    private Integer optional5(Optional<List<String>> lista) {
        return lista.map(this::cuantosHay).orElse(0);
    }

    private Integer cuantosHay(List<String> lista) {
        return lista.size();
    }


    //=========================================================

    // ejemplo que en caso de presente devuelve un objeto de otra clase
    // y si no esta presente lanza una excepcion
    @Test(expected = Exception.class)
    public void pruebaOptional6a() throws Exception {
        optional6(Optional.empty());

    }

    @Test
    public void pruebaOptional6b() throws Exception {
        List<String> lista = new LinkedList<>();
        lista.add("seba");
        Integer value = optional6(Optional.of(lista));
        assertThat(value).isEqualTo(1);
    }

    private Integer optional6(Optional<List<String>> lista) throws Exception {

        return lista.map(new Function<List<String>, Integer>() {
            @Override
            public Integer apply(List<String> values) {
                return values.size();
            }
        }).orElseThrow(Exception::new);
    }
}