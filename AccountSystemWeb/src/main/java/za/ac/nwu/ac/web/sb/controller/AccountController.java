package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;

import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {

    private final FetchAccountFlow fetchAccountFlow;

    @Autowired
    public AccountController (FetchAccountFlow fetchAccountFlow){
        this.fetchAccountFlow = fetchAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Obtain the configuration for Account.", notes = "Must return the list of accounts")
    @ApiResponses( value = {
        @ApiResponse(code = 200, message = "Accounts have been obtained", response =GeneralResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response =GeneralResponse.class),
        @ApiResponse(code = 404, message = "Not found", response =GeneralResponse.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response =GeneralResponse.class)
    })


    public ResponseEntity<GeneralResponse<String>>getAll() {
        GeneralResponse<String> response = new GeneralResponse<>(true, "No types found");
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
   /* public ResponseEntity<GeneralResponse<List<Account>>>getAll() {
        List<Account> account = fetchAccountFlow.getAllAccounts();
        GeneralResponse<List<Account>> response = new GeneralResponse<>(true, account);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }*/
}
