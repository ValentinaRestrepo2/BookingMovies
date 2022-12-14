package co.com.poli.bookingsservice.mapper;

public interface IMapper<I, O> {
    public O map(I in);
}
