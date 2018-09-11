package com.noobit.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.noobit.dto.User;
import com.noobit.dto.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping("/register")
    public void register(User user, HttpServletRequest request) {
        // 不管是注册用户还是绑定用户, 都会拿到一个用户唯一标识
        String userId = user.getUsername();
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
    }

    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @DeleteMapping("/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @PutMapping("/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    public User update(@PathVariable String id, @Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream()
                    .map(e -> (FieldError)e)
//                    .forEach(fieldError -> System.out.println(fieldError.getField() + " " + fieldError.getDefaultMessage()));
                    .forEach(fieldError -> System.out.println(fieldError.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(id);
        return user;
    }

    @PostMapping
    @JsonView(User.UserSimpleView.class)
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation("查询用户列表")
    public List<User> query(UserQueryCondition condition, Pageable pageable) {
        List<User> users = new ArrayList<>();
        System.out.println(condition);
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {

//        throw new RuntimeException("user not exist~");
//        throw  new UserNotExistException(id);
        User user = new User();
        user.setUsername("tom");
        user.setBirthday(new Date());
        return user;
    }
}
