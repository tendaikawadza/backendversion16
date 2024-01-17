package io.getarrays.securecapita.issues.cts.ctspens;

import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdt;
import io.getarrays.securecapita.issues.cts.ctsdt.Ctsdtrepository;

public interface Ctspensrepository <T  extends  Ctspens> {
        T createctsdt    (T data);

}
