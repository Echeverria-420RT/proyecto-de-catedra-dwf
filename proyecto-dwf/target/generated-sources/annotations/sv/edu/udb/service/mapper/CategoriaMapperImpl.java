package sv.edu.udb.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sv.edu.udb.controller.request.CategoriaRequest;
import sv.edu.udb.controller.response.CategoriaResponse;
import sv.edu.udb.repository.domain.Categoria;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-28T12:39:18-0600",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaResponse toCategoriaResponse(Categoria data) {
        if ( data == null ) {
            return null;
        }

        CategoriaResponse.CategoriaResponseBuilder categoriaResponse = CategoriaResponse.builder();

        categoriaResponse.categoria_id( data.getCategoria_id() );
        categoriaResponse.nombre( data.getNombre() );
        categoriaResponse.descripcion( data.getDescripcion() );

        return categoriaResponse.build();
    }

    @Override
    public List<CategoriaResponse> toCategoriaResponseList(List<Categoria> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoriaResponse> list1 = new ArrayList<CategoriaResponse>( list.size() );
        for ( Categoria categoria : list ) {
            list1.add( toCategoriaResponse( categoria ) );
        }

        return list1;
    }

    @Override
    public Categoria toCategoria(CategoriaRequest request) {
        if ( request == null ) {
            return null;
        }

        Categoria.CategoriaBuilder categoria = Categoria.builder();

        categoria.nombre( request.getNombre() );
        categoria.descripcion( request.getDescripcion() );

        return categoria.build();
    }
}
