package com.card.o2.service.svcclient;

import com.card.o2.service.svcclient.beans.O2SvcClientRequest;
import com.card.o2.service.svcclient.beans.O2SvcClientResponse;

public interface O2_SvcClientApi {
public O2SvcClientResponse verify(O2SvcClientRequest request);
}
