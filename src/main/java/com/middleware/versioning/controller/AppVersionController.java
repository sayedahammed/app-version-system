package com.middleware.versioning.controller;

import com.middleware.versioning.entity.AppVersion;
import com.middleware.versioning.model.GetVersionRequest;
import com.middleware.versioning.repository.AppVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app-version")
public class AppVersionController {

    @Autowired
    public AppVersionRepository appVersionRepository;

    @PostMapping
    public AppVersion save(@RequestBody AppVersion appVersion) {
        return appVersionRepository.save(appVersion);
    }

    @PostMapping(path = "/get")
    public AppVersion getVersion(@RequestBody GetVersionRequest versionRequest) {
        return appVersionRepository.find(versionRequest.getPlatform());
    }

}
