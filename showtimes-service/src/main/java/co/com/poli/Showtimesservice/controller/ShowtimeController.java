package co.com.poli.Showtimesservice.controller;


import co.com.poli.Showtimesservice.persistence.entity.Showtime;
import co.com.poli.Showtimesservice.helpers.Response;
import co.com.poli.Showtimesservice.helpers.ResponseBuild;
import co.com.poli.Showtimesservice.service.ShowtimeService;
import co.com.poli.Showtimesservice.service.dto.ShowtimeInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll(){
        return builder.success(showtimeService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody ShowtimeInDTO showtimeInDTO, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        showtimeService.save(showtimeInDTO);
        return builder.success(showtimeInDTO);
    }

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(showtimeService.findById(id));
    }

    @PutMapping("/{id}")
    public Response updateById(@PathVariable("id") Long id, @RequestBody Showtime showtime){
        Showtime showtimeToUpdate = showtimeService.findById(id);
        if(showtimeToUpdate == null){
            return builder.failed("Not found");
        }
        showtimeService.updateById(showtimeToUpdate, showtime);
        return builder.success();
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }

}
