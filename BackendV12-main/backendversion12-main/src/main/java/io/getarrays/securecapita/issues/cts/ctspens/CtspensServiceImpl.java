package io.getarrays.securecapita.issues.cts.ctspens;

import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdt;
import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdtrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CtspensServiceImpl implements  CtspensService{



        private final Ctspensrepository<Ctspens> ctspensrepository;


        @Override
        public   Ctspens  createCtspens(Ctspens ctspens){
            return  ctspensrepository.createctsdt(ctspens);


        }

    }
