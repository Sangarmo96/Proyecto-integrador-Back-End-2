package com.springgradle.project.persistence;

import com.springgradle.project.domain.Product;
import com.springgradle.project.domain.repository.ProductRepository;
import com.springgradle.project.persistence.crud.ProductoCrudRepository;
import com.springgradle.project.persistence.entity.Producto;
import com.springgradle.project.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//Esta anotacion indica que esta clase interactua con la base de datos
// pero tambien podriamos usar @Component que es una generalizacion de las
// de las anotaciones que usa Spring.
@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //Los operadores opcionales son parte de las nuevas versiones de java y son orientados
    // a la programacion funcional.

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
