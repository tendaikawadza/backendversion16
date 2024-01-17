package io.getarrays.securecapita.issues.cts.ctsict;

import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdt;
import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdtrepository;
import io.getarrays.securecapita.issues.cts.ctspens.Ctspens;
import io.getarrays.securecapita.issues.cts.ctspens.Ctspensrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CtsictServiceImpl implements CtsictService {

    private final  Ctsictrepository <Ctsict> ctsictrepository;


        @Override
        public Ctsict  createCtsict  (Ctsict ctsict){
            return  ctsictrepository.createctsdt(ctsict);


        }

    }
