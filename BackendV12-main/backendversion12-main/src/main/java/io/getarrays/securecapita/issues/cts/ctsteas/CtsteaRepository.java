package io.getarrays.securecapita.issues.cts.ctsteas;

public interface CtsteaRepository<T  extends Ctstea> {

    T createctstea    (T data);
}
