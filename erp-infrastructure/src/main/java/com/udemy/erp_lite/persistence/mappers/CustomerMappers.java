package com.udemy.erp_lite.persistence.mappers;


import com.udemy.erp_lite.customer.CustomerInfo;
import com.udemy.erp_lite.persistence.rest.dto.AddressDTO;
import com.udemy.erp_lite.persistence.rest.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

/*
 * Anti-Corruption Layer between external API (JSONPlaceholder) and domain
 * */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CustomerMappers {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address", qualifiedByName = "mapAddress")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.zipcode", target = "zipcode")
    @Mapping(source = "company.name", target = "companyName")
    CustomerInfo toCustomerInfo(UserDTO userDTO);

    /**
     * Combines street + suite info a single string, null/blank-safe
     */
    @Named("mapAddress")
    default String mapAddress(AddressDTO address) {
        if (address == null) {
            return null;
        }

        String street = address.street();
        String suite = address.suite();

        boolean streetIsBlank = street == null || street.isBlank();
        boolean suiteIsBlank = suite == null || suite.isBlank();

        if (streetIsBlank && suiteIsBlank) {
            return null;
        } else if (streetIsBlank) {
            return suite;
        } else if (suiteIsBlank) {
            return street;
        } else {
            return street + ", " + suite;
        }
    }
}
