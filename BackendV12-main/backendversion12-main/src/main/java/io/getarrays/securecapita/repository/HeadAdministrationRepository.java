package io.getarrays.securecapita.repository;
import io.getarrays.securecapita.domain.*;

public interface HeadAdministrationRepository<T extends HeadAdminPurchaseRequisition> {
    T create(T data, Long userId);
}
