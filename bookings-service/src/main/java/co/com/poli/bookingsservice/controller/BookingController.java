package co.com.poli.bookingsservice.controller;


import co.com.poli.bookingsservice.helpers.Response;
import co.com.poli.bookingsservice.helpers.ResponseBuild;
import co.com.poli.bookingsservice.persistence.entity.Booking;
import co.com.poli.bookingsservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody Booking booking, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        bookingService.save(booking);
        return builder.success(booking);
    }
    @DeleteMapping("/{userId}")
    public Response delete(@PathVariable("userId") Long userId){
        Booking booking = (Booking) findByUserID(userId).getData();
        if(booking==null){
            return builder.failed("Not found");
        }
        return builder.success(booking);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(bookingService.findAll());
    }

    @GetMapping("/userId/{userId}")
    public Response findByUserID(@PathVariable("userId") Long userId){
        return builder.success(bookingService.findByUserID(userId));
    }

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(bookingService.findById(id));
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
