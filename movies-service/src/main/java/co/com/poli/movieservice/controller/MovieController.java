package co.com.poli.movieservice.controller;

import co.com.poli.movieservice.helpers.Response;
import co.com.poli.movieservice.helpers.ResponseBuild;
import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.service.MovieServices;
import co.com.poli.movieservice.service.dto.MovieInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServices movieServices;
    private final ResponseBuild build;

    @GetMapping
    public Response findAll(){
        return build.success(movieServices.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody MovieInDTO movieInDTO, BindingResult result){
        if(result.hasErrors()){
            return build.failed(formatMessage(result));
        }
        movieServices.save(movieInDTO);
        return build.success(movieInDTO);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return build.success(movieServices.findById(id));
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movie movie = movieServices.findById(id);
        movieServices.delete(movie);
        return build.success(movie);
    }


    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String,String> err = new HashMap<>();
                    err.put(error.getField(),error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }
}
