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
import za.ac.nwu.ac.logic.flow.SubtractMilesFlow;
import za.ac.nwu.ac.logic.flow.ViewMilesFlow;

@RestController
@RequestMapping("miles-options")
public class MilesController {

    private final ViewMilesFlow viewMilesFlow;
    private final AddMilesFlow addMilesFlow;
    private final SubtractMilesFlow subtractMilesFlow;

    @Autowired
    public MilesController(ViewMilesFlow viewMilesFlow, @Qualifier("addMilesFlowName") AddMilesFlow addMilesFlow, @Qualifier("subtractMilesFlowName")SubtractMilesFlow subtractMilesFlow){
        this.addMilesFlow = addMilesFlow;
        this.viewMilesFlow = viewMilesFlow;
        this.subtractMilesFlow = subtractMilesFlow;
    }

    @GetMapping("{total-miles}")
    @ApiOperation(value = "Displays the Total miles of the specified Miles_ID.", notes = "Gives the Miles total present in that specific Miles_ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Total Miles found and displayed."),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<MilesDto>> getTotalMilesByID(
            @ApiParam(value = "The Miles_ID (a number), that will give the total miles of that ID.",
                    example = "1",
                    name = "miles_ID",
                    required = true
            )
            @PathVariable("miles_ID") final Long miles_ID
    ){
        MilesDto accountType = viewMilesFlow.getTotalMilesByID(miles_ID);
        GeneralResponse<MilesDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("Add-Miles")
    @ApiOperation(value = "Adds miles to your Total_Miles.", notes = "Needs your Miles_ID and your total Miles to be added.")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "The new Miles were added successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Sever Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<MilesDto>>addMiles (//MilesDto because of security reasons.  Private information in the Miles class must be kept separate.
            @ApiParam(value = "The MilesId that uniquely identifies the clients Miles account.",
                    example = "1",
                    name = "milesID",
                    required = true
            )
            @PathVariable("milesID") final Long milesID,
            @ApiParam(value = "The total Miles to be added.",
                    example = "10",
                    name = "milesToAdd",
                    required = true
            )
            @PathVariable("milesToAdd") final Long milesToAdd){
        MilesDto newMiles = addMilesFlow.addMiles(milesID, milesToAdd);
        GeneralResponse<MilesDto> response = new GeneralResponse<>(true, newMiles);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Subtract-Miles")
    @ApiOperation(value = "Subtract miles to your Total_Miles.", notes = "Needs your Miles_ID and your total Miles to be subtracted.")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "The new Miles were subtracted successfully.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Sever Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<MilesDto>> subtractMiles (//MilesDto because of security reasons.  Private information in the Miles class must be kept separate.
           @ApiParam(value = "The MilesId that uniquely identifies the clients Miles account.",
                   example = "1",
                   name = "milesID",
                   required = true
           )
           @PathVariable("milesID") final Long milesID,
           @ApiParam(value = "The total Miles to be subtracted.",
                     example = "10",
                     name = "milesToSubtract",
                     required = true
                     )
           @PathVariable("milesToSubtract") final Long milesToSubtract){
        MilesDto newMiles = subtractMilesFlow.subtractMiles(milesID, milesToSubtract);
        GeneralResponse<MilesDto> response = new GeneralResponse<>(true, newMiles);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
