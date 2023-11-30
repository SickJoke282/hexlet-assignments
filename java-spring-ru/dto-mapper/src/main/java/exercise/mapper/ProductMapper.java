package exercise.mapper;

// BEGIN
import exercise.dto.ProductUpdateDTO;
import org.mapstruct.*;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.model.Product;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    public abstract Product map(ProductCreateDTO dto);

    @InheritConfiguration
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);

    @InheritInverseConfiguration
    public abstract ProductDTO map(Product model);
}
// END
