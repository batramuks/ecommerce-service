/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.36).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.batra.api;

import com.batra.model.Error;
import com.batra.model.Product;
import com.batra.model.ProductListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Validated
public interface ProductApi {
    /*****
     *
     * @param product
     * @return
     */
    @Operation(summary = "Save product object", description = "create product", tags={ "product" })
    @ApiResponses(value = { 
     @ApiResponse(responseCode = "200", description = "Product created Succesfully"),
     @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> productPost(@Parameter(in = ParameterIn.DEFAULT, description = "body to be saved", required=true, schema=@Schema()) @Valid @RequestBody Product product);

    /*****
     *
     * @return
     */


    @Operation(summary = "Get product List", description = "Get product List", tags={ "product" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pending Applications object get successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductListResponse.class))),

            @ApiResponse(responseCode = "404", description = "Data not found.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),

            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/products",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<ProductListResponse> productsGet();

}

