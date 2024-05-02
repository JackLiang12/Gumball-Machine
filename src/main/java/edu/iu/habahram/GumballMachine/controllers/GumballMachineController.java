package edu.iu.habahram.GumballMachine.controllers;

import edu.iu.habahram.GumballMachine.model.GumballMachineRecord;
import edu.iu.habahram.GumballMachine.model.TransitionRequest;
import edu.iu.habahram.GumballMachine.model.TransitionResult;
import edu.iu.habahram.GumballMachine.service.IGumballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gumballs")
@CrossOrigin
public class GumballMachineController {

    private final IGumballService gumballService;

    public GumballMachineController(IGumballService gumballService) {
        this.gumballService = gumballService;
    }

    @GetMapping
    public ResponseEntity<List<GumballMachineRecord>> findAll() {
        try {
            List<GumballMachineRecord> records = gumballService.findAll();
            return ResponseEntity.ok(records);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addOrUpdate(@RequestBody GumballMachineRecord record) {
        try {
            String response = gumballService.save(record);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/insert-quarter")
    public ResponseEntity<TransitionResult> insertQuarter(@RequestBody TransitionRequest transitionRequest) {
        try {
            TransitionResult result = gumballService.insertQuarter(transitionRequest.id());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/eject-quarter")
    public ResponseEntity<TransitionResult> ejectQuarter(@RequestBody TransitionRequest transitionRequest) {
        try {
            TransitionResult result = gumballService.ejectQuarter(transitionRequest.id());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/turn-crank")
    public ResponseEntity<TransitionResult> turnCrank(@RequestBody TransitionRequest transitionRequest) {
        try {
            TransitionResult result = gumballService.turnCrank(transitionRequest.id());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/refill")
    public ResponseEntity<TransitionResult> refill(@RequestBody TransitionRequest transitionRequest) {
        try {
            TransitionResult result = gumballService.refill(transitionRequest.id(), transitionRequest.count());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
