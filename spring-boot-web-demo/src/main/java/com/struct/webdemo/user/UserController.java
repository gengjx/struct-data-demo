package com.struct.webdemo.user;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.struct.webdemo.api.ApiResponse;
import com.struct.webdemo.user.dto.CreateUserRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public ApiResponse<String> getById(@PathVariable("id") @Min(value = 1, message = "id must be >= 1") long id) {
        return ApiResponse.success("user-" + id);
    }

    @PostMapping
    public ApiResponse<CreateUserRequest> create(@Valid @RequestBody CreateUserRequest request) {
        return ApiResponse.success(request);
    }
}
