package io.getarrays.securecapita.issues.cts.ctsict;

import io.getarrays.securecapita.issues.cts.ctspens.Ctspens;

public interface Ctsictrepository <T  extends Ctsict> {


    T createctsdt    (T data);
}
