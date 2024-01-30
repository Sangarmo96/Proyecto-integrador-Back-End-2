package com.springgradle.project.persistence.crud;

import com.springgradle.project.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Producto, Integer>{
    //La anotacion @query se puede usar , pero es una mejor practica usar
    // los query Methods ya que dan mayor flexibilidad al momento de generar
    // nuestro codigo.


    //@Query(value = "SElECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);


    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
