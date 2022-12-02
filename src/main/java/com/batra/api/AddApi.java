package com.batra.api;

import com.batra.model.CartRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

@Validated
public interface AddApi {
    /****
     *
     * @param cartRequest
     * @return
     */
    @Operation(summary = "Add to  Cart ", description = "Add to Cart", tags={ "cart" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Cart created Succesfully"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/add",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Long> addPost(@Parameter(in = ParameterIn.DEFAULT, description = "body to be saved", required = true, schema = @Schema()) @Valid @RequestBody CartRequest cartRequest);

}

