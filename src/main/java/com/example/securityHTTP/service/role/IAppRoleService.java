package com.example.securityHTTP.service.role;

import com.example.securityHTTP.model.AppRole;
import com.example.securityHTTP.service.GeneralService;

public interface IAppRoleService extends GeneralService<AppRole> {
    AppRole findByName(String name);
}
