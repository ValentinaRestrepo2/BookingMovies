package co.com.poli.Bookingsservice.controller;

import co.com.poli.Bookingsservice.helpers.Response;
import co.com.poli.Bookingsservice.persistence.entity.Booking;
import co.com.poli.Bookingsservice.service.BookingService;
import co.com.poli.Bookingsservice.helpers.ResponseBuild;
import co.com.poli.Bookingsservice.service.dto.BookingInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuild builder;
       @PostMapping
    public Response save(@Valid @RequestBody BookingInDTO bookingInDTO, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(result);
        }
        bookingService.save(bookingInDTO);
        return builder.success(bookingInDTO);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(bookingService.findAll());
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return builder.failed("Not found");
        }
        return builder.success(booking);
    }

    @GetMapping("/{userid}")
    public Response ObtenerReservaUser(@PathVariable("userid") Long userid){
        List<Booking> list = bookingService.ObtenerReservaUser(userid);
        if(list == null){
            return builder.failed("No se han encontrado reservas");
        }
        return builder.success(list);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        bookingService.delete(id);
        return builder.success(booking);
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
