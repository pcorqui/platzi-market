package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//esta seria la clase entidad donde se piden los metodos
//con esta anotacion indicamos que sera la clase que interactuara con la base de datos
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    public Optional<List<Product>> getScarseProducts(int stock){
        Optional<List<Producto>> productos =  productoCrudRepository.findByCantidadStockLessThanAndEstado(stock,true);
        return productos.map(prod -> mapper.toProducts(prod));
    }

    public Optional<Product> getProduct(int productId){

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
