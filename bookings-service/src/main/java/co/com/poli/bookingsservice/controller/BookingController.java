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
    @GetMapping
    public Response findAll(){
        return builder.success(bookingService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody BookingInDTO bookingInDTO, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(result);
        }
        bookingService.save(bookingInDTO);
        return builder.success(bookingInDTO);
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return builder.failed("Not found");
        }
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
