package online_shop_jar.controller;

import lombok.RequiredArgsConstructor;
import online_shop_jar.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService>{

    protected final String API = "/api";
    protected final String VERSION = "/v1";

    protected final String PATH = API + VERSION;

    protected final S service;
}
