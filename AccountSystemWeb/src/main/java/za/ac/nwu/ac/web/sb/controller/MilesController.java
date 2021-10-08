package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.AddMilesFlow;
import za.ac.nwu.ac.logic.flow.ViewMilesFlow;
import za.ac.nwu.ac.logic.flow.SubtractMilesFlow;

import java.time.LocalDate;

@RestController
@RequestMapping("miles-options")
public class MilesController {

    private final ViewMilesFlow viewMilesFlow;
    private final AddMilesFlow addMilesFlow ;
    private final SubtractMilesFlow subtractMilesFlow;

    @Autowired
    public MilesController (ViewMilesFlow viewMilesFlow, @Qualifier("addMilesFlowName") AddMilesFlow addMilesFlow, @Qualifier("subtractMilesFlowName")SubtractMilesFlow subtractMilesFlow){
        this.addMilesFlow = addMilesFlow;
        this.viewMilesFlow = viewMilesFlow;
        this.subtractMilesFlow = subtractMilesFlow;
    }

    //VIEW the miles in an account
    @GetMapping("{total-miles}")
    @ApiOperation(value = "Displays the Total miles of the specified Miles_ID.", notes = "Gives the Miles total present in that specific Miles_ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Total Miles found and displayed."),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<MilesDto>> getTotalMilesByID(
           /* @ApiParam(value = "The Miles_ID (a number), that will give the total miles of that ID.",
                    example = "1",
                    name = "miles_ID",
                    required = true
            )
            @PathVariable("total-miles") final String miles_ID*/
            @RequestParam(value = "The Miles ID: ", defaultValue = "1")
                    Long milesID
    ){
        MilesDto accountType = viewMilesFlow.getTotalMilesByID(milesID);
        GeneralResponse<MilesDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Update the miles with ADD
    @PutMapping("{Add-Miles}")
    @ApiOperation(value = "Adds miles to your Total_Miles.", notes = "Needs your Miles_ID and your total Miles to be added.")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "The new Miles were added successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Sever Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<MilesDto>>addMiles (//MilesDto because of security reasons.  Private information in the Miles class must be kept separate.
            /*@ApiParam(value = "The MilesId that uniquely identifies the clients Miles account.",
                    example = "1",
                    name = "milesID",
                    required = true
            )
            @PathVariable("Add-Miles") final Long milesID,
            @ApiParam(value = "The total Miles to be added.",
                    example = "10",
                    name = "milesToAdd",
                    required = true
            )
            @PathVariable("Add-Miles") final Long milesToAdd,
    @ApiParam(value = "The start date of the miles account",
            example = "01-OCT-21",
            name = "startDate",
            required = true
    )
    @PathVariable("Add-Miles") final LocalDate startDate)*/
       @RequestParam(value = "The Miles ID: ", defaultValue = "1")
            Long milesID,
       @RequestParam(value = "The total miles you want to add:", defaultValue = "5")
             Long milesToAdd,
        @RequestParam(value = "The start date of the miles account:", defaultValue = "2021-10-01")
              String startDate)

    {
        MilesDto newMiles = addMilesFlow.addMiles(milesID, milesToAdd, LocalDate.parse(startDate));
        GeneralResponse<MilesDto> response = new GeneralResponse<>(true, newMiles);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Update the miles with SUBTRACT
    @PutMapping("{Subtract-Miles}")
    @ApiOperation(value = "Subtract miles to your Total_Miles.", notes = "Needs your Miles_ID and your total Miles to be subtracted.")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "The new Miles were subtracted successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Sever Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<MilesDto>> subtractMiles (//MilesDto because of security reasons.  Private information in the Miles class must be kept separate.
           /*@ApiParam(value = "The MilesId that uniquely identifies the clients Miles account.",
                   example = "1",
                   name = "milesID",
                   required = true
           )
           @PathVariable("Subtract-Miles") final Long milesID,
           @ApiParam(value = "The total Miles to be subtracted.",
                     example = "10",
                     name = "milesToSubtract",
                     required = true
                     )
           @PathVariable("Subtract-Miles") final Long milesToSubtract*/
           @RequestParam(value = "The Miles ID: ", defaultValue = "1")
                     Long milesID,
           @RequestParam(value = "The total miles you want to subtract:", defaultValue = "5")
                    Long milesToSubtract){
        MilesDto newMiles = subtractMilesFlow.subtractMiles(milesID, milesToSubtract);
        GeneralResponse<MilesDto> response = new GeneralResponse<>(true, newMiles);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
