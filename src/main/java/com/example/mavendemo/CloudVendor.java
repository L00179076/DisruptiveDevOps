package com.example.mavendemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendor {


    CloudVendorApplication CloudVendorApplication;

    @GetMapping("{Id}")
    public CloudVendorApplication gCloudVendorApplication(String Id)
    {
        return CloudVendorApplication;

    }
}
