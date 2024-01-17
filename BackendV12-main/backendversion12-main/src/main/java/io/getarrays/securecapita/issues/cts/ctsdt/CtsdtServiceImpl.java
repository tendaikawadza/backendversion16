package io.getarrays.securecapita.issues.cts.ctsdt;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.repository.PurchaseRequestsRepository;
import io.getarrays.securecapita.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CtsdtServiceImpl implements  CtsdtService{



    private final  Ctsdtrepository <Ctsdt> ctsdtrepository;


    @Override
    public   Ctsdt createCtsdt(Ctsdt ctsdt){
        return  ctsdtrepository.createctsdt(ctsdt);


    }


}
