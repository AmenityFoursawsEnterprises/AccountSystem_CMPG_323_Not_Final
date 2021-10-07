package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.RewardsDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchRewardsFlow;

import java.util.List;

@RestController
@RequestMapping("view-rewards")
public class RewardsController {
    private final FetchRewardsFlow fetchRewardsFlow;

    @Autowired
    public RewardsController(FetchRewardsFlow fetchRewardsFlow){
        this.fetchRewardsFlow = fetchRewardsFlow;
    }
    @GetMapping("/all-rewards")
    @ApiOperation(value = "Gets all of the Rewards.", notes = "Returns a list of the rewards but with no IDs' ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All rewards have been returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<RewardsDto>>> getAll() {
        List<RewardsDto> rewards = fetchRewardsFlow.getAllRewards();
        GeneralResponse<List<RewardsDto>> response = new GeneralResponse<>( true,  rewards);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{reward-by-name}")
    @ApiOperation(value = "Fetches the specified Reward.", notes = "Fetches the Reward corresponding to the given query name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reward Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<RewardsDto>> getRewards(
            @ApiParam(value = "The name to be queried for the reward.",
                    example = "Hokey Stick",
                    name = "Reward_Name",
                    required = true
            )
            @PathVariable("reward-by-name") final String rewardName
    ){
        RewardsDto reward = fetchRewardsFlow.getRewardByName(rewardName);
        GeneralResponse<RewardsDto> response = new GeneralResponse<>(true, reward);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
